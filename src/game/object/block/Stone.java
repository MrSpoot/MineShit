package game.object.block;

import engine.math.Vector3f;
import engine.texture.TextureAtlas;
import engine.texture.TextureAtlasManager;
import game.object.Block;
import org.w3c.dom.Text;

import static org.lwjgl.opengl.GL11.*;

public class Stone extends Block {

    private Vector3f position;

    private final TextureAtlas texureName = TextureAtlas.STONE;

    public Stone(){this(new Vector3f(0,0,0));}

    public Stone(Vector3f position) {
        this.position = position;
    }

    /*
    *
    *       3---2
    *       |   |
    *       0---1
    *
    */

    public void render(){

        float[] textureCord = TextureAtlasManager.getTextureCoordinate(texureName);

        //SOUTH
        glTexCoord2f(textureCord[0],textureCord[1]); glVertex3f(0+this.getX(), 0+this.getY(), 0+this.getZ());
        glTexCoord2f(textureCord[2],textureCord[3]); glVertex3f(1+this.getX(), 0+this.getY(), 0+this.getZ());
        glTexCoord2f(textureCord[4],textureCord[5]); glVertex3f(1+this.getX(), 1+this.getY(), 0+this.getZ());
        glTexCoord2f(textureCord[6],textureCord[7]); glVertex3f(0+this.getX(), 1+this.getY(), 0+this.getZ());
        //NORTH
        glTexCoord2f(textureCord[0],textureCord[1]); glVertex3f(1+this.getX(), 0+this.getY(), -1+this.getZ());
        glTexCoord2f(textureCord[2],textureCord[3]); glVertex3f(0+this.getX(), 0+this.getY(), -1+this.getZ());
        glTexCoord2f(textureCord[4],textureCord[5]); glVertex3f(0+this.getX(), 1+this.getY(), -1+this.getZ());
        glTexCoord2f(textureCord[6],textureCord[7]); glVertex3f(1+this.getX(), 1+this.getY(), -1+this.getZ());
        //TOP
        glTexCoord2f(textureCord[0],textureCord[1]); glVertex3f(0+this.getX(), 1+this.getY(), 0+this.getZ());
        glTexCoord2f(textureCord[2],textureCord[3]); glVertex3f(1+this.getX(), 1+this.getY(), 0+this.getZ());
        glTexCoord2f(textureCord[4],textureCord[5]); glVertex3f(1+this.getX(), 1+this.getY(), -1+this.getZ());
        glTexCoord2f(textureCord[6],textureCord[7]); glVertex3f(0+this.getX(), 1+this.getY(), -1+this.getZ());
        //BOTTOM
        glTexCoord2f(textureCord[0],textureCord[1]); glVertex3f(0+this.getX(), 0+this.getY(), -1+this.getZ());
        glTexCoord2f(textureCord[2],textureCord[3]); glVertex3f(1+this.getX(), 0+this.getY(), -1+this.getZ());
        glTexCoord2f(textureCord[4],textureCord[5]); glVertex3f(1+this.getX(), 0+this.getY(), 0+this.getZ());
        glTexCoord2f(textureCord[6],textureCord[7]); glVertex3f(0+this.getX(), 0+this.getY(), 0+this.getZ());
        //EAST
        glTexCoord2f(textureCord[0],textureCord[1]); glVertex3f(1+this.getX(), 0+this.getY(), 0+this.getZ());
        glTexCoord2f(textureCord[2],textureCord[3]); glVertex3f(1+this.getX(), 0+this.getY(), -1+this.getZ());
        glTexCoord2f(textureCord[4],textureCord[5]); glVertex3f(1+this.getX(), 1+this.getY(), -1+this.getZ());
        glTexCoord2f(textureCord[6],textureCord[7]); glVertex3f(1+this.getX(), 1+this.getY(), 0+this.getZ());
        //WEST
        glTexCoord2f(textureCord[0],textureCord[1]); glVertex3f(0+this.getX(), 0+this.getY(), -1+this.getZ());
        glTexCoord2f(textureCord[2],textureCord[3]); glVertex3f(0+this.getX(), 0+this.getY(), 0+this.getZ());
        glTexCoord2f(textureCord[4],textureCord[5]); glVertex3f(0+this.getX(), 1+this.getY(), 0+this.getZ());
        glTexCoord2f(textureCord[6],textureCord[7]); glVertex3f(0+this.getX(), 1+this.getY(), -1+this.getZ());
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
}
