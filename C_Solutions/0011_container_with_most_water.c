#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

/**
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.


Example 1:

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:

Input: height = [1,1]
Output: 1
*/

int min(int a, int b) {
    return (a < b) ? a : b;
}

int maxArea(int* height, int heightSize) {
    int max = INT_MIN, left = 0, right = heightSize-1;
    while (left < right) {
        int area = (right - left) * min(height[left], height[right]);
        if (area > max)
            max = area;

        if (height[left] < height[right])
            left++;
        else
            right--;
    }
    return max;
}

/**
O(n^2) Solution
**NOTE** This fails because it takes too long

int maxArea(int* height, int heightSize) {
    int max = INT_MIN;
    int i = 0, j = 0, verticle = 0;
    for(i = 0; i < heightSize; i++) {
        for(j = i+1; j < heightSize; j++) {
            int area = (j - i) * min(height[i], height[j]);
            if (area > max)
                max = area;
        }
    }
    return max;
}
**/

int main() {
    // Test Case 1
    int height1[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int size1 = sizeof(height1) / sizeof(height1[0]);
    printf("Test Case 1: %d\n", maxArea(height1, size1));

    // Test Case 2
    int height2[] = {1, 1};
    int size2 = sizeof(height2) / sizeof(height2[0]);
    printf("Test Case 2: %d\n", maxArea(height2, size2));

    return 0;
}
