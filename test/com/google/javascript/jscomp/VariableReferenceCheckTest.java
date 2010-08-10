/*
 * Copyright 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.javascript.jscomp;

import com.google.javascript.jscomp.CheckLevel;


/**
 * Test that warnings are generated in appropriate cases and appropriate
 * cases only by VariableReferenceCheck
 *
*
 */
public class VariableReferenceCheckTest extends CompilerTestCase {

  private static final String VARIABLE_RUN =
      "var a = 1; var b = 2; var c = a + b, d = c;";

  private boolean enableAmbiguousFunctionCheck = false;

  @Override
  public CompilerPass getProcessor(Compiler compiler) {
    if (enableAmbiguousFunctionCheck) {
      compiler.getOptions().setWarningLevel(
          DiagnosticGroups.AMBIGUOUS_FUNCTION_DECL, CheckLevel.WARNING);
    }

    // Treats bad reads as errors, and reports bad write warnings.
    return new VariableReferenceCheck(compiler, CheckLevel.WARNING);
  }

  @Override
  public void setUp() throws Exception {
    super.setUp();
    enableAmbiguousFunctionCheck = false;
  }

  public void testCorrectCode() {
    assertNoWarning("function foo(d) { (function() { d.foo(); }); d.bar(); } ");
    assertNoWarning("function foo() { bar(); } function bar() { foo(); } ");
    assertNoWarning("function(d) { d = 3; }");
    assertNoWarning(VARIABLE_RUN);
    assertNoWarning("function() { " + VARIABLE_RUN + "}");
  }

  public void testCorrectShadowing() {
    assertNoWarning(VARIABLE_RUN + "function f() { " + VARIABLE_RUN + "}");
  }

  public void testCorrectRedeclare() {
    assertNoWarning(
        "function f() { if (1) { var a = 2; } else { var a = 3; } }");
  }

  public void testCorrectRecursion() {
    assertNoWarning("function f() { var x = function() { x(); }; }");
  }

  public void testCorrectCatch() {
    assertNoWarning("function f() { try { var x = 2; } catch (x) {} }");
  }

  public void testRedeclare() {
    // Only test local scope since global scope is covered elsewhere
    assertRedeclare("function f() { var a = 2; var a = 3; }");
    assertRedeclare("function f(a) { var a = 2; }");
  }

  public void testEarlyReference() {
    assertUndeclared("function f() { a = 2; var a = 3; }");
  }

  public void testCorrectEarlyReference() {
    assertNoWarning("var goog = goog || {}");
    assertNoWarning("function f() { a = 2; } var a = 2;");
  }

  public void testUnreferencedBleedingFunction() {
    assertNoWarning("var x = function y() {}");
  }

  public void testReferencedBleedingFunction() {
    assertNoWarning("var x = function y() { return y(); }");
  }

  public void testDoubleDeclaration() {
    assertRedeclare("function x(y) { if (true) { var y; } }");
  }

  public void testDoubleDeclaration2() {
    assertRedeclare("function x() { var y; if (true) { var y; } }");
  }

  public void testHoistedFunction1() {
    enableAmbiguousFunctionCheck = true;
    assertNoWarning("f(); function f() {}");
  }

  public void testHoistedFunction2() {
    enableAmbiguousFunctionCheck = true;
    assertNoWarning("function g() { f(); function f() {} }");
  }

  public void testNonHoistedFunction() {
    enableAmbiguousFunctionCheck = true;
    assertUndeclared("if (true) { f(); function f() {} }");
  }

  public void testNonHoistedFunction2() {
    enableAmbiguousFunctionCheck = true;
    assertNoWarning("if (false) { function f() {} f(); }");
  }

  public void testNonHoistedFunction3() {
    enableAmbiguousFunctionCheck = true;
    assertNoWarning("function g() { if (false) { function f() {} f(); }}");
  }

  public void testNonHoistedFunction4() {
    enableAmbiguousFunctionCheck = true;
    assertAmbiguous("if (false) { function f() {} }  f();");
  }

  public void testNonHoistedFunction5() {
    enableAmbiguousFunctionCheck = true;
    assertAmbiguous("function g() { if (false) { function f() {} }  f(); }");
  }

  public void testNonHoistedFunction6() {
    enableAmbiguousFunctionCheck = true;
    assertUndeclared("if (false) { f(); function f() {} }");
  }

  public void testNonHoistedFunction7() {
    enableAmbiguousFunctionCheck = true;
    assertUndeclared("function g() { if (false) { f(); function f() {} }}");
  }

  public void testNonHoistedRecursiveFunction1() {
    enableAmbiguousFunctionCheck = true;
    assertNoWarning("if (false) { function f() { f(); }}");
  }

  public void testNonHoistedRecursiveFunction2() {
    enableAmbiguousFunctionCheck = true;
    assertNoWarning("function g() { if (false) { function f() { f(); }}}");
  }

  public void testNonHoistedRecursiveFunction3() {
    enableAmbiguousFunctionCheck = true;
    assertNoWarning("function g() { if (false) { function f() { f(); g(); }}}");
  }

  /**
   * Expects the JS to generate one bad-read error.
   */
  private void assertRedeclare(String js) {
    testSame(js, VariableReferenceCheck.REDECLARED_VARIABLE);
  }

  /**
   * Expects the JS to generate one bad-write warning.
   */
  private void assertUndeclared(String js) {
    testSame(js, VariableReferenceCheck.UNDECLARED_REFERENCE);
  }

  /**
   * Expects the JS to generate one bad-write warning.
   */
  private void assertAmbiguous(String js) {
    testSame(js, VariableReferenceCheck.AMBIGUOUS_FUNCTION_DECL);
  }


  /**
   * Expects the JS to generate no errors or warnings.
   */
  private void assertNoWarning(String js) {
    testSame(js);
  }
}
