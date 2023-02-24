package src;

import java.util.Stack;

public class Tree {

    TreeNode root;
    
    public Tree(Stack<Symbol> input) {
        this.root = genTree(input);
    }

    private TreeNode genTree(Stack<Symbol> input){

        Stack<TreeNode> nodes = new Stack<>();

        for (int i = 0; i < input.size(); i ++) {
            if (!isOperator(input.get(i))) {
                TreeNode newNode = new TreeNode(input.get(i));
                nodes.push(newNode);
            } else {
                TreeNode left = nodes.pop();
                TreeNode right = nodes.pop();
                TreeNode newNode = new TreeNode(input.get(i), left, right);
                nodes.push(newNode);
            }
        }

        return nodes.pop();
    }

    public void printTree( TreeNode node) {

        if (node == null) {
            return;
        }

        if (node.leftChild == null && node.righChild == null) {
            System.out.println(node.value.c_id);
        }

        printTree(node.leftChild);
        printTree(node.righChild);
    }

    private boolean isOperator(Symbol s) {
        boolean res = false;

        if (s.c_id == '?' || s.c_id == '.' || 
            s.c_id == '+' || s.c_id == '*' ||
            s.c_id == '(' || s.c_id == ')' ||
            s.c_id == '|' ) {
                
                res = true;
            }

        return res;
    }
}