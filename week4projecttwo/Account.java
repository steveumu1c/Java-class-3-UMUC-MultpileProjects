package week4projecttwo;


public class Account {
    /* Declare Fields */
    private static int svcToken = 0;//svcToken for applying service charge
    private double balance;

    /* Constructor*/
    public Account(double balance){
        this.balance=balance;
    }

    /* Getter and setter methods */
    public double getBalance(){
        return balance;
    }

    /* Instance Methods*/

    /* Method to withdraw from account */
    public void withdraw(double withdrawAmt) throws InsufficientFunds {
        withdrawAmt += (getSvcToken()+1 > 4)? 1.50 : 0.00;
        if (balance > withdrawAmt) {
            balance -= withdrawAmt;
            svcToken++;
        }
        else{
            throw new InsufficientFunds();
        }
    }

    /* Method to add deposit to account balance */
    public void deposit(double depositAmt){
        balance += depositAmt;
    }

    /* Method to adjust conduct an account transfer from */
    public void transferAmountTo(double transferAmt, Account account) throws InsufficientFunds {
        if (transferAmt > balance){ //ensure sufficient funds
            throw new InsufficientFunds();
        }
        else {
            balance -= transferAmt;
            account.balance += transferAmt;
        }
    }

    public int getSvcToken(){
        return svcToken;
    }

}//End Account Class