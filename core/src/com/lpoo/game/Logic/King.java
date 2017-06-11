package com.lpoo.game.Logic;

/**
 * Created by FranciscoSilva on 17/05/17.
 */

public class King extends Piece {
    public King(char sym, int pos, boolean playerColor) {
        super(sym, pos, playerColor);
    }

    /**
     *
     * @param chessBoard given an instance of the gameLogic
     * @return Returns a String with All the possible moves that this. King has in form Line Column A NextLine NextColumn   ( + oldPiece or +'C') when possibility to castle
     * in case of castle it returns as KingOldColumn RookOldColumn K KingNewColumn RookNewColumn C
     *
     */
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

        //castling (returns move as kingColumn,rookColumn,kingNewColumn,rookNewColumn,C
        if ('A'==chessBoard.getChessBoard()[7][4] && BoardLogic.castleWhiteLong && 'R'==chessBoard.getChessBoard()[7][0] && ' '==chessBoard.getChessBoard()[7][1] && ' '==(chessBoard.getChessBoard()[7][2]) && ' '==chessBoard.getChessBoard()[7][3]) {
            boolean temp=false;
            for (int j=1;j<=2;j++) {
                chessBoard.makeKingMove("747"+j+" ");
                temp=(temp || !chessBoard.kingSafe());
                chessBoard.undoKingMove("747"+j+" ");
            }
            if (!temp) {
                //all criteria have been met:
                //System.out.println("White Castle Long");
                list+="40A23C ;";
            }
        }
        if ('A'==(chessBoard.getChessBoard()[7][4]) && BoardLogic.castleWhiteShort && 'R'==(chessBoard.getChessBoard()[7][7]) && ' '==(chessBoard.getChessBoard()[7][5]) && ' '==(chessBoard.getChessBoard()[7][6])) {
            boolean temp=false;
            for (int j=5;j<=6;j++) {
                chessBoard.makeKingMove("747"+j+" ");
                temp=(temp || !chessBoard.kingSafe());
                chessBoard.undoKingMove("747"+j+" ");
            }
            if (!temp) {
                //all criteria have been met:
                //System.out.println("White Castle Short");
                list+="47A65C ;";
            }
        }
        if ('A'==(chessBoard.getChessBoard()[7][3]) && BoardLogic.castleBlackLong && 'R'==(chessBoard.getChessBoard()[7][7]) && ' '==(chessBoard.getChessBoard()[7][4]) && ' '==(chessBoard.getChessBoard()[7][5]) && ' '==(chessBoard.getChessBoard()[7][6])) {
            boolean temp=false;
            for (int j=4;j<=5;j++) {
                chessBoard.makeKingMove("747"+j+" ");
                temp=(temp || !chessBoard.kingSafe());
                chessBoard.undoKingMove("747"+j+" ");
            }
            if (!temp) {
                //all criteria have been met:
                //System.out.println("Black Castle Long");
                list+="37A54C ;";
            }
        }
        if ('A'==(chessBoard.getChessBoard()[7][3]) && BoardLogic.castleBlackShort && 'R'==(chessBoard.getChessBoard()[7][0]) && ' '==(chessBoard.getChessBoard()[7][1]) && ' '==(chessBoard.getChessBoard()[7][2])) {
            boolean temp=false;
            for (int j=1;j<=2;j++) {
                chessBoard.makeKingMove("747"+j+" ");
                temp=(temp || !chessBoard.kingSafe());
                chessBoard.undoKingMove("747"+j+" ");
            }
            if (!temp) {
                //all criteria have been met:
                //System.out.println("Black Castle Short");
                list+="30A12C ;";
            }
        //need to add casting later
        }
        return list;
    }
}
