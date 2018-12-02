package com.mygdx.spat;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	List<Enemy> enemyList;
	private final int ENEMY_NUMBER = 5;
    List<Bullet> bulletList;
    Background background;

	Ship ship;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();

		ship = new Ship(100,Gdx.graphics.getHeight()/2); //переписать
		enemyList = new ArrayList<Enemy>();
		for (int i = 0; i <ENEMY_NUMBER; i++){
			enemyList.add(new Enemy(new Random().nextInt(Gdx.graphics.getWidth()-40),
					new Random().nextInt(Gdx.graphics.getHeight()-40)));
		}
		bulletList = new ArrayList<Bullet>();
	}
	@Override
	public void render () {
		background.move();
		for (Enemy enemies:enemyList) {
			enemies.move();
			enemies.collisionToShip(ship);
		}
        for (Bullet bullet:bulletList) {
            bullet.move();
            bullet.collision(enemyList,ship);
        }
		ship.move(bulletList);
		ship.collisionToScreen();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.draw(batch);

		for (Enemy enemies:enemyList) {
			enemies.draw(batch);

		}
        for (Bullet bullet:bulletList) {
            bullet.draw(batch,ship);

        }
		ship.draw(batch,enemyList);
		ship.drawInfo(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		ship.getTexture().dispose();
		ship.getScoreFont().dispose();
		background.getTexture().dispose();
		for (Enemy enemies:enemyList) {
			enemies.getTexture().dispose();
		}
		batch.dispose();
	}
}
