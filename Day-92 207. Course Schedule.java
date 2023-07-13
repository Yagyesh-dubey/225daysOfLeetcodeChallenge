class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list representation of the courses and their prerequisites
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            g.get(prerequisite[1]).add(prerequisite[0]);
        }

        // Calculate the indegree (number of prerequisites) for each course
        int[] indegree = new int[numCourses];
        for (List<Integer> dependencies : g) {
            for (int dependency : dependencies) {
                indegree[dependency]++;
            }
        }

        // Initialize a queue to perform a breadth-first search
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;  // Initialize a count to check if all courses can be finished
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            // Reduce the indegree of each course that depends on the current course
            for (int dependency : g.get(node)) {
                indegree[dependency]--;
                if (indegree[dependency] == 0) {
                    queue.offer(dependency);
                }
            }
        }

        // If the count equals the total number of courses, return true (all courses can be finished)
        return count == numCourses;
    }
}
