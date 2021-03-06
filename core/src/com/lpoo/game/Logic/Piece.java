package com.lpoo.game.Logic;

import java.util.ArrayList;

/**
 * Created by FranciscoSilva on 17/05/17.
 */

public class Piece {
    private char symbol;
    private boolean inGame;

    int posOnBoard;
    String actualPossibleMoves;
    public boolean playerColor;


    public void setPosOnBoard(int posOnBoard) {
        this.posOnBoard = posOnBoard;
    }

    public Piece(char sym, int pos, boolean playerColor){
        this.symbol = sym;
        this.inGame = true;
        posOnBoard = pos;
        this.playerColor = playerColor;
    }

    public void setXY(int pos){
        this.posOnBoard = pos;
    }

    public void setOutOfGame(){
        this.inGame = false;
    }

    public int getPosOnBoard(){
        return this.posOnBoard;
    }

    public boolean getInGameState(){
        return this.inGame;
    }

    public char getSymbol(){
        return this.symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     *
     * @param x Line on Board
     * @param y Column on Board
     * @return Position 0-63 on board
     */
//castling (returns move as 0kingColumn,1rookColumn,2kingNewColumn,3rookNewColumn,4C

    /**
     *
     * @param move A Possible move for a piece
     * @param board an instance of GameLogic
     *              This function updates the information on the board according to the move recieved,
     *              in case of 24B35p it would delete a pawn from the Board, and move the bishop from position (2,4) to (3,5)
     */
    public void setNewMove(String move, BoardLogic board){
        if(move.charAt(5)=='C') {
            //trackMakeMove++;
            //if castling
            board.getChessBoard()[7][Character.getNumericValue(move.charAt(0))] = ' ';
            board.getChessBoard()[7][Character.getNumericValue(move.charAt(1))] = ' ';
            board.getChessBoard()[7][Character.getNumericValue(move.charAt(3))] = 'A';
            board.getChessBoard()[7][Character.getNumericValue(move.charAt(4))] = 'R';
            board.kingPositionC = 56 + Character.getNumericValue(move.charAt(3));//updates the king position (56=8*7)


            this.posOnBoard = board.calculatePos(7, Character.getNumericValue(move.charAt(3)));
            board.findRook(board.calculatePos(7, Character.getNumericValue(move.charAt(1)))).setPosOnBoard(board.calculatePos(7, Character.getNumericValue(move.charAt(4))));
            System.out.println("Pos on Board: ");
            System.out.print(this.posOnBoard);


        }
        else {
            board.getChessBoard()[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))] = ' ';
            board.getChessBoard()[Character.getNumericValue(move.charAt(3))][Character.getNumericValue(move.charAt(4))] = this.symbol;

            if (move.charAt(5) != ' ') {
                switch (move.charAt(5)) {
                    case 'p':
                        board.delPawn(board.calculatePos(Character.getNumericValue(move.charAt(3)), Character.getNumericValue(move.charAt(4))));
                    case 'q':
                        board.delQueen(board.calculatePos(Character.getNumericValue(move.charAt(3)), Character.getNumericValue(move.charAt(4))));
                    case 'r':
                        board.delRook(board.calculatePos(Character.getNumericValue(move.charAt(3)), Character.getNumericValue(move.charAt(4))));
                    case 'k':
                        board.delknight(board.calculatePos(Character.getNumericValue(move.charAt(3)), Character.getNumericValue(move.charAt(4))));
                    case 'b':
                        board.delBishop(board.calculatePos(Character.getNumericValue(move.charAt(3)), Character.getNumericValue(move.charAt(4))));
                }
            }
            this.posOnBoard = board.calculatePos(Character.getNumericValue(move.charAt(3)), Character.getNumericValue(move.charAt(4)));
            System.out.println("Pos on Board: ");
            System.out.print(this.posOnBoard);

            int pos = 0;

            if ('A' == board.getChessBoard()[Character.getNumericValue(move.charAt(3))][Character.getNumericValue(move.charAt(4))]) {
                board.kingPositionC = 8 * Character.getNumericValue(move.charAt(3)) + Character.getNumericValue(move.charAt(4));

            }
        }
    }
}
