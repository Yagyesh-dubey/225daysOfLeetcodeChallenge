/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair{
    int getKey;
    int getValue;
    public Pair(int a,int b){
        this.getKey=a;
        this.getValue=b;
    }
}
class Solution {
    int count;
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return count;
    }
    public Pair solve(TreeNode root){
        if(root==null) {
            Pair p = new Pair(0,0);
            return p;
        }
        Pair left1 = solve(root.left);
        Pair right1 = solve(root.right);
        int n= left1.getValue+right1.getValue+1;
        int sum=root.val+left1.getKey+right1.getKey;
        int avg = sum/n;
        if(avg==root.val) count++;
        return new Pair(sum,n);
    }
}
