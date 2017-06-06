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

    public int calculatePos(int x, int y){
        int temp[][] = new int[8][8];

        if(x == 7 && y == 7)
            temp[x][y] = 0;
        else
            temp[x][y] = 1;

        int pos=0;

        for(int i = 0; i < temp.length; i++){
            for(int j = 0; j < temp[i].length; j++) {
                pos++;
                if (temp[i][j] == 1) {
                    return pos-1;
                }
            }
        }

        return pos - 1;
    }//castling (returns move as 0kingColumn,1rookColumn,2kingNewColumn,3rookNewColumn,4C

    public void setNewMove(String move, BoardLogic board){
        if(move.charAt(5)=='C') {
            //trackMakeMove++;
            //if castling
            board.getChessBoard()[7][Character.getNumericValue(move.charAt(0))] = ' ';
            board.getChessBoard()[7][Character.getNumericValue(move.charAt(1))] = ' ';
            board.getChessBoard()[7][Character.getNumericValue(move.charAt(3))] = 'A';
            board.getChessBoard()[7][Character.getNumericValue(move.charAt(4))] = 'R';
            board.kingPositionC = 56 + Character.getNumericValue(move.charAt(3));//updates the king position (56=8*7)


            this.posOnBoard = calculatePos(7, Character.getNumericValue(move.charAt(3)));
            board.findRook(calculatePos(7, Character.getNumericValue(move.charAt(1)))).setPosOnBoard(calculatePos(7, Character.getNumericValue(move.charAt(4))));
            System.out.println("Pos on Board: ");
            System.out.print(this.posOnBoard);


        }
        else {
            board.getChessBoard()[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))] = ' ';
            board.getChessBoard()[Character.getNumericValue(move.charAt(3))][Character.getNumericValue(move.charAt(4))] = this.symbol;

            if (move.charAt(5) != ' ') {
                switch (move.charAt(5)) {
                    case 'p':
                        board.delPawn(calculatePos(Character.getNumericValue(move.charAt(3)), Character.getNumericValue(move.charAt(4))));
                    case 'q':
                        board.delQueen(calculatePos(Character.getNumericValue(move.charAt(3)), Character.getNumericValue(move.charAt(4))));
                    case 'r':
                        board.delRook(calculatePos(Character.getNumericValue(move.charAt(3)), Character.getNumericValue(move.charAt(4))));
                    case 'k':
                        board.delknight(calculatePos(Character.getNumericValue(move.charAt(3)), Character.getNumericValue(move.charAt(4))));
                    case 'b':
                        board.delBishop(calculatePos(Character.getNumericValue(move.charAt(3)), Character.getNumericValue(move.charAt(4))));
                }
            }
            this.posOnBoard = calculatePos(Character.getNumericValue(move.charAt(3)), Character.getNumericValue(move.charAt(4)));
            System.out.println("Pos on Board: ");
            System.out.print(this.posOnBoard);

            int pos = 0;

            if ('A' == board.getChessBoard()[Character.getNumericValue(move.charAt(3))][Character.getNumericValue(move.charAt(4))]) {
                board.kingPositionC = 8 * Character.getNumericValue(move.charAt(3)) + Character.getNumericValue(move.charAt(4));

            }
        }
    }
}
