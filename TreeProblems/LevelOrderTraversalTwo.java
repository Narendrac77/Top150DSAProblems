package TreeProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalTwo {
    public List<List<Integer>> bfs(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();

        if(root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            List<Integer> currentLevel = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode currentNode = queue.poll();
                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right);
                currentLevel.add(currentNode.val);
            }
            list.add(0,currentLevel);
        }

        return list;
    }
}
