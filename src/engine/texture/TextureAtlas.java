package engine.texture;

public enum TextureAtlas {

    NONE(0,0),
    STONE(1,0),
    DIRT(2,0),
    LOG(4,1),
    LOG_TOP(5,1);

    private int x;
    private int y;
    TextureAtlas(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
