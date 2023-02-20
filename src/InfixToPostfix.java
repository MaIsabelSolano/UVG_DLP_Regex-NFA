package src;

import java.io.CharConversionException;
import java.util.*;

public class InfixToPostfix {

    HashMap<Integer, Symbol> dict;

    /*
     * Constructor
     * 
     * @param dict - Dictionary with all the symbol from the alphabet
     */
    public InfixToPostfix(HashMap<Integer, Symbol> dict) {
        this.dict = dict;
    }

    
    /*
     * convert ()
     * 
     */
    public Stack convert(String infix) {

        Stack<Symbol> stack = new Stack<>();
        Stack<Symbol> inifixStack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        ArrayList<Symbol> input = transformToSymbols(infix);

        System.out.println(input.toString());


        // for (int i = 0; i < infix.length(); i++) {
        //     char c = infix.charAt(i);

        //     if (Character.isDigit(c) || Character.isLetter(c)){
        //         postfix.append(c);
        //     } else if (c == '(') {
        //         // stack.push(c);
        //     }
        // }

        return stack;
    }

    private ArrayList<Symbol> transformToSymbols(String ogInput) {

        ArrayList<Symbol> input = new ArrayList<>();

        for (int i = 0; i < ogInput.length(); i ++) {

            int j = ogInput.charAt(i);
            
            if ( ogInput.charAt(i) == '?' || ogInput.charAt(i) == '*' ||
                 ogInput.charAt(i) == '+' || ogInput.charAt(i) == '.' ||
                 ogInput.charAt(i) == '|' ) {
                
                Symbol temp = new Symbol(ogInput.charAt(i));
                input.add(temp);
            } else if (dict.containsKey(j)) {
                input.add(dict.get(j));
            } else {
                //The input contains unrecognized Symbols
                System.out.println("No existe");
            }
        }

        return input;
    }
}
