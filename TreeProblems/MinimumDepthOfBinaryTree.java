package TreeProblems;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int depth = 1;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode currentNode = queue.poll();

                if(currentNode.left == null && currentNode.right == null){
                    return depth;
                }

                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right);
            }
            depth++;
        }
        return depth;
    }
}
