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
