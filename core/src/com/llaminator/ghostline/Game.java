package com.llaminator.ghostline;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Game extends ApplicationAdapter {
	OrthographicCamera camera;
	SpriteBatch MRoute;
	SpriteBatch MGh;
	Route GameRoute;
	Ghost Gh;
	double x = 0, y = 0, x0 = 10, y0 = 10;
	double speedX = 30, speedY = 0;
	int cnt = 1;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 600, 480);
		MRoute = new SpriteBatch();
		MGh = new SpriteBatch();
		GameRoute = new Route();
		Gh = new Ghost(x0 + 10, y0 + 10);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		MRoute.begin();
		x = x0;
		y = y0;
		//System.out.println(GameRoute.Level.size());
		for (int i = 0; i < GameRoute.Level.size(); i++){
			MRoute.draw(GameRoute.Level.get(i).Step, (float)x, (float) y);
			if (GameRoute.Level.get(i).getDir() == 1)
				x += GameRoute.Level.get(i).Step.getWidth();
			else
				y += GameRoute.Level.get(i).Step.getHeight();
		}
		MRoute.end();

		MGh.begin();

		//System.out.println(Gh.x + " " + Gh.y);

		Gh.x += speedX * Gdx.graphics.getDeltaTime();

		Gh.y += speedY * Gdx.graphics.getDeltaTime();

		MGh.draw(new Texture(Gdx.files.internal("ghost.png")), (float)Gh.x, (float)Gh.y);

		System.out.println(camera.position.x + " " + camera.position.y);

		//camera.position.set( (float)Gh.x, (float)Gh.y, 0 );
		camera.position.set(camera.viewportWidth, camera.viewportHeight, 0);
		camera.update();

		MGh.end();


		if (Gh.x - x0 * cnt > GameRoute.Level.get(0).Step.getHeight()) {
			GameRoute.ExpandLevel();
			cnt++;
		}

		if (Gdx.input.justTouched()) {
			double tmp = speedX;
			speedX = speedY;
			speedY = tmp;

		}
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}


	@Override
	public void dispose () {
		super.dispose();
		MRoute.dispose();

	}


}
