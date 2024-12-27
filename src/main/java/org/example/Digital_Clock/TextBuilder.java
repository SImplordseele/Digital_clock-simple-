package org.example.Digital_Clock;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class TextBuilder {
    Text text = new Text();
    final double SCREEN_HEIGHT = Screen.getPrimary().getVisualBounds().getHeight();
    final double SCREEN_WIDTH = Screen.getPrimary().getVisualBounds().getWidth();
    private boolean checkTextIsEmpty() {
        return text.getText() != null;
    }

    public TextBuilder setText(String string) {
        if(checkTextIsEmpty()) {
            text.setText(string);
        }
        return this;
    }
    public TextBuilder setFont(String fontstyle, int size) {
        if (checkTextIsEmpty()) {
            text.setFont(Font.font(fontstyle,size));
        }
        return this;
    }

    public TextBuilder setColor(Color color) {
        if (checkTextIsEmpty()) {
            text.setFill(color);
        }
        return this;
    }

    public TextBuilder setUnderline(Boolean string) {
        if (checkTextIsEmpty()) {
            text.setUnderline(string);
        }
        return this;
    }

    public TextBuilder setXRatio(double ratio) {
        if (checkTextIsEmpty()) {
            double textWidth = text.getBoundsInLocal().getWidth();
            text.setX((SCREEN_WIDTH - textWidth) * ratio);
        }
        return this;
    }

    public TextBuilder setYRatio(double ratio) {
        if (checkTextIsEmpty()) {
            double textHeight = text.getBoundsInLocal().getHeight();
            text.setY((SCREEN_HEIGHT - textHeight) * ratio);
        }
        return this;
    }

    public Text getResult() {
        return text;
    }
}
