package game;

import cards.Special;
import cards.WildCard;

import java.util.ArrayList;
import java.util.Random;

public class AIplayer extends Player {


    AIplayer(GameState g, String n) {
        super(g);
        name = n;
    }

    @Override
    public void playingACard(cards.Card c, GameState g)
    {
        Player.pickUpCards(c, g);

        Player.doSkip(c, g);

        Player.doReverse(c, g);

        System.out.println(this.name + " " + "has played" + " " + c.toString());

        this.playerHand.cardsInHand.remove(c);
    }

    @Override
    public void winMessage() {
        System.out.println(this.name + " has won the game! \n better luck next time!");
    }

    @Override
    public cards.Card doTurn(cards.Card c, GameState g)
    {

        ArrayList<cards.Card> playableCards = new ArrayList<cards.Card>();

        for (int i = 0; i < this.playerHand.cardsInHand.size(); i++)
        {
            cards.Card temp = this.playerHand.cardsInHand.get(i);
            if(Player.validMove(temp, c))
                playableCards.add(temp);
        }

        if (playableCards.isEmpty())
        {
            this.playerHand.addToHand(g.deck);
            System.out.println(this.name + " " + "could not play a card so one was drawn");
            return c;
        }

        cards.Card toPlay = playableCards.get((new Random()).nextInt(playableCards.size()));

        this.playingACard(toPlay, g);

        return toPlay;

    }
}

