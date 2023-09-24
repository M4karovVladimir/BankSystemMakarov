package atm;
import phone_app.PhoneApp;
import user.Card;
import org.example.CheckingForLice;

import java.util.ArrayList;
import java.util.Scanner;
public class BankAccount implements BankUser {
    Scanner scanner = new Scanner(System.in);
    private Card currentCard;
    private user.BankAccount currentUser;
    private int AttemptsLeft;
    private boolean next = false;
    public ArrayList<Card> cards = new ArrayList<Card>();
    public ArrayList<user.BankAccount> bankAccounts = new ArrayList<>();
    public Card card1 = new Card(123456,1234,123);
    public Card card2 = new Card(654321,4321,321);

    public Card card3 = new Card(234567, 2345, 345);

    public Card card4 = new Card(567890, 1235, 567);

    public user.BankAccount user1 = new user.BankAccount("Nikita",1,1234, card1, 9999, "1234");
    public user.BankAccount user2 = new user.BankAccount("Andrey",2,4321, card2, 2345, "2345");

    public user.BankAccount user3 = new user.BankAccount("Vladimir",3,4321, card3, 2345, "2345");

    public user.BankAccount user4 = new user.BankAccount("Elena",4,4321, card4, 2345, "2345");
    public BankAccount(){
        addCardsAndUsers();
    }

    public void addCardsAndUsers(){
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        bankAccounts.add(user1);
        bankAccounts.add(user2);
        bankAccounts.add(user3);
        bankAccounts.add(user4);
    }
    private int checkMethod() {
        System.out.println("1 - Посмотреть баланс");
        System.out.println("2 - Положить деньги");
        System.out.println("3 - Снять деньги");
        System.out.println("4 - Выход с терминала");
        int method = CheckingForLice.integer();
        return method;
    }
    private int checkPinCode() {
        System.out.println("Введите пин-код:");
        int pinCode = CheckingForLice.integer();
        return pinCode;
    }
    private double checkMethodsTwo() {
        System.out.println("Выберите сумму которую хотите положить:");
        double sum = scanner.nextDouble();
        return sum;
    }
    private double checkMethodsThree() {
        System.out.println("Выберите сумму  которую хотите снять:");
        double sum = scanner.nextDouble();
        return sum;
    }
    public void terminate() {
            cards.add(card1);
            cards.add(card2);
            bankAccounts.add(user1);
            bankAccounts.add(user2);
            System.out.println("Введите номер карты:");
            int card = CheckingForLice.integer();
            if (card > 0) {
                insertCard(card);
                next = true;
            } else if (card == -1) {
                System.out.println("Вы ввели не правильный тип данных, попробуйте ещё раз");
                terminate();
            }

            for (int i = 0; i <= AttemptsLeft; i++) {
                int pinCode = checkPinCode();
                boolean x = false;
                if(pinCode > 0) {
                    x = enterPin(pinCode);
                }
                if (x == true) {
                    while (currentCard != null) {
                        int method = checkMethod();
                        if(method == -1){
                            System.out.println("Вы ввели не правильный тип данных, попробуйте ещё раз");
                            method = checkMethod();
                        }
                        if (method == 1) {
                            System.out.println(checkBalance());
                        } else if (method == 2) {
                            double sum = checkMethodsTwo();
                            if(sum == -1){
                                System.out.println("Вы ввели не правильный тип данных, попробуйте ещё раз");
                                sum = checkMethodsTwo();
                            }else {
                                deposit(sum);
                            }
                        } else if (method == 3) {
                            double sum = checkMethodsThree();
                            if(sum == -1){
                                System.out.println("Вы ввели не правильный тип данных, попробуйте ещё раз");
                                sum = checkMethodsThree();
                            }else {
                                withdraw(sum);
                            }
                        } else if (method == 4) {
                            System.out.println("Вы ввели не правильный тип данных, попробуйте ещё раз");
                            ejectCard();
                        }
                    }
                    return;
                }else {
                    System.out.println("ВВы ввели не правильный тип данных, попробуйте ещё раз");
                    pinCode = checkPinCode();
            }
        }
    }
    @Override
    public void insertCard(int cardNumber) {
        for(int i = 0; i < cards.size(); i++) {
            if(cards.get(i).getCardNumber() == cardNumber){
                currentCard = cards.get(i);
            };
        }
        AttemptsLeft = 3;
    }

    @Override
    public boolean enterPin(int pin) {
        if (currentCard != null && pin == currentCard.getPinCode() && AttemptsLeft > 0) {
            for(int i =0; i < bankAccounts.size(); i++) {
                if (bankAccounts.get(i).getUserCard() == currentCard){
                    currentUser = bankAccounts.get(i);
                    System.out.println("Вы успешно вошли");
                    getCurrentUser();
                }
            }
            return true;
        } else {
            AttemptsLeft--;
            if (AttemptsLeft == 0) {
                blockCard();
            }
            return false;
        }
    }

    @Override
    public void getCurrentUser() {
        System.out.println("Имя: " + currentUser.getUserName());
    }

    @Override
    public double checkBalance() {
        if (currentUser != null) {
            return currentUser.getAccountBalance();
        }
        return 0.0;
    }

    @Override
    public void deposit(double amount) {
        double x = currentUser.getAccountBalance();
        if (amount > 0) {
            currentUser.setAccountBalance(x += amount);
            System.out.println("Успешно положили " + amount + "У вас на счету стало: " + x);
        }else {
            System.out.println("Вы ввели не допустимую сумму");
        }
    }

    @Override
    public void withdraw(double amount) {
        double x = currentUser.getAccountBalance();
        if (amount > 0 && amount <= x) {

                currentUser.setAccountBalance(x -= amount);
                System.out.println("Успешно сняли " + amount + "У вас на счету стало: " + x);
            }else {
            System.out.println("Вы ввели не допустимую сумму");
        }
    }

    @Override
    public void ejectCard() {
        currentCard = null;
        currentUser = null;
    }

    @Override
    public void blockCard() {
        System.out.println("Вы заблакированны");
        currentCard.setIsBlocked(true);
    }


    @Override
    public void registerUser(long phone, String password, Card card) {
        user.BankAccount newUser = new user.BankAccount("Account1",bankAccounts.size(),0, card,phone,password);
        bankAccounts.add(newUser);
        System.out.println(bankAccounts);
    }

    @Override
    public void ask() {
        System.out.println("Войти в приложение - 1");
        System.out.println("Вставить карту в банкомат - 2");
        int command = CheckingForLice.integer();
        if (command != -1 ){
            if (command == 1){
                PhoneApp phoneApp = new PhoneApp(this);
                phoneApp.enterInApp();
            } else {
                if (command == 2){
                    terminate();
                } else System.out.println("Неправильная команда");
            }
        }
        else {
            System.out.println("Неправильный тип данных");
            ask();
        }
    }

    public Card getCurrentCard() {
        return currentCard;
    }
}