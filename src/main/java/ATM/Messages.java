package ATM;

public class Messages {
    
    public static String Welcome(){
        return ("Welcome to Toms ATM, the only ATM in the world not guarenties to not scam you!\nPlease enter your card\n");
    }

    public static String cardEnter(){
        return ("***CARD Inserted***\n");
    }

    public static String cardReturned(){
        return("***CARD Returned***\n");
    }

    public static String ProvidePin(){
        return("Please enter your PIN number\n");
    }

    public static String PinRejected(){
        return("Incorect Pin\n");
    }

    public static String NotEnoughMoney(int moneyAvailable, int moneyDesired){
        return("Uh Oh, it looks like we don't have enough cash for you.\nWe could only retreve £" + moneyAvailable + " from the machine, meaning you are £" + (moneyDesired - moneyAvailable) + " short.\n");
    }

    public static String MainMenu(){
        return("Please select an option:\n1. Withdraw money\n2. Deposit money\n3. Check balance\n4. Exit\n");
    }

    public static String InvalidOption(){
        return("Invalid option\n");
    }

    public static String MoneyWanted(){
        return("How much money do you want?\n");
    }

    public static String MoneyToDeposit(){
        return("How much money do you want to deposit?\n");
    }

    public static String TooMuchMoney(){
        return("Naught Naughty, you dont have that money in your account");
    }

}
