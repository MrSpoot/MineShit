package game.object.block;

import engine.math.Vector3f;
import engine.texture.Texture;
import engine.texture.TextureAtlas;
import engine.texture.TextureAtlasManager;
import engine.texture.TextureManager;
import game.object.Block;

import java.sql.SQLOutput;

import static org.lwjgl.opengl.GL11.*;

public class Stone extends Block {

    private Vector3f position;

    private int texture;

    public Stone(){this(new Vector3f(0,0,0));}

    public Stone(Vector3f position) {
        this.position = position;
        try {
            this.texture = TextureManager.getTextures(TextureAtlas.STONE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("STONE BLOCK |TEXTURE ID : "+texture);
    }

    /*
    *
    *       3---2
    *       |   |
    *       0---1
    *
    */

    public void render(){
        bind();
        //SOUTH
        glTexCoord2f(0,0); glVertex3f(0+this.getX(), 0+this.getY(), 0+this.getZ());
        glTexCoord2f(1,0); glVertex3f(1+this.getX(), 0+this.getY(), 0+this.getZ());
        glTexCoord2f(1,1); glVertex3f(1+this.getX(), 1+this.getY(), 0+this.getZ());
        glTexCoord2f(0,1); glVertex3f(0+this.getX(), 1+this.getY(), 0+this.getZ());
        //NORTH
        glTexCoord2f(0,0); glVertex3f(1+this.getX(), 0+this.getY(), -1+this.getZ());
        glTexCoord2f(1,0); glVertex3f(0+this.getX(), 0+this.getY(), -1+this.getZ());
        glTexCoord2f(1,1); glVertex3f(0+this.getX(), 1+this.getY(), -1+this.getZ());
        glTexCoord2f(0,1); glVertex3f(1+this.getX(), 1+this.getY(), -1+this.getZ());
        //TOP
        glTexCoord2f(0,0); glVertex3f(0+this.getX(), 1+this.getY(), 0+this.getZ());
        glTexCoord2f(1,0); glVertex3f(1+this.getX(), 1+this.getY(), 0+this.getZ());
        glTexCoord2f(1,1); glVertex3f(1+this.getX(), 1+this.getY(), -1+this.getZ());
        glTexCoord2f(0,1); glVertex3f(0+this.getX(), 1+this.getY(), -1+this.getZ());
        //BOTTOM
        glTexCoord2f(0,0); glVertex3f(0+this.getX(), 0+this.getY(), -1+this.getZ());
        glTexCoord2f(1,0); glVertex3f(1+this.getX(), 0+this.getY(), -1+this.getZ());
        glTexCoord2f(1,1); glVertex3f(1+this.getX(), 0+this.getY(), 0+this.getZ());
        glTexCoord2f(0,1); glVertex3f(0+this.getX(), 0+this.getY(), 0+this.getZ());
        //EAST
        glTexCoord2f(0,0); glVertex3f(1+this.getX(), 0+this.getY(), 0+this.getZ());
        glTexCoord2f(1,0); glVertex3f(1+this.getX(), 0+this.getY(), -1+this.getZ());
        glTexCoord2f(1,1); glVertex3f(1+this.getX(), 1+this.getY(), -1+this.getZ());
        glTexCoord2f(0,1); glVertex3f(1+this.getX(), 1+this.getY(), 0+this.getZ());
        //WEST
        glTexCoord2f(0,0); glVertex3f(0+this.getX(), 0+this.getY(), -1+this.getZ());
        glTexCoord2f(1,0); glVertex3f(0+this.getX(), 0+this.getY(), 0+this.getZ());
        glTexCoord2f(1,1); glVertex3f(0+this.getX(), 1+this.getY(), 0+this.getZ());
        glTexCoord2f(0,1); glVertex3f(0+this.getX(), 1+this.getY(), -1+this.getZ());
    }

    public Vector3f getPosition() {
        return position;
    }
    
    public float getX(){
        return this.position.getX();
    }

    public float getY(){
        return this.position.getY();
    }

    public float getZ(){
        return this.position.getZ();
    }

    private void bind(){
        glBindTexture(GL_TEXTURE_2D,texture);
    }
}
