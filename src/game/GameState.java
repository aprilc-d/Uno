package game;

import cards.UnoDeck;

import java.util.ArrayList;
import java.util.List;

public class GameState
{
    public ArrayList<Player> players;
    public cards.UnoDeck deck = new UnoDeck();
    private boolean done = false;
    public final int numOfPlayers;
    int whoseTurn;
    private cards.Card currentCard = deck.draw();


    GameState(List<Player> p)
    {
        assert p.size() > 1;

        players = (ArrayList<Player>) p;

        numOfPlayers = p.size();
        whoseTurn = 0;
    }

    public void turn(Player p)
    {
        currentCard = p.doTurn(this.currentCard, this);
        if (p.playerHand.cardsInHand.isEmpty())
        {
            done = true;
            p.winMessage();
        }
        whoseTurn = this.nextTurn();
    }

    public int nextTurn()
    {
        if (whoseTurn < players.size() - 1 )
        {
            int i = whoseTurn + 1;
            return i;

        } else
            return 0;
    }

    public int prevTurn()
    {
        if (whoseTurn == 0)
            return players.size() - 1;
        else
            return whoseTurn - 1;
    }
    public void runGame()
    {
        System.out.println("the starting card is" + " " + this.currentCard.toString());
        while (!done)
            this.turn(players.get(whoseTurn));
    }
}
