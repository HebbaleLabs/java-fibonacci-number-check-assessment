package com.talfinder.assessment;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

public class FibonacciNumberCheckTests {

  int fibonacciNums[] = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};

  @Test
  public void testForKnownFibonacciSequence() {
    // Given we know 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 are Fibonacci numbers,
    // test if the function identifies them as Fibonacci numbers
    for (int fibonacciNum : fibonacciNums) {
      boolean isFibonacci = FibonacciNumberCheck.isFibonacci(fibonacciNum);
      assertThat(isFibonacci, is(equalTo(true)));
    }
  }

  @Test
  public void testForKnownFailures() {
    // Given we know 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 are Fibonacci numbers,
    // test if the rest of the numbers from 0 to 200 are not fibonacci numbers
    Set<Integer> knownFibonaccis = Arrays.stream(fibonacciNums).boxed().collect(Collectors.toSet());
    for (int ctr = 0; ctr < 200; ctr++) {
      boolean isFibonacci = FibonacciNumberCheck.isFibonacci(ctr);
      if (knownFibonaccis.contains(ctr)) {
        assertThat(isFibonacci, is(equalTo(true)));
      } else {
        assertThat(isFibonacci, is(equalTo(false)));
      }
    }
  }

  @Test
  public void testForRandomFibonacciSequence() {
    // Generate a new sequence of fibonacci numbers (up to the 40th fibonacci number from 0) based on the known set
    java.util.Random random = new Random();
    int fibonacciNumsToGenerate = random.nextInt(40 - fibonacciNums.length);
    int first = fibonacciNums[fibonacciNums.length - 2];
    int second = fibonacciNums[fibonacciNums.length - 1];
    while (fibonacciNumsToGenerate > 0) {
      int nextNum = first + second;
      first = second;
      second = nextNum;
      boolean isFibonacci = FibonacciNumberCheck.isFibonacci(nextNum);
      assertThat(nextNum + " is not a fibonacci num", isFibonacci, is(equalTo(true)));
      fibonacciNumsToGenerate--;
    }
  }

  @Test
  public void testForLargeFibonacciNumbers() {
    // Generate a new sequence of fibonacci numbers (at least the first hundred fibonacci numbers starting from 0) based on the known set
    java.util.Random random = new Random();
    int fibonacciNumsToGenerate = random.nextInt(25) + 100 - fibonacciNums.length;
    int first = fibonacciNums[fibonacciNums.length - 2];
    int second = fibonacciNums[fibonacciNums.length - 1];
    while (fibonacciNumsToGenerate > 0) {
      int nextNum = first + second;
      first = second;
      second = nextNum;
      boolean isFibonacci = FibonacciNumberCheck.isFibonacci(nextNum);
      assertThat(nextNum + " is not a fibonacci num", isFibonacci, is(equalTo(true)));
      fibonacciNumsToGenerate--;
    }
  }
}
