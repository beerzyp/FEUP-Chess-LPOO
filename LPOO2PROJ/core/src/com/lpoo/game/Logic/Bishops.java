package com.lpoo.game.Logic;

/**
 * Created by FranciscoSilva on 17/05/17.
 */

public class Bishops extends Piece {
    public Bishops(char sym, int pos) {
        super(sym, pos);
    }

    public String possibleMove(BoardLogic chessBoard){
        String list="";
        char oldPiece;
        int r=this.posOnBoard/8, c=this.posOnBoard%8;
        int temp=1;
        for (int j=-1; j<=1; j+=2) {
            for (int k=-1; k<=1; k+=2) {
                try {
                    while(' ' == chessBoard.getChessBoard()[r+temp*j][c+temp*k])
                    {
                        oldPiece=chessBoard.getChessBoard()[r+temp*j][c+temp*k];
                        chessBoard.getChessBoard()[r][c]=' ';
                        chessBoard.getChessBoard()[r+temp*j][c+temp*k]='B';
                        if (chessBoard.kingSafe()) {
                            list=list+r+c+this.getSymbol()+(r+temp*j)+(c+temp*k)+oldPiece+';';
                        }
                        chessBoard.getChessBoard()[r][c]='B';
                        chessBoard.getChessBoard()[r+temp*j][c+temp*k]=oldPiece;
                        temp++;
                    }
                    if (Character.isLowerCase(chessBoard.getChessBoard()[r+temp*j][c+temp*k])) {
                        oldPiece=chessBoard.getChessBoard()[r+temp*j][c+temp*k];
                        chessBoard.getChessBoard()[r][c]=' ';
                        chessBoard.getChessBoard()[r+temp*j][c+temp*k]='B';
                        if (chessBoard.kingSafe()) {
                            list=list+r+c+this.getSymbol()+(r+temp*j)+(c+temp*k)+oldPiece+';';
                        }
                        chessBoard.getChessBoard()[r][c]='B';
                        chessBoard.getChessBoard()[r+temp*j][c+temp*k]=oldPiece;
                    }
                } catch (Exception e) {}
                temp=1;
            }
        }

        this.actualPossibleMoves = list;
        return list;
    }
}
