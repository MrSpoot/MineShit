package game.object;

public class Game {

    private World world;

    public Game() {
        this.world = new World();
    }

    public void update(){
        this.world.update();
    }

    public void render(){
       this.world.render();
    }
}
