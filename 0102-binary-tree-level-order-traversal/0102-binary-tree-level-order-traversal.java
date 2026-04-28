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

// List<List<Integer>> ans = new LinkedList<List<Integer>>();
//         if(root == null) return ans;
//         Queue<TreeNode> q = new LinkedList<TreeNode>();
//         q.offer(root);

//         while(!q.isEmpty())
//         {
//             int s = q.size();
//             List<Integer> level = new LinkedList<Integer>();

//             for(int i=0; i<s; i++)
//             {
//                 if(q.peek().left != null) q.offer(q.peek().left);
//                 if(q.peek().right != null) q.offer(q.peek().right);
//                 level.add(q.poll().val);
//             }
//             ans.add(level);

//         }
//         return ans;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(root == null){
            return ans;
        }

        Queue<TreeNode> qs = new LinkedList<TreeNode>();
        qs.offer(root);

        while(!qs.isEmpty()){
            int n = qs.size();
            List<Integer> level  = new LinkedList<>();

            for(int i=0; i<n; i++){
                if(qs.peek().left != null){
                    qs.offer(qs.peek().left);
                }
                if(qs.peek().right != null){
                    qs.offer(qs.peek().right);
                }
                level.add(qs.poll().val);
            }
            ans.add(level);
        }

        return ans;
    }
}