/*
2544. Alternating Digit Sum

You are given a positive integer n. Each digit of n has a sign according to the following rules:

The most significant digit is assigned a positive sign.
Each other digit has an opposite sign to its adjacent digits.
Return the sum of all digits with their corresponding sign.

Example 1:
Input: n = 521
Output: 4
Explanation: (+5) + (-2) + (+1) = 4.

Example 2:
Input: n = 111
Output: 1
Explanation: (+1) + (-1) + (+1) = 1.

Example 3:
Input: n = 886996
Output: 0
Explanation: (+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0.

Constraints:
1 <= n <= 109
*/

//Code

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int alternateDigitSum(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        while(n != 0) {
            int digit = n%10;
            arr.add(digit);
            n /= 10;
        }
        Collections.reverse(arr);
        // int sum1 = 0, sum2 = 0;
        int sum = 0;
        for(int i = 0; i<arr.size();i++) {
            if(i % 2 == 0) {
                //sum1 += arr.get(i);
                sum += arr.get(i);
            }
            else {
                //sum2 += arr.get(i);
                sum -= arr.get(i);
            }
        }
        // return sum1 - sum2;
        return sum;
    }
}

// OR
class solution {
    public int alternateDigitSum(int n) {
        String s = Integer.toString(n);
        int sum = 0;

        for(int i = 0; i<s.length(); i++) {
            int digit = s.charAt(i) - '0';

            if(i % 2 == 0) {
                sum += digit;
            } else {
                sum -= digit;
            }
        }
        return sum;
    }
}