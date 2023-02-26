package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GraphToFile {

    private String outputFileName;

    public GraphToFile(String outputFileName) {

        try {

            File file = new File(outputFileName);
            FileWriter writer = new FileWriter(file);

            writer.write("Hello, world!");
            writer.write("\n\tHello, world!");

            writer.close();


        }
        catch (IOException e) {
            System.out.println("Error while writing to file");
            e.printStackTrace();
        }

    }

    public GraphToFile(String outputFileName, AFN afn) {

        try {

            File file = new File(outputFileName);
            FileWriter writer = new FileWriter(file);

            // header
            writer.write("digraph AFN\n{");

            // parese through AFN
            // -States
            for (State s: afn.getStates()) {
                writer.write("\n\t"+s.toString()+";");
            }

            writer.write("\n");

            // -Transitions
            for (Transition t: afn.getTransitions()) {
                writer.write(
                    "\n\t" +
                    t.getOriginState().toString() +
                    " -> " +
                    t.getFinalState().toString() +
                    " [label=" +
                    t.getSymbol().c_id +
                    "];"
                );
            }

            // close bracket
            writer.write("\n}");


            writer.close();


        }
        catch (IOException e) {
            System.out.println("Error while writing to file");
            e.printStackTrace();
        }

    }
}