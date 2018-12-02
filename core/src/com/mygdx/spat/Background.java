package com.mygdx.spat;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background {
    private float x,y;
    private Texture texture;

    public Texture getTexture() {
        return texture;
    }

    private float width;
    private float speed;


    public Background(){
        x = 0; y = 0; speed = 3;
        texture = new Texture("back.png");
        width = texture.getWidth();
    }

    public void draw(SpriteBatch batch){
        batch.draw(texture,x,y);
        batch.draw(texture,x+width,y);
    }
    public void move(){
        x-=speed;
        if(x+width<0){
            x = 0;
        }
    }
}
