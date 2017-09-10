package za.co.jumo.process;

import za.co.jumo.beans.Aggregate;
import za.co.jumo.beans.Loan;

import java.util.ArrayList;
import java.util.List;

public class CalculateAgregates {

    private List<String> networks;
    private List<String> products;
    private List<String> dategrouping;
    private List<Loan> loanList;

    public CalculateAgregates(List<String> networks, List<String> products, List<String> dategrouping, List<Loan> loanList) {
        this.networks = networks;
        this.products = products;
        this.dategrouping = dategrouping;
        this.loanList = loanList;
    }

    public  List<Loan> orderedLoanList (){

        List<Loan> orderedLoanList = new ArrayList<>();
        this.networks.forEach(network->{
            products.forEach(product->{
                dategrouping.forEach(dategroup->{
                    loanList.forEach(loan->{
                        String currDateGroup = loan.getLocalDate().getYear() + "-" + loan.getLocalDate().getMonth().getValue();
                        if(network.compareTo(loan.getNetwork()) == 0 &&
                                product.compareTo(loan.getProduct()) == 0 &&
                                dategroup.compareTo(currDateGroup)==0){
                            orderedLoanList.add(loan);
                        }
                    });
                });
            });
        });

        return  orderedLoanList;
    }

    public  List<Aggregate> aggregateLoanList (List<Loan> loanList){
        List<Aggregate> finalList = new ArrayList<>();
        int loanCounter = 1;
        double totalAmount = loanList.get(0).getAmount();

        for (int i=1; i < loanList.size(); i++){

            if(loanList.get(i).getNetwork().compareTo(loanList.get(i-1).getNetwork())== 0 &&
                    loanList.get(i).getProduct().compareTo(loanList.get(i-1).getProduct())== 0 &&
                    loanList.get(i).getLocalDate().getMonth() == loanList.get(i-1).getLocalDate().getMonth() &&
                    loanList.get(i).getLocalDate().getYear() == loanList.get(i-1).getLocalDate().getYear()){

                loanCounter++;
                totalAmount = totalAmount + loanList.get(i).getAmount();
            }else{
                Aggregate aggregate = new Aggregate();
                aggregate.setNetwork(loanList.get(i-1).getNetwork());
                aggregate.setProduct(loanList.get(i-1).getProduct());
                aggregate.setLocalDate(loanList.get(i-1).getLocalDate());
                aggregate.setTotalAmount(totalAmount);
                aggregate.setCounter(loanCounter);
                finalList.add(aggregate);

                loanCounter = 1;
                totalAmount = loanList.get(i).getAmount();
            }
         }

        Aggregate aggregate = new Aggregate();
        aggregate.setNetwork(loanList.get(loanList.size()-1).getNetwork());
        aggregate.setProduct(loanList.get(loanList.size()-1).getProduct());
        aggregate.setLocalDate(loanList.get(loanList.size()-1).getLocalDate());
        aggregate.setTotalAmount(totalAmount);
        aggregate.setCounter(loanCounter);
        finalList.add(aggregate);
        return finalList;
    }
}
