package engine.texture;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TextureAtlasManager {

    private static String sheetPath = "/texture/texture_sheet.png";

    private static BufferedImage sheet;
    private static final int TEXTURE_RESOLUTION = 128;

    public static void create(){
        try {
            sheet = ImageIO.read(TextureAtlasManager.class.getResource(sheetPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static BufferedImage getTextureImage(TextureAtlas textureName){
        return sheet.getSubimage(textureName.getX()*TEXTURE_RESOLUTION,textureName.getY()*TEXTURE_RESOLUTION,TEXTURE_RESOLUTION,TEXTURE_RESOLUTION);
    }

    public static BufferedImage getTextureImage(String path){
        BufferedImage image = null;
        try {
            image = ImageIO.read(TextureAtlasManager.class.getResource("/texture/"+path+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return image;
    }

}
