class Solution {
public:
    vector<int>dp;
    int solve(int n){
        if(n<=2) return n;
        if(dp[n]!=-1) return dp[n];
        dp[n] = solve(n-1)+solve(n-2);
        return dp[n];
    }

    int climbStairs(int n) {
        dp.resize(n+1);
        for(int i = 0; i<=n; ++i) dp[i] = -1;
        return solve(n);
    }
};