package src;

import java.util.HashMap;
import java.util.Scanner;

public class Vista {
    
    Scanner scan = new Scanner(System.in);

    public Vista() {

    }

    public void Welcome() {
        System.out.println("Bienvenido al programa");
        System.out.println("Por favor siga los pasos a continuación... \n");
    }

    public HashMap<Integer, Symbol> getSymbols() {

        HashMap<Integer, Symbol> SymbolSet = new HashMap<>();

        System.out.println("Ingrese todos los símbolos pertenecientes a su alfabeto");
        System.out.println("Para detenerse ingrese CANCELAR");

        boolean cancel = false;
        int counter = 1;
        while (!cancel) {
            try {
                System.out.println("Ingrese el valor # " + counter);
                String line = scan.nextLine();
                char c = line.charAt(0);

                int i = c; 

                if (SymbolSet.containsKey(i)) {
                    // The hashmap already contains that value
                    System.out.println("Ingrese un valor nuevo, no repita");
                } else if (line.toUpperCase().equals("CANCELAR")) {
                    cancel = true;
                }
                else {
                    // It's a new value
                    System.out.println("Seguro que desea ingresar " + Character.toString(c) +"?");
                    System.out.println("Enter para continuar");
                    System.out.println("Ingrese NO para cancelar");

                    String no = scan.nextLine();

                    if (!no.toUpperCase().equals("NO")) {
                        Symbol s = new Symbol(c);
                        SymbolSet.put(i, s);
                        counter ++;
                    }
                }
                
            } catch (Exception e) {
                // TODO: handle exception
                scan.nextLine();
            }
        }


        return SymbolSet;
        
    }

    public String getRegex() {

        System.out.println("Regex de input: ");
        return scan.nextLine();
    }
}
