class Solution:
    def findTheString(self, lcp):
        n = len(lcp)
        res = [''] * n
        ch = 'a'
        for i in range(n):
            if res[i] == '':
                if ch > 'z':
                    return ""
                res[i] = ch
                
                for j in range(i + 1, n):
                    if lcp[i][j] > 0:
                        res[j] = ch
                
                ch = chr(ord(ch) + 1)
        

        dp = [[0] * (n + 1) for _ in range (n+1)]
        
        for i in range(n - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if res[i] == res[j]:
                    dp[i][j] = 1 + dp[i + 1][j + 1]
        
        
        for i in range(n):
            for j in range(n):
                if dp[i][j] != lcp[i][j]:
                    return ""
        
        return "".join(res)