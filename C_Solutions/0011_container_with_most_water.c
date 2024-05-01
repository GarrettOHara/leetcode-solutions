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
