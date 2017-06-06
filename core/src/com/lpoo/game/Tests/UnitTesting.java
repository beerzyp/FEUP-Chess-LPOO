package com.lpoo.game.Tests;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.lpoo.game.Logic.Bishops;
import com.lpoo.game.Logic.BoardLogic;
import com.lpoo.game.Logic.King;
import com.lpoo.game.Logic.Knights;
import com.lpoo.game.Logic.Pawns;
import com.lpoo.game.Logic.Queen;
import com.lpoo.game.Logic.Rooks;

import static org.junit.Assert.assertEquals;

/**
 * Created by beerzy on 05-06-2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class UnitTesting {



    @Test
    public void testMovePawn(){
       char[][] chessBoard= new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'p'},
                {' ', ' ',' ', ' ', ' ', ' ', ' ', 'r'}
        };

        BoardLogic board=new BoardLogic(chessBoard);

        Rooks r2 = new Rooks('r', 64, false);
        Pawns p1 = new Pawns('p', 55, false);
        //Pawns p2 = new Pawns('p',54, false);
        board.addRookPieces(r2);
        board.addPawnPieces(p1);
        //board.printBoardChess();
       // System.out.println(board.findPawn(55).possibleMove(board));
        assertEquals(p1.getPosOnBoard(),board.getPawnPieces().get(0).getPosOnBoard());
        board.findPawn(55).setNewMove("67P57 ", board);
       // board.setChessBoard(6, 7, 5, 7,'p');
        //board.printBoardChess();
        assertEquals(p1.getSymbol(),board.getChessBoard()[5][7]);

    }


    @Test
    public void testMoveRook(){
        char[][] chessBoard= new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'P'},
                {' ', ' ',' ', ' ', ' ', ' ', ' ', 'r'}
        };

        BoardLogic board=new BoardLogic(chessBoard);
        int pos=board.calculatePos(6,7);

        Rooks r2 = new Rooks('r', 63, false);
        Pawns p1 = new Pawns('p', pos, false);
        //Pawns p2 = new Pawns('p',54, false);
        board.addRookPieces(r2);
        board.addPawnPieces(p1);
        //board.printBoardChess();
        assertEquals(r2.getPosOnBoard(),board.getRookPieces().get(0).getPosOnBoard());
        //if(board.retrievePossibleMovesList(board.findJogada(63)).length!=0)
        System.out.println(board.findJogada(63));
        //board.findQueen(63).setNewMove(board.retrievePossibleMovesList(board.findJogada(63))[0], board);
        board.findRook(63).setNewMove(board.retrievePossibleMovesList(board.findJogada(63))[6], board);
        assertEquals(r2.getSymbol(),board.getChessBoard()[7][0]);
     // System.out.println( board.retrievePossibleMovesList(board.findJogada(63)).length);

    }

    @Test
    public void testMoveQueenHorizontaly(){
        char[][] chessBoard= new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'p'},
                {' ', ' ',' ', ' ', ' ', ' ', ' ', 'q'}
        };

        BoardLogic board=new BoardLogic(chessBoard);
        int pos=board.calculatePos(6,7);

        Queen r2 = new Queen('q', 63, false);
        Pawns p1 = new Pawns('p', pos, false);
        //Pawns p2 = new Pawns('p',54, false);
        board.addQueenPieces(r2);
        board.addPawnPieces(p1);
        //board.printBoardChess();
        assertEquals(r2.getPosOnBoard(),board.getQueenPieces().get(0).getPosOnBoard());
        board.findQueen(63).setNewMove(board.retrievePossibleMovesList(board.findJogada(63))[14], board);
        assertEquals(r2.getSymbol(),board.getChessBoard()[7][0]);

        // System.out.println( board.retrievePossibleMovesList(board.findJogada(63)).length);

    }

    @Test
    public void testMoveQueenDiag(){
        char[][] chessBoard= new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'p'},
                {' ', ' ',' ', ' ', ' ', ' ', ' ', 'q'}
        };

        BoardLogic board=new BoardLogic(chessBoard);
        int pos=board.calculatePos(6,7);

        Queen r2 = new Queen('q', 63, false);
        Pawns p1 = new Pawns('p', pos, false);
        //Pawns p2 = new Pawns('p',54, false);
        board.addQueenPieces(r2);
        board.addPawnPieces(p1);
        //board.printBoardChess();
        assertEquals(r2.getPosOnBoard(),board.getQueenPieces().get(0).getPosOnBoard());
        //if(board.retrievePossibleMovesList(board.findJogada(63)).length!=0)
        //System.out.println(board.findJogada(63));
        board.findQueen(63).setNewMove(board.retrievePossibleMovesList(board.findJogada(63))[0], board);
        assertEquals(r2.getSymbol(),board.getChessBoard()[6][6]);

        // System.out.println( board.retrievePossibleMovesList(board.findJogada(63)).length);

    }

    @Test
    public void testMoveBishop(){
        char[][] chessBoard= new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'p'},
                {' ', ' ',' ', ' ', ' ', ' ', ' ', 'k'}
        };

        BoardLogic board=new BoardLogic(chessBoard);
        int pos=board.calculatePos(6,7);

        Bishops r2 = new Bishops('b', 63, false);
        Pawns p1 = new Pawns('p', pos, false);
        //Pawns p2 = new Pawns('p',54, false);
        board.addBishopPieces(r2);
        board.addPawnPieces(p1);
        //board.printBoardChess();
        assertEquals(r2.getPosOnBoard(),board.getBishopPieces().get(0).getPosOnBoard());
        //if(board.retrievePossibleMovesList(board.findJogada(63)).length!=0)
        // System.out.println(board.findJogada(63));
        board.findBishop(63).setNewMove(board.retrievePossibleMovesList(board.findJogada(63))[0], board);
        assertEquals(r2.getSymbol(),board.getChessBoard()[6][6]);

        // board.printBoardChess();
        // System.out.println( board.retrievePossibleMovesList(board.findJogada(63)).length);

    }



    @Test
    public void testMoveKnight(){
        char[][] chessBoard= new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'p'},
                {' ', ' ',' ', ' ', ' ', ' ', ' ', 'k'}
        };

        BoardLogic board=new BoardLogic(chessBoard);
        int pos=board.calculatePos(6,7);

        Knights r2 = new Knights('k', 63, false);
        Pawns p1 = new Pawns('p', pos, false);
        //Pawns p2 = new Pawns('p',54, false);
        board.addKnightPieces(r2);
        board.addPawnPieces(p1);
        //board.printBoardChess();
        assertEquals(r2.getPosOnBoard(),board.getKnightPieces().get(0).getPosOnBoard());
        //if(board.retrievePossibleMovesList(board.findJogada(63)).length!=0)
       System.out.println(board.findJogada(63));
        board.findKnight(63).setNewMove(board.retrievePossibleMovesList(board.findJogada(63))[0], board);
        assertEquals(r2.getSymbol(),board.getChessBoard()[6][5]);

        // board.printBoardChess();
        // System.out.println( board.retrievePossibleMovesList(board.findJogada(63)).length);

    }



    @Test
    public void testMoveRookBlockedByPiece(){
        char[][] chessBoard= new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'P'},
                {' ', ' ',' ', ' ', ' ', ' ', ' ', 'r'}
        };

        BoardLogic board=new BoardLogic(chessBoard);
        int pos=board.calculatePos(6,7);

        Rooks r2 = new Rooks('R', 63, false);
        Pawns p1 = new Pawns('p', pos, false);
        //Pawns p2 = new Pawns('p',54, false);
        board.addRookPieces(r2);
        board.addPawnPieces(p1);
        //board.printBoardChess();
        assertEquals(r2.getPosOnBoard(),board.getRookPieces().get(0).getPosOnBoard());
        //if(board.retrievePossibleMovesList(board.findJogada(63)).length!=0)
        //System.out.println(board.findJogada(63));
        //board.findQueen(63).setNewMove(board.retrievePossibleMovesList(board.findJogada(63))[0], board);
        for(int i=0;i<board.retrievePossibleMovesList(board.findJogada(63)).length;i++)
        {
            if(board.retrievePossibleMovesList(board.findJogada(63))[i]=="77R07 ")
            board.findRook(63).setNewMove(board.retrievePossibleMovesList(board.findJogada(63))[i], board);
        }
       // board.findRook(63).setNewMove("77R57 ", board);
       // board.printBoardChess();
        assertEquals(r2.getSymbol(),board.getChessBoard()[7][7]);
        // System.out.println( board.retrievePossibleMovesList(board.findJogada(63)).length);

    }

    @Test
    public void testThreatenCheck(){
        char[][] chessBoard= new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', 'r', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ',' ', ' ', 'A', ' ', ' ', ' '}
        };

        BoardLogic board=new BoardLogic(chessBoard);
        int pos=board.calculatePos(2,2);

        Rooks r2 = new Rooks('r',pos, false);
        //Pawns p1 = new Pawns('p', pos, false);
        King k1 = new King('A',60,true);
       // Pawns p2 = new Pawns('p',54, false);
        board.addRookPieces(r2);
      // board.addPawnPieces(p1);
        board.addKingPieces(k1);

        System.out.println(board.findJogada(pos));
        //board.findQueen(63).setNewMove(board.retrievePossibleMovesList(board.findJogada(63))[0], board);
        System.out.println(board.findJogada(63));
        assertEquals(board.kingSafe(),true);
        board.printBoardChess();
       board.findRook(pos).setNewMove("22r72 ", board);
        // board.printBoardChess();
        //board.findRook(63).setNewMove("77R70 ", board);
        //assertEquals(r2.getSymbol(),board.getChessBoard()[7][0]);
       System.out.println("\n\n\n");

            //System.out.println(board.findJogada(56));
        board.printBoardChess();
        assertEquals(board.kingSafe(),false);
        // System.out.println( board.retrievePossibleMovesList(board.findJogada(63)).length);

    }


    @Test
    public void testCastleKingSide(){
        char[][] chessBoard= new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'R', ' ',' ', ' ', 'A', ' ', ' ', 'R'}
        };

        BoardLogic board=new BoardLogic(chessBoard);
        int pos=board.calculatePos(2,2);

        Rooks r2 = new Rooks('r',pos, false);
        //Pawns p1 = new Pawns('p', pos, false);
        King k1 = new King('A',60,true);
        // Pawns p2 = new Pawns('p',54, false);
        board.addRookPieces(r2);
        // board.addPawnPieces(p1);
        board.addKingPieces(k1);
        board.printBoardChess();

        //board.findQueen(63).setNewMove(board.retrievePossibleMovesList(board.findJogada(63))[0], board);
        //System.out.println(board.retrievePossibleMovesList(board.findJogada(63))[6].length());
        assertEquals(board.kingSafe(),true);
       // board.findKing(60).setNewMove("4765C ",board);
        System.out.println(board.findJogada(60));
        board.makeKingMove(board.retrievePossibleMovesList(board.findJogada(60))[6]);
        board.printBoardChess();

        // System.out.println( board.retrievePossibleMovesList(board.findJogada(63)).length);

    }





    @Test
    public void testCastleQueenSide(){
        char[][] chessBoard= new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'R', ' ',' ', ' ', 'A', ' ', ' ', 'R'}
        };

        BoardLogic board=new BoardLogic(chessBoard);
        int pos=board.calculatePos(2,2);

        Rooks r2 = new Rooks('r',pos, false);
        //Pawns p1 = new Pawns('p', pos, false);
        King k1 = new King('A',60,true);
        // Pawns p2 = new Pawns('p',54, false);
        board.addRookPieces(r2);
        // board.addPawnPieces(p1);
        board.addKingPieces(k1);
        board.printBoardChess();

        //board.findQueen(63).setNewMove(board.retrievePossibleMovesList(board.findJogada(63))[0], board);
        //System.out.println(board.retrievePossibleMovesList(board.findJogada(63))[6].length());
        assertEquals(board.kingSafe(),true);
        // board.findKing(60).setNewMove("4765C ",board);
        System.out.println(board.findJogada(60));
        board.makeKingMove(board.retrievePossibleMovesList(board.findJogada(60))[5]);
        board.printBoardChess();

        // System.out.println( board.retrievePossibleMovesList(board.findJogada(63)).length);

    }



}