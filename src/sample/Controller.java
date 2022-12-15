package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public ListView<String> listView;
    Timeline timeline = new Timeline();
    public static int squareSize = 50;
    public AnchorPane root;
    public Canvas canvas;
    GraphicsContext gc;
    ImagesLoader loader = new ImagesLoader();





    Rectangle rectangle = new Rectangle(squareSize,squareSize);
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setItems(ImagesLoader.imagesName);
        gc = canvas.getGraphicsContext2D();
        rectangle.setLayoutX(-squareSize);
        rectangle.setLayoutY(-squareSize);
        root.getChildren().add(rectangle);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(0.1),event -> {
            draw(gc);
        }));
        timeline.setCycleCount(-1);
        timeline.play();



    }

    public void squareMove(MouseEvent mouseEvent) {
        rectangle.setLayoutX(((int) mouseEvent.getX()/ squareSize) *squareSize);
        rectangle.setLayoutY(((int) mouseEvent.getY()/ squareSize) *squareSize);
        root.setPrefWidth(3000);
        root.setPrefHeight(3000);
        canvas.setHeight(root.getHeight());
        canvas.setWidth(root.getWidth());
    }

    private void draw(GraphicsContext gc){

    }

    public void setBlock(MouseEvent mouseEvent) {
        gc.drawImage(loader.ImageLoader(loader.stringToBlockType(listView.getSelectionModel().getSelectedItem()
        )),rectangle.getLayoutX(),rectangle.getLayoutY(),squareSize,squareSize);
    }

    public void genrate(ActionEvent actionEvent) {
    }

    public void toDown(ActionEvent actionEvent) {
    }

    public void toUp(ActionEvent actionEvent) {
    }

    public void toLift(ActionEvent actionEvent) {
    }

    public void toRight(ActionEvent actionEvent) {
    }
}
