package com.example.softeng;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class WeightCalculatorController {
    private final Double MALE_COEFICENT = 0.9d;
    private final Double FEMALE_COEFICENT = 0.8d;

    @FXML
    private TextField ageTextField;

    @FXML
    private RadioButton femaleRadioButton;

    @FXML
    private ToggleGroup genderToggle;

    @FXML
    private TextField heightTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private RadioButton maleRadioButton;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label resultLabel;

    @FXML
    private void onSubmit(ActionEvent event) {
        //get data from UI
        int age;
        try {
            age = Integer.parseInt(ageTextField.getText());
        } catch (NumberFormatException e) {
            resultLabel.setText("Vlera e moshes nuk eshte e sakte!");
            return;
        }
        int height;
        try {
            height = Integer.parseInt(heightTextField.getText());
        } catch (NumberFormatException e) {
            resultLabel.setText("Vlera e gjatesise nuk eshte e sakte!");
            return;
        }
        final var res = getCalculatedData(age, height, maleRadioButton.isSelected());
        resultLabel.setText("Pesha ideale e " + nameTextField.getText() + " " + lastNameTextField.getText() +
                " eshte : " + res + " kg");
    }

    private Double getCalculatedData(int age, int height, boolean isMale) {
        if (isMale) {
         return (height - 100 + age/10)*MALE_COEFICENT;
        } else { //female
            return (height - 100 + age/10)*FEMALE_COEFICENT;
        }
    }

}