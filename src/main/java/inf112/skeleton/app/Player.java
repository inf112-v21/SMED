package inf112.skeleton.app;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;

import java.util.ArrayList;

public class Player {

    public Vector2 playerPos;
    public Vector2 checkPoint;
    public boolean loseCondition = false;
    public boolean winCondition = false;
    public int dir = 0; //take this in as a parameter
    public int orgDir = 0; //take this in as a parameter
    public Cell playerCell;
    public Cell playerWonCell;
    public Cell playerDiedCell;
    public String playerTexture; //take this in as a parameter
    public int maxHP = 5;
    public int HP = maxHP;
    public int life = 3;
    public String name;
    public ArrayList<Vector2> visitedCheckPoints = new ArrayList<>();
    public ArrayList<Enum> pickedCards = new ArrayList<>();

    public Player(Vector2 pos, int dir, String texture){
        this.playerPos = pos;
        this.checkPoint = new Vector2(pos.x,pos.y);
        this.dir = dir;
        this.orgDir = dir;
        this.playerTexture = texture;
    }

    public void setPlayerState(){
        if(!(playerTexture==null)) {
            // Split player.png into 3 textures
            Texture texture = new Texture(playerTexture);
            TextureRegion texturePlayer = new TextureRegion(texture);
            TextureRegion[][] texturePlayerSplit = texturePlayer.split(texture, RenderServer.widthPixels, RenderServer.heightPixels);

            // Get the textures for the different player states
            StaticTiledMapTile playerCellTile = new StaticTiledMapTile(texturePlayerSplit[0][0]);
            StaticTiledMapTile playerDiedCellTile = new StaticTiledMapTile(texturePlayerSplit[0][1]);
            StaticTiledMapTile playerWonTile = new StaticTiledMapTile(texturePlayerSplit[0][2]);

            // Create player states
            playerCell = new TiledMapTileLayer.Cell().setTile(playerCellTile);
            playerDiedCell = new TiledMapTileLayer.Cell().setTile(playerDiedCellTile);
            playerWonCell = new TiledMapTileLayer.Cell().setTile(playerWonTile);
        }
    }

    public ArrayList<Enum> getCurrentCards(){
        return pickedCards;
    }

    public boolean playerLost(){
        return loseCondition;
    }

    public boolean playerWon(){
        return winCondition;
    }

    public void addCheckPoint(Vector2 pos){
        visitedCheckPoints.add(pos);
        this.checkPoint = new Vector2(pos.x,pos.y);
    }

    public Vector2 getCheckPoint(){
        return checkPoint;
    }

    public Vector2 getPosition(){
        return playerPos;
    }

    public void setHP(int HP){
        this.HP = HP;
    }

    public void addHP(int val) {
        HP = HP + val;
    }

    public int getMaxHP(){
        return maxHP;
    }

    public int getCurrentHP(){
        return HP;
    }

    public void addLife(int val){
        life = life + val;
    }

    public int getLife(){
        return this.life;
    }

    public void setLife(int life){
        this.life=life;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void move(Vector2 newPos){
        this.playerPos = newPos;
    }

    public void move(int x, int y){
        this.playerPos = new Vector2(x,y);
    }

    public void moveInDir(int dir, int dist, Board board){
        if(dir == 0 && board.canGo(this, dir)){
            playerPos.y = playerPos.y + dist;
        }
        else if(dir == 90 && board.canGo(this, dir)){
            playerPos.x = playerPos.x + dist;
        }
        else if(dir == 180 && board.canGo(this, dir)){
            playerPos.y = playerPos.y - dist;
        }
        else if(dir == 270 && board.canGo(this, dir)){
            playerPos.x = playerPos.x - dist;
        }
    }

    public void move(Enum ChosenMovement, Board board) {

        if(ChosenMovement == CardMovement.Movement.MOVE1
                || ChosenMovement == CardMovement.Movement.MOVE2
                || ChosenMovement == CardMovement.Movement.MOVE3
                || ChosenMovement == CardMovement.Movement.BACKUP){
            relocation(ChosenMovement, board);
        }
        else if(ChosenMovement == CardRotation.Rotation.ROTATERIGHT
                || ChosenMovement == CardRotation.Rotation.ROTATELEFT
                || ChosenMovement == CardRotation.Rotation.UTURN){
            rotate(ChosenMovement);
        }
    }

    public void rotate(Enum ChosenMovement){
        if (ChosenMovement == CardRotation.Rotation.ROTATERIGHT) {
            dir += 90;
        } else if (ChosenMovement == CardRotation.Rotation.ROTATELEFT) {
            dir += 270;
        } else if (ChosenMovement == CardRotation.Rotation.UTURN) {
            dir += 180;
        }
        dir = (dir % 360 + 360) % 360;
    }

    public void relocation(Enum ChosenMovement, Board board){
        if (ChosenMovement == CardMovement.Movement.MOVE1) {
            move1(board);
        } else if (ChosenMovement == CardMovement.Movement.MOVE2) {
            move1(board);
            move1(board);
        } else if (ChosenMovement == CardMovement.Movement.MOVE3) {
            move1(board);
            move1(board);
            move1(board);
        } else if (ChosenMovement == CardMovement.Movement.BACKUP) {
            moveBack1(board);
        }

    }

    public void move1(Board board){
        if(dir == 0 && board.canGo(this, dir)){
            playerPos.y = playerPos.y + 1;
        }
        else if(dir == 90 && board.canGo(this, dir)){
            playerPos.x = playerPos.x + 1;
        }
        else if(dir == 180 && board.canGo(this, dir)){
            playerPos.y = playerPos.y - 1;
        }
        else if(dir == 270 && board.canGo(this, dir)){
            playerPos.x = playerPos.x - 1;
        }
    }

    public void moveBack1(Board board){
        if(dir == 0 && board.canGoBackwards(this)){
            playerPos.y = playerPos.y - 1;
        }
        else if(dir == 90 && board.canGoBackwards(this)){
            playerPos.x = playerPos.x - 1;
        }
        else if(dir == 180 && board.canGoBackwards(this)){
            playerPos.y = playerPos.y + 1;
        }
        else if(dir == 270 && board.canGoBackwards(this)){
            playerPos.x = playerPos.x + 1;
        }
    }

    public void moveBack1(){
        if(dir == 0){
            playerPos.y = playerPos.y - 1;
        }
        else if(dir == 90){
            playerPos.x = playerPos.x - 1;
        }
        else if(dir == 180){
            playerPos.y = playerPos.y + 1;
        }
        else if(dir == 270){
            playerPos.x = playerPos.x + 1;
        }
    }
}
