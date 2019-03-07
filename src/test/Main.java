import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author tony.chenjy
 * @date 2019-03-08
 */
public class Main {
      public class TreeNode {
          public int val;
          public TreeNode left, right;
            public TreeNode(int val) {
              this.val = val;
              this.left = this.right = null;
          }
      }

    public class Solution {
        /**
         * @param root: A tree
         * @return: buttom-up level order a list of lists of integer
         */
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            // write your code here
            return helper(root);
        }

        private List<List<Integer>> helper(TreeNode root) {
            LinkedList<List<Integer>> list = new LinkedList<>();

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            if (root != null) {
                queue.offer(root);
            }
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<Integer>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    level.add(node.val);
                }
                list.addFirst(level);
            }
            return list;
        }
    }
}
