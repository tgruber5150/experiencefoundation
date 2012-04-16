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
        player2.setPlayerType(PlayerType.0);
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
           getGameBoard().isWinner();
       }
    }

}
