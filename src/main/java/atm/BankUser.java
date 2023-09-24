package atm;
import user.Card;

public interface BankUser {
    void insertCard(int cardNumber);

    boolean enterPin(int pin);

    void getCurrentUser();

    double checkBalance();

    void deposit(double amount);

    void withdraw(double amount);

    void ejectCard();

    void blockCard();

    void registerUser(long phone, String password, Card card);

    void ask();

}