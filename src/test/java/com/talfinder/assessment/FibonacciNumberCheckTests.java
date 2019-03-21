package com.talfinder.assessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FibonacciNumberCheckTests {
  private Type type;
  private int min;
  private int max;
  private int[] input;

  public FibonacciNumberCheckTests( Type type, int min, int max, int[] input) {
    this.type = type;
    this.min = min;
    this.max = max;
    this.input = input;
  }

  enum Type {FIBONACCI, NON_FIBONACCI};
  @Parameters
  public static Collection<Object[]> parameters() {
    return Arrays.asList(new Object[][] {
        {Type.FIBONACCI, 0, 200, new int[]{0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144}},
        {Type.NON_FIBONACCI, 0, 50, new int[]{4, 6, 7, 9, 10, 11, 12, 14, 15, 16, 17, 18, 19, 20, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49}},
        {Type.NON_FIBONACCI, 50, 100, new int[]{50, 51, 52, 53, 54, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99}},
        {Type.NON_FIBONACCI, 100, 150, new int[]{100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 145, 146, 147, 148, 149}},
        {Type.NON_FIBONACCI, 150, 200, new int[]{150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199}}

    });
  }

  @Test
  public void testFibonacciSequence() {
    Assume.assumeTrue("Skipped", type == Type.FIBONACCI);
    List<Integer> expectedSet = Arrays.stream(input).boxed().collect(Collectors.toList());
    List<Integer> actualSet = new ArrayList<>();

    for (int ctr = min; ctr < max; ctr++) {
      boolean isFibonacci = FibonacciNumberCheck.isFibonacci(ctr);
     if (isFibonacci) {
        actualSet.add(ctr);
      }
    }
    Assert.assertEquals("input:Checking for Fibonacci from " + min + " to " + max, expectedSet.toString(), actualSet.toString());
  }

  @Test
  public void testNonFibonacciSequence() {
    Assume.assumeTrue("Skipped", type == Type.NON_FIBONACCI);
    List<Integer> expectedSet = Arrays.stream(input).boxed().collect(Collectors.toList());
    List<Integer> actualSet = new ArrayList<>();

    for (int ctr = min; ctr < max; ctr++) {
      boolean isFibonacci = FibonacciNumberCheck.isFibonacci(ctr);
      if (!isFibonacci) {
        actualSet.add(ctr);
      }
    }
    Assert.assertEquals("input:Checking for Non Fibonacci from " + min + " to " + max, expectedSet.toString(), actualSet.toString());
  }
}
