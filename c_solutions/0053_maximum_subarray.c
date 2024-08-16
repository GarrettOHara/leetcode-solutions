#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

/**
Given an integer array nums, find the
subarray
with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

Constraints:
    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
 

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
**/

int maxSubArray(int* nums, int numsSize) {
    int max = INT_MIN, sum = 0;
    int i;
    for(i = 0; i < numsSize; i++){
        sum += nums[i];

        if(sum > max)
            max = sum;

        if(sum < 0)
            sum = 0;
    }
    return max;
}

int main() {
    // Test Case 1
    int nums1[] = {-2,1,-3,4,-1,2,1,-5,4};
    int numsSize1 = sizeof(nums1) / sizeof(nums1[0]);
    printf("Test Case 1: %d\n", maxSubArray(nums1, numsSize1));

    // Test Case 2
    int nums2[] = {1};
    int numsSize2 = sizeof(nums2) / sizeof(nums2[0]);
    printf("Test Case 2: %d\n", maxSubArray(nums2, numsSize2));

    // Test Case 3
    int nums3[] = {5,4,-1,7,8};
    int numsSize3 = sizeof(nums3) / sizeof(nums3[0]);
    printf("Test Case 3: %d\n", maxSubArray(nums3, numsSize3));

    return 0;
}
