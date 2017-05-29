package com.lpoo.game.Logic;

/**
 * Created by FranciscoSilva on 17/05/17.
 */

public class King extends Piece {
    public King(char sym, int pos, boolean playerColor) {
        super(sym, pos, playerColor);
    }

    public String possibleMove(BoardLogic chessBoard){
        String list="";
        char oldPiece;
        int r=this.posOnBoard/8, c=this.posOnBoard%8;
        for (int j=-1; j<=1; j+=2) {
            for (int k=-1; k<=1; k+=2) {
                try {
                    if (' ' == chessBoard.getChessBoard()[r+j][c+k*2] || ' ' == chessBoard.getChessBoard()[r+j][c+k*2]) {
                        oldPiece=chessBoard.getChessBoard()[r+j][c+k*2];
                        chessBoard.getChessBoard()[r][c]=' ';
                        if (chessBoard.kingSafe()) {
                            list=list+r+c+this.getSymbol()+(r+j)+(c+k*2)+oldPiece+';';
                        }
                        chessBoard.getChessBoard()[r][c]='K';
                        chessBoard.getChessBoard()[r+j][c+k*2]=oldPiece;
                    }
                } catch (Exception e) {}
                try {
                    if (Character.isLowerCase(chessBoard.getChessBoard()[r+j*2][c+k]) || ' ' == chessBoard.getChessBoard()[r+j*2][c+k]) {
                        oldPiece=chessBoard.getChessBoard()[r+j*2][c+k];
                        chessBoard.getChessBoard()[r][c]=' ';
                        if (chessBoard.kingSafe()) {
                            list=list+r+c+this.getSymbol()+(r+j*2)+(c+k)+oldPiece+';';
                        }
                        chessBoard.getChessBoard()[r][c]='K';
                        chessBoard.getChessBoard()[r+j*2][c+k]=oldPiece;
                    }
                } catch (Exception e) {}
            }
        }

        this.actualPossibleMoves = list;
        return list;
    }
}
