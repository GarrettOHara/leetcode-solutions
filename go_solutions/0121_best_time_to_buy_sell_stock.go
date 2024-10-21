/*
You are given an array prices where prices[i] is the price of a given stock on
the ith day.
You want to maximize your profit by choosing a single day to buy one stock
and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you
cannot achieve any profit, return 0.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
*/
package main

import (
	"testing"
)

func maxProfit(prices []int) int {
	res, lo := 0, prices[0]

	if len(prices) == 2 {
		return prices[1] - prices[0]
	}

	for _, price := range prices {
		if price < lo {
			lo = price
		}

		if res < price-lo {
			res = price - lo
		}
	}

	return res
}

func TestMaxProfit(t *testing.T) {
	// Test cases
	testCases := []struct {
		prices []int
		expect int
	}{
		// Test case 1: Typical increasing values
		{prices: []int{7, 1, 5, 3, 6, 4}, expect: 5}, // Buy at 1, sell at 6

		// Test case 2: Constant values (no profit)
		{prices: []int{7, 7, 7, 7, 7}, expect: 0},

		// Test case 3: Decreasing values (no profit)
		{prices: []int{7, 6, 4, 3, 1}, expect: 0}, // Prices decrease, no profit can be made

		// Test case 4: Single day (no profit possible)
		{prices: []int{5}, expect: 0},

		// Test case 5: Only two prices
		{prices: []int{1, 5}, expect: 4}, // Buy at 1, sell at 5

		// Test case 6: Large profit available
		{prices: []int{2, 4, 1, 10}, expect: 9}, // Buy at 1, sell at 10

		// Test case 7: Prices rise and fall multiple times
		{prices: []int{3, 3, 5, 0, 0, 3, 1, 4}, expect: 4}, // Buy at 0, sell at 4
	}

	for i, tc := range testCases {
		result := maxProfit(tc.prices)
		if result != tc.expect {
			t.Errorf("Test case %d failed: got %d, expected %d", i+1, result, tc.expect)
		}
	}
}
