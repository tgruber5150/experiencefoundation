package com.ef;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

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

    private static final List<List<Cell>> expectedKeys = new ArrayList<List<Cell>>(){{
       add(Arrays.asList(Cell.A1, Cell.A2, Cell.A3));
       add(Arrays.asList(Cell.B1, Cell.B2, Cell.B3));
       add(Arrays.asList(Cell.C1, Cell.C2, Cell.C3));

       add(Arrays.asList(Cell.A1, Cell.B1, Cell.C1));
       add(Arrays.asList(Cell.A2, Cell.B2, Cell.C2));
       add(Arrays.asList(Cell.A3, Cell.B3, Cell.C3));

       add(Arrays.asList(Cell.A1, Cell.B2, Cell.C3));
       add(Arrays.asList(Cell.A3, Cell.B2, Cell.C1));
    }};

    @Test
    public void playerXShouldWinWith3InARow() {
        for(List<Cell> key : expectedKeys) {
            game.startGame();
            assertFalse(game.getGameBoard().isWinner());
            game.move(key.get(0), playerO);
            assertFalse(game.getGameBoard().isWinner());
            game.move(key.get(1), playerO);
            assertFalse(game.getGameBoard().isWinner());
            game.move(key.get(2), playerO);
            assertTrue("Expected key: " + key, game.getGameBoard().isWinner());
        }
    }

    @Test
    public void noWinnerFoundInA1ThruA3() {
        game.move(Cell.A1, playerX);
        assertFalse(game.getGameBoard().isWinner());
        game.move(Cell.A2, playerO);
        assertFalse(game.getGameBoard().isWinner());
        game.move(Cell.A3, playerX);
        assertFalse(game.getGameBoard().isWinner());
    }

    @Test
    public void cellShouldContainOnePlayer() {
        game.move(Cell.A1, playerO);
        game.move(Cell.A1, playerX);
        Player actualPlayer = game.getGameBoard().get(Cell.A1);
        assertEquals(playerO.getPlayerType(), actualPlayer.getPlayerType());
    }


}

