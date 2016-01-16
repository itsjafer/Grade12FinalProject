package com.mygdx.game;

import com.mygdx.game.input.GameInputs;
import com.mygdx.game.input.InputProcessor;
import com.mygdx.game.gamestate.ScreenManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.input.GameInputs;
import com.mygdx.game.model.Polygon;

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
        screenManager = new ScreenManager(ScreenManager.GameScreens.MAIN_MENU);
        // The game input processor is gonna distribute all of the input for the game
        gameInput = new InputProcessor();
        Gdx.input.setInputProcessor(gameInput);
        
        System.out.println(Polygon.vectorProject(new Vector2(0.0f, -20.765337f), new Vector2(25.0f, -0.0f)));
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
