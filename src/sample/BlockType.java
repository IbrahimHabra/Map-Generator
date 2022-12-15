package sample;

public enum BlockType {
    BLOCK_FOR_TEST("BlockTest"),
    DIRT_FOR_TEST("DirtTest"),
    SKY_FOR_TEST("SkyTest"),
    NULL("null");

    String blockName;

    BlockType(String blockNameAsText) {
        this.blockName = blockNameAsText;
    }

    public String getBlockName(){
        return blockName;
    }
    }
