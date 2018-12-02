package com.mygdx.spat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Enemy {
    private float x,y;
    private Texture texture;
    private float width,height;
    private float speed;
    private float start_position;


    public Enemy(int x,int y){
         this.x = x;
         this.y = y;
         texture = new Texture("enemy.png");
         width = texture.getWidth();
         height = texture.getHeight();
         speed = 4;
         start_position = 700;
    }
    public void draw(SpriteBatch batch){
        batch.draw(texture,x,y);
    }
    public void move(){
        x-=speed;
        if(x+width<0) {
            x = start_position;
        }
    }
    public void collisionToShip(Ship ship){
        if( (x<ship.getX()+ship.getWidth())&(ship.getX()<x+width)&
                (ship.getY()+ship.getHeight()>y)&(ship.getY()<y+height)){
            x= x+Gdx.graphics.getWidth();
            ship.setLife(ship.getLife()-1);
            if(ship.getLife()<1) Gdx.app.exit();

        }
    }





    public void setX(float x) {

        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Texture getTexture() {
        return texture;
    }

    public float getHeight() {
        return height;
    }

    public void setStart_position(float start_position) {
        this.start_position = start_position;
    }
}
