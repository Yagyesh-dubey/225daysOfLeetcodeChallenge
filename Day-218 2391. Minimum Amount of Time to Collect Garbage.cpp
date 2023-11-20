class Solution {
public:
    int garbageCollection(vector<string>& garbage, vector<int>& travel) {
        int n = garbage.size();
        int G_idx = 0;
        int P_idx = 0;
        int M_idx = 0;
        int TimeToTake = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < garbage[i].size(); j++)
            {
                if(garbage[i][j] == 'M')
                    M_idx = i;
                else if(garbage[i][j] == 'P')
                    P_idx = i;
                else
                    G_idx = i;
                TimeToTake++;
            }
        }

        for(int i = 1; i < travel.size(); i++)
        {
            travel[i] += travel[i - 1];
        }

        TimeToTake += (M_idx > 0) ? travel[M_idx-1] : 0;
        TimeToTake += (P_idx > 0) ? travel[P_idx-1] : 0;
        TimeToTake += (G_idx > 0) ? travel[G_idx-1] : 0;

        return TimeToTake;
    }
};
