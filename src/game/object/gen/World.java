package game.object.gen;

import engine.math.Vector2f;
import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.opengl.GL11.*;

public class World {

    private static int renderingList;
    private static HashMap<Vector2f,Chunk> world;
    private static HashMap<Vector2f,Chunk> activeChunks;

    public static void create(){
        world = new HashMap<>();
        activeChunks = new HashMap<>();
    }

    public static void compileRendering(){
        renderingList = glGenLists(1);
        glNewList(renderingList,GL_COMPILE);
            glBegin(GL_QUADS);
                for (Map.Entry<Vector2f,Chunk> entry : activeChunks.entrySet()) {
                    Chunk c = entry.getValue();
                    c.render();
                }
            glEnd();
        glEndList();
    }

    public static void addWorldChunk(Vector2f position){
        Chunk chunk;
        if(world.containsKey(position)){
            chunk = world.get(position);
            chunk.preProcessRender();
        }else{
            chunk = new Chunk(position);
            chunk.preProcessRender();
            world.put(position,chunk);
        }
        activeChunks.put(position,chunk);
    }

    public static void update(){

    }

    public static void render(){
        glCallList(renderingList);
    }

    public static HashMap<Vector2f,Chunk> getActiveChunks() {
        return activeChunks;
    }
}
