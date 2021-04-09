package ATM;

public class Card {
    private int moneyAvailable;
    private int pin;
    public String name;

    public Card(){
        this.moneyAvailable = 0;
        this.pin = 1111;
    }

    public Card(int money, int pin, String name){
        this.moneyAvailable = money;
        this.pin = pin;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public Integer getBalance(){
        return this.moneyAvailable;
    }

    public Boolean VerifyPin(int pin){
        if (pin == this.pin){
            return true;
        } else {
            return false;
        }
    }

    public void depositMoney(int money){
        moneyAvailable =+ money;
    }
}
