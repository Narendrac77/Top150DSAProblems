package TreeProblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreePostOrderTraversal {
    
    public List<Integer> postOrderRecursive(TreeNode root){
        List<Integer> list = new ArrayList<>();
        recursive(root, list);
        return list;
    }

    public void recursive(TreeNode root, List<Integer> list){
        if(root == null) return;

        recursive(root.left, list);
        recursive(root.right, list);
        list.add(root.val);
    }

    public List<Integer> postOrderTraversal(TreeNode root){
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();

        stack1.push(root);

        while(!stack1.isEmpty()){
            TreeNode curr = stack1.pop();
            if(curr.left != null) stack1.push(curr.left);
            if(curr.right != null) stack1.push(curr.right);
            stack2.push(curr);
        }

        while(!stack2.isEmpty()){
            list.add(stack2.pop().val);
        }

         return list;
    }

    
}
