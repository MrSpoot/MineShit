package engine.texture;

import java.util.ArrayList;
import java.util.Optional;

public class TextureManager {

    private static ArrayList<Texture> textures = new ArrayList<>();

    public static void loadNewTexture(Texture texture){
        textures.add(texture);
    }

    public static int getTextures(TextureAtlas textureName) throws Exception {
       Optional<Texture> t = textures.stream().filter(texture -> texture.getName().equals(textureName)).findFirst();

       if(t.isPresent()){
           return t.get().getId();
       }else{
           throw new Exception();
       }
    }

    public static ArrayList<Texture> getTextures() {
        return textures;
    }
}
