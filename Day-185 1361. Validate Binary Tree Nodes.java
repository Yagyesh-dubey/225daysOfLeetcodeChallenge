class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] left, int[] right) {
        boolean[] visited = new boolean[n];

        // Mark every visited node. Each must be visited once.
        // If a node is visited for the 2nd time - it's not a tree anymore.
        for (int i = 0; i < n; i++) {
            if (left[i] != -1) {
                if (visited[left[i]]) {
                    return false;
                }
                visited[left[i]] = true;
            }
            if (right[i] != -1) {
                if (visited[right[i]]) {
                    return false;
                }
                visited[right[i]] = true;    
            }
        }

        // Find the root. It's the only unvisited node.
        // If there are few - it's not a tree anymore.
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (index == -1) {
                    index = i;
                } else {
                    return false;
                }
            }
        }

        // If index == -1 -> root not found (there are loops) - return false.
        // Else, start a recursive mechanism to visit every node from the root.
        visited = new boolean[n];
        if (index == -1 || !move(index, left, right, visited)) {
            return false;
        }

        // If there are still unvisited nodes - it's not a tree.
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    // Recursivly move from root to it's children.
    // If reach -1 -> it's a leaf. If meet visited -> not a tree.
    private boolean move(int x, int[] a, int[] b, boolean[] visited) {
        if (x == -1) {
            return true;
        }
        if (visited[x]) {
            return false;
        }
        visited[x] = true;
        return move(a[x], a, b, visited) && move(b[x], a, b, visited);
    }
}
