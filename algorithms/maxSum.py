import sys
prices = [13, 10, 8, 4, 10]
def solution(prices):
    print(prices)
    hi = len(prices)
    print(hi)
    return divideConqure(prices,0,hi-1)
    pass

def crossingArray(arr, lo, mid, hi):
    sum = 0
    leftSum = -sys.maxsize-1
    for i in range(mid, lo-1, -1):
        sum += arr[i]
        if sum > leftSum:
            leftSum = sum
    sum = 0
    rightSum = -sys.maxsize-1
    for i in range(mid+1, hi+1):
        sum += arr[i]
        if sum > rightSum: 
            rightSum = sum
    return max(leftSum + rightSum, leftSum, rightSum)

def divideConqure(arr, lo, hi):
    if lo == hi:
        return arr[lo]
    mid = (hi + lo) // 2
    return max(divideConqure(arr, lo, mid),
            divideConqure(arr, mid+1,hi),
            crossingArray(arr, lo, mid, hi))

if __name__ == '__main__':
    print(solution(prices))
