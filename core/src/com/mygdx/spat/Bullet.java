package com.mygdx.spat;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.List;
import java.util.Random;

public class Bullet {
    private float x,y;
    private Texture texture;
    private float width,height;
    private float speed;


    public Bullet(float x,float y){
        this.x = x;
        this.y = y;
        texture = new Texture("bullet.png");
        width = texture.getWidth();
        height = texture.getHeight();
        speed = 5f;


    }
    public void draw(SpriteBatch batch,Ship ship){
        batch.draw(texture,x ,y);
    }
    public  void move(){
        x+=speed;
    }

    public void collision(List<Enemy> enemyList, Ship ship){
        for (Enemy enemies: enemyList){
            if(x+width>enemies.getX()&(x<enemies.getX()+width)&(y>enemies.getY())
                                        &(y<enemies.getY()+enemies.getHeight())){

                    enemies.setX(700);
                    enemies.setY(new Random().nextInt(450));
                    y = -5f;
                    ship.setScore(ship.getScore()+1);


            }
        }
    }

    public Texture getTexture() {
        return texture;
    }
}
