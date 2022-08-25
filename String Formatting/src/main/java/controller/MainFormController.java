package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.NumberFormat;

public class MainFormController {
    public Label lblOutput;
    public TextField txtInput;
    public Button btnFormat;
    public TextField txtInput2;
    public Button btnFormat2;

    public void txtInputOnAction(ActionEvent actionEvent) {
        btnFormat.fire();
    }

    public void btnFormatOnAction(ActionEvent actionEvent) {
        lblOutput.setText("NOTHING TO FORMAT");
        String input = txtInput.getText();
        if (input.isBlank()){
            new Alert(Alert.AlertType.ERROR, "Input can't be empty").show();
            txtInput.requestFocus();
            return;
        }else if(!input.matches("^[+-]?\\d+([.]\\d+)?$")){
            new Alert(Alert.AlertType.ERROR, "Invalid number").show();
            txtInput.requestFocus();
            return;
        }
//        NumberFormat ni = NumberFormat.getNumberInstance();
//        ni.setGroupingUsed(true);
//        ni.setMaximumFractionDigits(2);
//        ni.setMinimumFractionDigits(2);
//        String formattedText = ni.format(Double.parseDouble(txtInput.getText()));
        lblOutput.setText(String.format("%,.2f", Double.parseDouble(txtInput.getText())));
        txtInput.requestFocus();
        txtInput.selectAll();
    }

    public void btnFormat2OnAction(ActionEvent actionEvent) {
        lblOutput.setText("NOTHING TO FORMAT");
        String input = txtInput2.getText();
        if (input.isBlank()){
            new Alert(Alert.AlertType.ERROR, "Input can't be empty").show();
            txtInput2.requestFocus();
            return;
        }else if(!input.matches("^[+]?\\d+$")){
            new Alert(Alert.AlertType.ERROR, "Invalid positive integer").show();
            txtInput2.requestFocus();
            return;
        }
//        NumberFormat ii = NumberFormat.getIntegerInstance();
//        ii.setGroupingUsed(false);
//        ii.setMinimumIntegerDigits(4);
//        String formattedText = ii.format(Integer.parseInt(txtInput2.getText()));
//        lblOutput.setText("E" + formattedText);
        lblOutput.setText(String.format("E%04d", Integer.parseInt(txtInput2.getText())));
        txtInput2.requestFocus();
        txtInput2.selectAll();
    }

    public void txtInput2OnAction(ActionEvent actionEvent) {
        btnFormat2.fire();
    }
}
