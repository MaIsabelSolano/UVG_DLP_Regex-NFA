package src;

import java.util.Stack;

public class Tree {

    private TreeNode root;
    
    public Tree(Stack<Symbol> input) {
        this.root = genTree(input);
    }

    private TreeNode genTree(Stack<Symbol> input){

        Stack<TreeNode> nodes = new Stack<>();

        for (int i = 0; i < input.size(); i ++) {
            if (!input.get(i).isOperator()) {
                // If it is not, it is a leaf of the tree and just
                // addet to it 
                TreeNode newNode = new TreeNode(input.get(i));
                nodes.push(newNode);
            } else {
                // If it is, we have to check wheather or not the have
                // one or two children
                if (input.get(i).c_id == '+' || input.get(i).c_id == '*' || input.get(i).c_id == '?') {
                    TreeNode left = nodes.pop();
                    TreeNode newNode = new TreeNode(input.get(i), left);
                    nodes.push(newNode);
                }
                else {
                    TreeNode right = nodes.pop();
                    TreeNode left = nodes.pop();
                    TreeNode newNode = new TreeNode(input.get(i), left, right);
                    nodes.push(newNode);
                }
            }
        }

        return nodes.pop();
    }

    public void printTree( TreeNode node) {

        if (node == null) {
            return;
        }

        printTree(node.leftChild);

        printTree(node.righChild);

        System.out.println(node.value.c_id);

        
    }

    /* Getters */
    public TreeNode getRoot() {
        return root;
    }

}