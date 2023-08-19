class DSU{
    int n;
    vector<int> par, size;
public:
    DSU(int n){
        this->n = n;
        par.resize(n+1, -1);
        size.resize(n+1, 1);
    }

    int findPar(int u){
        return par[u] == -1 ? u : par[u] = findPar(par[u]);
    }

    bool unite(int u, int v){
        u = findPar(u);
        v = findPar(v);
        if( u == v ) return false;
        if( size[u] > size[v] ) swap(u, v);
        par[u] = v;
        size[v] += size[u];
        return true;
    }
};



class Solution {
    int minWtKruskal(int n, vector<vector<int>> &es, vector<int> include, vector<int> exclude){
        vector<vector<int>> edges;
        for(auto &e : es){
            if( include.size() && e == include ) continue;
            if( exclude.size() && e == exclude ) continue;
            edges.push_back({e[2], e[0], e[1]});
            // edges.push_back({e[2], e[1], e[0]});
        }

        sort(edges.begin(), edges.end());
        int mstWt = 0;
        DSU dsu(n);

        if( include.size() ){
            dsu.unite(include[0], include[1]);
            mstWt += include[2];
        }

        for(auto &e : edges){
            int wt = e[0], u = e[1], v = e[2];
            
            // take the current edge in MST if it doesn't form a cycle
            if( dsu.findPar(u) != dsu.findPar(v) ){
                mstWt +=  wt;
                dsu.unite(u, v);
            }
        }
        return mstWt;
    }


public:
    vector<vector<int>> findCriticalAndPseudoCriticalEdges(int n, vector<vector<int>>& es) {
        int minWt = minWtKruskal(n, es, {}, {});
        vector<vector<int>> ans(2);
        cout<<minWt<<" ";

        for(int i=0; i<es.size(); i++){
            int minWt2 = minWtKruskal(n, es, {}, es[i]);

            if( minWt2 != minWt ){
                // Found Critical edge
                ans[0].push_back(i);
            }else{
                int minWt3 = minWtKruskal(n, es, es[i], {});
                if( minWt3 == minWt ) ans[1].push_back(i);
            }
        }
        return ans;
    }
};
