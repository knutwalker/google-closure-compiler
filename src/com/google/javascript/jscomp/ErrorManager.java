/*
 * Copyright 2007 Google Inc.
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
 * The error manager is in charge of storing, organizing and displaying
 * errors and warnings generated by the compiler.
 *
 *
 */
public interface ErrorManager {
  /**
   * Reports an error. The errors will be displayed by the
   * {@link #generateReport()} at the discretion of the implementation.
   *
   * @param level the reporting level
   * @param error the error to report
   */
  void report(CheckLevel level, JSError error);

  /**
   * Writes a report to an implementation-specific medium. The compiler calls
   * this method after any and all {@link #report} calls.
   */
  void generateReport();

  /**
   * Gets the number of reported errors.
   */
  int getErrorCount();

  /**
   * Gets the number of reported warnings.
   */
  int getWarningCount();

  /**
   * Gets all the errors.
   */
  JSError[] getErrors();

  /**
   * Gets all the warnings.
   */
  JSError[] getWarnings();

  /**
   * Sets the percentage of typed expressions.
   */
  void setTypedPercent(double typedPercent);

  /**
   * Gets the percentage of typed expressions.
   */
  double getTypedPercent();
}
