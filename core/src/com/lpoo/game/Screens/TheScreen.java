package com.lpoo.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
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
import com.lpoo.game.Logic.Piece;
import com.lpoo.game.Logic.Queen;
import com.lpoo.game.Logic.Rooks;

import java.awt.Font;
import java.util.ArrayList;

/**
 * Created by FranciscoSilva on 17/05/17.
 */

public class TheScreen implements Screen {
    private FeupChess game;
    public boolean gyroscopeAvail;
    Texture texture;
    private OrthographicCamera gamecam;
    private Viewport gameport;
    BitmapFont font;
    Texture green, white;
    float startingX,startingY;
    DragAndDrop dnd;
    boolean promotion;
    boolean gyro;
    Stage stage;
    Stage Pieces;
    Stage SelectPiece;
    boolean madeNewMove;
    BoardLogic board; //inicialização da board;
    Sprite whiteKing = new Sprite(new Texture(Gdx.files.internal("Pieces/WhiteKing.png")));
    Sprite blackKing = new Sprite(new Texture(Gdx.files.internal("Pieces/BlackKing.png")));
    Sprite whiteRook = new Sprite(new Texture(Gdx.files.internal("Pieces/WhiteRook.png")));
    Sprite blackRook = new Sprite(new Texture(Gdx.files.internal("Pieces/BlackRook.png")));
    Sprite whiteKnight = new Sprite(new Texture(Gdx.files.internal("Pieces/WhiteKnight.png")));
    Sprite blackKnight = new Sprite(new Texture(Gdx.files.internal("Pieces/BlackKnight.png")));
    Sprite whiteQueen = new Sprite(new Texture(Gdx.files.internal("Pieces/WhiteQueen.png")));
    Sprite blackQueen = new Sprite(new Texture(Gdx.files.internal("Pieces/BlackQueen.png")));
    Sprite whitePawn = new Sprite(new Texture(Gdx.files.internal("Pieces/WhitePawn.png")));
    Sprite blackPawn = new Sprite(new Texture(Gdx.files.internal("Pieces/BlackPawn.png")));
    Sprite whiteBishop = new Sprite(new Texture(Gdx.files.internal("Pieces/WhiteBishop.png")));
    Sprite blackBishop = new Sprite(new Texture(Gdx.files.internal("Pieces/BlackBishop.png")));
    Sprite transparent = new Sprite(new Texture(Gdx.files.internal("Pieces/transparent.png")));
    int tempPos = -1;
    ArrayList<Integer> globalMade;
    boolean listenerFlag;
    int counter, counterCheck;
    InputMultiplexer inputMultiplexer;
    Texture feupBar = new Texture(Gdx.files.internal("feupBar.png"));
    Texture btUndo = new Texture(Gdx.files.internal("btUndo.png"));
    Texture btGit = new Texture(Gdx.files.internal("btGit.png"));
    Texture btExit = new Texture(Gdx.files.internal("btExit.png"));
    Texture btGyr = new Texture(Gdx.files.internal("gyr.png"));

    Stage barBox;
    int player;


    public TheScreen(FeupChess game){
        this.game = game;
        texture = new Texture("badlogic.jpg");
        gamecam = new OrthographicCamera();
        gameport = new FitViewport(500,500,gamecam);
        gyro = false;

        gyroscopeAvail = Gdx.input.isPeripheralAvailable(Input.Peripheral.Gyroscope);
        if(gyroscopeAvail)
        {
            startingX=Gdx.input.getGyroscopeX();
            startingY=Gdx.input.getGyroscopeY();
        }
        //gamecam.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight())
        promotion = false;
        LoadLogic();
        LoadBoard();
        LoadPieces();
        madeNewMove = false;
        int player = 0;
        PlayOnBoard();

        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(Pieces);
        inputMultiplexer.addProcessor(SelectPiece);
        inputMultiplexer.addProcessor(barBox);
        Gdx.input.setInputProcessor(inputMultiplexer);
        //Gdx.input.setInputProcessor(Pieces);
    }

    public void removeAllListeners(){
        for(int i = 0; i < SelectPiece.getActors().size; i++){
            SelectPiece.getActors().get(i).clearListeners();
        }
    }

    public void gyroscopeRotate()
    {
        if(gyroscopeAvail){
            float xmin=200;
            float ymin=200;
            float gyroX = Gdx.input.getGyroscopeX();
            float gyroY = Gdx.input.getGyroscopeY();
           // float gyroZ = Gdx.input.getGyroscopeZ();
            boolean flag=false;
            if(flag);
            {
                gamecam.translate(gyroX, gyroY);
            }
        }
    }

    public void PlayOnBoard(){
        counter=0;
        counterCheck=0;
        int flag;
        tempPos = -1;
        globalMade = new ArrayList<Integer>();
        board.kingSsNotSafe = false;

        for(int i = 0; i < Pieces.getActors().size; i++){
            Pieces.getActors().get(i).clearListeners();
        }

        board.printBoardChess();


        //Pieces = new Stage(gameport, game.batch);
        Pieces.clear();

        //board.printBoardChess();

        for(int i = 0; i < board.getChessBoard().length; i++){

            for(int j = 0; j < board.getChessBoard()[i].length ; j++){

                flag = 0;

                tempPos++;
                final int index = tempPos;
                TextureRegion TextR = new TextureRegion(transparent);

                switch(board.getChessBoard()[i][j]){
                    case 'a':case 'A':{
                        if(board.findKing(tempPos).playerColor){
                            //whiteKing.flip(false,true);
                            TextR = new TextureRegion(whiteKing);
                        }
                        else{
                            TextR = new TextureRegion(blackKing);
                        }
                        break;
                    }
                    case 'k':case 'K':{
                        if(board.findKnight(tempPos).playerColor){
                            TextR = new TextureRegion(whiteKnight);
                        }
                        else{
                            TextR = new TextureRegion(blackKnight);
                        }
                        break;
                    }
                    case 'b':case 'B':{
                        if(board.findBishop(tempPos).playerColor){
                            TextR = new TextureRegion(whiteBishop);
                        }
                        else{
                            TextR = new TextureRegion(blackBishop);
                        }
                        break;
                    }
                    case 'r':case 'R':{
                        if(board.findRook(tempPos).playerColor){
                            TextR = new TextureRegion(whiteRook);
                        }
                        else{
                            TextR = new TextureRegion(blackRook);
                        }
                        break;
                    }
                    case 'q':case 'Q':{
                        if(board.findQueen(tempPos).playerColor){
                            TextR = new TextureRegion(whiteQueen);
                        }
                        else{
                            TextR = new TextureRegion(blackQueen);
                        }
                        break;
                    }
                    case 'p':case 'P':{
                        if(board.findPawn(tempPos).playerColor){
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
                TextR.flip(false,true);

                final Image bt = new Image(new TextureRegionDrawable(TextR));

                if(Character.isUpperCase(board.getChessBoard()[i][j])){
                    counter++;
                    if(board.findJogada(tempPos) == "")
                        counterCheck++;

                }

                if(flag != 1){
                    if(Character.isUpperCase(board.getChessBoard()[i][j])){
                        if(board.getChessBoard()[i][j] == 'A'){
                            //board.findKing(tempPos).possibleMove(board);
                            if(!board.kingSafe())
                                bt.setColor(Color.RED);
                            else
                                bt.setColor(Color.WHITE);
                        }

                        listenerTreatment(index, bt);
                    }

                }

                Pieces.addActor(bt);

            }

        }

        if(counter == counterCheck){
            Pieces.getActors().get(board.kingPositionC).setColor(Color.GOLD);
            board.gameOver = true;
        }

    }

    public void listenerTreatment(final int index, Image bt) {
        bt.addListener( new InputListener() {

            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Example", "touch started at (" + x + ", " + y + ")");
                listenerFlag = true;
                clearActiveListeners();
                return true;
            }

            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                globalMade = new ArrayList<Integer>();
                final String[] AllPossibleMoves=board.retrievePossibleMovesList(board.findJogada(index));
                System.out.println("Cavalo: ");


                if(AllPossibleMoves.length!=0)
                {
                    for(int l=0;l<AllPossibleMoves.length;l++) {
                        System.out.println(AllPossibleMoves[l]);
                        if (AllPossibleMoves[l].length() <= 6) {

                            normalListener(l, AllPossibleMoves, index);

                        }
                        else{
                            if(AllPossibleMoves[l].charAt(5)=='C')
                            {
                                normalListener(l, AllPossibleMoves, index);
                            }
                            else{
                            pawnPromotionListener(l, AllPossibleMoves, index);
                            }
                        }
                    }
                }

            }
        });
    }

    private void pawnPromotionListener(int l, final String[] allPossibleMoves,final int index) {
        final int tmp = l;
        final int indexOnBoard = board.getPossibleMoveIndexAtBoard(allPossibleMoves[l]);


        if (indexOnBoard != -1) {
            stage.getActors().get(indexOnBoard).setColor(Color.RED);

            if (listenerFlag)
                Pieces.getActors().get(indexOnBoard).addListener(new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        Gdx.app.log("Example", "touch started at (" + x + ", " + y + ")");
                        return true;
                    }

                    @Override
                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                        if (listenerFlag == true) {
                            removeAllListeners();
                            clearActiveListeners();
                            for(int i = 1; i < SelectPiece.getActors().size; i++){
                                final int pos = i;
                                SelectPiece.getActors().get(i).addListener(new InputListener() {
                                    @Override
                                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                                        Gdx.app.log("Example", "touch started at (" + x + ", " + y + ")");
                                        return true;
                                    }

                                    @Override
                                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                                        if (listenerFlag == true) {
                                            boolean t = board.findPawn(index).playerColor;
                                            board.delPawn(index);
                                            if(pos==1){

                                                board.addQueenPieces(new Queen('Q', indexOnBoard, t));
                                                board.setChessBoard(index/8, index%8, indexOnBoard/8, indexOnBoard%8, 'Q');
                                            }
                                            else if(pos == 2){
                                                board.addRookPieces(new Rooks('R', indexOnBoard, t));
                                                board.setChessBoard(index/8, index%8, indexOnBoard/8, indexOnBoard%8, 'R');
                                            }
                                            else if(pos == 3){
                                                board.addBishopPieces(new Bishops('B', indexOnBoard, t));
                                                board.setChessBoard(index/8, index%8, indexOnBoard/8, indexOnBoard%8, 'B');
                                            }
                                            else if(pos == 4){
                                                board.addKnightPieces(new Knights('K', indexOnBoard, t));
                                                board.setChessBoard(index/8, index%8, indexOnBoard/8, indexOnBoard%8, 'K');
                                            }

                                            promotion = false;
                                            madeNewMove = true;
                                        }

                                        board.flipBoard();
                                    }
                                });
                            }


                            promotion = true;
                        }
                    }
                });

            globalMade.add(indexOnBoard);
        }
    }

    public void normalListener(int l, final String[] allPossibleMoves, final int index) {
        final int tmp = l;
        final int indexOnBoard = board.getPossibleMoveIndexAtBoard(allPossibleMoves[l]);


        if (indexOnBoard != -1) {
            stage.getActors().get(indexOnBoard).setColor(Color.RED);

            if (listenerFlag)
                Pieces.getActors().get(indexOnBoard).addListener(new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        Gdx.app.log("Example", "touch started at (" + x + ", " + y + ")");
                        return true;
                    }

                    @Override
                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                        if (listenerFlag == true) {
                            System.out.println(tmp);
                            System.out.println(index);
                            System.out.println(allPossibleMoves[tmp]);

                            if (board.findKing(index) != null) {
                                board.findKing(index).setNewMove(allPossibleMoves[tmp], board);
                            } else if (board.findQueen(index) != null) {
                                board.findQueen(index).setNewMove(allPossibleMoves[tmp], board);
                            } else if (board.findPawn(index) != null) {
                                //System.out.println(allPossibleMoves[tmp]);
                                board.findPawn(index).setNewMove(allPossibleMoves[tmp], board);
                            } else if (board.findKnight(index) != null) {
                                board.findKnight(index).setNewMove(allPossibleMoves[tmp], board);
                            } else if (board.findRook(index) != null) {
                                board.findRook(index).setNewMove(allPossibleMoves[tmp], board);
                            } else if (board.findBishop(index) != null) {
                                board.findBishop(index).setNewMove(allPossibleMoves[tmp], board);
                            }


                            board.flipBoard();
                            madeNewMove = true;
                            Pieces.getActors().get(indexOnBoard).clearListeners();
                            Pieces.getActors().get(index).clearListeners();

                            clearActiveListeners();
                            removeAllListeners();

                        }
                    }
                });

            globalMade.add(indexOnBoard);
        }
    }

    public void clearActiveListeners() {
        if(globalMade != null){
            for(int i=0; i < globalMade.size(); i++){
                System.out.print("Pontos: ");
                System.out.println(globalMade.get(i));
                stage.getActors().get(globalMade.get(i)).setColor(Color.WHITE);
                Pieces.getActors().get(globalMade.get(i)).clearListeners();
            }
        }
    }

    public void LoadLogic(){
        board = new BoardLogic(null);

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


    }

    public void LoadBoard(){

        green = new Texture(Gdx.files.internal("green.jpg"));
        white = new Texture(Gdx.files.internal("white.jpg"));

        barBox = new Stage(gameport, game.batch);

        Texture promotionBox = new Texture(Gdx.files.internal("promotion.png"));
        TextureRegion prom = new TextureRegion(promotionBox);
        prom.flip(false, true);
        TextureRegion wQ =  new Sprite(new Texture(Gdx.files.internal("Pieces/WhiteQueen.png")));
        TextureRegion wR = new Sprite(new Texture(Gdx.files.internal("Pieces/WhiteRook.png")));
        TextureRegion wB = new Sprite(new Texture(Gdx.files.internal("Pieces/WhiteBishop.png")));
        TextureRegion wK = new Sprite(new Texture(Gdx.files.internal("Pieces/WhiteKnight.png")));
        wQ.flip(false, true);
        wR.flip(false, true);
        wB.flip(false, true);
        wK.flip(false, true);

        SelectPiece = new Stage(gameport, game.batch);
        SelectPiece.addActor(new Image(new TextureRegionDrawable(prom)));
        SelectPiece.addActor(new Image(new TextureRegionDrawable(wQ)));
        SelectPiece.addActor(new Image(new TextureRegionDrawable(wR)));
        SelectPiece.addActor(new Image(new TextureRegionDrawable(wB)));
        SelectPiece.addActor(new Image(new TextureRegionDrawable(wK)));


        TextureRegion fbar = new Sprite(feupBar);
        TextureRegion undo = new Sprite(btUndo);
        TextureRegion git = new Sprite(btGit);
        TextureRegion exit = new Sprite(btExit);
        TextureRegion gyr = new Sprite(btGyr);

        fbar.flip(false,true);
        gyr.flip(false, true);
        undo.flip(false,true);
        git.flip(false,true);
        exit.flip(false,true);

        barBox.addActor(new Image(new TextureRegionDrawable(fbar)));
        barBox.addActor(new Image(new TextureRegionDrawable(git)));
        barBox.addActor(new Image(new TextureRegionDrawable(gyr)));
        barBox.addActor(new Image(new TextureRegionDrawable(undo)));
        barBox.addActor(new Image(new TextureRegionDrawable(exit)));

        barBox.getActors().get(1).setX(320);
        barBox.getActors().get(2).setX(360);
        barBox.getActors().get(3).setX(400);
        barBox.getActors().get(4).setX(440);

        barBox.getActors().get(4).addListener( new InputListener() {

            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                System.exit(0);
            }
        });

        barBox.getActors().get(3).addListener( new InputListener() {

            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

                if(player == 0)
                    System.out.println(board.Hint(0));
                else
                    System.out.println(board.Hint(1));
            }
        });

        barBox.getActors().get(2).addListener( new InputListener() { // listener para a flag giroscopio

            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                gyro = !gyro;
            }
        });

        barBox.getActors().get(1).addListener( new InputListener() {

            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.net.openURI("https://github.com/beerzyp/LPOO1617_T5G8");
            }
        });



        stage = new Stage(gameport, game.batch);
        Pieces = new Stage(gameport, game.batch);


        for(int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                if(y % 2 == 0)
                    if(x % 2 == 0)
                        stage.addActor(new Image(new TextureRegionDrawable(new TextureRegion(white))));
                    else
                        stage.addActor(new Image(new TextureRegionDrawable(new TextureRegion(green))));
                else
                if(x % 2 == 0)
                    stage.addActor(new Image(new TextureRegionDrawable(new TextureRegion(green))));
                else
                    stage.addActor(new Image(new TextureRegionDrawable(new TextureRegion(white))));
            }
        }
    }

    public void LoadPieces(){

        int flag;
        int fl = 7;
        boolean fplo = true;
        int ind = 55;

        for(int i = 0; i < board.getChessBoard().length; i++){

            for(int j = 0; j < board.getChessBoard()[i].length ; j++){

                flag = 0;

                tempPos++;
                final int index = tempPos;
                TextureRegion TextR = new TextureRegion(transparent);

                switch(board.getChessBoard()[i][j]){
                    case 'a':case 'A':{
                        if(board.findKing(tempPos).playerColor){
                            //whiteKing.flip(false,true);
                            TextR = new TextureRegion(whiteKing);
                        }
                        else{
                           TextR = new TextureRegion(blackKing);
                        }
                        break;
                    }
                    case 'k':case 'K':{
                        if(board.findKnight(tempPos).playerColor){
                            TextR = new TextureRegion(whiteKnight);
                        }
                        else{
                            TextR = new TextureRegion(blackKnight);
                        }
                        break;
                    }
                    case 'b':case 'B':{
                        if(board.findBishop(tempPos).playerColor){
                            TextR = new TextureRegion(whiteBishop);
                        }
                        else{
                            TextR = new TextureRegion(blackBishop);
                        }
                        break;
                    }
                       case 'r':case 'R':{
                        if(board.findRook(tempPos).playerColor){
                            TextR = new TextureRegion(whiteRook);
                        }
                        else{
                            TextR = new TextureRegion(blackRook);
                        }
                        break;
                    }
                    case 'q':case 'Q':{
                        if(board.findQueen(tempPos).playerColor){
                            TextR = new TextureRegion(whiteQueen);
                        }
                        else{
                            TextR = new TextureRegion(blackQueen);
                        }
                        break;
                    }
                    case 'p':case 'P':{
                        if(board.findPawn(tempPos).playerColor){
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
                TextR.flip(false,true);
                final Image bt = new Image(new TextureRegionDrawable(TextR));

                Pieces.addActor(bt);

            }

        }


        Pieces.getCamera().up.set(0, -1, 0);
        Pieces.getCamera().direction.set(0, 0, 1);

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //game.batch.setProjectionMatrix(gamecam.combined);
        if(gyro)
            gyroscopeRotate();

        //tempPos = -1;

        if(board.gameOver){
            System.out.println("Game Over!");
        }

        if(madeNewMove == true){
            madeNewMove = false;
            if(player == 0) player=1; else player=0;
            PlayOnBoard();
        }

        float buttonWidth = (gamecam.viewportWidth) / 8;
        float buttonHeight = (gamecam.viewportHeight-50) / 8;

        for(int y = 1; y <= 8; y++){
            for(int x = 0; x < 8; x++){
                Image button = (Image)stage.getActors().get(x + (y-1) * 8);
                button.setSize(100,100);
                button.setX(x * buttonWidth);
                button.setY(y * buttonHeight-6);
                button.setWidth(buttonWidth);
                button.setHeight(buttonHeight);
            }
        }

        for(int y = 1; y <= 8; y++){
            for(int x = 0; x < 8; x++){
                Image button = (Image)Pieces.getActors().get(x + (y-1) * 8);
                button.setSize(100,100);
                button.setX(x * buttonWidth);
                button.setY(y * buttonHeight-6);
                button.setWidth(buttonWidth);
                button.setHeight(buttonHeight);

            }
        }




        stage.act(delta);
        stage.draw();

        Pieces.act(delta);
        Pieces.draw();

        barBox.act(delta);
        barBox.draw();

        if(promotion){
            for(int x = 1; x < 5; x++){

                Image button = (Image)SelectPiece.getActors().get(x);
                //button.setColor(Color.ORANGE);
                button.setSize(100,100);

                if(x == 1)
                    button.setX(45);
                else if(x == 2)
                    button.setX(145);
                else if(x == 3)
                    button.setX(245);
                else if(x == 4)
                    button.setX(345);


                button.setY(225);
                button.setWidth(100);
                button.setHeight(100);
            }

            SelectPiece.act(delta);
            SelectPiece.draw();
        }

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
