package user;
public class Card {
    private int cardNumber;
    private int pinCode;
    private int cvv;
    private boolean isBlocked;

    private long phoneNumber;

    private String password;

    public Card(int cardNumber, int pinCode, int cvv) {
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        this.cvv = cvv;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getPinCode() {
        return pinCode;
    }

    public int getCvv() {
        return cvv;
    }
    public boolean getIsBlocked() {
        return isBlocked;
    }
    public void setIsBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}