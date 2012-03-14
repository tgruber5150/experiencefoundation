package com.ef;

import java.util.*;

public class Game {

    private List<Player> players;
    private Map<Cell, Player> gameBoard;
    private Player winner;

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
        gameBoard = new HashMap<Cell, Player>();
        gameBoard.put(Cell.A1, null);
        gameBoard.put(Cell.A2, null);
        gameBoard.put(Cell.A3, null);
        gameBoard.put(Cell.B1, null);
        gameBoard.put(Cell.B2, null);
        gameBoard.put(Cell.B3, null);
        gameBoard.put(Cell.C1, null);
        gameBoard.put(Cell.C2, null);
        gameBoard.put(Cell.C3, null);
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public Map<Cell, Player> getGameBoard() {
        return this.gameBoard;
    }


    public void move(Cell cell, Player player) {
       getGameBoard().put(cell, player);
    }

    public boolean hasWinner() {
        return isWinnerFoundInA1ThruA3();
    }

    private boolean isWinnerFoundInA1ThruA3() {
        List<Player> playersFromCells = new ArrayList<Player>();
        playersFromCells.add(getGameBoard().get(Cell.A1));
        playersFromCells.add(getGameBoard().get(Cell.A2));
        playersFromCells.add(getGameBoard().get(Cell.A3));

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

        if(containsOnePlayer) {
            setWinner(playersFromCells.get(0));
        }

        return containsOnePlayer;
    }

    private boolean containsOnePlayerType(boolean containsX, boolean containsO) {
        return containsX && !containsO || !containsX && containsO;
    }


    public Player getWinner() {
        return this.winner;
    }

    private void setWinner(Player player) {
        this.winner = player;
    }

}
