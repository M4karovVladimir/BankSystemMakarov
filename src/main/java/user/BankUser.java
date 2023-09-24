package user;

public interface BankUser {
    String getUserName();
    int getAccountId();
    double getAccountBalance();
    void setAccountBalance(double accountBalance);
    Card getUserCard();
}
