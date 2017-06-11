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

    }

	@Override
	public void render () {
		super.render();
	}
}
