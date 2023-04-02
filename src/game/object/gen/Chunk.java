package game.object.gen;

import engine.math.Vector2f;
import engine.math.Vector3f;
import game.object.Block;
import game.object.gen.block.*;
import game.object.utils.Face;
import game.object.utils.WorldUtils;

public class Chunk {

    private final Vector2f position;
    private final int MAX_HEIGHT = 255;
    private final int MAX_SIZE = 16;
    private Block[][][] blocks;

    public Chunk(){
        this(new Vector2f(0,0));
    }

    public Chunk(Vector2f position) {
        this.position = new Vector2f(position.getX(),position.getZ());
        this.blocks = new Block[MAX_SIZE][MAX_HEIGHT][MAX_SIZE];
        generateChunk();
    }

    public void generateChunk(){
        for(int y = 0; y < MAX_HEIGHT; y++){
            for(int x = 0; x < MAX_SIZE; x++){
                for(int z = 0; z < MAX_SIZE; z++){

                    if(y == 0){
                        this.blocks[x][y][z] = new Bedrock(new Vector3f(x + position.getX()*MAX_SIZE, y, z + position.getZ()*MAX_SIZE));
                    }else if (y > 59 && y < 65 ){
                        this.blocks[x][y][z] = new Dirt(new Vector3f(x + position.getX()*MAX_SIZE, y, z + position.getZ()*MAX_SIZE));
                    }else if(y == 65){
                        this.blocks[x][y][z] = new Grass(new Vector3f(x + position.getX()*MAX_SIZE, y, z + position.getZ()*MAX_SIZE));
                    }else if(y < 60){
                        this.blocks[x][y][z] = new Stone(new Vector3f(x + position.getX()*MAX_SIZE, y, z + position.getZ()*MAX_SIZE));
                    }else{
                        this.blocks[x][y][z] = new Air(new Vector3f(x + position.getX()*MAX_SIZE, y, z + position.getZ()*MAX_SIZE));
                    }

                }
            }
        }
    }

    public Block[][][] getBlocks() {
        return blocks;
    }

    public Vector2f getPosition() {
        return position;
    }

    public int getMAX_HEIGHT() {
        return MAX_HEIGHT;
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public void preProcessRender(){
        for (int y = 0; y < MAX_HEIGHT; y++) {
            for (int x = 0; x < MAX_SIZE; x++) {
                for (int z = 0; z < MAX_SIZE; z++) {
                    if (blocks[x][y][z] != null) {
                        blocks[x][y][z].setFaceToDisplay(WorldUtils.getFaceToDisplay(blocks[x][y][z].getPosition(), this));
                    }
                }
            }
        }
    }

    public void render(){
        for(int y = 0; y < MAX_HEIGHT; y++){
            for(int x = 0; x < MAX_SIZE; x++){
                for(int z = 0; z < MAX_SIZE; z++){
                    if(blocks[x][y][z] != null){
                        blocks[x][y][z].render();
                    }
                }
            }
        }
    }
}
