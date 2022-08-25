package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class EditorFormController {
    public TextField txtSearch;
    public Button btnFind;
    public TextArea txtEditor;
    public Button btnFindUp;
    public ToggleButton btnRegExp;
    private int lastSearchIndex;

    public void initialize(){
        btnFind.setDisable(true);
        btnFindUp.setDisable(true);
        btnFind.setDefaultButton(true);
        txtSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                setUp();
            }
        });
    }

    private void setUp(){
        //!txtEditor.getText().contains(txtSearch.getText())
        btnFind.setDisable(btnRegExp.isSelected()?
                !isPatternExist(): !txtEditor.getText().contains(txtSearch.getText()));
        btnFindUp.setDisable(btnRegExp.isSelected()?
                !isPatternExist(): !txtEditor.getText().contains(txtSearch.getText()));
//                btnFindUp.setDisable(!txtEditor.getText().contains(txtSearch.getText()));
        lastSearchIndex = 0;
        if (btnFind.isDisable()){
            txtEditor.deselect();
        }
    }

    private boolean isPatternExist(){
        String regExp = txtSearch.getText();
        Pattern pattern;
        try {
            pattern = Pattern.compile(regExp, Pattern.MULTILINE);
        }catch (PatternSyntaxException e){
            return false;
        }
        return pattern.matcher(txtEditor.getText()).find();
    }

    public void btnFindOnAction(ActionEvent actionEvent) {
        String searchText = txtSearch.getText();
        String text = txtEditor.getText();
        int startIndex = 0;
        int endIndex = 0;

        if (!btnRegExp.isSelected()){
            startIndex = text.indexOf(searchText, lastSearchIndex);
            if (startIndex == -1){
                lastSearchIndex = 0;
                startIndex = text.indexOf(searchText, lastSearchIndex);
            }
            endIndex = startIndex + searchText.length();
        }else{
            Pattern pattern = Pattern.compile(searchText);
            Matcher matcher = pattern.matcher(text);
            if (!matcher.find(lastSearchIndex)){
                matcher.reset();
                lastSearchIndex = 0;
                matcher.find();
            }
            startIndex = matcher.start();
            endIndex = matcher.end();
        }

        lastSearchIndex = endIndex;
        txtEditor.selectRange(startIndex, endIndex);
    }

    public void btnFindUpOnAction(ActionEvent actionEvent) {
    }

    public void btnRegExpOnAction(ActionEvent actionEvent) {
        txtSearch.requestFocus();
        setUp();
    }
}
