class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        // Create an adjacency list to represent the graph
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Populate the adjacency list based on the roads
        for (int[] road : roads) {
            int city1 = road[0];
            int city2 = road[1];
            graph[city1].add(city2);
            graph[city2].add(city1);
        }
        
        int maxRank = 0;
        
        // Iterate through all pairs of cities
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = graph[i].size() + graph[j].size();
                // If there is a road directly between the two cities, reduce the rank by 1
                if (graph[i].contains(j)) {
                    rank--;
                }
                maxRank = Math.max(maxRank, rank);
            }
        }
        
        return maxRank;
    }
}
