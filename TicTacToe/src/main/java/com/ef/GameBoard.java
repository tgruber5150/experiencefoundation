package com.ef;

import java.util.HashMap;
import java.util.List;

public class GameBoard<Cell, Player> extends HashMap<Cell, Player> {

    public GameBoard() {
    }

    public boolean isWinnerFound(List<com.ef.Player> playersFromCells) {
        if(playersFromCells.contains(null)) {
            return false;
        }

        boolean containsX = false;
        boolean containsO = false;
        for(com.ef.Player player : playersFromCells) {
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
