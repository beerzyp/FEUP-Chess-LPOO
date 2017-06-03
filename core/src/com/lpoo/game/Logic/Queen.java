package com.lpoo.game.Logic;

/**
 * Created by FranciscoSilva on 17/05/17.
 */

public class Queen extends Piece {
    public Queen(char sym, int pos, boolean playerColor) {
        super(sym, pos, playerColor);
    }

    public String possibleMove(BoardLogic chessBoard){
        String list="";
        char oldPiece;
        int r=this.posOnBoard/8, c=this.posOnBoard%8;
        int temp=1;
        for (int j=-1; j<=1; j++) {
            for (int k=-1; k<=1; k++) {
                if (j!=0 || k!=0) {
                    try {
                        while(' ' == chessBoard.getChessBoard()[r+temp*j][c+temp*k])
                        {
                            oldPiece=chessBoard.getChessBoard()[r+temp*j][c+temp*k];
                            chessBoard.getChessBoard()[r][c]=' ';
                            chessBoard.getChessBoard()[r+temp*j][c+temp*k]='Q';
                            if (chessBoard.kingSafe()) {
                                list=list+r+c+this.getSymbol()+(r+temp*j)+(c+temp*k)+oldPiece+';';
                                chessBoard.printBoardChess();

                            }
                            chessBoard.getChessBoard()[r][c]='Q';
                            chessBoard.getChessBoard()[r+temp*j][c+temp*k]=oldPiece;
                            temp++;
                        }
                        if (Character.isLowerCase(chessBoard.getChessBoard()[r+temp*j][c+temp*k])) {
                            oldPiece=chessBoard.getChessBoard()[r+temp*j][c+temp*k];
                            chessBoard.getChessBoard()[r][c]=' ';
                            chessBoard.getChessBoard()[r+temp*j][c+temp*k]='Q';
                            if (chessBoard.kingSafe()) {
                                list=list+r+c+this.getSymbol()+(r+temp*j)+(c+temp*k)+oldPiece+';';
                                chessBoard.printBoardChess();

                            }
                            chessBoard.getChessBoard()[r][c]='Q';
                            chessBoard.getChessBoard()[r+temp*j][c+temp*k]=oldPiece;
                        }
                    } catch (Exception e) {}
                    temp=1;
                }
            }
        }
        this.actualPossibleMoves = list;
        return list;
    }
}
