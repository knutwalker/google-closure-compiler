/*
 * Copyright 2009 The Closure Compiler Authors.
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

/**
 * Interface used by {@link ReplaceCssNames} to substitute CSS class names.
 */
<<<<<<< HEAD
public interface CssRenamingMap {
=======
public interface CssRenamingMap extends RenamingMap {

  /** Kind of renaming map */
>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
  public static enum Style {
    BY_WHOLE,
    BY_PART,
  }

<<<<<<< HEAD
=======
  @Override
>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
  String get(String value);

  Style getStyle();

<<<<<<< HEAD
  public static abstract class ByPart implements CssRenamingMap {
    @Override
    abstract public String get(String value);
=======
  /** ByPart renaming map */
  public abstract static class ByPart implements CssRenamingMap {
    @Override
    public abstract String get(String value);
>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77

    @Override
    public Style getStyle() {
      return Style.BY_PART;
    }
  }

<<<<<<< HEAD
  public static abstract class ByWhole implements CssRenamingMap {
    @Override
    abstract public String get(String value);
=======
  /** ByWhole renaming map */
  public abstract static class ByWhole implements CssRenamingMap {
    @Override
    public abstract String get(String value);
>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77

    @Override
    public Style getStyle() {
      return Style.BY_WHOLE;
    }
  }
}
