package engine.render;

import static org.lwjgl.opengl.GL11.*;

import engine.math.Vector3f;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.glu.GLU;

public class Camera {

    private float fov;
    private float zNear;
    private float zFar;
    private Vector3f position;
    private Vector3f rotation;

    public Camera(Vector3f position){
        this.position = position;
        this.rotation = new Vector3f();
    }

    public Vector3f getRight(){
        Vector3f r = new Vector3f();
        Vector3f rot = new Vector3f(rotation);

        float cosY = (float) Math.cos(Math.toRadians(rot.getY()));
        float sinY = (float) Math.sin(Math.toRadians(rot.getY()));

        r.setX(cosY);
        r.setZ(sinY);

        return r;
    }

    public Vector3f getForward(){
        Vector3f r = new Vector3f();
        Vector3f rot = new Vector3f(rotation);

        float cosY = (float) Math.cos(Math.toRadians(rot.getY() + 90));
        float sinY = (float) Math.sin(Math.toRadians(rot.getY() + 90));
        float cosP = (float) Math.cos(Math.toRadians(rot.getX()));
        float sinP = (float) Math.sin(Math.toRadians(rot.getX()));

        r.setX(cosY*cosP);
        r.setY(sinP);
        r.setZ(sinY*cosP);

        return r;
    }

    public Camera setPerspectiveProjection(float fov, float zNear, float zFar){
        this.fov = fov;
        this.zFar = zFar;
        this.zNear = zNear;

        return this;
    }

    public void getPerspectiveProjection(){
        glEnable(GL_PROJECTION);
        glLoadIdentity();

        GLU.gluPerspective(this.fov, (float)Display.getWidth()/(float)Display.getHeight(),this.zNear,this.zFar);

        glEnable(GL_MODELVIEW);
    }

    public void update(){
        glPushAttrib(GL_TRANSFORM_BIT);
        glRotatef(rotation.getX(),1,0,0);
        glRotatef(rotation.getY(),0,1,0);
        glRotatef(rotation.getZ(),0,0,1);
        glTranslatef(position.getX(), position.getY(),position.getZ());
        glPopMatrix();
    }

    float speed = 1f;

    public void input(){

        rotation.addX(-Mouse.getDY());
        rotation.addY(Mouse.getDX());

        if(rotation.getX() > 90) rotation.setX(90);
        if(rotation.getX() < -90) rotation.setX(-90);

        if(Keyboard.isKeyDown(Keyboard.KEY_Z) || Keyboard.isKeyDown(Keyboard.KEY_W)){
            position.add(getForward().mul(new Vector3f(speed,speed,speed)));
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)){
            position.add(getForward().mul(new Vector3f(-speed,-speed,-speed)));
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_Q)|| Keyboard.isKeyDown(Keyboard.KEY_A)){
            position.add(getRight().mul(new Vector3f(speed,speed,speed)));
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
            position.add(getRight().mul(new Vector3f(-speed,-speed,-speed)));
        }


        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
            position.add(new Vector3f(0,-speed,0));
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
            position.add(new Vector3f(0,speed,0));
        }
    }

    public Vector3f getPosition() {
        return this.position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }
}
