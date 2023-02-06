package game;

import java.util.ArrayList;

// TODO implement skip
// TODO implement reverse

public class go
{
    public static void main(String args[])
    {
        ArrayList<Player> players = new ArrayList<Player>();

        GameState g = new GameState(players);

        players.add(new AIplayer(g, "computer"));
        players.add(new HumanPlayer(g));

        g.runGame();

    }

}
