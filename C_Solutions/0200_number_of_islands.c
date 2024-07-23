#include <stdio.h>
#include <stdlib.h>

/**

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

 

Constraints:
    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] is '0' or '1'.



**/

void dfs(int i, int j, char** grid, int gridSize, int* gridColSize) {
    if(i < 0 || i >= gridSize || j < 0 || j >= gridColSize[i] || grid[i][j] != '1') 
        return;

    grid[i][j] = 'x';

    dfs(i+1, j, grid, gridSize, gridColSize);
    dfs(i-1, j, grid, gridSize, gridColSize);
    dfs(i, j+1, grid, gridSize, gridColSize);
    dfs(i, j-1, grid, gridSize, gridColSize);
    return;
}

int numIslands(char** grid, int gridSize, int* gridColSize) {
    int islands = 0, i = 0, j = 0; 
    for(i = 0; i < gridSize; i++){
        for(j = 0; j < gridColSize[i]; j++) {
            if(grid[i][j] == '1') {
                dfs(i, j, grid, gridSize, gridColSize);
                islands++;
            }
        }
    }

    return islands;
}

int main() {
    char* grid1[] = {"11110", "11010", "11000", "00000"};
    char* grid2[] = {"11000", "11000", "00100", "00011"};

    int colSize1 = 5;
    int colSize2 = 5;

    int islands1 = numIslands(grid1, 4, &colSize1);
    int islands2 = numIslands(grid2, 4, &colSize2);

    printf("Number of islands in grid 1: %d\n", islands1); // Output: 1
    printf("Number of islands in grid 2: %d\n", islands2); // Output: 3

    return 0;
}
