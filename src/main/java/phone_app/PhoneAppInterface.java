package phone_app;

import user.BankUser;

public interface PhoneAppInterface {

    void registerUser(String phone, String password, int cardnumber);
    void enterInApp();
    void enterPhoneNumber(boolean isRegistre);
    void enterPassword(boolean isRegistre);
    void enterCardNumber(boolean isRegister);
    void checkCardNumber(boolean isRegister);
    void printInfo(boolean i, boolean isRegister);
    boolean findUserPhone(long phoneNumber);
    void checkUserPassword(BankUser user);
    void exiteApp();
    void deposit(double amount);
    void withdraw(double amount);
    void consoleInterface();
    boolean findAnotherUserPhone(long phoneNumber);
}
