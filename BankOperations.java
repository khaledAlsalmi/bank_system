
package k.bank_abb;


//An interface is a completely "abstract class" that is used to group related methods with empty bodies

public interface BankOperations {
    
//method to set a new account
    public abstract void setNewAccount(String ID, String n, String ad, String e, long mobileNum);
    
//method to creat a new account
    public abstract void createNewAccount();
    
// method to diposit 
    public abstract void deposit();
    
// method to WithDrawl 
    public abstract void withDrawl();

    //method to Check the balanc
    public abstract void checkingAccount();
    
    //method to get Information of account
        public abstract void aboutAccount();

//method to creat a new loan
    public abstract void createNewLoan();

    //methodto get Information about Loan
    public abstract void aboutLoan();

    //method to pay a loan
    public abstract void payLoan();

    //method to call up the number account
    public abstract Account numAccountValidation(long numAcount);

}


