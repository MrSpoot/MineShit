package engine.texture;

import org.lwjgl.BufferUtils;
import java.awt.image.BufferedImage;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.*;

public class Texture {

    private int id;
    private TextureAtlas name;
    private int width,height;

    public Texture(TextureAtlas name, int filter) {
        this.name = name;

        BufferedImage image = TextureAtlasManager.getTextureImage(name);
        int[] pixels = null;

            this.width = image.getWidth();
            this.height = image.getHeight();
            pixels = new int[width*height];
            image.getRGB(0,0,width,height,pixels,0,width);

        int[] data = new int[width*height];
        for(int i = 0; i < data.length; i++){

            int a = (pixels[i] & 0xff000000) >> 24;
            int r = (pixels[i] & 0xff0000) >> 16;
            int g = (pixels[i] & 0xff00) >> 8;
            int b = (pixels[i] & 0xff);

            data[i] = a << 24 | b << 16 | g << 8 | r;
        }

        int id = glGenTextures();
        //glBindTexture(GL_TEXTURE_2D,id);
        glTexParameteri(GL_TEXTURE_2D,GL_TEXTURE_MIN_FILTER,filter);
        glTexParameteri(GL_TEXTURE_2D,GL_TEXTURE_MAG_FILTER,filter);
        IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        glTexImage2D(GL_TEXTURE_2D,0,GL_RGBA,width,height,0,GL_RGBA,GL_UNSIGNED_BYTE, buffer);
        this.id = id;
    }

    public TextureAtlas getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
