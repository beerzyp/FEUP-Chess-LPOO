package com.lpoo.game.Logic;

/**
 * Created by FranciscoSilva on 17/05/17.
 */

public class Bishops extends Piece {
    public Bishops(char sym, int pos, boolean playerColor) {
        super(sym, pos, playerColor);
    }
    public static void naoFazNada(){};
    /**
     *
     * @param chessBoard given an instance of the gameLogic
     * @return Returns a String with All the possible moves that this. Bishop has in form Line Column B NextLine NextColumn + or not oldPiece
     */
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
                } catch (Exception e) {naoFazNada();}
                temp=1;
            }
        }

        this.actualPossibleMoves = list;
        return list;
    }
}
