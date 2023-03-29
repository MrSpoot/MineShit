package game.object.utils;

import engine.math.Vector3f;
import game.object.gen.Chunk;

import java.util.ArrayList;
import java.util.List;

public class WorldUtils {

    public static ArrayList<Face> getFaceToDisplay(Vector3f position, Chunk chunk){
        ArrayList<Face> faceToDisplay = new ArrayList<>(List.of(Face.values()));

        int xLength = chunk.getMAX_SIZE();
        int yLength = chunk.getMAX_HEIGHT();
        int zLength = chunk.getMAX_SIZE();

        float relativeXToChunk = position.getX()-chunk.getPosition().getX();
        float relativeYToChunk = position.getY()-chunk.getPosition().getY();
        float relativeZToChunk = position.getZ()-chunk.getPosition().getZ();

        if(relativeXToChunk-1 >= 0 && chunk.getBlocks()[(int) relativeXToChunk-1][(int) relativeYToChunk][(int) relativeZToChunk] != null && chunk.getBlocks()[(int) relativeXToChunk-1][(int) relativeYToChunk][(int) relativeZToChunk].isOpaque()){
            faceToDisplay.remove(Face.WEST);
        }
        if(relativeXToChunk+1 < xLength && chunk.getBlocks()[(int) relativeXToChunk+1][(int) relativeYToChunk][(int) relativeZToChunk] != null && chunk.getBlocks()[(int) relativeXToChunk+1][(int) relativeYToChunk][(int) relativeZToChunk].isOpaque()){
           faceToDisplay.remove(Face.EAST);
        }
        if(relativeYToChunk-1 >= 0 && chunk.getBlocks()[(int) relativeXToChunk][(int) relativeYToChunk-1][(int) relativeZToChunk] != null && chunk.getBlocks()[(int) relativeXToChunk][(int) relativeYToChunk-1][(int) relativeZToChunk].isOpaque()){
            faceToDisplay.remove(Face.BOTTOM);
        }
        if(relativeYToChunk+1 < yLength && chunk.getBlocks()[(int) relativeXToChunk][(int) relativeYToChunk+1][(int) relativeZToChunk] != null && chunk.getBlocks()[(int) relativeXToChunk][(int) relativeYToChunk+1][(int) relativeZToChunk].isOpaque()){
            faceToDisplay.remove(Face.TOP);
        }
        if(relativeZToChunk-1 >= 0 && chunk.getBlocks()[(int) relativeXToChunk][(int) relativeYToChunk][(int) relativeZToChunk-1] != null && chunk.getBlocks()[(int) relativeXToChunk][(int) relativeYToChunk][(int) relativeZToChunk-1].isOpaque()){
            faceToDisplay.remove(Face.NORTH);
        }
        if(relativeZToChunk+1 < zLength && chunk.getBlocks()[(int) relativeXToChunk][(int) relativeYToChunk][(int) relativeZToChunk+1] != null && chunk.getBlocks()[(int) relativeXToChunk][(int) relativeYToChunk][(int) relativeZToChunk+1].isOpaque()){
            faceToDisplay.remove(Face.SOUTH);
        }

        return faceToDisplay;
    }

}
