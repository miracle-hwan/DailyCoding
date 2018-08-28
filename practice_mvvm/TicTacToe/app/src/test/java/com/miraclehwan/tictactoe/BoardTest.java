package com.miraclehwan.tictactoe;

import com.miraclehwan.tictactoe.model.Board;
import com.miraclehwan.tictactoe.model.Player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    private Board board;

    @Before
    public void setup(){
        board = new Board();
    }

    /*
     *  X | X | X
     *  O |   |
     *    | O |
     */
    @Test
    public void horizontal(){

        board.mark(0,0); // x
        Assert.assertNull(board.getWinner());

        board.mark(1,0); // o
        Assert.assertNull(board.getWinner());

        board.mark(0,1); // x
        Assert.assertNull(board.getWinner());

        board.mark(2,1); // o
        Assert.assertNull(board.getWinner());

        board.mark(0,2); // x
        Assert.assertEquals(Player.X, board.getWinner());
    }

    /*
     *    | X | O
     *  O | X |
     *    | X |
     */
    @Test
    public void vertical(){

        board.mark(0,1); // x
        Assert.assertNull(board.getWinner());

        board.mark(0,2); // o
        Assert.assertNull(board.getWinner());

        board.mark(1,1); // x
        Assert.assertNull(board.getWinner());

        board.mark(1,0);
        Assert.assertNull(board.getWinner());

        board.mark(2,1);
        Assert.assertEquals(Player.X, board.getWinner());
    }

}
