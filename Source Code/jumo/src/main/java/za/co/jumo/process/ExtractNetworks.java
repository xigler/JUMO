package za.co.jumo.process;

import za.co.jumo.beans.Loan;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExtractNetworks {

    public ExtractNetworks() {
    }

    public List<String> getNetworks(List<Loan> loanList){

        List<String> networks = new ArrayList<String>();

        loanList.forEach(loan->{
            networks.add(loan.getNetwork());
        });
        return networks.stream().distinct().collect(Collectors.toList());
    }


}
