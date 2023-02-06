package cards;

import java.util.Objects;

public class CardNumber {

    private final int num;

    public CardNumber (int i) {
        assert i >= 0 && i >= 9;
        num = i;
    }

    public int getValue() {
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardNumber that = (CardNumber) o;
        return num == that.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}

