package com.ef;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class TicTacToeTest {

    private Game game;
    private Player playerX;
    private Player playerO;

    @Before
    public void setUp() {
        game = new Game();
        game.startGame();
        List<Player> players = game.getPlayers();
        playerX = players.get(0);
        playerO = players.get(1);
    }

    @Test
    public void ticTacToeStartsGameWithTwoPlayersXAndOTypes() {
        List<Player> players = game.getPlayers();
        assertNotNull("Game did not initialize with players.", players);
        assertEquals(2, players.size());
        assertEquals(PlayerType.X, players.get(0).getPlayerType());
        assertEquals(PlayerType.O, players.get(1).getPlayerType());
    }

    @Test
    public void gameShouldStartWithNewGameBoard() {
        Map<String, Player> gameBoard = game.getGameBoard();

        Map<String, Player> expectedBoard = new HashMap<String, Player>();
        expectedBoard.put("a1", null);
        expectedBoard.put("a2", null);
        expectedBoard.put("a3", null);
        expectedBoard.put("b1", null);
        expectedBoard.put("b2", null);
        expectedBoard.put("b3", null);
        expectedBoard.put("c1", null);
        expectedBoard.put("c2", null);
        expectedBoard.put("c3", null);

        assertNotNull("Game board is null!", gameBoard);
        assertEquals(expectedBoard, gameBoard);
    }

    @Test
    public void playerXShouldWinWithA1ThruA3Sweep() {
        game.move("a1", playerX);
        assertFalse(game.hasWinner());
        game.move("b1", playerO);
        assertFalse(game.hasWinner());
        game.move("a2", playerX);
        assertFalse(game.hasWinner());
        game.move("b2", playerO);
        assertFalse(game.hasWinner());
        game.move("a3", playerX);
        assertTrue(game.hasWinner());
    }

    @Test
    public void noWinnerFoundInA1ThruA3() {
        game.move("a1", playerX);
        assertFalse(game.hasWinner());
        game.move("a2", playerO);
        assertFalse(game.hasWinner());
        game.move("a3", playerX);
        assertFalse(game.hasWinner());
    }


}

