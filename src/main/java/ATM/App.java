package ATM;

import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        //Making an ATM machine with £10,000
        ATMMachine ATM = new ATMMachine(10000);

        //Making 3 cards to use in the machine
        Card tomsCard = new Card(400, 6789, "TomsCard");
        Card isacsCard = new Card(800, 1234, "IsacsCard");
        Card bensCard = new Card(2000, 4888, "BensCard");

        ArrayList<Card> cardList = new ArrayList<Card>();
        cardList.add(tomsCard);
        cardList.add(isacsCard);
        cardList.add(bensCard);

        System.out.println("Cards available:\n1. " + cardList.get(0).getName() + "\n2." + cardList.get(1).getName() + "\n3." + cardList.get(2).getName() + "\n");

        //Card selection loop
        Card cardSelected = null;
        Scanner sc=new Scanner(System.in);

        //Select a card to use
        while(cardSelected == null){
            int cardNo = sc.nextInt();
            if(cardNo >= cardList.size() || cardNo < 0){
                System.out.println("Invalid card selection");;
            } else {
                cardSelected = cardList.get(cardNo - 1);
            }
        }

        //Insert card in to machine
        System.out.println(Messages.Welcome());
        ATM.insertCard(cardSelected);
    }
}
