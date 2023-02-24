/*
 * @author: @MaIsabelSolano
 * @version 0.1, 02/02/23
 * 
 * Main class to interact with the program. 
 */

package src;

import java.util.HashMap;
import java.util.Stack;

public class Controller {
    public static void main(String[] args) {

        Vista vis = new Vista();
        
        // Welcome the user
        vis.Welcome();

        // Get regex from user
        String regex = vis.getRegex();

        // Transform to postfix
        InfixToPostfix itp = new InfixToPostfix();

        Stack<Symbol> stack = itp.convert(regex);

        HashMap<Integer, Symbol> alphabet = itp.getDic();

        System.out.println("\nDictionary:");
        for (int i: alphabet.keySet()) {
            System.out.println(alphabet.get(i).c_id);
        }

        System.out.println("\nStack: ");
        for (Symbol s: stack) {
            System.out.println(s.c_id);
        }

        // From postfix transform to Tree
        // Tree regexT = new Tree(stack);

        // regexT.printTree(regexT.root);

    }

}