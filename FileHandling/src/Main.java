import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Input and output file paths
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        int lineCount = 0;
        int wordCount = 0;

        try {
            // Opening input file
            File file = new File(inputFile);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineCount++;

                // Splitting line into words using whitespace regex
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }

            scanner.close(); // Always close the scanner!

            // Writing results to output file
            FileWriter writer = new FileWriter(outputFile);
            writer.write("Lines: " + lineCount + "\n");
            writer.write("Words: " + wordCount + "\n");
            writer.close();

            System.out.println("Processed successfully! Output written to " + outputFile);

        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found - " + inputFile);
        } catch (IOException e) {
            System.out.println("Error: Could not write to output file - " + outputFile);
        }
    }
}
