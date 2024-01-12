import java.io.*;

class FileHandling {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

           
            System.out.print("Enter input file name: ");
            String inputFileName = reader.readLine();

          
            System.out.print("Enter output file name: ");
            String outputFileName = reader.readLine();

           
            System.out.println("Choose the operation to perform:");
            System.out.println("1. Uppercase");
            System.out.println("2. Lowercase");
            System.out.println("3. Reverse");
            System.out.print("Enter your choice (1/2/3): ");
            int choice = Integer.parseInt(reader.readLine());

            FileHandling.processFile(inputFileName, outputFileName, choice);
        } catch (IOException | NumberFormatException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public static void processFile(String inputFileName, String outputFileName, int choice) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFileName))) {

            StringBuilder processedData = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                switch (choice) {
                    case 1:
                        processedData.append(line.toUpperCase()).append("\n");
                        break;
                    case 2:
                        processedData.append(line.toLowerCase()).append("\n");
                        break;
                    case 3:
                        processedData.insert(0, line + "\n");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select 1, 2, or 3.");
                        return;
                }
            }

            bufferedWriter.write(processedData.toString());
            System.out.println("Data processed and written to " + outputFileName);
        }
    }
}
