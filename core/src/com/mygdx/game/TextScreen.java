package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static com.mygdx.game.Main.WIDTH;


public class TextScreen implements Screen {
    private final Main game;
    private Texture wheelbarrowImage;
    private TextureRegion wheelBarrowReagon;
    private Sprite wheelbarrow;
    private int wbDirection;


    public TextScreen(Main game) {
        wheelbarrowImage = new Texture(Gdx.files.internal("wheelbarrow.png"));
        wheelBarrowReagon = new TextureRegion(wheelbarrowImage);
        wheelbarrow = new Sprite(wheelbarrowImage);
        wheelbarrow.setSize(wheelbarrow.getWidth() / 3, wheelbarrow.getHeight() / 3);
        wheelbarrow.setOriginCenter();
        wheelbarrow.setRotation(250);
        wheelbarrow.setPosition(WIDTH-100, 20);

        this.game = game;
        wbDirection = 0;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.06f, 0.6f, 0.9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.drawImage(wheelBarrowReagon, wheelbarrow);
        game.batch.end();

        if (wheelbarrow.getX() > 300) {
            if (wbDirection % 20 < 10) {
                wheelbarrow.rotate(1);
            } else {
                wheelbarrow.rotate(-1);
            }
            wbDirection++;
            wheelbarrow.setX(wheelbarrow.getX() - 200 * Gdx.graphics.getDeltaTime());
        }
    }

    @Override
    public void resize(int width, int height) {

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
