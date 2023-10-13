class Solution {
    bool findItineraryHelp(string &from, unordered_map<string, vector<string>> &mpp, vector<string> &ans, int n){
        if( ans.size() == n+1 ) return 1;

        for(int i=0; i<mpp[from].size(); i++){
            string to = mpp[from][i];
            if( to == "$$$" ) continue;

            // mark it as visited
            mpp[from][i] = "$$$";
            ans.push_back(to);

            // check if using [from, to] ticket we can traverse all the city
            if( findItineraryHelp(to, mpp, ans, n) ) return 1;
            else{
                mpp[from][i] = to; // backtrack
                ans.pop_back();
            }
        }
        return 0;
    }

public:
    vector<string> findItinerary(vector<vector<string>>& ts) {
        unordered_map<string, vector<string>> mpp;
        int n = ts.size();
        vector<string> ans;
        string start = "JFK";

        for(auto t : ts ) mpp[t[0]].push_back(t[1]);

        // sort TOs a/c to lexicographically order
        for(auto &x : mpp){
            sort(x.second.begin(), x.second.end());
        }

        ans.push_back(start);
        findItineraryHelp(start, mpp, ans, n);
        return ans;
    }
};
