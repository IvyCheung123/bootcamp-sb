package com.bootcamp.sb.sb_calculator.model;

import java.util.Arrays;

public class Database {
  // private static final String[] strings = new String[] {"abc", "def", "ijk"};
  private static String[] strings = new String[] {"abc", "def", "ijk"};

  public static int size() {
    return strings.length;
  }  

  public static String addString(String newString) {
    String[] newArray = Arrays.copyOf(strings, strings.length + 1);
    newArray[newArray.length - 1] = newString;
    strings = newArray;
    return newString;
  }

  public static String getString(int index) {
    return strings[index];
  }

  public static String[] getStrings() {
    return strings;
  }
}
