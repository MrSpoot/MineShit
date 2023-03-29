package game.object;

import engine.math.Vector3f;
import game.object.utils.Face;
import java.util.ArrayList;

public abstract class Block {

    private Vector3f position;

    public abstract void render();

    public abstract float getX();

    public abstract float getY();

    public abstract float getZ();

    public abstract Vector3f getPosition();

    public abstract void setFaceToDisplay(ArrayList<Face> faceToDisplay);

    public abstract boolean isOpaque();

}
