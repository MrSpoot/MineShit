package game.object.gen.block;

import engine.math.Vector3f;
import game.object.Block;
import game.object.utils.Face;

import java.util.ArrayList;

public class Air extends Block {

    private Vector3f position;
    private boolean isOpaque = false;

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

    @Override
    public void setFaceToDisplay(ArrayList<Face> faceToDisplay) {
        //DO NOTHING
    }
    @Override
    public ArrayList<Face> getFaceToDisplay() {
        return new ArrayList<>();
    }
    @Override
    public boolean isOpaque() {
        return false;
    }
}
