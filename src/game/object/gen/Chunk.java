package game.object.gen;

import engine.math.Vector3f;
import game.object.Block;
import game.object.block.Air;
import game.object.block.Bedrock;
import game.object.block.Dirt;
import game.object.block.Stone;

public class Chunk {

    private final Vector3f position;
    private final int MAX_HEIGHT = 255;
    private final int MAX_SIZE = 16;

    private Block[][][] blocks;

    public Chunk(){
        this(new Vector3f(0,0,0));
    }

    public Chunk(Vector3f position) {
        this.position = position;
        this.blocks = new Block[MAX_SIZE][MAX_HEIGHT][MAX_SIZE];
        generateChunk();
    }

    public void generateChunk(){

        for(int y = 0; y < MAX_HEIGHT; y++){
            for(int x = 0; x < MAX_SIZE; x++){
                for(int z = 0; z < MAX_SIZE; z++){

                    if(y == 0){
                        this.blocks[x][y][z] = new Bedrock(new Vector3f(x + position.getX(), y + position.getY(), z + position.getZ()));
                    }else if (y > 59 && y < 65 ){
                        this.blocks[x][y][z] = new Dirt(new Vector3f(x + position.getX(), y + position.getY(), z + position.getZ()));
                    }else if(y < 60){
                        this.blocks[x][y][z] = new Stone(new Vector3f(x + position.getX(), y + position.getY(), z + position.getZ()));
                    }else{
                        this.blocks[x][y][z] = new Air(new Vector3f(x + position.getX(), y + position.getY(), z + position.getZ()));
                    }

                }
            }
        }
    }

    public Block[][][] getBlocks() {
        return blocks;
    }

    public Vector3f getPosition() {
        return position;
    }

    public int getMAX_HEIGHT() {
        return MAX_HEIGHT;
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }
}
