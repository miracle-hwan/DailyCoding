package com.miraclehwan.tictactoe.viewmodel;

import android.databinding.ObservableArrayMap;
import android.databinding.ObservableField;

import com.miraclehwan.tictactoe.model.Board;
import com.miraclehwan.tictactoe.model.Player;

public class TIcTacToeViewModel{

    private Board model;

    public ObservableArrayMap<String, String> cells = new ObservableArrayMap<>();
    public ObservableField<String> winnner = new ObservableField<>();

    public TIcTacToeViewModel() {
        model = new Board();
    }

    public void onRestartSelected(){
        model.restart();
        winnner.set(null);
        cells.clear();
    }

    public void onClickedCellAt(int row, int col){
        if (!model.isCheck(row, col) && !model.isFinish()){
            Player playerThatMoved = model.mark(row, col);
            cells.put("" + row + col, playerThatMoved.toString());
            winnner.set(model.getWinner() == null ? null : model.getWinner().toString());
        }
    }
}
