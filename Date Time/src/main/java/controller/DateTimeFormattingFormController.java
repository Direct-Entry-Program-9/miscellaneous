package controller;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Label;

import java.util.Date;

public class DateTimeFormattingFormController {
    public Label lblDate;
    public Label lblTime;
    public Label lblDay;

    public void initialize(){
        lblDay.setText(String.format("%tA", new Date()));
        lblDate.setText(String.format("%1$tY-%1$tB-%1$td", new Date()));
        Task<String> task = new Task<>() {
            @Override
            protected String call() throws Exception {
                while(true){
                    Thread.sleep(500);
                    updateValue(String.format("%tT \n", new Date()));
                }
            }
        };
        lblTime.textProperty().bind(task.valueProperty());
        new Thread(task).start();
    }
}
