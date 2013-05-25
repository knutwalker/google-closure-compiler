/*
 *
 * ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1/GPL 2.0
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is Rhino code, released
 * May 6, 1999.
 *
 * The Initial Developer of the Original Code is
 * Netscape Communications Corporation.
 * Portions created by the Initial Developer are Copyright (C) 1997-1999
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 *   Bob Jervis
 *   Google Inc.
 *
 * Alternatively, the contents of this file may be used under the terms of
 * the GNU General Public License Version 2 or later (the "GPL"), in which
 * case the provisions of the GPL are applicable instead of those above. If
 * you wish to allow use of your version of this file only under the terms of
 * the GPL and not to allow others to use your version of this file under the
 * MPL, indicate your decision by deleting the provisions above and replacing
 * them with the notice and other provisions required by the GPL. If you do
 * not delete the provisions above, a recipient may use your version of this
 * file under either the MPL or the GPL.
 *
 * ***** END LICENSE BLOCK ***** */

package com.google.javascript.rhino.jstype;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.io.Serializable;
<<<<<<< HEAD
=======
import java.util.Arrays;
>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77

/**
 * Manages a mapping from TemplateType to its resolved JSType. Provides utility
 * methods for cloning/extending the map.
 *
 * @author izaakr@google.com (Izaak Rubin)
 */
public class TemplateTypeMap implements Serializable {
<<<<<<< HEAD
  private final ImmutableList<String> templateKeys;
  private final ImmutableList<JSType> templateValues;
  final JSTypeRegistry registry;

  TemplateTypeMap(JSTypeRegistry registry,
                  ImmutableList<String> templateKeys,
=======
  // The TemplateType keys of the map.
  private final ImmutableList<TemplateType> templateKeys;
  // The JSType values, which are index-aligned with their corresponding keys.
  // These values are left as specified in the TemplateTypeMap constructor; they
  // may refer to TemplateTypes that are keys in this TemplateTypeMap, requiring
  // iterative type resolution to find their true, resolved type.
  private final ImmutableList<JSType> templateValues;
  // The JSType values, which are index-aligned with their corresponding keys.
  // These values have been iteratively type-resolved using this TemplateTypeMap
  // instance. These fully-resolved values are necessary for determining the
  // equivalence of two TemplateTypeMap instances.
  private final ImmutableList<JSType> resolvedTemplateValues;
  final JSTypeRegistry registry;

  TemplateTypeMap(JSTypeRegistry registry,
                  ImmutableList<TemplateType> templateKeys,
>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
                  ImmutableList<JSType> templateValues) {
    Preconditions.checkNotNull(templateKeys);
    Preconditions.checkNotNull(templateValues);

    this.registry = registry;
    this.templateKeys = templateKeys;

    int nKeys = templateKeys.size();
    this.templateValues = templateValues.size() > nKeys ?
        templateValues.subList(0, nKeys) : templateValues;
<<<<<<< HEAD
=======

    // Iteratively resolve any JSType values that refer to the TemplateType keys
    // of this TemplateTypeMap.
    TemplateTypeMapReplacer replacer = new TemplateTypeMapReplacer(
        registry, this);
    ImmutableList.Builder<JSType> builder = ImmutableList.builder();
    for (JSType templateValue : this.templateValues) {
      builder.add(templateValue.visit(replacer));
    }
    this.resolvedTemplateValues = builder.build();
  }

  /**
   * Returns true if the map is empty; false otherwise.
   */
  public boolean isEmpty() {
    return templateKeys.isEmpty();
>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
  }

  /**
   * Returns a list of all template keys.
   */
<<<<<<< HEAD
  public ImmutableList<String> getTemplateKeys() {
=======
  public ImmutableList<TemplateType> getTemplateKeys() {
>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
    return templateKeys;
  }

  /**
   * Returns true if this map contains the specified template key, false
   * otherwise.
   */
<<<<<<< HEAD
  public boolean hasTemplateKey(String templateKey) {
    return templateKeys.contains(templateKey);
=======
  public boolean hasTemplateKey(TemplateType templateKey) {
    // Note: match by identity, not equality
    for (TemplateType entry : templateKeys) {
      if (entry == templateKey) {
        return true;
      }
    }
    return false;
>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
  }

  /**
   * Returns the number of template keys in this map that do not have a
   * corresponding JSType value.
   */
  int numUnfilledTemplateKeys() {
    return templateKeys.size() - templateValues.size();
  }

  /**
   * Returns a list of template keys in this map that do not have corresponding
   * JSType values.
   */
<<<<<<< HEAD
  ImmutableList<String> getUnfilledTemplateKeys() {
=======
  ImmutableList<TemplateType> getUnfilledTemplateKeys() {
>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
    return templateKeys.subList(templateValues.size(), templateKeys.size());
  }

  /**
   * Returns true if there is a JSType value associated with the specified
   * template key; false otherwise.
   */
<<<<<<< HEAD
  public boolean hasTemplateType(String key) {
    return getTemplateTypeInternal(key) != null;
=======
  public boolean hasTemplateType(TemplateType key) {
    return getTemplateTypeIndex(key) != -1;
>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
  }

  /**
   * Returns the JSType value associated with the specified template key. If no
   * JSType value is associated, returns UNKNOWN_TYPE.
   */
<<<<<<< HEAD
  public JSType getTemplateType(String key) {
    JSType templateType = getTemplateTypeInternal(key);
    return (templateType == null) ?
        registry.getNativeType(JSTypeNative.UNKNOWN_TYPE) : templateType;
  }

  /**
   * Returns the JSType value associated with the specified template key. If no
   * JSType value is associated, returns null.
   */
  private JSType getTemplateTypeInternal(String key) {
    int index = templateKeys.indexOf(key);
    if (index < 0 || index >= templateValues.size()) {
      return null;
    }
    return templateValues.get(index);
=======
  public JSType getTemplateType(TemplateType key) {
    int index = getTemplateTypeIndex(key);
    return (index == -1) ? registry.getNativeType(JSTypeNative.UNKNOWN_TYPE) :
         templateValues.get(index);
  }

  public TemplateType getTemplateTypeKeyByName(String keyName) {
    for (TemplateType key : templateKeys) {
      if (key.getReferenceName().equals(keyName)) {
        return key;
      }
    }
    return null;
  }

  /**
   * Returns the index of the JSType value associated with the specified
   * template key. If no JSType value is associated, returns -1.
   */
  private int getTemplateTypeIndex(TemplateType key) {
    int maxIndex = Math.min(templateKeys.size(), templateValues.size());
    for (int i = maxIndex - 1; i >= 0; i--) {
      if (templateKeys.get(i) == key) {
        return i;
      }
    }
    return -1;
  }

  private JSType getResolvedTemplateType(TemplateType key) {
    int index = getTemplateTypeIndex(key);
    return (index == -1) ? registry.getNativeType(JSTypeNative.UNKNOWN_TYPE) :
         resolvedTemplateValues.get(index);
  }

  /**
   * An enum tracking the three different equivalence match states for a
   * template key-value pair.
   */
  private enum EquivalenceMatch {
    NO_KEY_MATCH, VALUE_MISMATCH, VALUE_MATCH
>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
  }

  /**
   * Determines if this map and the specified map have equivalent template
   * types.
   */
  public boolean checkEquivalenceHelper(
      TemplateTypeMap that, EquivalenceMethod eqMethod) {
<<<<<<< HEAD
    int thisNumKeys = templateKeys.size();
    int thatNumKeys = that.getTemplateKeys().size();

    for (int i = 0; i < Math.min(thisNumKeys, thatNumKeys); i++) {
      JSType thisTemplateType = getTemplateType(templateKeys.get(i));
      JSType thatTemplateType = that.getTemplateType(
          that.getTemplateKeys().get(i));
      if (!thisTemplateType.checkEquivalenceHelper(
          thatTemplateType, eqMethod)) {
=======
    ImmutableList<TemplateType> thisKeys = getTemplateKeys();
    ImmutableList<TemplateType> thatKeys = that.getTemplateKeys();

    EquivalenceMatch[] thatMatches = new EquivalenceMatch[thatKeys.size()];
    Arrays.fill(thatMatches, EquivalenceMatch.NO_KEY_MATCH);

    for (int i = 0; i < thisKeys.size(); i++) {
      TemplateType thisKey = thisKeys.get(i);
      JSType thisType = getResolvedTemplateType(thisKey);
      EquivalenceMatch thisMatch = EquivalenceMatch.NO_KEY_MATCH;

      for (int j = 0; j < thatKeys.size(); j++) {
        TemplateType thatKey = thatKeys.get(j);
        JSType thatType = that.getResolvedTemplateType(thatKey);

        // Cross-compare every key-value pair in this TemplateTypeMap with
        // those in that TemplateTypeMap. Update the Equivalence match for both
        // key-value pairs involved.
        if (thisKey == thatKey) {
          EquivalenceMatch newMatchType = EquivalenceMatch.VALUE_MISMATCH;
          if (thisType.checkEquivalenceHelper(thatType, eqMethod)) {
            newMatchType = EquivalenceMatch.VALUE_MATCH;
          }

          if (thisMatch != EquivalenceMatch.VALUE_MATCH) {
            thisMatch = newMatchType;
          }
          if (thatMatches[j] != EquivalenceMatch.VALUE_MATCH) {
            thatMatches[j] = newMatchType;
          }
        }
      }

      if (failedEquivalenceCheck(thisMatch, eqMethod)) {
>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
        return false;
      }
    }

<<<<<<< HEAD
    return thisNumKeys == thatNumKeys ||
        eqMethod == EquivalenceMethod.INVARIANT;
  }

  /**
   * Returns a new TemplateTypeMap whose keys have been extended with the
   * specified list.
   */
  TemplateTypeMap extendKeys(ImmutableList<String> newKeys) {
    return registry.createTemplateTypeMap(
        concatImmutableLists(templateKeys, newKeys), templateValues);
=======
    for (int i = 0; i < thatMatches.length; i++) {
      if (failedEquivalenceCheck(thatMatches[i], eqMethod)) {
        return false;
      }
    }

    return true;
  }

  /**
   * Determines if the specified EquivalenceMatch is considered a failing
   * condition for an equivalence check, given the EquivalenceMethod used for
   * the check.
   */
  private boolean failedEquivalenceCheck(
      EquivalenceMatch eqMatch, EquivalenceMethod eqMethod) {
    return eqMatch == EquivalenceMatch.VALUE_MISMATCH ||
        (eqMatch == EquivalenceMatch.NO_KEY_MATCH &&
         eqMethod != EquivalenceMethod.INVARIANT);
  }

  /**
   * Extends this TemplateTypeMap with the contents of the specified map.
   * UNKNOWN_TYPE will be used as the value for any missing values in the
   * specified map.
   */
  TemplateTypeMap extend(TemplateTypeMap thatMap) {
    thatMap = thatMap.addUnknownValues();
    return registry.createTemplateTypeMap(
        concatImmutableLists(thatMap.templateKeys, templateKeys),
        concatImmutableLists(thatMap.templateValues, templateValues));
>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
  }

  /**
   * Returns a new TemplateTypeMap whose values have been extended with the
   * specified list.
   */
<<<<<<< HEAD
  TemplateTypeMap extendValues(ImmutableList<JSType> newValues) {
=======
  TemplateTypeMap addValues(ImmutableList<JSType> newValues) {
>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
    // Ignore any new template values that will not align with an existing
    // template key.
    int numUnfilledKeys = numUnfilledTemplateKeys();
    if (numUnfilledKeys < newValues.size()) {
      newValues = newValues.subList(0, numUnfilledKeys);
    }

    return registry.createTemplateTypeMap(
        templateKeys, concatImmutableLists(templateValues, newValues));
  }

  /**
<<<<<<< HEAD
=======
   * Returns a new TemplateTypeMap, where all unfilled values have been filled
   * with UNKNOWN_TYPE.
   */
  private TemplateTypeMap addUnknownValues() {
    int numUnfilledTemplateKeys = numUnfilledTemplateKeys();
    if (numUnfilledTemplateKeys == 0) {
      return this;
    }

    ImmutableList.Builder<JSType> builder = ImmutableList.builder();
    for (int i = 0; i < numUnfilledTemplateKeys; i++) {
      builder.add(registry.getNativeType(JSTypeNative.UNKNOWN_TYPE));
    }
    return addValues(builder.build());
  }

  /**
>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
   * Concatenates two ImmutableList instances. If either input is empty, the
   * other is returned; otherwise, a new ImmutableList instance is created that
   * contains the contents of both arguments.
   */
  private <T> ImmutableList<T> concatImmutableLists(
    ImmutableList<T> first, ImmutableList<T> second) {
    if (first.isEmpty()) {
      return second;
    }
    if (second.isEmpty()) {
      return first;
    }
    ImmutableList.Builder<T> builder = ImmutableList.builder();
    builder.addAll(first);
    builder.addAll(second);
    return builder.build();
  }

  boolean hasAnyTemplateTypesInternal() {
    for (JSType templateValue : templateValues) {
      if (templateValue.hasAnyTemplateTypes()) {
        return true;
      }
    }
    return false;
  }
}
