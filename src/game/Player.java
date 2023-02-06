package game;

import cards.Special;
import cards.WildCard;
import java.util.Collections;

public abstract class Player
{

    public Hand playerHand;

    public String name;

    Player(GameState g)
    {
        playerHand = new Hand(g);
    }

    public abstract void playingACard(cards.Card c, GameState g);


    public static void pickUpCards (cards.Card toPlay, GameState g)
    {
        if (toPlay instanceof WildCard && (((WildCard) toPlay).getAttribute().equals(Special.DRAW4)))
        {
            g.players.get((g.nextTurn())).playerHand.pickUp4(g.deck);

        }
        if (toPlay instanceof WildCard && ((WildCard) toPlay).getAttribute().equals(Special.DRAW2))
        {
            g.players.get((g.nextTurn())).playerHand.pickUp2(g.deck);
        }
    }

    public static void doSkip(cards.Card toPlay, GameState g)
    {
        if (toPlay instanceof WildCard && ((WildCard) toPlay).getAttribute().equals(Special.SKIP))
            g.whoseTurn = g.nextTurn();

    }

    public static void doReverse(cards.Card toPlay, GameState g)
    {
        if (toPlay instanceof WildCard && ((WildCard) toPlay).getAttribute().equals(Special.REVERSE))
        {
            g.whoseTurn = g.players.size() - 1 -g.whoseTurn;
            Collections.reverse(g.players);
        }
    }

    public abstract void winMessage();

    static boolean validMove(cards.Card toPlay, cards.Card toCheck) {

        boolean isPlayable = false;
        if (toCheck instanceof WildCard && ((WildCard) toCheck).getAttribute().equals(Special.DRAW4))
        {
            return true;
        }
        if (toCheck instanceof WildCard) {
            if (toPlay instanceof WildCard && ((WildCard) toPlay).getAttribute().equals(Special.DRAW4)) {
                return true;
            }

            if (toPlay.getColour().equals(toCheck.getColour())) {
                return true;

            } else
                return false;
        }

        // c is a normal card
        if (toCheck instanceof cards.Card) {
            if (toPlay instanceof WildCard && ((WildCard) toPlay).getAttribute().equals(Special.DRAW4)) {
                return true;
            }

            if (toPlay instanceof WildCard && toPlay.getColour().equals(toCheck.getColour())) {
                return true;
            }

            if (toPlay.getColour().equals(toCheck.getColour())) {
                return true;
            }

            if (toPlay.getClass() == toCheck.getClass() && toPlay.getNum().equals(toCheck.getNum())) {
                return true;
            } else return false;
        }
        return false;
    }

    public abstract cards.Card doTurn(cards.Card c, GameState g);

}
