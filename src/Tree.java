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
                TreeNode temp = new TreeNode(input.get(i));
                nodes.push(temp);
            } else {
                TreeNode temp = new TreeNode(input.get(i), nodes.pop(), nodes.pop());
                nodes.push(temp);
            }
        }

        return nodes.pop();
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