package com.lpoo.game.Logic;

/**
 * Created by FranciscoSilva on 17/05/17.
 */


public class Knights extends Piece {
    public static void naoFazNada(){};
    public Knights(char sym, int pos, boolean playerColor) {
        super(sym, pos, playerColor);
    }
    /**
     *
     * @param chessBoard given an instance of the gameLogic
     * @return Returns a String with All the possible moves that this. Knight has in form Line Column K NextLine NextColumn + or not oldPiece
     */
    public String possibleMove(BoardLogic chessBoard){

        String list="";
        char oldPiece;
        int r=this.posOnBoard/8, c=this.posOnBoard%8;
        for (int j=-1; j<=1; j+=2) {
            for (int k=-1; k<=1; k+=2) {
                try {
                    if (Character.isLowerCase(chessBoard.getChessBoard()[r+j][c+k*2]) || ' ' == chessBoard.getChessBoard()[r+j][c+k*2]) {
                        oldPiece=chessBoard.getChessBoard()[r+j][c+k*2];
                        chessBoard.getChessBoard()[r][c]=' ';
                        if (chessBoard.kingSafe()) {
                            list=list+r+c+this.getSymbol()+(r+j)+(c+k*2)+oldPiece+';';
                        }
                        chessBoard.getChessBoard()[r][c]='K';
                        chessBoard.getChessBoard()[r+j][c+k*2]=oldPiece;
                    }
                } catch (Exception e) {naoFazNada();}
                try {
                    if (Character.isLowerCase(chessBoard.getChessBoard()[r+j*2][c+k]) || ' ' == (chessBoard.getChessBoard()[r+j*2][c+k])) {
                        oldPiece=chessBoard.getChessBoard()[r+j*2][c+k];
                        chessBoard.getChessBoard()[r][c]=' ';
                        if (chessBoard.kingSafe()) {
                            list=list+r+c+this.getSymbol()+(r+j*2)+(c+k)+oldPiece+';';
                        }
                        chessBoard.getChessBoard()[r][c]='K';
                        chessBoard.getChessBoard()[r+j*2][c+k]=oldPiece;
                    }
                } catch (Exception e) {naoFazNada();}
            }
        }
        return list;
    }
}
