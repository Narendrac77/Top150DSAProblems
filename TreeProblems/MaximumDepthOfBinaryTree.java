package TreeProblems;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    
    public int maxDepth(TreeNode rootNode){
        int maxDepth = 0;

        if(rootNode == null) return maxDepth;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(rootNode);

        while (!queue.isEmpty()) {
            int size = queue.size();
            maxDepth++;
            for(int i = 0; i < size; i++){
                TreeNode currentNode = queue.poll();
                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right);
            }
        }
        return maxDepth;
    }
}
