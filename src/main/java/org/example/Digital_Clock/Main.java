package org.example.Digital_Clock;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Complete");
            }
        };
        timer.scheduleAtFixedRate(timerTask,0,1000);
    }
}
