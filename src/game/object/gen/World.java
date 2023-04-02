package game.object.gen;

import engine.math.Vector2f;
import engine.math.Vector3f;
import game.object.GenerationEngine;
import game.object.gen.block.Dirt;
import game.object.gen.block.Grass;
import game.object.gen.block.Stone;
import game.object.utils.WorldUtils;

import java.awt.*;
import java.util.ArrayList;
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
                for (var entry : activeChunks.entrySet()) {
                    Chunk c = entry.getValue();
                    c.render();
                }
            glEnd();
        glEndList();
    }

    public static HashMap<Vector2f, Chunk> getWorld() {
        return world;
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
