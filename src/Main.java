import engine.texture.Texture;
import game.object.Game;
import org.lwjgl.opengl.Display;
import engine.render.DisplayManager;

import static org.lwjgl.opengl.GL11.*;

public class Main {

    private static final float MAX_FRAME_RATE = 500;
    private static final float MAX_TICKS_RATE = 60;
    private boolean running = false;

    public Main(){
        DisplayManager.create(1600,900,"Mineshit");
    }

    public void start(){
        System.out.println("GAME STARTED");
        this.running = true;
        loadAsset();
        Game.create();
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
                System.out.println(ticks + "ticks, "+ frames + " fps");
                ticks = 0;
                frames = 0;
            }
        }
        exit();
    }

    public void update(){
        Game.update();
    }

    public void render(){
        if(Display.wasResized()){
            glViewport(0,0,Display.getWidth(),Display.getHeight());
        }
        DisplayManager.clearBuffers();
        Game.render();
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