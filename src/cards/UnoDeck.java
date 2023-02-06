package cards;

import game.CardSequence;

import java.util.ArrayList;
import java.util.Collections;

public class UnoDeck implements CardSequence
{
    private ArrayList<Card> deck = new ArrayList<Card>();

     public UnoDeck()
     {
         //initializing cards with a colour
        for(Colour c : Colour.values())
        {
            for(int i = 0; i <= 9; i++)
                deck.add(new Card(c, new CardNumber(i)));

            for(int i = 1; i<= 9; i++)
                deck.add(new Card(c, new CardNumber(i)));

            for(int i=0; i <= 1; i++)
            {
                deck.add(new WildCard(cards.Special.DRAW2, c));
                deck.add(new WildCard(cards.Special.REVERSE, c));
                deck.add(new WildCard(cards.Special.SKIP, c));
            }

        }

        // initializing draw4 cards
        for(int i = 0; i < 4; i++)
            deck.add(new WildCard(Special.DRAW4));

            this.shuffle();
    }

    /*
    @ pre, deck cannot be empty
    @ post, returns first element of deck, removes it from list
     */

    public Card draw()
    {
        assert !deck.isEmpty();

        Card c = deck.get(1);
        deck.remove(1);
        return c;
    }

    private void shuffle()
    {
        Collections.shuffle(deck);
    }

    @Override
    public ArrayList<Card> listCards()
    {
            return (ArrayList<Card>) Collections.unmodifiableList(deck);
    }

    @Override
    public void printCards()
    {
        System.out.println(deck.toString());
    }
}
