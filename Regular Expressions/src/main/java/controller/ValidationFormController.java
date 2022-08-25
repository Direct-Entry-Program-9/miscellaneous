package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ValidationFormController {
    public TextField txtNic;
    public Button btnNiCValidate;
    public TextField txtContact;
    public Button btnContactValidate;
    public TextField txtName;
    public Button btnNameValidate;
    public TextField txtRegistrationNumber;
    public Button btnRegistrationValidate;

    private boolean isInteger(String input){
//        char[] chars = input.toCharArray();
//        for (char aChar : chars) {
//            if (!Character.isDigit(aChar)) return false;
//        }
//        return true;
        return input.matches("\\d+");
    }

    private boolean areUppercaseLettersOnly(String input){
//        char[] chars = input.toCharArray();
//        for (char aChar : chars) {
//            if (!(Character.isUpperCase(aChar) && Character.isLetter(aChar))) return false;
//        }
//        return true;
        return input.matches("[A-Z]+");
    }

    public void txtNicOnAction(ActionEvent actionEvent) {
        btnNiCValidate.fire();
    }

    public void btnNiCValidateOnAction(ActionEvent actionEvent) {
        String nic = txtNic.getText();
//        !nic.isBlank() && nic.length() == 10 && (nic.toUpperCase().endsWith("V")) &&
//                isInteger(nic.substring(0, nic.length() -1))
        if (nic.matches("\\d{3}-\\d{7}")){
            new Alert(Alert.AlertType.INFORMATION, "Valid NIC").show();
        }else{
            new Alert(Alert.AlertType.ERROR, "Invalid NIC").show();
        }
        txtNic.requestFocus();
        txtNic.selectAll();
    }

    public void txtContactOnAction(ActionEvent actionEvent) {
        btnContactValidate.fire();
    }

    public void btnContactValidateOnAction(ActionEvent actionEvent) {
        String contact = txtContact.getText();
//        !contact.isBlank() && contact.length() == 11 && isInteger(contact.substring(0, 3)) &&
//                contact.charAt(3) == '-' && isInteger(contact.substring(4))
        if (contact.matches("\\d{3}-\\d{7}"))  {
            new Alert(Alert.AlertType.INFORMATION, "Valid Contact Number").show();
        }else{
            new Alert(Alert.AlertType.ERROR, "Invalid Contact Number").show();
        }
        txtContact.requestFocus();
        txtContact.selectAll();
    }

    public void txtNameOnAction(ActionEvent actionEvent) {
        btnNameValidate.fire();
    }

    public void btnNameValidateOnAction(ActionEvent actionEvent) {
        String name = txtName.getText();
        boolean isName = name.matches("[A-Za-z ]+");
//        if (!name.isBlank()){
//            isName = true;
//            char[] chars = name.toCharArray();
//            for (char aChar : chars) {
//                if (!(Character.isLetter(aChar) || Character.isSpaceChar(aChar))){
//                    isName = false;
//                    break;
//                }
//            }
//        }
        new Alert(isName? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR,
                isName? "Valid Name": "Invalid Name").show();
        txtName.requestFocus();
        txtName.selectAll();
    }

    public void txtRegistrationNumberOnAction(ActionEvent actionEvent) {
        btnRegistrationValidate.fire();
    }

    public void btnRegistrationValidateOnAction(ActionEvent actionEvent) {
        String regNum = txtRegistrationNumber.getText();
//        !regNum.isBlank() && (regNum.length() == 7 || regNum.length() == 8) &&
//                ((areUppercaseLettersOnly(regNum.substring(0,2)) && regNum.charAt(2) == '-' && isInteger(regNum.substring(3))) ||
//                        (areUppercaseLettersOnly(regNum.substring(0,3)) && regNum.charAt(3) == '-' && isInteger(regNum.substring(4))))
        if (regNum.matches("[A-Z]{2,3}-\\d{4}")){
            new Alert(Alert.AlertType.INFORMATION, "Valid Registration Number").show();
        }else{
            new Alert(Alert.AlertType.ERROR, "Invalid Registration Number").show();
        }
        txtRegistrationNumber.requestFocus();
        txtRegistrationNumber.selectAll();
    }
}
