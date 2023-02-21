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

        // Create empty dictionary to store the set of Symbols
        HashMap<Integer, Symbol> dict = vis.getSymbols();

        // Get regex from user
        String regex = vis.getRegex();

        // Transform to postfix
        InfixToPostfix itp = new InfixToPostfix(dict);

        Stack<Symbol> stack = itp.convert(regex);

        for (Symbol s: stack) {
            System.out.println(s.c_id);
        }

        // From postfix transform to Tree
        Tree regexT = new Tree(stack);

        

    }

}