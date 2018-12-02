package com.mygdx.spat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.List;

public class Ship {
    private float x,y;
    private Texture texture;
    private float width,height;
    private float speed;
    private int score,life;
    private float score_positionX = 100;
    private float score_positionY = 100;
    private BitmapFont scoreFont,lifeFont;


    public Ship(float x,float y){
        this.x = x;
        this.y = y;
        scoreFont = new BitmapFont();
        lifeFont = new BitmapFont();
        texture = new Texture("ship.png");
        width = texture.getWidth();
        height = texture.getHeight();
        speed = 4;
        score = 0;
        life = 5;
    }
    public void draw(SpriteBatch batch, List<Enemy> enemyList){
        batch.draw(texture,x,y);
    }

    public  void move(List<Bullet> bulletList){
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) y-=speed;
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) y+=speed;
        if(Gdx.input.isKeyJustPressed(Input.Keys.F)) bulletList.add(new Bullet(x,y+height/2));
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) Gdx.app.exit();



    }


    public void collisionToScreen(){
        if(y<0) y = 0;
        if(y+height> Gdx.graphics.getHeight()) y = Gdx.graphics.getHeight() - height;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {

        return life;
    }

    public void drawInfo(SpriteBatch batch){
    scoreFont.draw(batch,"score = "+Integer.toString(score),score_positionX,score_positionY);
        scoreFont.draw(batch,"life  = "+Integer.toString(life),score_positionX,score_positionY+20);

    }

    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public BitmapFont getScoreFont() {
        return scoreFont;
    }

    public Texture getTexture() {

        return texture;
    }

    public float getHeight() {
        return height;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {

        return score;
    }

}
