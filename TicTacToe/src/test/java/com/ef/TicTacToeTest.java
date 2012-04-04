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
        GameBoard<Cell, Player> gameBoard = game.getGameBoard();

        Map<Cell, Player> expectedBoard = new HashMap<Cell, Player>();

        assertNotNull("Game board is null!", gameBoard);
        assertTrue(gameBoard.isEmpty());
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
    public void playerXShouldWinWithB1ThruB3Sweep() {
        game.move(Cell.B1, playerX);
        assertFalse(game.hasWinner());
        game.move(Cell.C1, playerO);
        assertFalse(game.hasWinner());
        game.move(Cell.B2, playerX);
        assertFalse(game.hasWinner());
        game.move(Cell.C2, playerO);
        assertFalse(game.hasWinner());
        game.move(Cell.B3, playerX);
        assertTrue(game.hasWinner());
    }

    @Test
    public void playerXShouldWinWithA1ThruC1Sweep() {
        game.move(Cell.A1, playerX);
        assertFalse(game.hasWinner());
        game.move(Cell.C2, playerO);
        assertFalse(game.hasWinner());
        game.move(Cell.B1, playerX);
        assertFalse(game.hasWinner());
        game.move(Cell.C3, playerO);
        assertFalse(game.hasWinner());
        game.move(Cell.C1, playerX);
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
    public void cellShouldContainOnePlayer() {
        game.move(Cell.A1, playerO);
        game.move(Cell.A1, playerX);
        assertEquals(playerO.getPlayerType(), game.getGameBoard().get(Cell.A1).getPlayerType());
    }


}

