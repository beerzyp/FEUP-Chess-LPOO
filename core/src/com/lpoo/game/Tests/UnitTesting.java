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
    public void testCaputreWithRook(){
        char[][] chessBoard= new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'p'},
                {' ', ' ',' ', ' ', ' ', ' ', ' ', 'R'}
        };

        BoardLogic board=new BoardLogic(chessBoard);
        int pos=board.calculatePos(6,7);

        Rooks r2 = new Rooks('R', 63, false);
        Pawns p1 = new Pawns('p', pos, true);
        //Pawns p2 = new Pawns('p',54, false);
        board.addRookPieces(r2);
        board.addPawnPieces(p1);
        board.printBoardChess();
        assertEquals(r2.getPosOnBoard(),board.getRookPieces().get(0).getPosOnBoard());
        //if(board.retrievePossibleMovesList(board.findJogada(63)).length!=0)
        //System.out.println(board.retrievePossibleMovesList(board.findJogada(63))[7]);
        //board.findQueen(63).setNewMove(board.retrievePossibleMovesList(board.findJogada(63))[0], board);
        board.findRook(63).setNewMove(board.retrievePossibleMovesList(board.findJogada(63))[7], board);
        assertEquals(r2.getSymbol(),board.getChessBoard()[6][7]);
        assertEquals(0,board.getPawnPieces().size());
        // System.out.println( board.retrievePossibleMovesList(board.findJogada(63)).length);
        board.printBoardChess();
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
    public void testCaptureBishop(){
        char[][] chessBoard= new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', 'p', ' '},
                {' ', ' ',' ', ' ', ' ', ' ', ' ', 'B'}
        };

        BoardLogic board=new BoardLogic(chessBoard);
        int pos=board.calculatePos(6,6);

        Bishops r2 = new Bishops('B', 63, true);
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
        assertEquals(' ',board.getChessBoard()[7][7]);
        assertEquals(board.getPawnPieces().size(),0);

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
                {'R', ' ', ' ', ' ', 'A', ' ', ' ', 'R'}
        };

        BoardLogic board=new BoardLogic(chessBoard);
        int pos=board.calculatePos(7,0);
        int pos2=board.calculatePos(7,7);

        Rooks r2 = new Rooks('R',pos, true);
        Rooks r1 = new Rooks('R',pos2, true);
        //Pawns p1 = new Pawns('p', pos, false);
        King k1 = new King('A',60,true);
        // Pawns p2 = new Pawns('p',54, false);
        board.addRookPieces(r2);
        board.addRookPieces(r1);
        board.addKingPieces(k1);
        board.printBoardChess();
        assertEquals(board.findKing(60).getSymbol(),board.getChessBoard()[7][4]);
        assertEquals(board.findRook(63).getSymbol(),board.getChessBoard()[7][7]);
        assertEquals(board.kingSafe(),true);
        board.findKing(60).setNewMove(board.retrievePossibleMovesList(board.findJogada(60))[5],board);
        // board.findKing(60).setNewMove(board.retrievePossibleMovesList(board.findJogada(60))[6],board);
        assertEquals(board.kingSafe(),true);
        assertEquals(k1.getSymbol(),board.getChessBoard()[7][2]);
        assertEquals(r2.getSymbol(),board.getChessBoard()[7][3]);
        board.printBoardChess();
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
                {'R', ' ', ' ', ' ', 'A', ' ', ' ', 'R'}
        };

        BoardLogic board=new BoardLogic(chessBoard);
        int pos=board.calculatePos(7,0);
        int pos2=board.calculatePos(7,7);

        Rooks r2 = new Rooks('R',pos, true);
        Rooks r1 = new Rooks('R',pos2, true);
        //Pawns p1 = new Pawns('p', pos, false);
        King k1 = new King('A',60,true);
        // Pawns p2 = new Pawns('p',54, false);
        board.addRookPieces(r2);
        board.addRookPieces(r1);
        board.addKingPieces(k1);
        board.printBoardChess();
        assertEquals(board.findKing(60).getSymbol(),board.getChessBoard()[7][4]);
        assertEquals(board.findRook(63).getSymbol(),board.getChessBoard()[7][7]);
        assertEquals(board.kingSafe(),true);
        board.findKing(60).setNewMove(board.retrievePossibleMovesList(board.findJogada(60))[6],board);
       // board.findKing(60).setNewMove(board.retrievePossibleMovesList(board.findJogada(60))[6],board);

        assertEquals(k1.getSymbol(),board.getChessBoard()[7][6]);
        assertEquals(r2.getSymbol(),board.getChessBoard()[7][5]);
        board.printBoardChess();

        // System.out.println( board.retrievePossibleMovesList(board.findJogada(63)).length);

    }


    @Test
    public void testPawnPromotionToQueen(){
        char[][] chessBoard= new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'P'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ',' ', ' ', ' ', ' ', ' ', 'R'}
        };

        BoardLogic board=new BoardLogic(chessBoard);
        int pawnPos=board.calculatePos(1,7);
        assertEquals(pawnPos,15);
        Rooks r2 = new Rooks('R', 64, true);
        Pawns p1 = new Pawns('P', 15, true);
        Queen q1;
        //Pawns p2 = new Pawns('p',54, false);
        board.addRookPieces(r2);
        board.addPawnPieces(p1);
        System.out.println(board.findJogada(15));
        board.printBoardChess();
        assertEquals(board.findJogada(15),p1.possibleMove(board));
        assertEquals(p1.getSymbol(),board.getChessBoard()[1][7]);
        board.delPawn(pawnPos);
        board.setChessBoard(1,7,0,7,'Q');
        board.addQueenPieces(q1=new Queen('Q',7,true));
        assertEquals(' ',board.getChessBoard()[1][7]);
        assertEquals(q1.getSymbol(),board.getChessBoard()[0][7]);
        board.printBoardChess();
        // assertEquals(p1.getSymbol(),board.getChessBoard()[5][7]);

    }


    @Test
    public void testPawnCapturesPiece(){
        char[][] chessBoard= new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', 'q', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', 'P', ' '},
                {' ', ' ',' ', ' ', ' ', ' ', ' ', 'R'}
        };

        BoardLogic board=new BoardLogic(chessBoard);
        int qPos=board.calculatePos(5,5);
        int pPos=board.calculatePos(6,6);
        //assertEquals(pawnPos,15);
        King r2 = new King('A', 64, true);
        Pawns p1 = new Pawns('P', pPos, true);
        Queen q1 = new Queen('q',qPos, false);
        //Pawns p2 = new Pawns('p',54, false);
        board.addKingPieces(r2);
        board.addPawnPieces(p1);
        board.addQueenPieces(q1);
        assertEquals(p1.getSymbol(),board.getChessBoard()[6][6]);
        assertEquals(q1.getSymbol(),board.getChessBoard()[5][5]);

        System.out.println(board.retrievePossibleMovesList(board.findPawn(pPos).possibleMove(board))[0]);
        board.findPawn(pPos).setNewMove(board.retrievePossibleMovesList(board.findJogada(pPos))[0],board);
        // assertEquals(board.findJogada(15),p1.possibleMove(board));
        assertEquals(p1.getSymbol(),board.getChessBoard()[5][5]);

        board.printBoardChess();
        // assertEquals(p1.getSymbol(),board.getChessBoard()[5][7]);

    }

    @Test
    public void invertAllPieces(){
        char chessBoard[][]= new char[][]{
                {'r','k','b','q','a','b','k','r'},
                {'p','p','p','p','p','p','p','p'},
                {' ',' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' ',' '},
                {'P','P','P','P','P','P','P','P'},
                {'R','K','B','Q','A','B','K','R'}
        };

        BoardLogic board=new BoardLogic(chessBoard);
        //player 2 Pieces
        Rooks r1 = new Rooks('r', 0, false);
        Knights k1 = new Knights('k', 1, false);
        Bishops b1  = new Bishops('b', 2, false);
        Queen q = new Queen('q', 3, false);
        King a = new King('a', 4, false);
        Bishops b2  = new Bishops('b', 5, false);
        Knights k2 = new Knights('k', 6, false);
        Rooks r2 = new Rooks('r', 7, false);
        Pawns p1 = new Pawns('p', 8, false);
        Pawns p2 = new Pawns('p', 9, false);
        Pawns p3 = new Pawns('p', 10, false);
        Pawns p4 = new Pawns('p', 11, false);
        Pawns p5 = new Pawns('p', 12, false);
        Pawns p6 = new Pawns('p', 13, false);
        Pawns p7 = new Pawns('p', 14, false);
        Pawns p8 = new Pawns('p', 15, false);

        //player 1 Pieces
        Rooks R1 = new Rooks('R', 56, true);
        Knights K1 = new Knights('K', 57, true);
        Bishops B1  = new Bishops('B', 58, true);
        Queen Q = new Queen('Q', 59, true);
        King A = new King('A', 60, true);
        Bishops B2  = new Bishops('B', 61, true);
        Knights K2 = new Knights('K', 62, true);
        Rooks R2 = new Rooks('R', 63, true);
        Pawns P1 = new Pawns('P', 55, true);
        Pawns P2 = new Pawns('P', 54, true);
        Pawns P3 = new Pawns('P', 53, true);
        Pawns P4 = new Pawns('P', 52, true);
        Pawns P5 = new Pawns('P', 51, true);
        Pawns P6 = new Pawns('P', 50, true);
        Pawns P7 = new Pawns('P', 49, true);
        Pawns P8 = new Pawns('P', 48, true);

        //add pieces to board
        board.addBishopPieces(B1);
        board.addBishopPieces(B2);
        board.addBishopPieces(b1);
        board.addBishopPieces(b2);
        board.addKingPieces(A);
        board.addKingPieces(a);
        board.addKnightPieces(K1);
        board.addKnightPieces(K2);
        board.addKnightPieces(k1);
        board.addKnightPieces(k2);
        board.addRookPieces(R1);
        board.addRookPieces(R2);
        board.addRookPieces(r1);
        board.addRookPieces(r2);
        board.addQueenPieces(Q);
        board.addQueenPieces(q);
        board.addPawnPieces(p1);
        board.addPawnPieces(p2);
        board.addPawnPieces(p3);
        board.addPawnPieces(p4);
        board.addPawnPieces(p5);
        board.addPawnPieces(p6);
        board.addPawnPieces(p7);
        board.addPawnPieces(p8);
        board.addPawnPieces(P1);
        board.addPawnPieces(P2);
        board.addPawnPieces(P3);
        board.addPawnPieces(P4);
        board.addPawnPieces(P5);
        board.addPawnPieces(P6);
        board.addPawnPieces(P7);
        board.addPawnPieces(P8);
        board.invertAllPiecesInfo();


    }


    @Test
    public void KingEatOnCheck(){
        char[][] chessBoard= new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'P'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ',' ', ' ', ' ', ' ', ' ', 'R'}
        };

        BoardLogic board=new BoardLogic(chessBoard);
        int pawnPos=board.calculatePos(1,7);
        assertEquals(pawnPos,15);
        Rooks r2 = new Rooks('R', 64, true);
        Pawns p1 = new Pawns('P', 15, true);
        Queen q1;
        //Pawns p2 = new Pawns('p',54, false);
        board.addRookPieces(r2);
        board.addPawnPieces(p1);
        System.out.println(board.findJogada(15));
        board.printBoardChess();
        assertEquals(board.findJogada(15),p1.possibleMove(board));
        assertEquals(p1.getSymbol(),board.getChessBoard()[1][7]);
        board.delPawn(pawnPos);
        board.setChessBoard(1,7,0,7,'Q');
        board.addQueenPieces(q1=new Queen('Q',7,true));
        assertEquals(' ',board.getChessBoard()[1][7]);
        assertEquals(q1.getSymbol(),board.getChessBoard()[0][7]);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
        assertEquals(false,board.gameOver);
    }











}