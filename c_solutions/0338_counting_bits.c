#include <stdio.h>
#include <stdlib.h>
/**
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

Example 1:
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

Constraints:
    0 <= n <= 105
**/

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
// Iterative solution
int* countBits(int n, int* returnSize) {
    *returnSize = n + 1; // Set the return size
    int* result = (int*)malloc(sizeof(int) * (*returnSize)); // Allocate memory for the result array
    int i;
    for (i = 0; i <= n; i++) {
        int num = i; 
        int count = 0;
        while(num > 0) {
            if(num & 1)
                count++;

            num >>= 1;
        }

        result[i] = count;
    }

    return result;
}

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
// Linear DP Solution
int* dynamic_programming(int n, int* returnSize) {
    *returnSize = n + 1; // Set the return size
    int* result = (int*)malloc(sizeof(int) * (*returnSize)); // Allocate memory for the result array
    int i;
    result[0] = 0;
    for (i = 1; i <= n; i++) {
        if(i%2 == 0)
            result[i] = result[i/2];
        else
            result[i] = 1 + result[i-1];
    }
    return result;
}

int main() {
    /** Case 1 **/
    int n = 5;
    int case1;
    int* case_1A = countBits(n, &case1);
    int* case_1B = dynamic_programming(n, &case1);

    // Print the result
    printf("Number of set bits in each integer from 0 to %d with Iterative approach:\n", n);
    for (int i = 0; i <= n; i++) {
        printf("%d: %d\n", i, case_1A[i]);
    }
    printf("Number of set bits in each integer from 0 to %d with Dynamic Programming approach:\n", n);
    for (int i = 0; i <= n; i++) {
        printf("%d: %d\n", i, case_1B[i]);
    }

    // Free the dynamically allocated memory
    free(case_1A);
    free(case_1B);

    /** Case 2 **/
    n = 30;
    int case2;
    int* case_2A = countBits(n, &case2);
    int* case_2B = dynamic_programming(n, &case2);

    // Print the result
    printf("Number of set bits in each integer from 0 to %d with Iterative approach:\n", n);
    for (int i = 0; i <= n; i++) {
        printf("%d: %d\n", i, case_2A[i]);
    }
    printf("Number of set bits in each integer from 0 to %d with Dynamic Programming approach:\n", n);
    for (int i = 0; i <= n; i++) {
        printf("%d: %d\n", i, case_2B[i]);
    }

    // Free the dynamically allocated memory
    free(case_2A);
    free(case_2B);
    return 0;
}
