/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Using a hashmap to create adjacency list as the number of nodes is unknown
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        // Create the graph 
        createGraph(root, adjList);

        return findNodesAtDistanceK(adjList, target.val, k);
    }

    private void createGraph(TreeNode root, HashMap<Integer, List<Integer>> adjList) {
        // Create graph using the inorder traversal
        if(root == null) return;

        // Create graph of the left subtree
        createGraph(root.left, adjList);

        // Create the link between the current node and the left node and the right node if they are not null
        if(root.left != null) createLink(adjList, root, root.left);
        if(root.right != null) createLink(adjList, root, root.right);

        // Create graph of the right subtree
        createGraph(root.right, adjList);
    }

    private void createLink(HashMap<Integer, List<Integer>> adjList, TreeNode node1, TreeNode node2) {
        // Since values are unique, we can use them to identify the nodes

        // Get the values of the first and the second node
        int val1 = node1.val;
        int val2 = node2.val;

        // Add the second node to the list of neighbours of the first node
        List<Integer> firstNodeNeighbours = adjList.getOrDefault(val1, new ArrayList<>());
        firstNodeNeighbours.add(val2);
        adjList.put(val1, firstNodeNeighbours);

        // Add the first node to the list of neighbours of the second node
        List<Integer> secondNodeNeighbours = adjList.getOrDefault(val2, new ArrayList<>());
        secondNodeNeighbours.add(val1);
        adjList.put(val2, secondNodeNeighbours);

        // We have successfully linked the two nodes using an undirected edge/bidirectional edge
    }

    private List<Integer> findNodesAtDistanceK(HashMap<Integer, List<Integer>> adjList, int targetNodeVal, int k) {
        // Creating a queue that will store { nodeValue, distanceFromTarget }
        Queue<int[]> queue = new LinkedList<>();

        // List to store the nodes at distance k
        List<Integer> nodesAtDistanceK = new ArrayList<>();

        // Adding the target node as source of BFS
        queue.offer(new int[]{ targetNodeVal, 0 });

        // Create a set to store the visited nodes
        Set<Integer> visited = new HashSet<>();

        while(!queue.isEmpty()) {
            // Get the element in the front of the queue
            int[] queueElement = queue.poll();

            // Extract the element's value and the distance from the target from the queueElement
            int node = queueElement[0], distance = queueElement[1];

            // Otherwise process it and add to the set of visited nodes
            visited.add(node);

            // If the distance is K, add the node to the nodesAtDistanceK list and continue as all the nodes further are greater than distance k
            if(distance == k) {
                nodesAtDistanceK.add(node);
                continue;
            }

            // Add the all the neighbours of the current node 
            for(int neighbour : adjList.getOrDefault(node, new ArrayList<>())) {
                // If the neighbour has already been visited, dont process it
                if(visited.contains(neighbour)) continue;

                // Otherwise add the node's neighbours to the queue with distance+1 for processing
                queue.offer(new int[]{ neighbour, distance+1 });
            }
        }

        return nodesAtDistanceK;
    }
}
