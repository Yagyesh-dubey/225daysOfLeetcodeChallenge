class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& hs) {
        priority_queue < pair<int, pair<int, int>>, vector < pair<int, pair<int, int>> >, greater<pair<int, pair<int, int>> >> pq;
        int n = hs.size(), m = hs[0].size();
        vector<vector<int>> adiff(n, vector<int>(m, 1e9));
        vector<vector<int>> ways = { {0, 1},{0, -1}, {-1, 0}, {1,0} };

        adiff[0][0] = 0;
        pq.push({ 0, {0, 0} }); // {diff, {x, y}}

        while (pq.size()) {
            auto it = pq.top(); pq.pop();
            int dif = it.first, i = it.second.first, j = it.second.second;
            if (i == n - 1 && j == m - 1) return dif;

            for (auto &w : ways) {
                int x = w[0] + i, y = w[1] + j;
                if (x >= 0 && x < n && y >= 0 && y < m && max(dif, abs(hs[i][j] - hs[x][y])) < adiff[x][y]) {
                    adiff[x][y] = max(dif, abs(hs[i][j] - hs[x][y]));
                    pq.push({ adiff[x][y], {x, y} });
                }
            }
        }
        return 0;
    }
};
