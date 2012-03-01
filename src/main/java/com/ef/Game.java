package com.ef;

import java.util.*;

public class Game {

    private List<Player> players;
    private Map<String, Player> gameBoard;

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
        gameBoard = new HashMap<String, Player>();
        gameBoard.put("a1", null);
        gameBoard.put("a2", null);
        gameBoard.put("a3", null);
        gameBoard.put("b1", null);
        gameBoard.put("b2", null);
        gameBoard.put("b3", null);
        gameBoard.put("c1", null);
        gameBoard.put("c2", null);
        gameBoard.put("c3", null);
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public Map<String, Player> getGameBoard() {
        return this.gameBoard;
    }


    public void move(String coordinate, Player player) {
       getGameBoard().put(coordinate, player);
    }

    public boolean hasWinner() {
        return isWinnerFoundInA1ThruA3();
    }

    private boolean isWinnerFoundInA1ThruA3() {
        List<Player> players = new ArrayList<Player>();
        players.add(getGameBoard().get("a1"));
        players.add(getGameBoard().get("a2"));
        players.add(getGameBoard().get("a3"));

        if(players.contains(null)) {
            return false;
        }

        boolean containsX = false;
        boolean containsO = false;
        for(Player player : players) {
            if(PlayerType.X == player.getPlayerType()) {
                containsX = true;
            }
            if(PlayerType.O == player.getPlayerType()) {
                containsO = true;
            }

            if(containsX && containsO) {
                return false;
            }
        }

//        return containsX && !containsO || !containsX && containsO;
        return true;

    }



}
