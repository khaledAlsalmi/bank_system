
package k.bank_abb;

import java.util.Scanner;


public class Account {
 


    // Customer Informations :
    Scanner in = new Scanner(System.in);
     Loan currentLoan=new Loan();
    private String national_ID;
    private long mobile_Number; 
    private String name, address, email;
    private double balance;
    private long numberAccount;
    private static long acn;
    // --------------------------

    //This is to increase the account number by one each time you create a new account 
    public Account() {
        numberAccount = ++acn;
   }

    public Account(String national_ID, String name, String address, String email, long mobile_Number) {
        this.national_ID = national_ID;
        this.name = name;
        this.address = address;
        this.email = email;
        this.mobile_Number = mobile_Number;
        numberAccount = ++acn;
    }

    public Loan getCurrentLoan() {
        return currentLoan;
    }

   public long getNumberAccount() {
        return numberAccount;
  }

    // --------------------------
    public void setCurrentLoan(Loan cLoan) {
        this.currentLoan = cLoan;
    }

    public void SetID(String id) {
        national_ID = id;
    }

    public String getID() {
        return national_ID;
    }

    public void SetName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void SetAdress(String a) {
        address = a;
    }

    public String getAddress() {
        return address;
    }

    public void SetEmail(String e) {
        email = e;
    }

    public String getEmail() {
        return email;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balan){
        balance = balan;
    }

    public void SetMobileNum(long mobileN) {
        mobile_Number = mobileN;
    }

    public long getMobileNum() {
        return mobile_Number;
    }

    // --------------------------
    
    //to String the Information about the account
    @Override
    public String toString() {
        return "\n Number Account : " + numberAccount + "\n National ID : " + national_ID
                + "\n Name : " + name + "\n Address : " + address + "\n Email : " + email
                + "\n Mobile Number : " + mobile_Number + "\n The Balance now : " + balance + "\n";
    }

    // --------------------------
  
    // --------------------------
    // 2.Deposit .
    public double deposit(double amount) {
        return balance += amount;
    }

    // 3. Withdrawal .
    public double withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Balance is not enough");
        }
        return balance;
    }

    // 4. Check Balance .
    public void checkBalance() {
        System.out.println("Your Balance : " + balance);
    }

    // 5. New loan .
    public void getLoan() {
        if (currentLoan != null) {
            if (currentLoan.getRemaining() > 0) {
                System.out.println("you can not get a new loan , you stell have remaining to pay which equal to " + currentLoan.getRemaining());
            } else {

                System.out.println("How much is the loan you want to get?");
                long loanAmount = in.nextLong();
                System.out.println("How many years ?");
                int numOfYears = in.nextInt();
                System.out.println("interest of rate is: " + 0.07 * numOfYears);

                currentLoan = new Loan();
                currentLoan.setLoan(loanAmount);
                currentLoan.setPeriod(numOfYears);
                currentLoan.setInterest_rate(0.07 * numOfYears);
                currentLoan.setRemaining(currentLoan.getTotalPayableAmount());
                balance += currentLoan.getLoanAmount();
            }
        } 

    }

    // 7. Pay for a loan .
    public void pay() {
        if (balance > currentLoan.getMonthlyPayment()) {
            currentLoan.setRemaining((currentLoan.getRemaining() - currentLoan.getMonthlyPayment()));
            balance -= currentLoan.getMonthlyPayment();

                           System.out.println("your balance now is " + balance);
            
        } else {
            System.out.println("Balance is not enough !");
        }
    }

}



