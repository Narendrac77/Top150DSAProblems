package TreeProblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//https://leetcode.com/problems/binary-tree-preorder-traversal/description/
public class BinaryTreePreOrderTraversal {

    public List<Integer> preOrderIterative(TreeNode root){
        List<Integer> list = new ArrayList<>();
        dfsPreOrderIterative(root, list);
        return list;
    }

    public void dfsPreOrderIterative(TreeNode root, List<Integer> list){
        if(root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode currNode = stack.pop();
            if(currNode.right != null){
                stack.push(currNode.right);
            } if(currNode.left != null){
                stack.push(currNode.left);
            }
            list.add(currNode.val);
        }
    }
    
    public List<Integer> dfsPreOrderRecursive(TreeNode root){
        List<Integer> list = new ArrayList<>();
        dfsPreOrder(root, list);
        return list;
    }

    public void dfsPreOrder(TreeNode root, List<Integer> list){
        if(root == null) return;

        list.add(root.val);
        dfsPreOrder(root.left, list);
        dfsPreOrder(root.right, list);
    }
}
