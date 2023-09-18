class Solution {
public:
    
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
      vector<pair<int,int>> sol(mat.size() + 1);
      int k1 = 0;
      for(int i = 0; i < mat.size(); i++){
        for(int j = 0; j < mat[0].size(); j++){
          sol[i + 1].first += mat[i][j];
          sol[i + 1].second = i;
        }
      }
      for(int i = 1; i <= mat.size(); i++){
        cout << sol[i].first << " " << sol[i].second << "\n";
      }
      vector<int> ans;
      // Sorting by value using Bubble sort
      for(int i = 1; i < sol.size(); i++){
        for(int j = i + 1; j < sol.size(); j++){
          if(sol[i].first > sol[j].first){
            swap(sol[i].first,sol[j].first);
            swap(sol[i].second,sol[j].second);
          }
          else if(sol[i].first == sol[j].first && sol[i].second > sol[j].second){
            swap(sol[i].first,sol[j].first);
            swap(sol[i].second,sol[j].second);
          }
        }
      }
      for(int i = 1; i <= k; i++){
        ans.push_back(sol[i].second);
      }
      return ans;
    }
};
