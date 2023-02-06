package game;

import cards.Special;
import cards.WildCard;

import java.util.Scanner;
import java.util.regex.*;

public class HumanPlayer extends Player
{

    HumanPlayer(GameState g)
    {
        super(g);
        name = "you";
    }

    @Override
    public void playingACard(cards.Card c, GameState g)
    {
        Player.pickUpCards(c, g);

        Player.doSkip(c, g);

        Player.doReverse(c, g);

        System.out.println(this.name + " " + "have played" + " " + c.toString());

        this.playerHand.cardsInHand.remove(c);
    }

    @Override
    public void winMessage()
    {
        System.out.println("Congrats! you have won the game!");
    }

    private boolean playable(cards.Card c)
    {
        boolean isPlayable = false;
        for(cards.Card k : this.playerHand.cardsInHand)
        {
            if (Player.validMove(k, c))
                isPlayable = true;

        }
        return isPlayable;
    }

    private cards.Card inputGetter(cards.Card c)
    {
        boolean isValid = false;
        while (!isValid)
        {

            Scanner scanner = new Scanner (System.in);
            String input = scanner.nextLine();

            Pattern isNum = Pattern.compile("-?\\d+(\\.\\d+)?");

            if (isNum.matcher(input).matches())
            {
                int n = Integer.parseInt(input);

                if (n >= 0 && n < this.playerHand.cardsInHand.size())
                {
                    isValid = true;
                    cards.Card toPlay = this.playerHand.cardsInHand.get(n);

                    return toPlay;

                } else
                    System.out.println("Invalid input");
            }

        }

        //failsafe
        return c;
    }

    public cards.Card doTurn(cards.Card c, GameState g)
    {
        System.out.println("Please select which card you would like to play");
        this.playerHand.printCards();

        if(!this.playable(c))
        {
            System.out.println("you have no valid moves! you pick up a card");
            System.out.println("press any key to continue");

            Scanner scanner = new Scanner (System.in);
            char input = scanner.next().charAt(0);


            this.playerHand.addToHand(g.deck);
            return c;

        }
        cards.Card toPlay = this.inputGetter(c);

        if (validMove(toPlay, c))
        {
            this.playingACard(toPlay, g);
            return toPlay;

        } else
        {
            System.out.println("that is not a valid move!");
            this.doTurn(c, g);
        }

       return c;
    }
}
