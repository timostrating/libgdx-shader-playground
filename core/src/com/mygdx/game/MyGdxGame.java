package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
	String vertexShader;
	String fragmentShader;
	ShaderProgram shaderProgram;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		sprite = new Sprite(img);
		sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		vertexShader = Gdx.files.internal("vertex.glsl").readString();
		fragmentShader = Gdx.files.internal("fragment.glsl").readString();
		shaderProgram = new ShaderProgram(vertexShader,fragmentShader);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.setShader(shaderProgram);
		batch.draw(sprite,sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
		batch.end();
	}
}
