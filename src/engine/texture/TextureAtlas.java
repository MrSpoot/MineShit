package engine.texture;

public enum TextureAtlas {

    GRASS_TOP(0,0),
    STONE(1,0),
    DIRT(2,0),
    SAND(2,1),
    GRASS(3,0),
    LOG(4,1),
    LOG_TOP(5,1),
    BEDROCK(1,1),
    OAK_LEAVES(4,3),
    TEST(14,0);


    private final int x;
    private final int y;

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
