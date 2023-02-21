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
    public Stack<Symbol> convert(String infix) {

        Stack<Symbol> stack = new Stack<>();
        Stack<Symbol> inifixStack = new Stack<>();
        Stack<Symbol> postfix = new Stack<>();

        ArrayList<Symbol> input = transformToSymbols(infix);

        // Agregar concat
        input = concatAdd(input);

        String test = "";
        for (Symbol s: input) {
            test += String.valueOf(s.c_id);
        }

        System.out.println(test);

        for ( int i = 0; i < input.size(); i++) {
            Symbol c = input.get(i);

            if ( Character.isDigit(c.c_id) || Character.isLetter(c.c_id)) {
                postfix.push(c);
            } else if (c.c_id == '(') {
                stack.push(c);
            } else if (c.c_id == ')') {
                while (!stack.empty() && stack.peek().c_id != '(') {
                    postfix.push(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek().c_id != '(') {
                    throw new IllegalArgumentException("Invalid expression");
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.empty() && precedence(c.c_id) <= precedence(stack.peek().c_id)) {
                    postfix.push(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.push(stack.pop());
        }

        return postfix;
    }

    private ArrayList<Symbol> transformToSymbols(String ogInput) {

        ArrayList<Symbol> input = new ArrayList<>();

        for (int i = 0; i < ogInput.length(); i ++) {

            int j = ogInput.charAt(i);
            
            if ( ogInput.charAt(i) == '?' || ogInput.charAt(i) == '*' ||
                 ogInput.charAt(i) == '+' || ogInput.charAt(i) == '.' ||
                 ogInput.charAt(i) == '|' || ogInput.charAt(i) == '(' ||
                 ogInput.charAt(i) == ')') {
                
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

    private ArrayList<Symbol> concatAdd(ArrayList<Symbol> input) {

        Symbol concat = new Symbol('.');

        ArrayList<Symbol> temp = new ArrayList<>();

        // copying the array
        for (int i = 0; i < input.size() ; i++) {
            temp.add(input.get(i));
        }

        // adding the '.'s
        int bias = 1;  
        for (int i = 0; i < input.size() - 1 ; i ++) {
            if ( isOperator(input.get(i)))  {
                if ( input.get(i).c_id == '*' || input.get(i).c_id == '+' ||
                     input.get(i).c_id == ')' || input.get(i).c_id == '?') {
                    if ( !isOperator(input.get(i + 1))) {

                        temp.add(i + bias, concat);
                        bias ++;
    
                    }
                }

            } else if ( !isOperator(input.get(i))) {
                if ( !isOperator(input.get(i + 1))) {

                    temp.add(i + bias, concat);
                    bias ++;

                } else if (input.get(i + 1).c_id == '(') {
                    temp.add(i + bias, concat);
                    bias ++;
                }
            }
        }

        return temp;
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

    private int precedence(char operator) {
        int r = -1;
        if (operator == '?') {
            r = 3;
        } else if (operator == '|') {
            r = 2;
        } else if (operator == '*') {
            r = 3;
        } else if (operator == '+') {
            r = 3;
        } else if (operator == '.') {
            r = 1;
        }

        return r;
    }
}
