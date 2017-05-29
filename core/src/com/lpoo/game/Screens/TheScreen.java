package com.lpoo.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.SnapshotArray;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lpoo.game.FeupChess;
import com.lpoo.game.Logic.Bishops;
import com.lpoo.game.Logic.BoardLogic;
import com.lpoo.game.Logic.King;
import com.lpoo.game.Logic.Knights;
import com.lpoo.game.Logic.Pawns;
import com.lpoo.game.Logic.Queen;
import com.lpoo.game.Logic.Rooks;

import java.awt.Font;

/**
 * Created by FranciscoSilva on 17/05/17.
 */

public class TheScreen implements Screen {
    private FeupChess game;
    Texture texture;
    private OrthographicCamera gamecam;
    private Viewport gameport;
    BitmapFont font;
    Texture green, white;
    Stage stage;
    Stage Pieces;
    BoardLogic board; //inicialização da board;
    Texture whiteKing = new Texture(Gdx.files.internal("Pieces/WhiteKing.png"));
    Texture blackKing = new Texture(Gdx.files.internal("Pieces/BlackKing.png"));
    Texture whiteRook = new Texture(Gdx.files.internal("Pieces/WhiteRook.png"));
    Texture blackRook = new Texture(Gdx.files.internal("Pieces/BlackRook.png"));
    Texture whiteKnight = new Texture(Gdx.files.internal("Pieces/WhiteKnight.png"));
    Texture blackKnight = new Texture(Gdx.files.internal("Pieces/BlackKnight.png"));
    Texture whiteQueen = new Texture(Gdx.files.internal("Pieces/WhiteQueen.png"));
    Texture blackQueen = new Texture(Gdx.files.internal("Pieces/BlackQueen.png"));
    Texture whitePawn = new Texture(Gdx.files.internal("Pieces/WhitePawn.png"));
    Texture blackPawn = new Texture(Gdx.files.internal("Pieces/BlackPawn.png"));
    Texture whiteBishop = new Texture(Gdx.files.internal("Pieces/WhiteBishop.png"));
    Texture blackBishop = new Texture(Gdx.files.internal("Pieces/BlackBishop.png"));
    Texture transparent = new Texture(Gdx.files.internal("Pieces/transparent.png"));
    int tempPos = -1;


    public TheScreen(FeupChess game){
        this.game = game;
        texture = new Texture("badlogic.jpg");
        gamecam = new OrthographicCamera();
        gameport = new FitViewport(500,500,gamecam);
        LoadLogic();
        LoadBoard();
        LoadPieces();
    }

    public void LoadLogic(){
        board = new BoardLogic();

        //inserção dos elementos da board

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


        //int pos = 0;

        /*while(pos != -1){

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
        }*/
    }

    public void LoadBoard(){

        //font = new BitmapFont(Gdx.files.internal("Arial.fnt"));
        green = new Texture(Gdx.files.internal("green.jpg"));
        white = new Texture(Gdx.files.internal("white.jpg"));




        stage = new Stage(gameport, game.batch);
        Pieces = new Stage(gameport, game.batch);


        for(int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                if(y % 2 == 0)
                    if(x % 2 == 0)
                        stage.addActor(new ImageButton(new TextureRegionDrawable(new TextureRegion(white))));
                    else
                        stage.addActor(new ImageButton(new TextureRegionDrawable(new TextureRegion(green))));
                else
                    if(x % 2 == 0)
                        stage.addActor(new ImageButton(new TextureRegionDrawable(new TextureRegion(green))));
                    else
                        stage.addActor(new ImageButton(new TextureRegionDrawable(new TextureRegion(white))));
            }
        }

        /*for(int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                if(y % 2 == 0)
                    if(x % 2 == 0)
                        Pieces.addActor(new ImageButton(new TextureRegionDrawable(new TextureRegion(whiteKing))));
                    else
                        Pieces.addActor(new ImageButton(new TextureRegionDrawable(new TextureRegion(blackKing))));
                else
                if(x % 2 == 0)
                    Pieces.addActor(new ImageButton(new TextureRegionDrawable(new TextureRegion(blackKing))));
                else
                    Pieces.addActor(new ImageButton(new TextureRegionDrawable(new TextureRegion(whiteKing))));
            }
        }*/

    }


    public void LoadPieces(){

        int flag;

        for(int i = 0; i < board.getChessBoard().length; i++){
            for(int j = 0; j < board.getChessBoard()[i].length ; j++){

                flag = 0;

                tempPos++;
                final int index = 63 - tempPos;
                TextureRegion TextR = new TextureRegion(transparent);

                switch(board.getChessBoard()[i][j]){
                    case 'a':case 'A':{
                        if(!board.findKing(tempPos).playerColor){
                            TextR = new TextureRegion(whiteKing);
                        }
                        else{
                           TextR = new TextureRegion(blackKing);
                        }
                        break;
                    }
                    case 'k':case 'K':{
                        if(!board.findKnight(tempPos).playerColor){
                            TextR = new TextureRegion(whiteKnight);
                        }
                        else{
                            TextR = new TextureRegion(blackKnight);
                        }
                        break;
                    }
                    case 'b':case 'B':{
                        if(!board.findBishop(tempPos).playerColor){
                            TextR = new TextureRegion(whiteBishop);
                        }
                        else{
                            TextR = new TextureRegion(blackBishop);
                        }
                        break;
                    }
                    case 'r':case 'R':{
                        if(!board.findRook(tempPos).playerColor){
                            TextR = new TextureRegion(whiteRook);
                        }
                        else{
                            TextR = new TextureRegion(blackRook);
                        }
                        break;
                    }
                    case 'q':case 'Q':{
                        if(!board.findQueen(tempPos).playerColor){
                            TextR = new TextureRegion(whiteQueen);
                        }
                        else{
                            TextR = new TextureRegion(blackQueen);
                        }
                        break;
                    }
                    case 'p':case 'P':{
                        if(!board.findPawn(tempPos).playerColor){
                            TextR = new TextureRegion(whitePawn);
                        }
                        else{
                            TextR = new TextureRegion(blackPawn);
                        }
                        break;
                    }
                    case ' ':{
                        TextR = new TextureRegion(transparent);
                        flag = 1;
                        break;
                    }
                }
                ImageButton bt = new ImageButton(new TextureRegionDrawable(TextR));

                if(flag != 1){
                    bt.addListener( new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            System.out.println(index);
                            System.out.println(board.findJogada(index));
                        };
                    });
                }

                Pieces.addActor(bt);


            }
        }
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //game.batch.setProjectionMatrix(gamecam.combined);

        float buttonWidth = gamecam.viewportWidth / 8;
        float buttonHeight = gamecam.viewportHeight / 8;
        for(int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                ImageButton button = (ImageButton)stage.getActors().get(x + y * 8);
                button.setSize(100,100);
                button.setX(x * buttonWidth);
                button.setY(y * buttonHeight);
                button.setWidth(buttonWidth);
                button.setHeight(buttonHeight);
            }
        }


        //System.out.println(board.findJogada(48));

        for(int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                ImageButton button = (ImageButton)Pieces.getActors().get(x + y * 8);
                button.setSize(100,100);
                button.setX(x * buttonWidth);
                button.setY(y * buttonHeight);
                button.setWidth(buttonWidth);
                button.setHeight(buttonHeight);
                Gdx.input.setInputProcessor(Pieces);
            }
        }
        //tempPos = -1;

        stage.act(delta);
        stage.draw();
        Pieces.act(delta);
        Pieces.draw();

        /*SnapshotArray<Actor> actors = new SnapshotArray<Actor>(Pieces.getActors());
        for(Actor actor : actors) {
            actor.remove();
        }*/
    }


    @Override
    public void resize(int width, int height) {
        gameport.update(width, height);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
