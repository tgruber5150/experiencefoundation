package com.ef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GameBoard<K extends Cell, V extends Player> extends HashMap<K, V> {

    private List<List<Cell>> winningKeys = new ArrayList<List<Cell>>(){{
       add(Arrays.asList(Cell.A1, Cell.A2, Cell.A3));
       add(Arrays.asList(Cell.B1, Cell.B2, Cell.B3));
       add(Arrays.asList(Cell.C1, Cell.C2, Cell.C3));

       add(Arrays.asList(Cell.A1, Cell.B1, Cell.C1));
       add(Arrays.asList(Cell.A2, Cell.B2, Cell.C2));
       add(Arrays.asList(Cell.A3, Cell.B3, Cell.C3));

       add(Arrays.asList(Cell.A1, Cell.B2, Cell.C3));
       add(Arrays.asList(Cell.A3, Cell.B2, Cell.C1));
    }};

    public GameBoard() {
    }

    public boolean isWinner() {
        for(List winningKey : winningKeys) {
            List<Player> playersFromCells = new ArrayList<Player>();
            playersFromCells.add(this.get(winningKey.get(0)));
            playersFromCells.add(this.get(winningKey.get(1)));
            playersFromCells.add(this.get(winningKey.get(2)));

            if(isWinnerFoundInKey(playersFromCells)) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinnerFoundInKey(List<Player> playersFromCells) {
        if(playersFromCells.contains(null)) {
            return false;
        }

        boolean containsX = false;
        boolean containsO = false;
        for(Player player : playersFromCells) {
            if(PlayerType.X == player.getPlayerType()) {
                containsX = true;
            }
            if(PlayerType.O == player.getPlayerType()) {
                containsO = true;
            }
        }

        boolean containsOnePlayer = containsOnePlayerType(containsX, containsO);

        return containsOnePlayer;
    }

    private boolean containsOnePlayerType(boolean containsX, boolean containsO) {
        return containsX && !containsO || !containsX && containsO;
    }

}
