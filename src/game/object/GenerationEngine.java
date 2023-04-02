package game.object;

import engine.math.Vector2f;
import engine.render.Camera;
import game.object.gen.Chunk;
import game.object.gen.World;
import game.object.utils.WorldUtils;

import java.util.HashMap;

public class GenerationEngine {



    private static Integer actualChunkX = null;
    private static Integer actualChunkZ = null;
    private static final int RENDERING_DISTANCE = 4;
    private static HashMap<Vector2f,Chunk> cordsToRemove;
    private static boolean canBeCompile = false;
    private static boolean canBeGenerate = false;

    public static void create(){
        World.create();
    }


    public static void update(){
        if(canBeGenerate){
            Camera camera = Game.getCamera();
            Chunk c = new Chunk();

            int chunkX = (int) -camera.getPosition().getX()/c.getMAX_SIZE();
            int chunkZ = (int) -camera.getPosition().getZ()/c.getMAX_SIZE();

            if(actualChunkX == null || actualChunkX != chunkX || actualChunkZ == null || actualChunkZ != chunkZ ){
                cordsToRemove = (HashMap<Vector2f, Chunk>) World.getActiveChunks().clone();

                for(int x = chunkX - RENDERING_DISTANCE; x <= chunkX + RENDERING_DISTANCE; x++){
                    for(int z = chunkZ - RENDERING_DISTANCE; z <= chunkZ + RENDERING_DISTANCE; z++){
                        Vector2f chunkCord = new Vector2f(x,z);
                        if(!World.getActiveChunks().containsKey(chunkCord)){
                            World.addWorldChunk(chunkCord);
                        }
                        cordsToRemove.remove(chunkCord);
                    }
                }

                for(Vector2f coord : cordsToRemove.keySet()){
                    Chunk chunkToDelete = World.getActiveChunks().get(coord);
                    World.getActiveChunks().remove(coord);
                }

                if(actualChunkX == null || actualChunkZ == null){
                    for (var entry : World.getActiveChunks().entrySet()) {
                        Chunk chunk = entry.getValue();
                        for (int y = 0; y < chunk.getMAX_HEIGHT(); y++) {
                            for (int x = 0; x < chunk.getMAX_SIZE(); x++) {
                                for (int z = 0; z < chunk.getMAX_SIZE(); z++) {
                                    if (chunk.getBlocks()[x][y][z] != null) {
                                        chunk.getBlocks()[x][y][z].setFaceToDisplay(WorldUtils.getFaceToDisplay(chunk.getBlocks()[x][y][z].getPosition(), chunk));
                                    }
                                }
                            }
                        }
                    }
                }

                actualChunkX = chunkX;
                actualChunkZ = chunkZ;

                World.update();
                canBeCompile = true;
                //World.compileRendering();

            }
        }
        canBeGenerate = false;

    }

    public static void refreshGeneration(){
        canBeGenerate = true;
    }

    public static void compileRendering(){
        if(canBeCompile){
            World.compileRendering();
            canBeCompile = false;
        }
    }

    public static void render(){
        World.render();
    }
}
