class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        vector<int>ans;
        map<int,int>m1;
        map<int,int>m2;
        for(int i = 0; i<nums1.size(); ++i){
            m1[nums1[i]]=1;
        }
        for(int i = 0; i<nums2.size(); ++i){
            if(m1[nums2[i]]==1){
                m1[nums2[i]]=2;
                ans.push_back(nums2[i]);
            }
        }
        return ans;
    }
};