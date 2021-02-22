package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class Base10ConverterTest {

  Base10Converter converter = new Base10Converter();

  int[][] convertToBaseParams = {
      {10, 2},
      {2, 10},
      {15, 16},
      {36, 36},
      {35, 36},
      {-1, 2}
  };

  String[] convertToBaseExpected = {
      "1010",
      "2",
      "F",
      "10",
      "Z",
      "-1"
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
  }
}