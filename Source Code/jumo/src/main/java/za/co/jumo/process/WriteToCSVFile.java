package za.co.jumo.process;

import za.co.jumo.beans.Aggregate;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToCSVFile {

    private String fileName;

    public WriteToCSVFile(String fileName) {
        this.fileName = fileName;
    }

    private final String COMMA_DELIMITER = ",";
    private final String NEW_LINE_SEPARATOR = "\n";

    private final String FILE_HEADER = "Network, Product , Month, Total Amount, Count";

    public void writeCsvFile(List<Aggregate> aggregateList) throws IOException {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("./output/" + this.fileName+ ".csv");

            fileWriter.append(FILE_HEADER.toString());

            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Aggregate aggregate : aggregateList) {
                fileWriter.append(String.valueOf(aggregate.getNetwork()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(aggregate.getProduct()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(aggregate.getLocalDate().getMonth() + " " + aggregate.getLocalDate().getYear()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(aggregate.getTotalAmount()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(aggregate.getCounter()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(NEW_LINE_SEPARATOR);

            }
            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }

}
