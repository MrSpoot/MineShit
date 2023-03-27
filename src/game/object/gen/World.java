package game.object.gen;

import engine.math.Vector3f;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;

public class World {

    private int renderingList;
    private final ArrayList<Chunk> world;

    public World() {
        this.world = new ArrayList<>();

        this.world.add(new Chunk(new Vector3f(0,0,0)));
        this.world.add(new Chunk(new Vector3f(1,0,1)));
        this.world.add(new Chunk(new Vector3f(1,0,0)));
        this.world.add(new Chunk(new Vector3f(0,0,1)));

        compileRendering();
    }

    private void compileRendering(){
        renderingList = glGenLists(1);
        glNewList(renderingList,GL_COMPILE);
            glBegin(GL_QUADS);
                for(Chunk c : this.world){

                    for(int y = 0; y < c.getMAX_HEIGHT(); y++){
                        for(int x = 0; x < c.getMAX_SIZE(); x++){
                            for(int z = 0; z < c.getMAX_SIZE(); z++){

                               c.getBlocks()[x][y][z].render();

                            }
                        }
                    }

                }
            glEnd();
        glEndList();
    }

    public void update(){

    }

    public void render(){
        glCallList(renderingList);
    }

}
