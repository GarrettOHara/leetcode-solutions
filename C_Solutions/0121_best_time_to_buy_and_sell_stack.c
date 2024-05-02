#include <stdio.h>

/**
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

Constraints:
    1 <= prices.length <= 105
    0 <= prices[i] <= 104
*/
int max(int a, int b) {
    return (a > b) ? a : b;
}

int maxProfit(int* prices, int pricesSize) {
    int res = 0, lowest = INT_MAX;
    int i;
    for(i = 0; i < pricesSize; i++) {
        if(prices[i] < lowest)
            lowest = prices[i];

        res = max(prices[i]-lowest, res);
    }
    return res;
}

int twoPointers(int* prices, int pricesSize) {
    int res = 0, left = 0, right = 1;
    int i;

    while(right < pricesSize) {
        int profit = prices[right] - prices[left];
        res = max(res, profit);

        if (prices[left] > prices[right])
              left = right;

        right++;
    }
    return res;
}

int main() {
    int prices1[] = {7, 1, 5, 3, 6, 4};
    int prices2[] = {7, 6, 4, 3, 1};
    int prices3[] = {3, 8, 2, 5, 1, 6};

    int size1 = sizeof(prices1) / sizeof(prices1[0]);
    int size2 = sizeof(prices2) / sizeof(prices2[0]);
    int size3 = sizeof(prices3) / sizeof(prices3[0]);

    printf("Test Case 1: Max Profit: %d\n", maxProfit(prices1, size1));
    printf("Test Case 2: Max Profit: %d\n", maxProfit(prices2, size2));
    printf("Test Case 3: Max Profit: %d\n", maxProfit(prices3, size3));

    printf("\nUsing twoPointers function:\n");
    printf("Test Case 1: Max Profit: %d\n", twoPointers(prices1, size1));
    printf("Test Case 2: Max Profit: %d\n", twoPointers(prices2, size2));
    printf("Test Case 3: Max Profit: %d\n", twoPointers(prices3, size3));

    return 0;
}
