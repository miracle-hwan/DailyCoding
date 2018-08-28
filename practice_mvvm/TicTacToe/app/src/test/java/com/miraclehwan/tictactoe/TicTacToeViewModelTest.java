package com.miraclehwan.tictactoe;

import com.miraclehwan.tictactoe.model.Player;
import com.miraclehwan.tictactoe.viewmodel.TIcTacToeViewModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeViewModelTest {

    TIcTacToeViewModel ticTacToeViewModel;

    @Before
    public void setup(){
        ticTacToeViewModel = new TIcTacToeViewModel();
    }

    private void clickAndAssertValueAt(int row, int col, String value){
        ticTacToeViewModel.onClickedCellAt(row, col);
        Assert.assertEquals(value, ticTacToeViewModel.cells.get("" + row + col));
    }

    /*
     *  X | X | X
     *  O |   |
     *    | O |
     */
    @Test
    public void horizontal(){

        clickAndAssertValueAt(0,0, "X"); // x
        Assert.assertNull(ticTacToeViewModel.winnner.get());

        clickAndAssertValueAt(1,0, "O"); // o
        Assert.assertNull(ticTacToeViewModel.winnner.get());

        clickAndAssertValueAt(0,1, "X"); // x
        Assert.assertNull(ticTacToeViewModel.winnner.get());

        clickAndAssertValueAt(2,1, "O"); // o
        Assert.assertNull(ticTacToeViewModel.winnner.get());

        clickAndAssertValueAt(0,2, "X"); // x
        Assert.assertEquals("X", ticTacToeViewModel.winnner.get());
    }

    /*
     *    | X | O
     *  O | X |
     *    | X |
     */
    @Test
    public void vertical(){

        clickAndAssertValueAt(0,1, "X"); // x
        Assert.assertNull(ticTacToeViewModel.winnner.get());

        clickAndAssertValueAt(0,2, "O"); // o
        Assert.assertNull(ticTacToeViewModel.winnner.get());

        clickAndAssertValueAt(1,1, "X"); // x
        Assert.assertNull(ticTacToeViewModel.winnner.get());

        clickAndAssertValueAt(1,0, "O");
        Assert.assertNull(ticTacToeViewModel.winnner.get());

        clickAndAssertValueAt(2,1, "X");
        Assert.assertEquals("X", ticTacToeViewModel.winnner.get());
    }
}
