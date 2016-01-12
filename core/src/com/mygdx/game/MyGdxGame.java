package com.mygdx.game;

import com.mygdx.game.input.GameInputs;
import com.mygdx.game.input.InputProcessor;
import com.mygdx.game.gamestate.ScreenManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MyGdxGame extends Game {

    // The game state manager for the entire game
    private ScreenManager screenManager;
    ////////////NEED TO ASK ABOUT VIEWPORTS
    public static OrthographicCamera camera;
    //game input processor
    public static InputProcessor gameInput;
    // screen width and height
    public static int WIDTH, HEIGHT;

    /**
     * Creates the game
     */
    @Override
    public void create() {
        // initialize width and height
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
        // The game state manager starts out showing the menu screen
        screenManager = new ScreenManager(ScreenManager.GameStates.MAIN_MENU);
        // The game input processor is gonna distribute all of the input for the game
        gameInput = new InputProcessor();
        Gdx.input.setInputProcessor(gameInput);
    }

    /**
     * The main game loop
     */
    @Override
    public void render() {
        // Clear the screen
        Gdx.gl20.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // First update the current gamestate
        screenManager.update(Gdx.graphics.getDeltaTime());
        // Then draw it
        screenManager.render(Gdx.graphics.getDeltaTime());
        // Update the GameInputs key states
        GameInputs.update();
    }

    /**
     * Resizes the window
     *
     * @param width the new window width
     * @param height the new window height
     */
    @Override
    public void resize(int width, int height) {
        WIDTH = width;
        HEIGHT = height;
        screenManager.resize(width, height);
    }
}
