package game.object.gen.block;

import engine.math.Vector3f;
import engine.texture.TextureAtlas;
import engine.texture.TextureAtlasManager;
import game.object.Block;
import game.object.gen.Chunk;
import game.object.gen.World;
import game.object.utils.Face;
import static game.object.utils.WorldUtils.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.lwjgl.opengl.GL11.*;

public class Stone extends Block {

    private Vector3f position;

    private Chunk chunk;
    private final TextureAtlas textureName = TextureAtlas.STONE;

    private final ArrayList<Face> faceToDisplay;

    public Stone(){this(new Vector3f(0,0,0));}

    public Stone(Vector3f position) {
        this.position = position;
        this.faceToDisplay = new ArrayList<>();
        this.faceToDisplay.addAll(List.of(Face.values()));
    }

    /*
    *
    *       3---2
    *       |   |
    *       0---1
    *
    */

    public void render(){

        float[] textureCord = TextureAtlasManager.getTextureCoordinate(textureName);

        if(faceToDisplay.contains(Face.SOUTH)){
            //SOUTH
            glTexCoord2f(textureCord[0],textureCord[1]); glVertex3f(0+this.getX(), 0+this.getY(), 0+this.getZ());
            glTexCoord2f(textureCord[2],textureCord[3]); glVertex3f(1+this.getX(), 0+this.getY(), 0+this.getZ());
            glTexCoord2f(textureCord[4],textureCord[5]); glVertex3f(1+this.getX(), 1+this.getY(), 0+this.getZ());
            glTexCoord2f(textureCord[6],textureCord[7]); glVertex3f(0+this.getX(), 1+this.getY(), 0+this.getZ());
        }
        if(faceToDisplay.contains(Face.NORTH)){
            //NORTH
            glTexCoord2f(textureCord[0],textureCord[1]); glVertex3f(1+this.getX(), 0+this.getY(), -1+this.getZ());
            glTexCoord2f(textureCord[2],textureCord[3]); glVertex3f(0+this.getX(), 0+this.getY(), -1+this.getZ());
            glTexCoord2f(textureCord[4],textureCord[5]); glVertex3f(0+this.getX(), 1+this.getY(), -1+this.getZ());
            glTexCoord2f(textureCord[6],textureCord[7]); glVertex3f(1+this.getX(), 1+this.getY(), -1+this.getZ());
        }
        if(faceToDisplay.contains(Face.TOP)){
            //TOP
            glTexCoord2f(textureCord[0],textureCord[1]); glVertex3f(0+this.getX(), 1+this.getY(), 0+this.getZ());
            glTexCoord2f(textureCord[2],textureCord[3]); glVertex3f(1+this.getX(), 1+this.getY(), 0+this.getZ());
            glTexCoord2f(textureCord[4],textureCord[5]); glVertex3f(1+this.getX(), 1+this.getY(), -1+this.getZ());
            glTexCoord2f(textureCord[6],textureCord[7]); glVertex3f(0+this.getX(), 1+this.getY(), -1+this.getZ());
        }
        if(faceToDisplay.contains(Face.BOTTOM)){
            //BOTTOM
            glTexCoord2f(textureCord[0],textureCord[1]); glVertex3f(0+this.getX(), 0+this.getY(), -1+this.getZ());
            glTexCoord2f(textureCord[2],textureCord[3]); glVertex3f(1+this.getX(), 0+this.getY(), -1+this.getZ());
            glTexCoord2f(textureCord[4],textureCord[5]); glVertex3f(1+this.getX(), 0+this.getY(), 0+this.getZ());
            glTexCoord2f(textureCord[6],textureCord[7]); glVertex3f(0+this.getX(), 0+this.getY(), 0+this.getZ());
        }
        if(faceToDisplay.contains(Face.EAST)){
            //EAST
            glTexCoord2f(textureCord[0],textureCord[1]); glVertex3f(1+this.getX(), 0+this.getY(), 0+this.getZ());
            glTexCoord2f(textureCord[2],textureCord[3]); glVertex3f(1+this.getX(), 0+this.getY(), -1+this.getZ());
            glTexCoord2f(textureCord[4],textureCord[5]); glVertex3f(1+this.getX(), 1+this.getY(), -1+this.getZ());
            glTexCoord2f(textureCord[6],textureCord[7]); glVertex3f(1+this.getX(), 1+this.getY(), 0+this.getZ());
        }
        if(faceToDisplay.contains(Face.WEST)){
            //WEST
            glTexCoord2f(textureCord[0],textureCord[1]); glVertex3f(0+this.getX(), 0+this.getY(), -1+this.getZ());
            glTexCoord2f(textureCord[2],textureCord[3]); glVertex3f(0+this.getX(), 0+this.getY(), 0+this.getZ());
            glTexCoord2f(textureCord[4],textureCord[5]); glVertex3f(0+this.getX(), 1+this.getY(), 0+this.getZ());
            glTexCoord2f(textureCord[6],textureCord[7]); glVertex3f(0+this.getX(), 1+this.getY(), -1+this.getZ());
        }

    }

    @Override
    public void setFaceToDisplay(ArrayList<Face> faceToDisplay){
        this.faceToDisplay.clear();
        this.faceToDisplay.addAll(faceToDisplay);
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

    @Override
    public boolean isOpaque() {
        return true;
    }
}
