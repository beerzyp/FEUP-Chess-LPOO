package com.lpoo.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lpoo.game.FeupChess;

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


    public TheScreen(FeupChess game){
        this.game = game;
        texture = new Texture("badlogic.jpg");
        gamecam = new OrthographicCamera();
        gameport = new FitViewport(500,500,gamecam);
        Buttons();
    }

    public void Buttons(){

        font = new BitmapFont(Gdx.files.internal("Arial.fnt"));
        green = new Texture(Gdx.files.internal("green.jpg"));
        white = new Texture(Gdx.files.internal("white.jpg"));



        stage = new Stage(gameport, game.batch);


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

        stage.act(delta);
        stage.draw();
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
