package game.object.gen;

import engine.math.Vector2f;
import engine.math.Vector3f;
import game.object.Block;
import game.object.gen.block.*;
import game.object.gen.structure.Tree;
import game.object.utils.Face;
import game.object.utils.WorldUtils;

import java.sql.SQLOutput;
import java.util.HashMap;

public class Chunk {


    private final float scale = 500f;
    private final int octaves = 50;
    private final float persitance = 0.3f;
    private final float lacunarity = 0.2f;
    private final long seed = 1515612518794515L;
    private final Vector2f position;
    public static final int MAX_HEIGHT = 255;
    public static final int MAX_SIZE = 16;
    private Block[][][] blocks;
    private static boolean canBeDisplayable = false;

    public Chunk(){
        this(new Vector2f(0,0));
    }

    public Chunk(Vector2f position) {
        this.position = new Vector2f(position.getX(),position.getZ());
        this.blocks = new Block[MAX_SIZE][MAX_HEIGHT][MAX_SIZE];
        generateChunk();
    }

    public void generateChunk(){
        canBeDisplayable = false;

        Vector2f offset = new Vector2f(MAX_SIZE * position.getX(),MAX_SIZE * position.getZ());

        float[][] perlinNoiseMap = PerlinNoise.getPerlinNoise(MAX_SIZE,MAX_SIZE,seed,scale,octaves,persitance,lacunarity,offset);

        for(int x = 0; x < MAX_SIZE; x++){
            for(int z = 0; z < MAX_SIZE; z++){
                int maxHeight = Math.round((perlinNoiseMap[x][z] * (MAX_HEIGHT)));

                if(maxHeight >= 255){
                    maxHeight = 254;
                }
                if(maxHeight <= 0){
                    maxHeight = 0;
                }

                for(int y = maxHeight; y >= 0; y--){
                    if(y == 0){
                        this.blocks[x][y][z] = new Bedrock(new Vector3f(x + position.getX()*MAX_SIZE, y, z + position.getZ()*MAX_SIZE));
                    }else if(y == maxHeight) {
                        this.blocks[x][y][z] = new Grass(new Vector3f(x + position.getX()*MAX_SIZE, y, z + position.getZ() * MAX_SIZE));
                    }else if(y < maxHeight && y > maxHeight-4){
                        this.blocks[x][y][z] = new Dirt(new Vector3f(x + position.getX()*MAX_SIZE, y, z + position.getZ()*MAX_SIZE));
                    }else if(y <= maxHeight - 4){
                        this.blocks[x][y][z] = new Stone(new Vector3f(x + position.getX()*MAX_SIZE, y, z + position.getZ()*MAX_SIZE));
                    }
                }
            }
        }
        canBeDisplayable = true;
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
        if(canBeDisplayable){
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
}
