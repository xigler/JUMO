package za.co.jumo.main;

import javax.swing.JOptionPane;
import za.co.jumo.beans.Loan;
import za.co.jumo.process.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class Imp extends Thread {

    private Thread thread;
    private String threadAggregation;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    Imp(String name) {
        threadAggregation = name;
        System.out.println("Creating " + threadAggregation);
    }

    public void run() {
        System.out.println("Running " + threadAggregation);

        ReadCSVFile readCSVFile = new ReadCSVFile("Loans");
        List<Loan> loanList = readCSVFile.readFile();
        List<String> networks = new ExtractNetworks().getNetworks(loanList);
        List<String> products = new ExtractProducts().getProducts(loanList);
        List<String> dates = new IdentifyMonths().groupDates(loanList);

        CalculateAgregates calculateAgregates = new CalculateAgregates(networks, products, dates, loanList);

        calculateAgregates.aggregateLoanList(calculateAgregates.orderedLoanList()).forEach(loan -> {
            System.out.println(loan.toString());
        });

        WriteToCSVFile writeToCSVFile = new WriteToCSVFile("Output");
        try {
            writeToCSVFile.writeCsvFile(calculateAgregates.aggregateLoanList(calculateAgregates.orderedLoanList()));
        } catch (IOException io) {
            System.out.println(io.getStackTrace());
        }
        endTime = LocalDateTime.now();
        System.out.println(threadAggregation + " exiting."  + " : " + endTime);

        JOptionPane.showMessageDialog(null,
                "Process execution duration  : " + (endTime.getSecond() - startTime.getSecond())+ " seconds",
                 "Process Completed",
                JOptionPane.INFORMATION_MESSAGE);

        System.out.println("Process execution duration  : " + (endTime.getSecond() - startTime.getSecond())+ " seconds");

    }

    public void start() {
        startTime = LocalDateTime.now();
        System.out.println("Starting " + threadAggregation + " : " + startTime);
        if (thread == null) {
            thread = new Thread(this, threadAggregation);
            thread.start();
        }
    }
}
