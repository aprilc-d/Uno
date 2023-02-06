package cards;

public class WildCard extends Card
{
    final Special attribute;

    //for cards without a number, but have a colour

    WildCard(Special s, Colour c)
    {
        super(c);
        attribute = s;
    }

    //for draw4

    WildCard(Special s)
    {
        super();
        attribute = s;
    }

    public Special getAttribute() {
        return attribute;
    }

    public String toString()
    {
        if (this.colour.isPresent())
        {
            assert attribute != null;
            return this.colour.get().toString() + " " + this.attribute.toString();

        } else
            return this.attribute.toString();
    }

}
