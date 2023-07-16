class Solution {
public:
    int r;
    int n;
    vector<int> peoMask;
    vector<long long> dp;

    long long team(int skills_haved) {
        if (skills_haved == 0) return 0;
        if (dp[skills_haved] != INT_MAX) return dp[skills_haved];
        long long ans = n;
        for (int i = 0; i < n; i++) {
            int skills = skills_haved & ~peoMask[i];//no skills from person_i
            if (skills != skills_haved) {
                long long choosen = team(skills) | 1LL << i; //containing person_i
                bitset<60> bChoosen(choosen);
                //Check wether fewer people
                if (bChoosen.count() < bitset<60>(dp[skills_haved]).count())
                    dp[skills_haved] = choosen;
            }
        }
        return dp[skills_haved];
    }

    vector<int> smallestSufficientTeam(vector<string>& req_skills, vector<vector<string>>& people) 
    {
        r = req_skills.size();
        n = people.size();

        // Transform string to numbers
        unordered_map<string, int> skillnr;
        for (int i = 0; i < r; i++)
            skillnr[req_skills[i]] = i;

        peoMask.assign(n, 0);
        for (int i = 0; i < n; i++) {
            for (string& skill : people[i]) {
                peoMask[i] |= (1 << skillnr[skill]);
            }
        //    cout << i << "->" << peoMask[i] << endl;
        }

        // DP
        dp.assign(1<<r, INT_MAX);
        long long peoChoosen = team((1<<r)-1);
        bitset<60> X(peoChoosen);
        vector<int> ans;
        for (int i = 0; i < n; i++)
            if (X[i]) ans.push_back(i);

        return ans;
    }
};
