package edu.cnm.deepdive;

public class Base10Converter {

  /**
   * Input:
   *  * integer m. (m is the value to be represented.)
   *  * integer b. (b is the number base, or radix, here assumed to be greater than 1.)
   *  * character sequence D = (d0, d1, …, db−1). (D is an ordered sequence—array or list—of
   *    digit characters used in constructing the representation)
   *
   * To construct representation of n using radix b:
   *   1. integer n = |m|. (n is a work variable, set initially to |m|.)
   *   2. string s = "". (s is the representation being constructed, initially empty.)
   *   3. While n ≠ 0: (Repeat the indented steps below this, as long as n is non-zero.)
   *     a. integer r = n % b. (r is the non-negative remainder of the division n/b.)
   *     b. s = r + s. (Prepend the digit character corresponding to r to s.)
   *     c. n = floor(n / b). (Divide n by b, round down to get the quotient, and assign the
   *        result to n.)
   *   4. If s = "", then
   *     a. s = d0. (If s is empty—i.e. no digits have been prepended to it—use the digit
   *        character corresponding to 0.)
   *      otherwise, if m<0, then
   *     a. s = "−" + s. (If m<0, prepend the minus sign to s.)
   *   5. Return s.
   * @param value Any integer in base 10.
   * @param base A numeric base from 2 to 36.
   * @throws IllegalArgumentException If base is outside the range 2 to 36 inclusive.
   * @return A string in the specified base.
   */
  public String convertToBase(int value, int base) throws IllegalArgumentException {
    if (base > 36 || base < 2) {
      throw new IllegalArgumentException();
    }
    String result = "";
    int n = Math.abs(value);
    while (n != 0) {
      int remainder = n % base;
      String remainderSymbol = this.convertToBaseSymbol(remainder);
      result = String.format("%s%s", remainderSymbol, result);
      n /= base; //int division automatically drops decimal, equivalent to floor
    }
    if (result.equals("")) {
     result = "0";
    } else {
      if (value < 0) {
        result = String.format("%s%s", "-", result);
      }
    }
    return result;
  }

  private String convertToBaseSymbol(int remainder) {
    // Values 10-35 are represented by chars 'A'-'Z', which are ascii 65-90.
    int charOffset = 55;
    String result;
    if (remainder >= 10) {
      result = Character.toString((char) remainder + charOffset);
    } else {
      result = Integer.toString(remainder);
    }
    return result;
  }
}
