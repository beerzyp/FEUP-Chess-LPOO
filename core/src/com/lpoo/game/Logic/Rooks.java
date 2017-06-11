package com.lpoo.game.Logic;

/**
 * Created by FranciscoSilva on 17/05/17.
 */

public class Rooks extends Piece {
    public Rooks(char sym, int pos, boolean playerColor) {
        super(sym, pos, playerColor);
    }
    /**
     *
     * @param chessBoard given an instance of the gameLogic
     * @return Returns a String with All the possible moves that this. Rook has in form Line Column R NextLine NextColumn  + oldPiece
     */
    public String possibleMove(BoardLogic chessBoard){
        String list="";
        char oldPiece;
        int r=this.posOnBoard/8, c=this.posOnBoard%8;
        int temp=1;
        for (int j=-1; j<=1; j+=2) {
            try {
                while(' ' == chessBoard.getChessBoard()[r][c+temp*j])
                {
                    oldPiece=chessBoard.getChessBoard()[r][c+temp*j];
                    chessBoard.getChessBoard()[r][c]=' ';
                    chessBoard.getChessBoard()[r][c+temp*j]='R';
                    if (chessBoard.kingSafe()) {
                        list=list+r+c+this.getSymbol()+r+(c+temp*j)+oldPiece+';';
                    }
                    chessBoard.getChessBoard()[r][c]='R';
                    chessBoard.getChessBoard()[r][c+temp*j]=oldPiece;
                    temp++;
                }
                if (Character.isLowerCase(chessBoard.getChessBoard()[r][c+temp*j])) {
                    oldPiece=chessBoard.getChessBoard()[r][c+temp*j];
                    chessBoard.getChessBoard()[r][c]=' ';
                    chessBoard.getChessBoard()[r][c+temp*j]='R';
                    if (chessBoard.kingSafe()) {
                        list=list+r+c+this.getSymbol()+r+(c+temp*j)+oldPiece+';';
                    }
                    chessBoard.getChessBoard()[r][c]='R';
                    chessBoard.getChessBoard()[r][c+temp*j]=oldPiece;
                }
            } catch (Exception e) {}
            temp=1;
            try {
                while(' ' == chessBoard.getChessBoard()[r+temp*j][c])
                {
                    oldPiece=chessBoard.getChessBoard()[r+temp*j][c];
                    chessBoard.getChessBoard()[r][c]=' ';
                    chessBoard.getChessBoard()[r+temp*j][c]='R';
                    if (chessBoard.kingSafe()) {
                        list=list+r+c+this.getSymbol()+(r+temp*j)+c+oldPiece+';';
                    }
                    chessBoard.getChessBoard()[r][c]='R';
                    chessBoard.getChessBoard()[r+temp*j][c]=oldPiece;
                    temp++;
                }
                if (Character.isLowerCase(chessBoard.getChessBoard()[r+temp*j][c])) {
                    oldPiece=chessBoard.getChessBoard()[r+temp*j][c];
                    chessBoard.getChessBoard()[r][c]=' ';
                    chessBoard.getChessBoard()[r+temp*j][c]='R';
                    if (chessBoard.kingSafe()) {
                        list=list+r+c+this.getSymbol()+(r+temp*j)+c+oldPiece+';';
                    }
                    chessBoard.getChessBoard()[r][c]='R';
                    chessBoard.getChessBoard()[r+temp*j][c]=oldPiece;
                }
            } catch (Exception e) {}
            temp=1;
        }

        this.actualPossibleMoves = list;
        return list;
    }
}
