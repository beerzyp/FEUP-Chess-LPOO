package com.lpoo.game.Logic;

import java.util.ArrayList;

import static java.lang.Character.isUpperCase;

/**
 * Created by FranciscoSilva on 17/05/17.
 */

public class Pawns extends Piece {
    private ArrayList<String> possibleMoves = new ArrayList<String>(); //especificado no formato: Linha x Coluna x Linha-PeçaQueCome x Coluna-PeçaQueCome (caso nao coma LinhaxColunaxfxf)

    public Pawns(char sym, int pos, boolean playerColor) {
        super(sym, pos, playerColor);
    }
    /**
     *
     * @param chessBoard given an instance of the gameLogic
     * @return Returns a String with All the possible moves that this. Pawn has in form Line Column P NextLine NextColumn + or not oldPiece
     *
     */
    public String possibleMove(BoardLogic chessBoard){
        String list = ""; char oldPiece;
        int r=this.posOnBoard/8, c=this.posOnBoard%8;

        for (int j=-1; j<=1; j+=2) {
            try {//capture
                if (Character.isLowerCase(chessBoard.getChessBoard()[r-1][c+j]) && this.posOnBoard>=16) {
                    oldPiece=chessBoard.getChessBoard()[r-1][c+j];
                    chessBoard.getChessBoard()[r][c]=' ';
                    chessBoard.getChessBoard()[r-1][c+j]='P';
                    if (chessBoard.kingSafe()) {
                        list=list+r+c+this.getSymbol()+(r-1)+(c+j)+oldPiece+';';
                    }
                    chessBoard.getChessBoard()[r][c]='P';
                    chessBoard.getChessBoard()[r-1][c+j]=oldPiece;
                }
            } catch (Exception e) {}
            try {//promotion && capture
                if (Character.isLowerCase(chessBoard.getChessBoard()[r-1][c+j]) && this.posOnBoard<16) { // duvida
                    char[] temp={'Q','R','B','K'};
                    for (int k=0; k<4; k++) {
                        oldPiece=chessBoard.getChessBoard()[r-1][c+j];
                        chessBoard.getChessBoard()[r][c]=' ';
                        chessBoard.getChessBoard()[r-1][c+j]=temp[k];
                        if (chessBoard.kingSafe()) {
                            //column1,column2,captured-piece,new-piece,P
                            list=list+c+(c+j)+this.getSymbol()+oldPiece+temp[k]+'P'+' '+';';
                        }
                        chessBoard.getChessBoard()[r][c]='P';
                        chessBoard.getChessBoard()[r-1][c+j]=oldPiece;
                    }
                }
            } catch (Exception e) {}
        }
        try {//move one up
            if (' ' == chessBoard.getChessBoard()[r-1][c] && this.posOnBoard>=16) {
                oldPiece=chessBoard.getChessBoard()[r-1][c];
                chessBoard.getChessBoard()[r][c]=' ';
                chessBoard.getChessBoard()[r-1][c]='P';
                if (chessBoard.kingSafe()) {
                    list=list+r+c+this.getSymbol()+(r-1)+c+oldPiece+';';
                }
                chessBoard.getChessBoard()[r][c]='P';
                chessBoard.getChessBoard()[r-1][c]=oldPiece;
            }
        } catch (Exception e) {}
        try {//promotion && no capture
            if (' ' == chessBoard.getChessBoard()[r-1][c] && this.posOnBoard<16) {
                char[] temp={'Q','R','B','K'};
                for (int k=0; k<4; k++) {
                    oldPiece=chessBoard.getChessBoard()[r-1][c];
                    chessBoard.getChessBoard()[r][c]=' ';
                    chessBoard.getChessBoard()[r-1][c]=temp[k];
                    if (chessBoard.kingSafe()) {
                        //column1,column2,this-piece,captured-piece,new-piece,P
                        list=list+c+c+this.getSymbol()+oldPiece+temp[k]+'P'+' '+';';
                    }
                    chessBoard.getChessBoard()[r][c]='P';
                    chessBoard.getChessBoard()[r-1][c]=oldPiece;
                }
            }
        } catch (Exception e) {}
        try {//move two up
            if (' ' == chessBoard.getChessBoard()[r-1][c] && ' ' == chessBoard.getChessBoard()[r-2][c] && this.posOnBoard>=48) {
                oldPiece=chessBoard.getChessBoard()[r-2][c];
                chessBoard.getChessBoard()[r][c]=' ';
                chessBoard.getChessBoard()[r-2][c]='P';
                if (chessBoard.kingSafe()) {
                    list=list+r+c+this.getSymbol()+(r-2)+c+oldPiece+';';
                }
                chessBoard.getChessBoard()[r][c]='P';
                chessBoard.getChessBoard()[r-2][c]=oldPiece;
            }
        } catch (Exception e) {}

        this.actualPossibleMoves = list;
        return list;
    }
}
