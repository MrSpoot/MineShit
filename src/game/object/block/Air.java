package game.object.block;

import engine.math.Vector3f;
import engine.texture.TextureAtlas;
import engine.texture.TextureAtlasManager;
import game.object.Block;

import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex3f;

public class Air extends Block {

    private Vector3f position;

    private final TextureAtlas texureName = TextureAtlas.NONE;

    public Air(){this(new Vector3f(0,0,0));}

    public Air(Vector3f position) {
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
      //SPECIAL BLOCK WITHOUT RENDER
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
