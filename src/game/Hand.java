package game;

import cards.Card;
import java.util.ArrayList;
import java.util.Collections;

public class Hand implements CardSequence
{
    ArrayList<Card> cardsInHand =  new ArrayList<Card>();

    Hand(GameState g)
    {
        for (int i = 0; i < 7; i++)
        {

            Card c = g.deck.draw();
            cardsInHand.add(c);
        }
    }



    @Override
    public ArrayList<Card> listCards()
    {
        return (ArrayList<Card>) Collections.unmodifiableList(cardsInHand);
    }

    @Override
    public void printCards()
    {
        System.out.println(cardsInHand.toString());
    }

    public void addToHand(cards.UnoDeck d)
    {
        assert d != null;

        Card c = d.draw();
        cardsInHand.add(c);
    }

    public void pickUp2(cards.UnoDeck d)
    {
        for (int i = 0; i < 2; i++)
        {
            Card c = d.draw();
            cardsInHand.add(c);
        }

    }

    public void pickUp4(cards.UnoDeck d)
    {
        for (int i = 0; i < 4; i++)
        {
            Card c = d.draw();
            cardsInHand.add(c);
        }
    }
}
