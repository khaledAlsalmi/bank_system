
package k.bank_abb;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;



   



//i implements the BankOperations because the BankOperations is interface
public class Bank implements BankOperations {
// vector for Account class i use it in line (98)
    public static Vector<Account> account_Set = new Vector<>();

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome To The Bank ^_^");
                
        System.out.println("--------------------------------------------------------------------------------");
        do {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Please enter the number of your choise ( any number to exit )");
                System.out.println("1 - Create a new Account . \n"
                        + "2 - Deposite to an existing account . \n"
                        + "3 - withdrowal from an existing account . \n"
                        + "4 - Check balance of Account . \n"
                        + "5 - Get a new Loan . \n"
                        + "6 - Check a Loan . \n"
                        + "7 - Pay for a Loan . \n"
                        + "8 - Check Account information . \n");
    //This Java Scanner class method is used to scan the next token of the input as an int.
                int choice = input.nextInt();

                
                switch (choice) {
                    case 1:
                        new Bank().createNewAccount();
                        break;
                    case 2: {
                        new Bank().deposit();
                        break;
                    }
                    case 3: {
                        new Bank().withDrawl();
                        break;
                    }

                    case 4: {
                        new Bank().checkingAccount();
                        break;
                    }

                    case 5: {
                        new Bank().createNewLoan();
                        break;
                    }

                    case 6: {
                        new Bank().aboutLoan();
                        break;
                    }

                    case 7: {
                        new Bank().payLoan();
                        break;
                    }
                    case 8: {
                        new Bank().aboutAccount();
                        break;
                    }

                    default:
                        System.out.println("Thank You for Using A bank System ^_^ .. Good Bye");
                        System.exit(0);
                }
            } catch (Exception ex) {
                System.out.println("Error !!");
            }
        } while (true);
    }

    // 1. set a new account .
    
    public void setNewAccount(String ID, String n, String ad, String e, long mobileNum) {
        Account a = new Account();
        a.SetID(ID);
        a.SetName(n);
        a.SetAdress(ad);
        a.SetEmail(e);
        a.SetMobileNum(mobileNum);
        System.out.println("\nsuccessfully created your account !");
        System.out.println(a);
        account_Set.add(a);
    }

  //Create a new account by useing setNewAccount method
    public void createNewAccount() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter Informations ( national_ID - name - address - email - mobile_Number ) ? ");
        setNewAccount(input.next(), input.next(), input.next(), input.next(), input.nextLong());

    }
//  this is to call up the number account
    
    public Account numAccountValidation(long numAcount) {
        Account a = null;
        
        Iterator<Account> itr = account_Set.iterator();
        while (itr.hasNext()) {
            a = itr.next();
            if (numAcount == a.getNumberAccount()) {
                return a;
            }
        }
        return null;
    }

    //to depsit
    public void deposit() {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter The Account Number that you want to deposit in it ?");
        Account a =numAccountValidation(input.nextLong());
        if (a != null) {
            System.out.println("Please enter amount of many to deposite it ?");
            a.deposit(input.nextDouble());
        } else {
            System.out.println(" Wrong Account Number !");
        }
    }

    //to withDrawl
    public void withDrawl() {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter The Account Number that you want to withdraw from it ?");
        Account a = numAccountValidation(input.nextLong());
        if (a != null) {
            System.out.println("Please enter amount of many to withdraw it ?");
            a.withdraw(input.nextDouble());
        } else {
            System.out.println(" Wrong Account Number !");
        }
    }

    //@Override
    public void checkingAccount() {
        Scanner input = new Scanner(System.in);
        

        System.out.println("Please enter The Account Number that you want to check Balance ?");
        Account a = numAccountValidation(input.nextLong());
        if (a != null) {
            a.checkBalance();
        } else {
            System.out.println(" Wrong Account Number !");
        }
    }

    
    //@Override
    public void createNewLoan() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter The Account Number that you want to get New Loan ?");
        Account a = numAccountValidation(input.nextLong());
        if (a != null) {
            a.getLoan();
        } else {
            System.out.println(" Wrong Account Number !");
        }
    }

    
    //@Override
    public void aboutLoan() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter The Account Number that you want to get Information about Loan ?");
        Account a = numAccountValidation(input.nextLong());
        if (a != null) {
            if (a.getCurrentLoan() != null) {
                System.out.println(a.getCurrentLoan().toString());
            } else {
                System.out.println("You dont have any loan !");
            }
        } else {
            System.out.println(" Wrong Account Number !");
        }
    }

    //@Override
    public void payLoan() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter The Account Number that you want to pay for Loan ?");
        Account a =numAccountValidation(input.nextLong());
        if (a != null) {
            if (a.getCurrentLoan() != null) {
                a.pay();
                System.out.println("Done");
            } else {
                System.out.println("You dont have any loan !");
            }
        } else {
            System.out.println(" Wrong Account Number !");
        }
    }

    //@Override
    public void aboutAccount() {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter The Account Number to get Information ?");
        Account a = numAccountValidation(input.nextLong());
        if (a != null) {
            System.out.println(a);
        } else {
            System.out.println(" Wrong Account Number !");
        }
    }

}




