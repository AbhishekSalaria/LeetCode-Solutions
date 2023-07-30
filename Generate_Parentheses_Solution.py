class Solution:
    def getresult(self,n,open,close,s,ans):
        if(open == n and close == n):
            ans.append(s)
            return
        if(open < n):
            self.getresult(n,open+1,close,s+"(",ans)
        if(close < open):
            self.getresult(n,open,close+1,s+")",ans)
        return ans
    def generateParenthesis(self, n: int) -> List[str]:
        return self.getresult(n,0,0,"",[])