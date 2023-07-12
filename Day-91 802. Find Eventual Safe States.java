class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<Integer> safeStates = new ArrayList<>();
        int vis[] = new int[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(isSafe(i, graph , vis)) {
                safeStates.add(i);
            }
        }
        return safeStates;
    }
    public static boolean isSafe(int index, int[][] graph, int vis[]) {
        if(vis[index] == 2) {
            return true;
        }
        if(vis[index] == 1) {
            return false;
        }
        vis[index] = 1;
        int neighbor[] = graph[index];

        for(int i=0; i< neighbor.length; i++) {
            if(!isSafe(neighbor[i], graph, vis)) {
                return false;
            }
        }
        vis[index] = 2;
        return true;
    }
}
