package za.co.jumo.process;

import za.co.jumo.beans.Loan;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExtractProducts {

    public ExtractProducts() {
    }

    public List<String> getProducts(List<Loan> loanList){

        List<String> products = new ArrayList<String>();

        loanList.forEach(loan->{
            products.add(loan.getProduct());
        });
        return products.stream().distinct().collect(Collectors.toList());
    }
}
