package game.object.gen.structure;

import engine.math.Vector3f;
import game.object.Block;
import game.object.gen.block.Bedrock;
import game.object.gen.block.OakLog;

public class Tree {

    private Block[][][] blocks;
    private Vector3f origin;

    public Tree(Vector3f origin){
        this.origin = origin;
        this.blocks = new Block[5][6][5];
        generate();
    }

    public Block[][][] getBlocks() {
        return blocks;
    }

    private void generate(){
        this.blocks[0][1][0] = new OakLog(new Vector3f(origin.getX()+0,origin.getY()+1,origin.getZ()+0));
        this.blocks[0][2][0] = new OakLog(new Vector3f(origin.getX()+0,origin.getY()+2,origin.getZ()+0));
        this.blocks[0][3][0] = new OakLog(new Vector3f(origin.getX()+0,origin.getY()+3,origin.getZ()+0));
        this.blocks[0][4][0] = new OakLog(new Vector3f(origin.getX()+0,origin.getY()+4,origin.getZ()+0));
        this.blocks[0][5][0] = new OakLog(new Vector3f(origin.getX()+0,origin.getY()+5,origin.getZ()+0));
    }





}
