package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;

import java.io.IOException;
import java.util.ArrayList;


public class RenderServer extends InputAdapter implements ApplicationListener {
    private SpriteBatch batch;
    private BitmapFont font;

    // Displaying player
    private OrthographicCamera camera;
    private OrthogonalTiledMapRenderer renderer;
    public static final int widthPixels = 300;
    public static final int heightPixels = 300;
    public boolean pause = false;

    public Player player1;
    public Player player2;
    public Board board = new Board();

    private TextureRegion textureMove1, textureMove2, textureMove3, textureBackUp;
    private TextureRegion textureRotateLeft, textureRotateRight, textureUTurn;
    private Sprite spriteMove1, spriteMove2 ,spriteMove3, spriteBackUp;
    private Sprite spriteRotateLeft, spriteRotateRight, spriteUTurn;

    private boolean pickingCards = true;
    public ArrayList<String> listMoves= new ArrayList<String>();
    public int nCards=3;
    public ArrayList<Enum> pickedCards;
    public ArrayList<Enum> clientCards;
    public ArrayList<Enum> cardsToPickFrom;

    public Server server = new Server();
    public boolean showCards = true;
    public GameLogic gameLogic;



    @Override
    public void create() {
        // Setup text
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);

        // Load in map layers from tmx file
        board.createMap();

        // Setup camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, board.MAP_SIZE_X, board.MAP_SIZE_Y+3);
        camera.position.x= board.MAP_SIZE_X/2f;
        camera.position.y= (board.MAP_SIZE_Y-3)/2f;
        camera.update();

        // Setup render
        renderer = new OrthogonalTiledMapRenderer(board.map, 1F/widthPixels);
        renderer.setView(camera);

        // Setup player cell states, including textures
        player1.setPlayerState();
        player2.setPlayerState();
        player1 = new Player(new Vector2(1,1));
        player2 = new Player(new Vector2(3,1));

        // Setup card textures
        initializeCardTextures();

        // Setup server/ client
        try {
            server.setUpServer();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        gameLogic = new GameLogic(server, player1, player2, board);


        // Get key input
        Gdx.input.setInputProcessor(this);
    }


    public void initializeCardTextures(){
        // Split movement.png into 3 textures
        Texture texture1 = new Texture("assets/movement.jpg");
        TextureRegion textureMovement = new TextureRegion(texture1);
        TextureRegion[][] textureMovementSplit = textureMovement.split(texture1,100, 154);

        textureMove1 = textureMovementSplit[0][0];
        textureMove2 = textureMovementSplit[0][1];
        textureMove3 = textureMovementSplit[0][2];
        spriteMove1 = new Sprite(textureMove1);
        spriteMove2 = new Sprite(textureMove2);
        spriteMove3 = new Sprite(textureMove3);


        // Split rotation.png into 4 textures
        Texture texture2 = new Texture("assets/rotation.jpg");
        TextureRegion textureRotation = new TextureRegion(texture2);
        TextureRegion[][] textureRotationSplit = textureRotation.split(texture2,100, 154);

        textureBackUp = textureRotationSplit[0][1];
        textureRotateLeft = textureRotationSplit[1][0];
        textureRotateRight = textureRotationSplit[1][0];
        textureUTurn = textureRotationSplit[1][1];
        spriteBackUp = new Sprite(textureBackUp);
        spriteRotateLeft = new Sprite(textureRotateLeft);
        spriteRotateRight = new Sprite(textureRotateRight);
        spriteUTurn = new Sprite(textureUTurn);
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    public Integer n = 0;

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        renderer.render();
        board.updatePlayer(player1);
        board.updatePlayer(player2);
        n++;
        if (n>4) {
            n=0;
            try {
                gameLogic.round();
                cardsToPickFrom = gameLogic.cardsToPickFrom;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //board.updatePlayer(player1);
        //board.updatePlayer(player2);

        // Card visualization example
        batch.begin();
        spriteUTurn.setPosition(0,100);
        spriteUTurn.draw(batch);
        spriteMove2.setPosition(100,100);
        spriteMove2.draw(batch);
        spriteRotateLeft.setPosition(200,100);
        spriteRotateLeft.draw(batch);
        spriteMove3.setPosition(300,100);
        spriteMove3.draw(batch);
        spriteBackUp.setPosition(400,100);
        spriteBackUp.draw(batch);
        batch.end();


        if (player1.winCondition || player2.loseCondition){
            endGame();
            // End win screen
            batch.begin();
            font.getData().setScale(4, 4);
            font.draw(batch, "Player 2 lost, you won", 140, 250);
            batch.end();
        }
        else if (player2.winCondition || player1.loseCondition){
            endGame();
            // End win screen
            batch.begin();
            font.getData().setScale(4, 4);
            font.draw(batch, "Player 2 won, you LOST", 140, 250);
            batch.end();
        }

    }

    public void endGame(){
        pause = true;
    }
    @Override
    public void resize(int width, int height) {
    }
    @Override
    public void pause() {
        pause = true;
    }
    @Override
    public void resume() {
        pause = false;
    }

    @Override
    public boolean keyUp(int keyCode){
        // Remove player texture before moving
        //board.playerLayer.setCell((int) player.playerPos.x, (int) player.playerPos.y, null);
        gameLogic.selectCards(keyCode);
        return true;
    }
}
