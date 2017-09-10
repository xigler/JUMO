package za.co.jumo.process;

import za.co.commons.Util;
import za.co.jumo.beans.Loan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVFile {

    private String filename;

    public ReadCSVFile(String filename) {
        this.filename = filename;
    }

    public List<Loan> readFile(){

        String csvFile = "./input/" + this.filename+ ".csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String regex = "[0-9]+";
        List<Loan> loanList = new ArrayList<Loan>();
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                String[] loanContent = line.split(cvsSplitBy);
                Loan loan = new Loan();
                if(loanContent[0].matches(regex)){
                    loan.setMsisdn(loanContent[0]);
                    loan.setNetwork(loanContent[1].replaceAll("'",""));
                    loan.setLocalDate(new Util().dateValue(loanContent[2].replaceAll("'","")));
                    loan.setProduct(loanContent[3].replaceAll("'",""));
                    loan.setAmount(Double.parseDouble(loanContent[4]));
                    loanList.add(loan);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return loanList;
    }


}
