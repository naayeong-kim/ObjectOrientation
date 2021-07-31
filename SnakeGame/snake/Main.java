/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * The user scores a point if the snake eats food. The snake is attracted by the
 * position of the mouse. The snake dies if it hits the wall or its own tail.
 *
 * @author Nayeong Kim (s1006313)
 */
public class Main extends Application {

    public final static int DELAY = 300; // timer delay in ms
    private boolean running = false;

    private double goalX = (World.SIZE * World.UNIT)/2, goalY = (World.SIZE * World.UNIT)/2;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        VBox textPane  = new VBox();
        Label runningText = new Label("Press 's' to start");
        Label scoreText = new Label("0 points");
        textPane.getChildren().addAll(runningText, scoreText);

        World world = new World(scoreText.textProperty());
        root.setRight(textPane);
        root.setLeft(world);
        Scene scene = new Scene(root);
        
        KeyFrame keyFrame = new KeyFrame( Duration.millis(DELAY), e -> world.step() );
        Timeline timeline  = new Timeline(); 
        timeline.setCycleCount(Timeline.INDEFINITE); 
        timeline.getKeyFrames().add(keyFrame);

        scene.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.S)) {
                running = world.StartOrStop();
                if(running)
                    timeline.play();
                else
                    timeline.pause();
            }
        });

        scene.setOnMouseMoved((MouseEvent e) -> {
            world.redirectSnake(e.getX(), e.getY());
        });
        
        
        if ( world.gameover() ) {
            timeline.pause();
            Label res = new Label("GAME OVER");
            VBox newTextPane  = new VBox();
            newTextPane.getChildren().addAll(runningText, scoreText);
            root.setRight(newTextPane);
        }
        
        primaryStage.setTitle("Snake");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
