package com.lpoo.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lpoo.game.Logic.Bishops;
import com.lpoo.game.Logic.BoardLogic;
import com.lpoo.game.Logic.King;
import com.lpoo.game.Logic.Knights;
import com.lpoo.game.Logic.Pawns;
import com.lpoo.game.Logic.Queen;
import com.lpoo.game.Logic.Rooks;
import com.lpoo.game.Screens.TheScreen;

import java.util.Scanner;

public class FeupChess extends Game {
	public SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new TheScreen(this));

        /*BoardLogic board = new BoardLogic(); //inicialização da board;

        //inserção dos elementos da board


        //player 2 Pieces
        Rooks r1 = new Rooks('r', 0);
        Knights k1 = new Knights('k', 1);
        Bishops b1  = new Bishops('b', 2);
        Queen q = new Queen('q', 3);
        King a = new King('a', 4);
        Bishops b2  = new Bishops('b', 5);
        Knights k2 = new Knights('k', 6);
        Rooks r2 = new Rooks('r', 7);
        Pawns p1 = new Pawns('p', 8);
        Pawns p2 = new Pawns('p', 9);
        Pawns p3 = new Pawns('p', 10);
        Pawns p4 = new Pawns('p', 11);
        Pawns p5 = new Pawns('p', 12);
        Pawns p6 = new Pawns('p', 13);
        Pawns p7 = new Pawns('p', 14);
        Pawns p8 = new Pawns('p', 15);

        //player 1 Pieces
        Rooks R1 = new Rooks('R', 56);
        Knights K1 = new Knights('K', 57);
        Bishops B1  = new Bishops('B', 58);
        Queen Q = new Queen('Q', 59);
        King A = new King('A', 60);
        Bishops B2  = new Bishops('B', 61);
        Knights K2 = new Knights('K', 62);
        Rooks R2 = new Rooks('R', 63);
        Pawns P1 = new Pawns('P', 55);
        Pawns P2 = new Pawns('P', 54);
        Pawns P3 = new Pawns('P', 53);
        Pawns P4 = new Pawns('P', 52);
        Pawns P5 = new Pawns('P', 51);
        Pawns P6 = new Pawns('P', 50);
        Pawns P7 = new Pawns('P', 49);
        Pawns P8 = new Pawns('P', 48);

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


        int pos = 0;

        while(pos != -1){

            board.printBoardChess();

            System.out.println("\n");

            System.out.println("Search for a piece (48-63): ");
            Scanner S = new Scanner(System.in);
            pos = S.nextInt();

            while(board.getChessBoard()[pos/8][pos%8] == ' ' || Character.isLowerCase(board.getChessBoard()[pos/8][pos%8])){
                System.out.println("That chell is empty or represents a piece of the other player!: ");
                S = new Scanner(System.in);
                pos = S.nextInt();
            }

            if(board.findBishop(pos) != null){
                Bishops bishop = board.findBishop(pos);
                String[] possibleMoves = board.retrievePossibleMovesList(bishop.possibleMove(board));

                System.out.println("Choose move (0-X):\n");

                for(int i = 0; i < possibleMoves.length; i++){
                    System.out.print(i);
                    System.out.print(" -> ");
                    System.out.println(possibleMoves[i]);
                }

                Scanner scan = new Scanner(System.in);
                pos = scan.nextInt();

                bishop.setNewMove(possibleMoves[pos], board);

            }
            else if(board.findKing(pos) != null){
                King king = board.findKing(pos);
                String[] possibleMoves = board.retrievePossibleMovesList(king.possibleMove(board));

                System.out.println("Choose move (0-X):\n");

                for(int i = 0; i < possibleMoves.length; i++){
                    System.out.print(i);
                    System.out.print(" -> ");
                    System.out.println(possibleMoves[i]);
                }

                Scanner scan = new Scanner(System.in);
                pos = scan.nextInt();

                king.setNewMove(possibleMoves[pos], board);
            }
            else if(board.findKnight(pos) != null){
                Knights knight = board.findKnight(pos);
                String[] possibleMoves = board.retrievePossibleMovesList(knight.possibleMove(board));

                System.out.println("Choose move (0-X):\n");

                for(int i = 0; i < possibleMoves.length; i++){
                    System.out.print(i);
                    System.out.print(" -> ");
                    System.out.println(possibleMoves[i]);
                }

                Scanner scan = new Scanner(System.in);
                pos = scan.nextInt();

                knight.setNewMove(possibleMoves[pos], board);
            }
            else if(board.findPawn(pos) != null){
                Pawns pawn = board.findPawn(pos);
                String[] possibleMoves = board.retrievePossibleMovesList(pawn.possibleMove(board));

                System.out.println("Choose move (0-X):\n");

                for(int i = 0; i < possibleMoves.length; i++){
                    System.out.print(i);
                    System.out.print(" -> ");
                    System.out.println(possibleMoves[i]);
                }

                Scanner scan = new Scanner(System.in);
                pos = scan.nextInt();

                pawn.setNewMove(possibleMoves[pos], board);
            }
            else if(board.findQueen(pos) != null){
                Queen queen = board.findQueen(pos);
                String[] possibleMoves = board.retrievePossibleMovesList(queen.possibleMove(board));

                System.out.println("Choose move (0-X):\n");

                for(int i = 0; i < possibleMoves.length; i++){
                    System.out.print(i);
                    System.out.print(" -> ");
                    System.out.println(possibleMoves[i]);
                }

                Scanner scan = new Scanner(System.in);
                pos = scan.nextInt();

                queen.setNewMove(possibleMoves[pos], board);
            }
            else if(board.findRook(pos) != null){
                Rooks rook = board.findRook(pos);
                String[] possibleMoves = board.retrievePossibleMovesList(rook.possibleMove(board));

                System.out.println("Choose move (0-X):\n");

                for(int i = 0; i < possibleMoves.length; i++){
                    System.out.print(i);
                    System.out.print(" -> ");
                    System.out.println(possibleMoves[i]);
                }

                Scanner scan = new Scanner(System.in);
                pos = scan.nextInt();

                rook.setNewMove(possibleMoves[pos], board);
            }

            System.out.println("\n");
            board.flipBoard();
        }


        System.out.println("Queen: ");
        System.out.println(Q.possibleMove(board)); //calcula todas as jogadas para uma det. peça
        System.out.println("\n");
        System.out.println("Bishop: ");
        System.out.println(B1.possibleMove(board));
        System.out.println("\n");
        System.out.println("King: ");
        System.out.println(A.possibleMove(board));
        System.out.println("\n");
        System.out.println("Knight: ");
        System.out.println(K1.possibleMove(board));
        System.out.println("\n");
        System.out.println("Rook: ");
        System.out.println(R1.possibleMove(board));
        System.out.println("\n");
        System.out.println("Pawn: ");
        System.out.println(P1.possibleMove(board));
        System.out.println("\n");

        board.printBoardChess();

        Q.setNewMove("34Q23 ", board);

        System.out.println("\n");


        System.out.println("Bishop before flip");
        System.out.println(B1.getPosOnBoard());
        System.out.println(B1.getSymbol());

        board.flipBoard();

        System.out.println("\n");System.out.println("\n");
        System.out.println("Bishop after flip: ");
        System.out.println(board.getBishopPieces().get(0).getPosOnBoard());
        System.out.println(board.getBishopPieces().get(0).getSymbol());

        System.out.println("\n");

        board.printBoardChess();*/

    }

	@Override
	public void render () {
		super.render();
	}
}
