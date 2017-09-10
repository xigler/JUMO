package za.co.jumo.process;

import za.co.jumo.beans.Loan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IdentifyMonths {

    public IdentifyMonths() {
    }

    public List<String> groupDates(List<Loan> loanList){

        List<String> dates = new ArrayList<String>();

        loanList.forEach(loan->{
            dates.add(loan.getLocalDate().getYear() + "-" + loan.getLocalDate().getMonth().getValue());
        });
        return dates.stream().distinct().collect(Collectors.toList());
    }
}
