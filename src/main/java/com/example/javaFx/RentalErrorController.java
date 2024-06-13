package com.example.javaFx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RentalErrorController {
    @FXML
    private Label ErrorDescLabel;

    @FXML
    private Button OKButton;

    @FXML
    private Label errorTitleLabel;

    public void setErrorDescLabel(String errorDescLabel) {
        ErrorDescLabel.setText(errorDescLabel);
    }

    @FXML
    void onButtonClicked(ActionEvent event) {
        OKButton.getScene().getWindow().hide();
    }
}
