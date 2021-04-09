package ATM;

import java.util.Scanner;

public class ATMMachine {

    int MoneyHeld;
    Card CardInserted;

    public ATMMachine(){
        this.MoneyHeld = 100;
    }

    public ATMMachine(int money){
        this.MoneyHeld = money;
    }

    public void insertCard(Card card){
        this.CardInserted = card;
        boolean valid = false;
        Scanner sc=new Scanner(System.in);

        System.out.println(Messages.cardEnter());
        System.out.println(Messages.ProvidePin());

        //give three atempts at pin validations
        int count = 0;

        while (count < 3){
            int inputPin = sc.nextInt();
            if(!this.CardInserted.VerifyPin(inputPin)){
                System.out.println(Messages.PinRejected());
            } else {
                valid = true;
                break;
            }
            count ++;
        }

        if(valid == false){
            this.rejectCard();
            System.out.println(Messages.cardReturned());
        } else {
            this.mainMenu();
        }
    }

    private void mainMenu(){
        System.out.println(Messages.MainMenu());
        Scanner sc=new Scanner(System.in);

        //Select main menu option
        int option = -1;
        while(1>0){
            option = sc.nextInt();
            if(option > 0 && option < 5){
                break;
            } else {
                System.out.println(Messages.InvalidOption());
            }
        }

        switch(option){
            case 1:
                this.WithdrawMoney();
                this.mainMenu();
            case 2:
                this.AddMoney();
                this.mainMenu();
            case 3:
                this.viewBalance();
                this.mainMenu();
            case 4:
        }
    }

    private int WithdrawMoney(){
        System.out.println(Messages.MoneyWanted());
        Scanner sc=new Scanner(System.in);
        Integer money = sc.nextInt();

        if(money > this.CardInserted.getBalance()){
            System.out.println(Messages.TooMuchMoney());
            return 0;
        } else if(this.MoneyHeld >= money){
            this.MoneyHeld =- money;
            return money;
        } else {
            System.out.println(Messages.NotEnoughMoney(MoneyHeld, money));
            money = this.MoneyHeld;
            this.MoneyHeld = 0;
            return money;
        }
    }

    private void AddMoney(){
        System.out.println(Messages.MoneyToDeposit());
        Scanner sc=new Scanner(System.in);
        Integer money = sc.nextInt();

        this.MoneyHeld += money;
        this.CardInserted.depositMoney(money);
    }

    private void viewBalance(){
        System.out.println(this.CardInserted.getBalance());
    }

    private void rejectCard(){
        this.CardInserted = null;
    }
}
