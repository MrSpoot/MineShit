package game.object.gen;

import engine.math.Vector3f;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;

public class World {

    private static int renderingList;
    private static ArrayList<Chunk> world;

    public static void create(){
        world = new ArrayList<>();


        int worldSize = 8;

        for(int x = 0; x < worldSize; x++){
            for(int z = 0; z < worldSize; z++){
                world.add(new Chunk(new Vector3f(x,0,z)));
            }
        }

        //world.add(new Chunk(new Vector3f(1,0,1)));
       //world.add(new Chunk(new Vector3f(1,0,0)));
       //world.add(new Chunk(new Vector3f(0,0,1)));
        compileRendering();
    }

    private static void compileRendering(){
        renderingList = glGenLists(1);
        glNewList(renderingList,GL_COMPILE);
            glBegin(GL_QUADS);
                for(Chunk c : world){
                    for(int y = 0; y < c.getMAX_HEIGHT(); y++){
                        for(int x = 0; x < c.getMAX_SIZE(); x++){
                            for(int z = 0; z < c.getMAX_SIZE(); z++){

                                if(c.getBlocks()[x][y][z] != null){

                                    c.getBlocks()[x][y][z].render();
                                }

                            }
                        }
                    }
                }

            glEnd();
        glEndList();
    }

    public static ArrayList<Chunk> getWorld() {
        return world;
    }

    public void update(){

    }

    public static void render(){
        glCallList(renderingList);
    }

}
