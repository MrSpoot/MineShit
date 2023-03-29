package game.object.utils;

import engine.math.Vector3f;
import game.object.gen.Chunk;
import game.object.gen.World;

import java.util.ArrayList;
import java.util.List;

public class WorldUtils {

    private static Chunk eastChunk = null;
    private static Chunk westChunk = null;
    private static Chunk northChunk = null;
    private static Chunk southChunk = null;

    public static ArrayList<Face> getFaceToDisplay(Vector3f position, Chunk chunk){
        ArrayList<Face> faceToDisplay = new ArrayList<>(List.of(Face.values()));

        int xLength = chunk.getMAX_SIZE();
        int yLength = chunk.getMAX_HEIGHT();
        int zLength = chunk.getMAX_SIZE();

        float relativeXToChunk = position.getX()-chunk.getPosition().getX();
        float relativeYToChunk = position.getY()-chunk.getPosition().getY();
        float relativeZToChunk = position.getZ()-chunk.getPosition().getZ();

        if(relativeXToChunk-1 < 0){
              if(eastChunk == null ||
                      !(eastChunk.getPosition().getX()-chunk.getMAX_SIZE() == chunk.getPosition().getX() && eastChunk.getPosition().getZ() == chunk.getPosition().getZ())){
                  for(Chunk c : World.getWorld()){
                      if(c.getPosition().getX()-chunk.getMAX_SIZE() == chunk.getPosition().getX() && c.getPosition().getZ() == chunk.getPosition().getZ()){
                          eastChunk = c;
                          break;
                      }
                  }
                  if(eastChunk != null){
                      if(eastChunk.getBlocks()[15][(int) relativeYToChunk][(int) relativeZToChunk] != null &&
                              eastChunk.getBlocks()[15][(int) relativeYToChunk][(int) relativeZToChunk].isOpaque()){
                          faceToDisplay.remove(Face.WEST);
                      }
                  }
              }
        }
        if(relativeXToChunk+1 >= xLength){
            if(westChunk == null ||
                    !(westChunk.getPosition().getX()+chunk.getMAX_SIZE() == chunk.getPosition().getX() && westChunk.getPosition().getZ() == chunk.getPosition().getZ())){
                for(Chunk c : World.getWorld()){
                    if(c.getPosition().getX()+chunk.getMAX_SIZE() == chunk.getPosition().getX() && c.getPosition().getZ() == chunk.getPosition().getZ()){
                        westChunk = c;
                        break;
                    }
                }
                if(westChunk != null){
                    if(westChunk.getBlocks()[0][(int) relativeYToChunk][(int) relativeZToChunk] != null &&
                            westChunk.getBlocks()[0][(int) relativeYToChunk][(int) relativeZToChunk].isOpaque()){
                        faceToDisplay.remove(Face.EAST);
                    }
                }
            }
        }
        if(relativeZToChunk-1 < 0){
            if(northChunk == null ||
                    !(northChunk.getPosition().getX() == chunk.getPosition().getX() && northChunk.getPosition().getZ()-chunk.getMAX_SIZE() == chunk.getPosition().getZ())){

                for(Chunk c : World.getWorld()){
                    if(c.getPosition().getX() == chunk.getPosition().getX() && c.getPosition().getZ()-chunk.getMAX_SIZE() == chunk.getPosition().getZ()){
                        northChunk = c;
                        break;
                    }
                }
                if(northChunk != null){
                    if(northChunk.getBlocks()[(int) relativeXToChunk][(int) relativeYToChunk][15] != null &&
                            northChunk.getBlocks()[(int) relativeXToChunk][(int) relativeYToChunk][15].isOpaque()){
                        System.out.println("NORTH");
                        faceToDisplay.remove(Face.NORTH);
                    }
                }
            }
        }
        if(relativeZToChunk+1 >= zLength){
            if(southChunk == null ||
                    !(southChunk.getPosition().getX() == chunk.getPosition().getX() && southChunk.getPosition().getZ()+chunk.getMAX_SIZE() == chunk.getPosition().getZ())){
                for(Chunk c : World.getWorld()){
                    if(c.getPosition().getX() == chunk.getPosition().getX() && c.getPosition().getZ()+chunk.getMAX_SIZE() == chunk.getPosition().getZ()){
                        southChunk = c;
                        break;
                    }
                }
                if(southChunk != null){
                    System.out.println("SOUTH 1");
                  if(southChunk.getBlocks()[(int) relativeXToChunk][(int) relativeYToChunk][0] != null &&
                          southChunk.getBlocks()[(int) relativeXToChunk][(int) relativeYToChunk][0].isOpaque()){
                      System.out.println("SOUTH 2");
                      faceToDisplay.remove(Face.SOUTH);
                  }
                }
            }
        }

        if(relativeXToChunk-1 >= 0 &&
                chunk.getBlocks()[(int) relativeXToChunk-1][(int) relativeYToChunk][(int) relativeZToChunk] != null &&
                chunk.getBlocks()[(int) relativeXToChunk-1][(int) relativeYToChunk][(int) relativeZToChunk].isOpaque()){
            faceToDisplay.remove(Face.WEST);
        }
        if(relativeXToChunk+1 < xLength &&
                chunk.getBlocks()[(int) relativeXToChunk+1][(int) relativeYToChunk][(int) relativeZToChunk] != null &&
                chunk.getBlocks()[(int) relativeXToChunk+1][(int) relativeYToChunk][(int) relativeZToChunk].isOpaque()){
           faceToDisplay.remove(Face.EAST);
        }
        if(relativeYToChunk-1 >= 0 &&
                chunk.getBlocks()[(int) relativeXToChunk][(int) relativeYToChunk-1][(int) relativeZToChunk] != null &&
                chunk.getBlocks()[(int) relativeXToChunk][(int) relativeYToChunk-1][(int) relativeZToChunk].isOpaque()){
            faceToDisplay.remove(Face.BOTTOM);
        }
        if(relativeYToChunk+1 < yLength &&
                chunk.getBlocks()[(int) relativeXToChunk][(int) relativeYToChunk+1][(int) relativeZToChunk] != null &&
                chunk.getBlocks()[(int) relativeXToChunk][(int) relativeYToChunk+1][(int) relativeZToChunk].isOpaque()){
            faceToDisplay.remove(Face.TOP);
        }
        if(relativeZToChunk-1 >= 0 &&
                chunk.getBlocks()[(int) relativeXToChunk][(int) relativeYToChunk][(int) relativeZToChunk-1] != null &&
                chunk.getBlocks()[(int) relativeXToChunk][(int) relativeYToChunk][(int) relativeZToChunk-1].isOpaque()){
            faceToDisplay.remove(Face.NORTH);
        }
        if(relativeZToChunk+1 < zLength &&
                chunk.getBlocks()[(int) relativeXToChunk][(int) relativeYToChunk][(int) relativeZToChunk+1] != null &&
                chunk.getBlocks()[(int) relativeXToChunk][(int) relativeYToChunk][(int) relativeZToChunk+1].isOpaque()){
            faceToDisplay.remove(Face.SOUTH);
        }

        return faceToDisplay;
    }

}
