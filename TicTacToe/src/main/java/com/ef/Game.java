package com.ef;

import java.util.*;

public class Game {

    private List<Player> players;
    private GameBoard<Cell, Player> gameBoard;

    public void startGame() {
        addPlayersToGame();
        resetGameBoard();
    }

    private void addPlayersToGame() {
        players = new ArrayList<Player>();
        Player player1 = new Player();
        player1.setPlayerType(PlayerType.X);
        Player player2 = new Player();
        player2.setPlayerType(PlayerType.O);
        players.add(player1);
        players.add(player2);
    }

    private void resetGameBoard() {
        gameBoard = new GameBoard<Cell, Player>();
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public GameBoard<Cell, Player> getGameBoard() {
        return this.gameBoard;
    }


    public void move(Cell cell, Player player) {
       if(getGameBoard().get(cell) == null) {
           getGameBoard().put(cell, player);
           hasWinner();
       }
    }

    public boolean hasWinner() {
        List<Player> playersFromCells = new ArrayList<Player>();
        playersFromCells.add(getGameBoard().get(Cell.A1));
        playersFromCells.add(getGameBoard().get(Cell.A2));
        playersFromCells.add(getGameBoard().get(Cell.A3));

        if(getGameBoard().isWinnerFound(playersFromCells)) {
            return true;
        }

        List<Player> playersFromBCells = new ArrayList<Player>();
        playersFromBCells.add(getGameBoard().get(Cell.B1));
        playersFromBCells.add(getGameBoard().get(Cell.B2));
        playersFromBCells.add(getGameBoard().get(Cell.B3));

        if(getGameBoard().isWinnerFound(playersFromBCells)) {
            return true;
        }

        return false;
    }

}
