package StackProblems;

public class MinStackUsingTwoStacksMain {
    public static void main(String[] args) {
        MinStackUsingTwoStacks stacks = new MinStackUsingTwoStacks();
        stacks.push(5);
        System.out.println(stacks.getMin());
        stacks.push(4);
        System.out.println(stacks.getMin());
        stacks.push(8);
        System.out.println(stacks.getMin());
        stacks.push(3);
        System.out.println(stacks.getMin());
        System.out.println(stacks.top());
        stacks.pop();
        System.out.println(stacks.getMin());
    }
}
