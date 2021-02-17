package inf112.skeleton.app;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;


public class Player{

    public static Vector2 playerPos = new Vector2(0,0);
    public static boolean loseCondition = false;
    public static boolean winCondition = false;
    public static Cell playerCell;
    public static Cell playerWonCell;
    public static Cell playerDiedCell;

    public static void setPlayerState(){
        // Split player.png into 3 textures
        Texture texture = new Texture("assets/player.png");
        TextureRegion texturePlayer = new TextureRegion(texture);
        TextureRegion[][] tP = texturePlayer.split(texture,Render.widthPixels, Render.heightPixels);

        // Get the textures for the different player states
        StaticTiledMapTile playerCellTile = new StaticTiledMapTile(tP[0][0]);
        StaticTiledMapTile playerDiedCellTile = new StaticTiledMapTile(tP[0][1]);
        StaticTiledMapTile playerWonTile = new StaticTiledMapTile(tP[0][2]);

        // Create player states
        playerCell = new TiledMapTileLayer.Cell().setTile(playerCellTile);
        playerDiedCell = new TiledMapTileLayer.Cell().setTile(playerDiedCellTile);
        playerWonCell = new TiledMapTileLayer.Cell().setTile(playerWonTile);
    }

    public static void move(String direction){
        // -------- Placeholder movement for part 1--------
        if (direction == "up") {
            playerPos.y = playerPos.y + 1;
        }
        else if (direction == "down") {
            playerPos.y = playerPos.y - 1;
        }
        else if (direction == "right") {
            playerPos.x = playerPos.x + 1;
        }
        else if (direction == "left") {
            playerPos.x = playerPos.x - 1;
        }
    }

}