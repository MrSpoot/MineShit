package game.object;

import engine.math.Vector3f;
import engine.render.Camera;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Game {

    private static Thread generationThread;

    private static Camera camera;

    public static void create(){
        camera = new Camera(new Vector3f(7.5f,-68,7.5f));
        camera.setPerspectiveProjection(90.0f,0.1f,1000.0f);
        GenerationEngine.create();
        generationThread = new Thread() {
            public void run() {
                while(true){
                    GenerationEngine.update();
                }
            }
        };

        generationThread.start();
    }

    public static void update(){
        if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) Mouse.setGrabbed(false);
        if(Mouse.isButtonDown(0)) Mouse.setGrabbed(true);
        GenerationEngine.refreshGeneration();
        GenerationEngine.compileRendering();
        if(!Mouse.isGrabbed()) return;
        camera.input();

    }

    public static void render(){
        camera.getPerspectiveProjection();
        camera.update();
        GenerationEngine.render();
    }

    public static Camera getCamera(){
        return camera;
    }
}
