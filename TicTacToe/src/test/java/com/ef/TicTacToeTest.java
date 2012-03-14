package com.ef;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

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
        Map<Cell, Player> gameBoard = game.getGameBoard();

        Map<Cell, Player> expectedBoard = new HashMap<Cell, Player>();
        expectedBoard.put(Cell.A1, null);
        expectedBoard.put(Cell.A2, null);
        expectedBoard.put(Cell.A3, null);
        expectedBoard.put(Cell.B1, null);
        expectedBoard.put(Cell.B2, null);
        expectedBoard.put(Cell.B3, null);
        expectedBoard.put(Cell.C1, null);
        expectedBoard.put(Cell.C2, null);
        expectedBoard.put(Cell.C3, null);

        assertNotNull("Game board is null!", gameBoard);
        assertEquals(expectedBoard, gameBoard);
    }

    @Test
    public void playerXShouldWinWithA1ThruA3Sweep() {
        game.move(Cell.A1, playerX);
        assertFalse(game.hasWinner());
        game.move(Cell.B1, playerO);
        assertFalse(game.hasWinner());
        game.move(Cell.A2, playerX);
        assertFalse(game.hasWinner());
        game.move(Cell.B2, playerO);
        assertFalse(game.hasWinner());
        game.move(Cell.A3, playerX);
        assertTrue(game.hasWinner());
    }

    @Test
    public void noWinnerFoundInA1ThruA3() {
        game.move(Cell.A1, playerX);
        assertFalse(game.hasWinner());
        game.move(Cell.A2, playerO);
        assertFalse(game.hasWinner());
        game.move(Cell.A3, playerX);
        assertFalse(game.hasWinner());
    }

    @Test
    public void gameDeclaresWinner() {
        game.move(Cell.A1, playerX);
        game.move(Cell.B1, playerO);
        game.move(Cell.A2, playerX);
        game.move(Cell.B2, playerO);
        game.move(Cell.A3, playerX);


        assertTrue(game.hasWinner());
        Player winningPlayer = game.getWinner();

        assertNotNull("Winning Player is null", winningPlayer);
        assertEquals(playerX, winningPlayer);
    }

}

