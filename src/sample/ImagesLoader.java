package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static sample.BlockType.*;

public class ImagesLoader {

    public static ObservableList<String> imagesName = FXCollections.observableArrayList(

            BLOCK_FOR_TEST.getBlockName(),
            DIRT_FOR_TEST.getBlockName(),
            SKY_FOR_TEST.getBlockName());


    public Image ImageLoader(BlockType val){
        return getImage(val);
    }
    //"
    private Image getImage(BlockType val) {
        Image image = null;
        try {
            image = new Image(new FileInputStream("res/Images/" + val.getBlockName() + ".png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return image;
    }

    public BlockType stringToBlockType(String name){
        if (name.equals(BLOCK_FOR_TEST.getBlockName())) return BLOCK_FOR_TEST;
        else if (name.equals(SKY_FOR_TEST.getBlockName())){
            return SKY_FOR_TEST;
        }else if (name.equals(DIRT_FOR_TEST.getBlockName())){
            return DIRT_FOR_TEST;
        }
        else return BLOCK_FOR_TEST;

    }
}
