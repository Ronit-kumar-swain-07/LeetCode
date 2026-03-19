# 3212. Count Submatrices With Equal Frequency of X and Y

# Given a 2D character matrix grid, where grid[i][j] is either 'X', 'Y', or '.', return the number of submatrices that contain:

# grid[0][0]
# an equal frequency of 'X' and 'Y'.
# at least one 'X'.

# Example 1:
# Input: grid = [["X","Y","."],["Y",".","."]]
# Output: 3
# Explanation:

# Example 2:
# Input: grid = [["X","X"],["X","Y"]]
# Output: 0
# Explanation:
# No submatrix has an equal frequency of 'X' and 'Y'.

# Example 3:
# Input: grid = [[".","."],[".","."]]
# Output: 0
# Explanation:
# No submatrix has at least one 'X'.

# Constraints:
# 1 <= grid.length, grid[i].length <= 1000
# grid[i][j] is either 'X', 'Y', or '.'.

#Code
class Solution:
    def numberOfSubmatrices(self, grid: List[List[str]]) -> int:
        rows = len(grid)
        cols = len(grid[0])
        res = 0
        freq = [[[0,0] for _ in range(cols)]for _ in range(rows)]

        if grid[0][0] == "X":
            freq[0][0][0] = 1
        elif grid[0][0] == "Y":
            freq[0][0][1] = 1
        else:
            freq[0][0] = [0,0]

        for j in range(1,cols):
            if grid[0][j] == "X":
                freq[0][j] = [freq[0][j-1][0]+1,freq[0][j-1][1]]
            elif grid[0][j] == "Y":
                freq[0][j] = [freq[0][j-1][0],freq[0][j-1][1]+1]
            else:
                freq[0][j] = freq[0][j-1]
            if freq[0][j][0] == freq[0][j][1] and freq[0][j][0]>0:
                res+= 1

        for i in range(1,rows):
            if grid[i][0] == "X":
                freq[i][0] = [freq[i-1][0][0]+1,freq[i-1][0][1]]
            elif grid[i][0] == "Y":
                freq[i][0] = [freq[i-1][0][0],freq[i-1][0][1]+1]
            else:
                freq[i][0] = freq[i-1][0]
            if freq[i][0][0] == freq[i][0][1] and freq[i][0][0]>0:
                res+= 1
        for i in range(1,rows):
            for j in range(1,cols):
                x = freq[i-1][j][0] + freq[i][j-1][0]
                y = freq[i-1][j][1] + freq[i][j-1][1]
                zx = freq[i-1][j-1][0]
                zy = freq[i-1][j-1][1]
                if grid[i][j] == "X":
                    freq[i][j] = [x-zx+1,y-zy]
                elif grid[i][j] == "Y":
                    freq[i][j] = [x-zx,y-zy+1]
                else:
                    freq[i][j] = [x-zx,y-zy]

                if freq[i][j][0] == freq[i][j][1] and freq[i][j][0]>0:
                    res+= 1
        return res