package com.lpoo.game.Logic;

import java.util.ArrayList;

/**
 * Created by FranciscoSilva on 17/05/17.
 */

public class BoardLogic {
    public boolean kingSsNotSafe;
    public boolean gameOver;

    public BoardLogic(){
        this.gameOver = false;
        while ('A' != chessBoard[kingPositionC/8][kingPositionC%8]) {kingPositionC++;}//get King's location
        while ('a' != chessBoard[kingPositionL/8][kingPositionL%8]) {kingPositionL++;}//get king's location
    }

    private char chessBoard[][]={
        {'r','k','b','q','a','b','k','r'},
        {'p','p','p','p','p','p','p','p'},
        {' ',' ',' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' ',' ',' '},
        {'P','P','P','P','P','P','P','P'},
        {'R','K','B','Q','A','B','K','R'}
    };

    private ArrayList<King> kingPieces = new ArrayList<King>();
    private ArrayList<Queen> queenPieces = new ArrayList<Queen>();
    private ArrayList<Rooks> rookPieces = new ArrayList<Rooks>();
    private ArrayList<Pawns> pawnPieces = new ArrayList<Pawns>();
    private ArrayList<Bishops> bishopPieces = new ArrayList<Bishops>();
    private ArrayList<Knights> knightPieces = new ArrayList<Knights>();

    public int kingPositionC, kingPositionL;

    public String findJogada(int pos){
        if(findKing(pos) != null){
            return findKing(pos).possibleMove(this);
        }
        else if(findQueen(pos) != null){
            return findQueen(pos).possibleMove(this);
        }
        else if(findPawn(pos) != null){
            return findPawn(pos).possibleMove(this);
        }
        else if(findKnight(pos) != null){
            return findKnight(pos).possibleMove(this);
        }
        else if(findRook(pos) != null){
            return findRook(pos).possibleMove(this);
        }
        else if(findBishop(pos) != null){
            return findBishop(pos).possibleMove(this);
        }

        return null;
    }

    public King findKing(int pos){
        for(int i = 0; i < this.kingPieces.size(); i++){
            if(this.kingPieces.get(i).getPosOnBoard() == pos)
                return this.kingPieces.get(i);
        }

        return null;
    }

    public Queen findQueen(int pos){
        for(int i = 0; i < this.queenPieces.size(); i++){
            if(this.queenPieces.get(i).getPosOnBoard() == pos)
                return this.queenPieces.get(i);
        }

        return null;
    }

    public Knights findKnight(int pos){
        for(int i = 0; i < this.knightPieces.size(); i++){
            if(this.knightPieces.get(i).getPosOnBoard() == pos)
                return this.knightPieces.get(i);
        }

        return null;
    }

    public Rooks findRook(int pos){
        for(int i = 0; i < this.rookPieces.size(); i++){
            if(this.rookPieces.get(i).getPosOnBoard() == pos)
                return this.rookPieces.get(i);
        }

        return null;
    }

    public Bishops findBishop(int pos){
        for(int i = 0; i < this.bishopPieces.size(); i++){
            if(this.bishopPieces.get(i).getPosOnBoard() == pos)
                return this.bishopPieces.get(i);
        }

        return null;
    }

    public Pawns findPawn(int pos){
        for(int i = 0; i < this.pawnPieces.size(); i++){
            if(this.pawnPieces.get(i).getPosOnBoard() == pos)
                return this.pawnPieces.get(i);
        }

        return null;
    }

    public void delPawn(int pos){
        for(int i = 0; i < this.pawnPieces.size(); i++){
            if(this.pawnPieces.get(i).getPosOnBoard() == pos)
                this.pawnPieces.remove(i);
        }
    }

    public void delBishop(int pos){
        for(int i = 0; i < this.bishopPieces.size(); i++){
            if(this.bishopPieces.get(i).getPosOnBoard() == pos)
                this.bishopPieces.remove(i);
        }
    }

    public void delQueen(int pos){
        for(int i = 0; i < this.queenPieces.size(); i++){
            if(this.queenPieces.get(i).getPosOnBoard() == pos)
                this.queenPieces.remove(i);
        }
    }

    public void delknight(int pos){
        for(int i = 0; i < this.knightPieces.size(); i++){
            if(this.knightPieces.get(i).getPosOnBoard() == pos)
                this.knightPieces.remove(i);
        }
    }

    public void delRook(int pos){
        for(int i = 0; i < this.rookPieces.size(); i++){
            if(this.rookPieces.get(i).getPosOnBoard() == pos)
                this.rookPieces.remove(i);
        }
    }

    public ArrayList<King> getKingPieces() {
        return kingPieces;
    }

    public ArrayList<Queen> getQueenPieces() {
        return queenPieces;
    }

    public ArrayList<Rooks> getRookPieces() {
        return rookPieces;
    }

    public ArrayList<Pawns> getPawnPieces() {
        return pawnPieces;
    }

    public ArrayList<Bishops> getBishopPieces() {
        return bishopPieces;
    }

    public ArrayList<Knights> getKnightPieces() {
        return knightPieces;
    }

    public void addKingPieces(King kingPieces) {
        this.kingPieces.add(kingPieces);
    }

    public void addQueenPieces(Queen queenPieces) {
        this.queenPieces.add(queenPieces);
    }

    public void addRookPieces(Rooks rookPieces) {
        this.rookPieces.add(rookPieces);
    }

    public void addPawnPieces(Pawns pawnPieces) {
        this.pawnPieces.add(pawnPieces);
    }

    public void addBishopPieces(Bishops bishopPieces) {
        this.bishopPieces.add(bishopPieces);
    }

    public void addKnightPieces(Knights knightPieces) {
        this.knightPieces.add(knightPieces);
    }

    public void setChessBoard(int xAtual, int yAtual, int xNovo, int yNovo, char sym){
        this.chessBoard[xAtual][yAtual] = ' ';
        this.chessBoard[xNovo][yNovo] = sym;
    }

    public char[][] getChessBoard(){
        return this.chessBoard;
    }

    public void printBoardChess(){
        for (int i = 0; i < chessBoard.length; i++){
            for (int j = 0; j < chessBoard[i].length; j++){
                System.out.print(chessBoard[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    public boolean kingSafe() {
        /*for(int z= 0 ; z < getKingPieces().size(); z++)
            if(getKingPieces().get(z).getSymbol() == 'A')
                getKingPieces().get(z).possibleMove(this);*/
        //bishop/queen
        int temp=1;
        for (int i=-1; i<=1; i+=2) {
            for (int j=-1; j<=1; j+=2) {
                try {
                    while(' ' == chessBoard[kingPositionC/8+temp*i][kingPositionC%8+temp*j]) {temp++;}
                    if ('b' == chessBoard[kingPositionC/8+temp*i][kingPositionC%8+temp*j] ||
                            'q' == chessBoard[kingPositionC/8+temp*i][kingPositionC%8+temp*j]) {
                        return false;
                    }
                } catch (Exception e) {}
                temp=1;
            }
        }
        //rook/queen
        for (int i=-1; i<=1; i+=2) {
            try {
                while(' ' == chessBoard[kingPositionC/8][kingPositionC%8+temp*i]) {temp++;}
                if ('r' == chessBoard[kingPositionC/8][kingPositionC%8+temp*i] ||
                        'q' == chessBoard[kingPositionC/8][kingPositionC%8+temp*i]) {
                    return false;
                }
            } catch (Exception e) {}
            temp=1;
            try {
                while(' ' == chessBoard[kingPositionC/8+temp*i][kingPositionC%8]) {temp++;}
                if ('r' == chessBoard[kingPositionC/8+temp*i][kingPositionC%8] ||
                        'q' == chessBoard[kingPositionC/8+temp*i][kingPositionC%8]) {
                    return false;
                }
            } catch (Exception e) {}
            temp=1;
        }
        //knight
        for (int i=-1; i<=1; i+=2) {
            for (int j=-1; j<=1; j+=2) {
                try {
                    if ('k' == chessBoard[kingPositionC/8+i][kingPositionC%8+j*2]) {
                        return false;
                    }
                } catch (Exception e) {}
                try {
                    if ('k' == chessBoard[kingPositionC/8+i*2][kingPositionC%8+j]) {
                        return false;
                    }
                } catch (Exception e) {}
            }
        }
        //pawn
        if (kingPositionC>=16) {
            try {
                if ('p' == chessBoard[kingPositionC/80-1][kingPositionC%8-1]) {
                    return false;
                }
            } catch (Exception e) {}
            try {
                if ('p' == chessBoard[kingPositionC/80-1][kingPositionC%8+1]) {
                    return false;
                }
            } catch (Exception e) {}
            //king
            for (int i=-1; i<=1; i++) {
                for (int j=-1; j<=1; j++) {
                    if (i!=0 || j!=0) {
                        try {
                            if ('a' == chessBoard[kingPositionC/8+i][kingPositionC%8+j]) {
                                return false;
                            }
                        } catch (Exception e) {}
                    }
                }
            }
        }
        return true;
    }

    public void invertAllPiecesInfo(){
        for(int i=0; i < this.bishopPieces.size(); i++){
            if(Character.isUpperCase(this.bishopPieces.get(i).getSymbol())){
                this.bishopPieces.get(i).setSymbol(Character.toLowerCase(this.bishopPieces.get(i).getSymbol()));
            }
            else{
                this.bishopPieces.get(i).setSymbol(Character.toUpperCase(this.bishopPieces.get(i).getSymbol()));
            }
            this.bishopPieces.get(i).setPosOnBoard(63-this.bishopPieces.get(i).getPosOnBoard());
        }

        for(int i=0; i < this.queenPieces.size(); i++){
            if(Character.isUpperCase(this.queenPieces.get(i).getSymbol())){
                this.queenPieces.get(i).setSymbol(Character.toLowerCase(this.queenPieces.get(i).getSymbol()));
            }
            else{
                this.queenPieces.get(i).setSymbol(Character.toUpperCase(this.queenPieces.get(i).getSymbol()));
            }
            this.queenPieces.get(i).setPosOnBoard(63-this.queenPieces.get(i).getPosOnBoard());
        }

        for(int i=0; i < this.kingPieces.size(); i++){
            if(Character.isUpperCase(this.kingPieces.get(i).getSymbol())){
                this.kingPieces.get(i).setSymbol(Character.toLowerCase(this.kingPieces.get(i).getSymbol()));
            }
            else{
                this.kingPieces.get(i).setSymbol(Character.toUpperCase(this.kingPieces.get(i).getSymbol()));
            }
            this.kingPieces.get(i).setPosOnBoard(63-this.kingPieces.get(i).getPosOnBoard());
        }

        for(int i=0; i < this.pawnPieces.size(); i++){
            if(Character.isUpperCase(this.pawnPieces.get(i).getSymbol())){
                this.pawnPieces.get(i).setSymbol(Character.toLowerCase(this.pawnPieces.get(i).getSymbol()));
            }
            else{
                this.pawnPieces.get(i).setSymbol(Character.toUpperCase(this.pawnPieces.get(i).getSymbol()));
            }
            this.pawnPieces.get(i).setPosOnBoard(63-this.pawnPieces.get(i).getPosOnBoard());
        }

        for(int i=0; i < this.rookPieces.size(); i++){
            if(Character.isUpperCase(this.rookPieces.get(i).getSymbol())){
                this.rookPieces.get(i).setSymbol(Character.toLowerCase(this.rookPieces.get(i).getSymbol()));
            }
            else{
                this.rookPieces.get(i).setSymbol(Character.toUpperCase(this.rookPieces.get(i).getSymbol()));
            }
            this.rookPieces.get(i).setPosOnBoard(63-this.rookPieces.get(i).getPosOnBoard());
        }

        for(int i=0; i < this.knightPieces.size(); i++){
            if(Character.isUpperCase(this.knightPieces.get(i).getSymbol())){
                this.knightPieces.get(i).setSymbol(Character.toLowerCase(this.knightPieces.get(i).getSymbol()));
            }
            else{
                this.knightPieces.get(i).setSymbol(Character.toUpperCase(this.knightPieces.get(i).getSymbol()));
            }
            this.knightPieces.get(i).setPosOnBoard(63-this.knightPieces.get(i).getPosOnBoard());
        }
    }

    public void flipBoard() {
        char temp;

        for (int i=0;i<32;i++) {
            int r=i/8, c=i%8;
            if (Character.isUpperCase(chessBoard[r][c])) {
                temp = Character.toLowerCase(chessBoard[r][c]);
            } else {
                temp=Character.toUpperCase(chessBoard[r][c]);
            }
            if (Character.isUpperCase(chessBoard[7-r][7-c])) {
                chessBoard[r][c]= Character.toLowerCase(chessBoard[7-r][7-c]);
            } else {
                chessBoard[r][c]=Character.toUpperCase(chessBoard[7-r][7-c]);
            }
            chessBoard[7-r][7-c]=temp;
        }

        int kingTemp=kingPositionC;
        kingPositionC=63-kingPositionL;
        kingPositionL=63-kingTemp;

        invertAllPiecesInfo();
    }

    public String[] retrievePossibleMovesList(String str){
        String[] parts = str.split("\\;");
        return parts;
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
    }
    public int getPossibleMoveIndexAtBoard(String a1)
    {   int index=-1;
        if(!a1.isEmpty()) {
        int x = Integer.valueOf(a1.substring(3, 4));
        int y = Integer.valueOf(a1.substring(4, 5));
        index = this.calculatePos(x, y);
    }
        return index;

    }


}
