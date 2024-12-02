package ReportGenerationFolder;

import java.util.Scanner;

public class TransactionReport {
    Scanner scanner = new Scanner(System.in);

    public void generateReport() throws IOException {
        FileOutputStream fileStream = null;
        PrintWriter outFS = null;

        // Try to open file
        fileStream = new FileOutputStream("TransactionReport.txt");
        outFS = new PrintWriter(fileStream);

        // Arriving here implies that the file can now be written
        // to, otherwise an exception would have been thrown.
        outFS.println("Hello");
        outFS.println("1 2 3");

        // Done with file, so try to close
        // Note that close() may throw an IOException on failure
        outFS.close();
    }
    
}