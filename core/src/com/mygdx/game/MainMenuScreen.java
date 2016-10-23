package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import static com.mygdx.game.Main.HEIGHT;
import static com.mygdx.game.Main.WIDTH;


public class MainMenuScreen implements Screen {
    public static final int SIGNPOST_Y = 50;
    final Main game;

    OrthographicCamera camera;
    Texture signPostImage;
    Rectangle signPost;

    public MainMenuScreen(final Main game) {
        this.game = game;

        signPostImage = new Texture(Gdx.files.internal("sign-post.png"));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, WIDTH, HEIGHT);

        signPost = new Rectangle();
        signPost.setSize(250, 200);
        signPost.setX(WIDTH / 2 - signPost.getWidth() / 2);
        signPost.setY(SIGNPOST_Y);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.06f, 0.6f, 0.9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.drawImage(signPostImage, signPost);
        game.font.getData().setScale(2);
        game.font.draw(game.batch, "Yishtabach", 330, 190);
        game.batch.end();

        Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        if (Gdx.input.isTouched() || signPost.y < SIGNPOST_Y) {
            camera.unproject(touchPos);
            if (signPost.contains(touchPos.x, touchPos.y) || signPost.y < SIGNPOST_Y) {
                signPost.y -= 200 * Gdx.graphics.getDeltaTime();
                if (signPost.y <= -200) {
                    game.setScreen(new TextScreen(game));
                    dispose();
                }

            }
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
        signPostImage.dispose();

    }
}
