package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class Base10ConverterTest {

  Base10Converter converter = new Base10Converter();

  int[][] convertToBaseParams = {
      {10, 2},
      {2, 10},
      {9, 10},
      {10, 10},
      {15, 16},
      {16, 16},
      {35, 36},
      {36, 36},
      {0, 21},
      {-1, 2},
      {Integer.MAX_VALUE, 2},
      {Integer.MAX_VALUE, 8},
      {Integer.MAX_VALUE, 16},
      {Integer.MAX_VALUE, 36},
      {Integer.MIN_VALUE + 1, 10},
      {1059254948, 36}
  };

  String[] convertToBaseExpected = {
      "1010",
      "2",
      "9",
      "10",
      "F",
      "10",
      "Z",
      "10",
      "0",
      "-1",
      "1111111111111111111111111111111",
      "17777777777",
      "7FFFFFFF",
      "ZIK0ZJ",
      "-2147483647",
      "HINICK"
  };

  @Test
  void convertToBase() {

    for (int i = 0; i < convertToBaseParams.length; i++) {
      String params = Arrays.toString(convertToBaseParams[i]);
      String expected = convertToBaseExpected[i];
      String actual = converter.convertToBase(convertToBaseParams[i][0], convertToBaseParams[i][1]);
      System.out.printf("Params: %s; Expected: %s; Actual: %s%n", params, expected, actual);
      assertEquals(expected, actual);
    }
    System.out.println("Testing illegal base argument...");
    assertThrows(IllegalArgumentException.class, () -> converter.convertToBase(1, 37));
    System.out.println("Testing illegal value argument (Integer.MIN_VALUE sneaking through)...");
    assertThrows(IllegalArgumentException.class, () -> converter.convertToBase(Integer.MIN_VALUE, 16));
  }
}