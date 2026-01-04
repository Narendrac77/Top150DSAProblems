package TreeProblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeInOrderTraversal {

    public List<Integer> inOrderTraversalRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfsRecursive(root, list);
        return list;
    }

    public void dfsRecursive(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        dfsRecursive(root.left, list);
        list.add(root.val);
        dfsRecursive(root.right, list);
    }

    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfsTraversal(root, list);
        return list;
    }

    public void dfsTraversal(TreeNode root, List<Integer> list){
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode currNode = root;
        while(true){
            if(currNode != null){
                stack.push(currNode);
                currNode = currNode.left;
            } else{
                if(stack.isEmpty()) break;
                currNode = stack.pop();
                list.add(currNode.val);
                currNode = currNode.right;
            }
        }
    }

    public List<Integer> inOrderIterative(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
}
