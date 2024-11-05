class Solution {
public:
    int minChanges(string s) {
        int sum = 0;
        for(int i = 0; i<s.size(); i+=2){
            sum+=s[i]!=s[i+1];
        }
        return sum;
    }
};