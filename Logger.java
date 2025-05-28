import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static final String LOG_FILE = "simulation.txt";
    private static BufferedWriter writer;
    
    static {
        try {
            writer = new BufferedWriter(new FileWriter(LOG_FILE));
        } catch (IOException e) {
            System.err.println("Error: Logger initialization failed: " + e.getMessage());
            System.exit(1);
        }
    }

    public static void log(String message) {
        try {
            if (writer != null) {
                writer.write(message);
                writer.newLine();
                writer.flush();
            }
        }
        catch (IOException e) {
            System.err.println("Error: Failed to write log: " + e.getMessage());
        }
    }
}