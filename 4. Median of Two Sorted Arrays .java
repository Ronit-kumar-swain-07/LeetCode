/*
4. Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
*/

// BUT THIS SOLUTION IS O(m+n) NOT O(log(m+n)) BUT WORKING 1ms.


//Code
import java.util.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] res = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }

        while (i < n) res[k++] = nums1[i++];
        while (j < m) res[k++] = nums2[j++];
        int x = res.length;

        if(x % 2 != 0) {
            return res[x/2];
        }
        else {
            return (double)(res[x/2] + res[(x/2)-1]) / 2;
        }
    }
}

// Running Time : 5ms

class solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        ArrayList<Integer> res = new ArrayList<>();
        for(int a : nums1) {
            res.add(a);
        }
        for(int a : nums2){
            res.add(a);
        }

        Collections.sort(res);

        int x = res.size();

        if(x % 2 != 0) {
            return res.get(x/2);
        }
        else {
            return (double)((res.get(x/2) + res.get((x/2)-1)) / 2.0);
        }
    }
}