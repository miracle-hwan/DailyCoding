package com.miraclehwan.tictactoe.model;

import lombok.Data;

@Data
public class Board {

    private Cell[][] cells = new Cell[3][3];

    private enum GameState { IN_PROGRESS, FINISHED };

    private GameState state;
    private Player winner;
    private Player currentTurn;

    public Board(){
        restart();
    }

    public void clearCells(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void restart(){
        clearCells();
        winner = null;
        currentTurn = Player.X;
        state = GameState.IN_PROGRESS;
    }

    public Player mark(int row, int col){
        cells[row][col].setValue(currentTurn);
        Player playerThatMoved = currentTurn;
        if (isWin(currentTurn, row, col)){
            state = GameState.FINISHED;
            winner = currentTurn;
        } else {
            filpCurrentTurn();
        }
        return playerThatMoved;
    }

    public boolean isFinish(){
        if (state == GameState.FINISHED){
            return true;
        }else{
            return false;
        }
    }

    public boolean isCheck(int row, int col){
        if (cells[row][col].getValue() != null){
            return true;
        }else{
            return false;
        }
    }

    private void filpCurrentTurn(){
        if (currentTurn == Player.X){
            currentTurn = Player.O;
        }else{
            currentTurn = Player.X;
        }
    }

    private boolean isWin(Player player, int row, int col){
        return (cells[row][0].getValue() == player
                && cells[row][1].getValue() == player
                && cells[row][2].getValue() == player
                || cells[0][col].getValue() == player
                && cells[1][col].getValue() == player
                && cells[2][col].getValue() == player
                || row == col
                && cells[0][0].getValue() == player
                && cells[1][1].getValue() == player
                && cells[2][2].getValue() == player
                || row + col == 2
                && cells[0][2].getValue() == player
                && cells[1][1].getValue() == player
                && cells[2][0].getValue() == player);
    }
}
