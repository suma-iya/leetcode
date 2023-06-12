class Solution {
public:
    typedef long long ll;
    int missingNumber(vector<int>& nums) {
        int sz = nums.size();
        ll sum = 0;
        for(int i = 0; i<sz; ++i){
            sum+=nums[i];
        }
        ll total = (sz*(sz+1))/2;
        return total-sum;
    }
};
