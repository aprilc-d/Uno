package cards;

import java.util.Objects;
import java.util.Optional;

public class Card {

    //fields are optional bc see subclass, WildCard

    final Optional<Colour> colour;
    final Optional<CardNumber> num;

    // main constructor, only constructor used in this exact class, for cards with num and colour
    Card(Colour c, CardNumber n) {
        colour = Optional.ofNullable(c);
        num = Optional.ofNullable(n);
    }

    // needed for subclass, for skip, draw 2, reverse
    Card(Colour c) {
        colour = Optional.ofNullable(c);
        num = Optional.empty();
    }

    // needed for subclass, used to initialized draw4
    Card() {
        colour = Optional.empty();
        num = Optional.empty();
    }

    /*
     @ pre field must be initialized (ie cannot be a wildcard without colour)
     @ post returns colour of card
    */

    public Colour getColour() {
        assert colour.isPresent();
        return this.colour.get();
    }

    /*
     @ pre cannot be of instance WildCard
     @ post CardNumber is returned
    */

    public CardNumber getNum() {
        assert this.num.isPresent();
        return this.num.get();
    }

    public String toString() {
        assert this.colour.isPresent() && this.num.isPresent();

        return this.colour.get().toString() + " " + this.num.get().getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(colour, card.colour) && Objects.equals(num, card.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colour, num);
    }
}

