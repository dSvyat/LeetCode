package LeetCode.MediumLevel;

import java.util.Arrays;
import java.util.Collections;

/*
Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */
public class ReverseInteger {
    public static int reverse(int x) {
        long reversed = 0;
        while (x != 0) {
            reversed = reversed * 10 + x % 10;
            x = x / 10;
            if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) return 0;
        }
        return (int) reversed;
    }
}
