#include <stdio.h>

/**
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:
    1 <= n <= 45
**/

int climbStairs(int n) {
    if (n <= 1)
        return n;

    int stairs[n];
    stairs[0] = 1;
    stairs[1] = 2;
    int i;
    for (i = 2; i < n; i++) {
        stairs[i] = stairs[i - 1] + stairs[i - 2];
    }
    return stairs[n - 1];
}

// Test cases
void testClimbStairs(int n, int expected) {
    int result = climbStairs(n);
    if (result == expected) {
        printf("Test case passed for n = %d. Expected: %d, Actual: %d\n", n, expected, result);
    } else {
        printf("Test case FAILED for n = %d. Expected: %d, Actual: %d\n", n, expected, result);
    }
}

int main() {
    // Test cases
    testClimbStairs(0, 0);
    testClimbStairs(1, 1);
    testClimbStairs(2, 2);
    testClimbStairs(3, 3);
    testClimbStairs(4, 5);

    return 0;
}

