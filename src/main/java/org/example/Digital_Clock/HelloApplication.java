package org.example.Digital_Clock;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class HelloApplication extends Application {
    final double SCREEN_HEIGHT = Screen.getPrimary().getVisualBounds().getHeight();
    final double SCREEN_WIDTH = Screen.getPrimary().getVisualBounds().getWidth();
    private Text getDesignedText() {
        TextBuilder digital_text = new TextBuilder();
        digital_text.setText("DIGITAL CLOCK");
        digital_text.setColor(Color.rgb(0,253,82));
        digital_text.setFont("Bernard",40);
        digital_text.setUnderline(true);
        digital_text.setXRatio(0.5).setYRatio(0.15);
        return digital_text.getResult();
    }

    private Text getCurrentTimeStampText() {
        TextBuilder currentTimeStamp = new TextBuilder();
        LocalTime currentLocalTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String currentTimeText = currentLocalTime.format(formatter);
        currentTimeStamp.setText(currentTimeText).setColor(Color.rgb(255,0,0)).setFont("Times New Roman", 80).
                setXRatio(0.5).setYRatio(0.5);
        return currentTimeStamp.getResult();
    }

    private Text getCurrentDateText() {
        TextBuilder currentDate = new TextBuilder();
        LocalDate currentLocalDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String currentDateText = currentLocalDate.format(formatter);
        currentDate.setText(currentDateText).setFont("Times New Roman", 90).setColor(Color.BLACK).setXRatio(0.5).setYRatio(0.7);
        return currentDate.getResult();
    }

    private ImageView getImageView() {
        Image image = new Image("chibi_vita.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setSmooth(true);
        imageView.setPreserveRatio(true);
        imageView.setX(680);
        imageView.setY(160);
        imageView.setFitWidth(160);
        imageView.setFitHeight(160);
        return imageView;
    }
    public Group getDesignedGroup() {
        Group group = new Group();
        Text title = getDesignedText();
        ImageView vita = getImageView();
        Text digital_clock = getCurrentTimeStampText();
        Text date = getCurrentDateText();
        group.getChildren().addAll(title,vita,digital_clock,date);
        return group;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group group = getDesignedGroup();
        Scene scene = new Scene(group);
        scene.setFill(Color.rgb(0,148,253));
        stage.setHeight(SCREEN_HEIGHT);
        stage.setWidth(SCREEN_WIDTH);
        stage.setScene(scene);
        Timer timer = new Timer();
        TimerTask runningClockTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    Text currentTimeStamp = getCurrentTimeStampText();
                    Text date = getCurrentDateText();
                    group.getChildren().removeLast();
                    group.getChildren().removeLast();
                    group.getChildren().add(currentTimeStamp);
                    group.getChildren().add(date);
                });
            }
        };
        timer.scheduleAtFixedRate(runningClockTask,0,1000);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}