package game.object;

import engine.math.Vector3f;
import game.object.block.Stone;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;

public class World {

    private int renderingList;
    private ArrayList<Block> world;

    public World() {
        this.world = new ArrayList<>();

        this.world.add(new Stone(new Vector3f(0,0,-4)));
        this.world.add(new Stone(new Vector3f(0,1,-4)));

        compileRendering();
    }

    private void compileRendering(){
        //renderingList = glGenLists(1);
        //glNewList(renderingList,GL_COMPILE);
            glBegin(GL_QUADS);
                this.world.stream().forEach((block -> block.render()));
            glEnd();
        //glEndList();
    }

    public void update(){

    }

    public void render(){
        //glCallList(renderingList);
        glBegin(GL_QUADS);
        this.world.stream().forEach((block -> block.render()));
        glEnd();
    }

}
