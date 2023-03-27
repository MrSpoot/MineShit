
import engine.math.Vector3f;
import engine.texture.Texture;
import engine.texture.TextureAtlas;
import engine.texture.TextureAtlasManager;
import game.object.Game;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import engine.render.Camera;
import engine.render.DisplayManager;

import static org.lwjgl.opengl.GL11.*;

public class Main {

    private static final float MAX_FRAME_RATE = 500;
    private static final float MAX_TICKS_RATE = 60;
    private boolean running = false;
    private Camera camera;

    private Game game;

    public Main(){
        DisplayManager.create(1600,900,"Oui Oui Baguette");
        camera = new Camera(new Vector3f(0,-66,0));
        camera.setPerspectiveProjection(90.0f,0.1f,1000.0f);
    }

    public void start(){
        System.out.println("GAME STARTED");
        this.running = true;
        loadAsset();
        this.game = new Game();

        loop();
    }

    public void stop(){
        this.running = false;
    }

    public void loop(){

        long lastTickTime = System.nanoTime();
        long lastRenderTime = System.nanoTime();

        double tickTime = 1000000000.0/MAX_TICKS_RATE;
        double renderTime = 1000000000.0/MAX_FRAME_RATE;

        int ticks = 0;
        int frames = 0;

        long timer = System.currentTimeMillis();

        while(running){
            if(DisplayManager.isClosed()){
                stop();
            }
            if(System.nanoTime() - lastTickTime > tickTime){
                update();
                ticks++;
                lastTickTime += tickTime;
            }
            if(System.nanoTime() - lastRenderTime > renderTime){
                render();
                DisplayManager.update();
                frames++;
                lastRenderTime += renderTime;
            }else{
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println(ticks + "ticks, "+ frames + " fps");
                ticks = 0;
                frames = 0;
            }
        }
        exit();
    }

    public void update(){
        if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) Mouse.setGrabbed(false);
        if(Mouse.isButtonDown(0)) Mouse.setGrabbed(true);
        if(!Mouse.isGrabbed()) return;
        this.camera.input();
    }

    public void render(){
        if(Display.wasResized()){
            glViewport(0,0,Display.getWidth(),Display.getHeight());
        }
        DisplayManager.clearBuffers();
        this.camera.getPerspectiveProjection();
        this.camera.update();

        this.game.render();
    }

    public void exit(){
        DisplayManager.dispose();
        System.exit(0);
    }

    public void loadAsset(){

        Texture.create("/texture/texture_sheet.png",GL_NEAREST);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
}