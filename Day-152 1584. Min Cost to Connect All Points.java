import java.util.Arrays;

class Solution {
    // Function to find the index of the minimum key in 'key' array that is not yet included in MST
    private int minKey(boolean[] inMST, int[] key) {
        int minIndex = 0;
        int minVal = Integer.MAX_VALUE;
        // Loop through all vertices to find the minimum key
        for (int i = 0; i < key.length; i++) {
            // Check if the vertex is not in MST and its key is smaller than the current minimum value
            if (!inMST[i] && key[i] < minVal) {
                minIndex = i;
                minVal = key[i];
            }
        }
        return minIndex; // Return the index of the minimum key
    }

    // Function to calculate the minimum spanning tree (MST) of a given 'graph' with 'V' vertices
    private int MST(int[][] graph, int V) {
        int[] key = new int[V];
        boolean[] inMST = new boolean[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0; // Start with the first vertex as the source

        // Loop through V-1 vertices (all except the first one)
        for (int count = 1; count <= V - 1; count++) {
            int u = minKey(inMST, key); // Find the vertex with the minimum key not in MST
            inMST[u] = true; // Include the selected vertex in MST

            // Update the key values of adjacent vertices
            for (int v = 0; v < V; v++) {
                // If there is an edge from 'u' to 'v', 'v' is not in MST, and the edge weight is smaller than 'key[v]'
                if (graph[u][v] > 0 && !inMST[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v]; // Update the key value of 'v'
                }
            }
        }

        int cost = 0;
        for (int i : key) {
            cost += i; // Calculate the sum of key values, which represents the minimum cost of MST
        }
        return cost; // Return the minimum cost of MST
    }

    // Function to calculate the minimum cost to connect all points using Prim's Algorithm
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] graph = new int[n][n]; // Create a 2D matrix 'graph' to represent the distances between points

        // Calculate the Manhattan distance (md) between all pairs of points and populate the 'graph' matrix
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];
                int md = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]); // Calculate Manhattan distance
                graph[i][j] = md; // Store the distance in both directions since it's an undirected graph
                graph[j][i] = md;
            }
        }

        return MST(graph, n); // Find and return the minimum cost of connecting all points using MST
    }
}
