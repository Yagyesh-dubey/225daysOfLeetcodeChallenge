class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) {
            return 0;
        }

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int res = 0;

        for(int i = 0; i < routes.length; i++) {
            for(int j = 0; j < routes[i].length; j++) {
                if(!map.containsKey(routes[i][j])) {
                    map.put(routes[i][j], new ArrayList<Integer>());
                }
                map.get(routes[i][j]).add(i);
            }
        }

        q.offer(source);
        while(!q.isEmpty()) {
            int len = q.size();
            res++;
            for(int i = 0; i < len; i++) {
                int cur = q.poll();
                ArrayList<Integer> buses = map.get(cur);
                for(int bus : buses) {
                    if(visited.contains(bus)) {
                        continue;
                    }
                    visited.add(bus);
                    for(int j = 0; j < routes[bus].length; j++) {
                        if(routes[bus][j] == target) {
                            return res;
                        }
                        q.offer(routes[bus][j]);
                    }
                }
            }
        }
        return -1;
    }
}
// TC:O(m * n) traverse the whole matrix
// SC:O(m * n)
