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
        for (int j=0; j<9; j++) {
            if (j!=4) {
                try {
                    if (Character.isLowerCase(chessBoard.getChessBoard()[r-1+j/3][c-1+j%3]) || ' ' == chessBoard.getChessBoard()[r-1+j/3][c-1+j%3]) {
                        oldPiece=chessBoard.getChessBoard()[r-1+j/3][c-1+j%3];
                        chessBoard.getChessBoard()[r][c]=' ';
                        chessBoard.getChessBoard()[r-1+j/3][c-1+j%3]='A';
                        int kingTemp=chessBoard.kingPositionC;
                        chessBoard.kingPositionC=this.posOnBoard+(j/3)*8+j%3-9;
                        if (chessBoard.kingSafe()) {
                            list=list+r+c+this.getSymbol()+(r-1+j/3)+(c-1+j%3)+oldPiece+';';
                        }
                        chessBoard.getChessBoard()[r][c]='A';
                        chessBoard.getChessBoard()[r-1+j/3][c-1+j%3]=oldPiece;
                        chessBoard.kingPositionC=kingTemp;
                    }
                } catch (Exception e) {}
            }
        }
        //need to add casting later
        return list;
    }
}
