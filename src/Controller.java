package src;

import java.util.HashMap;
import java.util.Stack;

public class Controller {
    public static void main(String[] args) {

        Vista vis = new Vista();
        

        vis.Welcome();

        HashMap<Integer, Symbol> dict = vis.getSymbols();

        String regex = vis.getRegex();

        InfixToPostfix itp = new InfixToPostfix(dict);

        Stack<Symbol> stack = itp.convert(regex);

        for (Symbol s: stack) {
            System.out.println(s.c_id);
        }

    }

}