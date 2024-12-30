package main

import (
	"fmt"
	"testing"
	"time"
)

// O(n^2)
func climbStairsRecursion(n int) int {
	if n == 0 {
		return 1
	} else if n == 1 {
		return 1
	}

	return climbStairsRecursion(n-1) + climbStairsRecursion(n-2)
}

// O(n)
func climbStairsTabulation(n int) int {
	mem := make([]int, n+1)
	mem[0], mem[1] = 1, 1

	for i := 2; i < len(mem); i++ {
		mem[i] = mem[i-1] + mem[i-2]
	}
	return mem[n]
}

// O(n)
func climbStairsMemo(n int) int {
	memo := make(map[int]int)
	return memoHelper(n, memo)
}
func memoHelper(n int, memo map[int]int) int {
	if n <= 1 {
		return 1
	}
	if _, found := memo[n]; found {
		return memo[n]
	}
	memo[n] = memoHelper(n-1, memo) + memoHelper(n-2, memo)
	return memo[n]
}

func TestClimbStairs(t *testing.T) {
	tests := []struct {
		n        int
		expected int
	}{
		{n: 2, expected: 2},
		{n: 3, expected: 3},
		{n: 4, expected: 5},
		{n: 5, expected: 8},
		{n: 6, expected: 13},
		{n: 7, expected: 21},
		{n: 20, expected: 10946},
		{n: 30, expected: 1346269},
	}

	fmt.Printf("\n\nRunning Recursive:\n\n")
	for _, test := range tests {
		start := time.Now()
		result := climbStairsRecursion(test.n)
		duration := time.Since(start)

		if result != test.expected {
			t.Errorf("For n = %d, expected %d, but got %d", test.n, test.expected, result)
		} else {
			t.Logf("For n = %d, got expected result %d in %v", test.n, result, duration)
		}
	}

	fmt.Printf("\n\nRunning Tabulation:\n\n")
	for _, test := range tests {
		start := time.Now()
		result := climbStairsTabulation(test.n)
		duration := time.Since(start)

		if result != test.expected {
			t.Errorf("For n = %d, expected %d, but got %d", test.n, test.expected, result)
		} else {
			t.Logf("For n = %d, got expected result %d in %v", test.n, result, duration)
		}
	}

	fmt.Printf("\n\nRunning Memoization:\n\n")
	for _, test := range tests {
		start := time.Now()
		result := climbStairsMemo(test.n)
		duration := time.Since(start)

		if result != test.expected {
			t.Errorf("For n = %d, expected %d, but got %d", test.n, test.expected, result)
		} else {
			t.Logf("For n = %d, got expected result %d in %v", test.n, result, duration)
		}
	}
}

/**

Both **tabulation** and **memoization** are dynamic programming (DP) techniques that help solve problems efficiently by breaking them down into overlapping subproblems and avoiding redundant calculations. However, they have different approaches:

### 1. Tabulation (Bottom-Up)

Tabulation involves solving the problem iteratively in a "bottom-up" fashion. You start by solving the simplest subproblems and iteratively build up to the solution for the original problem. Here’s how it works:

- **Approach**: You initialize a table (usually an array) where each entry corresponds to the result of a subproblem.
- **Computation**: You fill in the table from the smallest subproblem up to the problem’s solution.
- **Example**: Calculating Fibonacci numbers using an array to store previously calculated values.

**Advantages of Tabulation**:
- **Time Efficiency**: Typically faster for problems where an iterative approach can be used directly.
- **Space Efficiency**: You can often reduce space by only keeping track of recent values needed for the computation, rather than an entire table (e.g., reducing from \(O(n)\) to \(O(1)\) in the Fibonacci sequence).

**Drawbacks**:
- **Sequential Processing**: All subproblems must be solved sequentially, even if some aren't required, which can be inefficient if you only need specific subproblem solutions.

**Example Code** (Fibonacci Sequence):
```go
func fibonacci(n int) int {
    if n <= 1 {
        return n
    }
    fib := make([]int, n+1)
    fib[0], fib[1] = 0, 1
    for i := 2; i <= n; i++ {
        fib[i] = fib[i-1] + fib[i-2]
    }
    return fib[n]
}
```

### 2. Memoization (Top-Down)

Memoization is a "top-down" approach where you solve the problem recursively but store results of subproblems in a cache (often a dictionary or array) to avoid redundant calculations.

- **Approach**: You start by solving the original problem, breaking it into subproblems recursively, and caching results as you go.
- **Computation**: Each subproblem is solved only once and stored for future use, allowing you to retrieve cached results in subsequent recursive calls.
- **Example**: Calculating Fibonacci numbers using a recursive function that stores results of each Fibonacci number in a map.

**Advantages of Memoization**:
- **On-Demand Calculation**: Only required subproblems are calculated, making it efficient for problems where not all subproblems are needed.
- **Natural Fit for Recursive Problems**: Easy to implement for problems that have a recursive structure, like the Fibonacci sequence.

**Drawbacks**:
- **Stack Overhead**: Recursive calls can lead to a large stack overhead, which may cause stack overflow errors for large inputs without tail call optimization (which Go does not support).

**Example Code** (Fibonacci Sequence):
```go
func fibonacci(n int) int {
    memo := make(map[int]int)
    return fibMemo(n, memo)
}

func fibMemo(n int, memo map[int]int) int {
    if n <= 1 {
        return n
    }
    if _, exists := memo[n]; !exists {
        memo[n] = fibMemo(n-1, memo) + fibMemo(n-2, memo)
    }
    return memo[n]
}
```

### Comparison Summary

| Aspect             | Tabulation                       | Memoization                       |
|--------------------|----------------------------------|-----------------------------------|
| **Approach**       | Bottom-up (iterative)           | Top-down (recursive)              |
| **Storage**        | Table or array for all subproblems | Cache (map/array) for used subproblems |
| **Control Flow**   | Iterative                       | Recursive                         |
| **Space Complexity** | Can be reduced in some cases  | Depends on recursive depth       |
| **Time Complexity** | \( O(n) \)                     | \( O(n) \)                        |
| **When to Use**    | When all subproblems must be solved, or problem is naturally iterative | When only some subproblems are needed, or problem is naturally recursive |

### Conclusion

- **Use Tabulation** when the problem can naturally be solved iteratively, or when you need to calculate all subproblems.
- **Use Memoization** when the problem has a natural recursive structure, and only specific subproblems are required (for instance, solving tree or graph-based problems where not all nodes are needed).

Both approaches yield the same time complexity for DP problems, but the choice can affect readability, space efficiency, and suitability based on the problem structure.

**/
