package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TerminalCommand {

    public TerminalCommand() {}

    public void GraphAFN(String txtFile, String jpgFile) {
        // Create a list of the command and its arguments
        List<String> command = new ArrayList<>();
        command.add("dot");
        command.add("-Tjpg");
        command.add(txtFile);
        command.add("-o");
        command.add(jpgFile);

        try {
            // Start a new process using ProcessBuilder
            ProcessBuilder pb = new ProcessBuilder(command);
            Process process = pb.start();

            // Read the output of the process
            java.io.InputStream inputStream = process.getInputStream();
            byte[] buffer = new byte[1024];
            while (inputStream.read(buffer) != -1) {
                System.out.println(new String(buffer));
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();
            System.out.println("Process exited with code " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}