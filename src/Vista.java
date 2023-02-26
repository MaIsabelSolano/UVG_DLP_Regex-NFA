/*
 * @Author Maria Isabel Solano
 * @version 0.1, 24/02/23
 * 
 * View class to interact with the user. 
 */

package src;

import java.util.Scanner;

public class Vista {
    
    Scanner scan = new Scanner(System.in);

    public Vista() {

    }

    public void Welcome() {
        System.out.println("Bienvenido al programa");
        System.out.println("Por favor siga los pasos a continuación... \n");
    }

    public String getRegex() {

        System.out.println("Regex de input: ");
        String input = scan.nextLine();

        if (checkCorrectness(input)) {
            return input;
        }
        else {
            return null;
        }
    }

    private boolean checkCorrectness(String input){
        boolean correct = true;

        if (input.charAt(0) == '+' || input.charAt(0) == '*' || 
            input.charAt(0) == '|' || input.charAt(0) == '.' ||
            input.charAt(0) == '?' || input.charAt(0) == ')') {
                // begins with invalid operator (1)
                printErrorMssg(0, 1);
                return false;
            }

        for (int i = 0; i < input.length() - 1; i++) {

            if (input.charAt(i) == '|' || input.charAt(i) == '.') {
                if (input.charAt(i + 1) == '|' || input.charAt(i + 1) == '+' ||
                    input.charAt(i + 1) == '*' || input.charAt(i + 1) == '?' ||
                    input.charAt(i + 1) == ')' || input.charAt(i + 1) == '.') {
                        // Invalid sequence of operators (2)
                        printErrorMssg(i, 2);
                        return false;
                }
            }

            // *, +, ? accept anything after them


            if (input.charAt(i) == '(' && input.charAt(i + 1) == ')') {
                // empty parenthesis (3)
                printErrorMssg(i, 3);
                return false;
            }

        }

        if (input.charAt(input.length() - 1) == '(') {
            // empty last parenthesis (4)
            printErrorMssg(input.length() - 1, 4);
            return false;
        }

        return correct;
    }

    private void printErrorMssg(int pos, int err) {
        if (err == 1) {
            System.out.println("^");
            System.out.println("ERROR AT POSITION 0: Cannot start a regular expresion with a operator\n");

        } else if (err == 2) {
            for (int i = 0; i < pos; i ++ ) {
                System.out.print("~");
            }
            System.out.print("^\n");
            System.out.println("ERROR AT POSITION " + Integer.toString(pos) + ": Invalid sequence of operators.");
            System.out.println("Operators such as '|' and '.' must be followed up by another valud sub expression\n");
        
        } else if (err == 3) {
            for (int i = 0; i < pos; i ++ ) {
                System.out.print("~");;
            }
            System.out.print("^\n");
            System.out.println("ERROR AT POSITION " + Integer.toString(pos) + ": Invalid empty parenthesis\n");
        } else if (err == 4) {
            for (int i = 0; i < pos; i ++ ) {
                System.out.print("~");
            }
            System.out.print("^\n");
            System.out.println("ERROR AT POSITION " + Integer.toString(pos) + ": Invalid empty parenthesis at the end of the input");
            System.out.println("Parenthesis can be left open, but the MUST have a valid subexpression after the opening bracket\n");
        }
    }
}
