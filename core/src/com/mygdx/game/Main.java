package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;


public class Main extends Game {

    public SpriteBatch batch;
    public BitmapFont font;
    public static int WIDTH = 800;
    public static int HEIGHT = 450;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        this.setScreen(new MainMenuScreen(this));
    }

    public void render() {
        super.render();
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }


    public void drawImage(Texture image, Rectangle rectangle) {
        batch.draw(image, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public void drawImage(TextureRegion image, Sprite r) {
        batch.draw(image, r.getX(), r.getY(), r.getOriginX(), r.getOriginY(), r.getWidth(),
                r.getHeight(), r.getScaleX(), r.getScaleY(), r.getRotation(), false) ;
    }

}
