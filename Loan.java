
package k.bank_abb;



public class Loan {
    

    
    private long loan;
    private int period;
    private double interest_rate, remaining;

   
    

    public long getLoanAmount() {
        return this.loan;
    }

    public void setLoan(long loan) {
        this.loan = loan;
    }

    public int getPeriod() {
        return this.period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getInterest_rate() {
        return this.interest_rate;
    }

    public void setInterest_rate(double interest_rate) {
        this.interest_rate = interest_rate;
    }

    public double getRemaining() {
        return this.remaining;
    }

    public void setRemaining(double remaining) {
        this.remaining = remaining;
    }

    public double getTotalInterest() {
        return getLoanAmount()* getInterest_rate();
    }

    public double getTotalPayableAmount() {

        return getLoanAmount()+ getTotalInterest();
    }

 
    public double getMonthlyPayment() {
        return getTotalPayableAmount() / getPeriod()/12;
    }
// to String the Information about Loan
    @Override
    public String toString() {
        String info = "Loan = " + getLoanAmount()+ "\n"
                + "Period = " + getPeriod() + " year(s)" + "\n"
                + "Interest rate = " + getInterest_rate() + "\n"
                + "Total interest rate = " + getTotalInterest() + "\n"
                + "Total payable amount = " + getTotalPayableAmount() + "\n"
                + "The monthly payment = " + getMonthlyPayment() + "\n"
                + "Remaining amount to paid = " + getRemaining();
        return info;
    }
}




