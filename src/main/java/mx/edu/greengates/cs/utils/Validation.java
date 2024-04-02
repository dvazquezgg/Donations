package mx.edu.greengates.cs.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class Validation {

    public static boolean emptyOrNonNumeric(TextField textField) {
        // Validate input
        String numberValue = textField.getText();
        if (numberValue.isEmpty()) {
            showErrorAlert("Error", textField.getPromptText() + " is required");
            return true;
        } else if (!numberValue.matches("\\d+")) {
            showErrorAlert("Error", textField.getPromptText() + " must be a number");
            return true;
        }
        return false;
    }

    public static boolean emptyOrNonEmail(TextField textField) {
        // Validate input
        String email = textField.getText();
        if (email.isEmpty()) {
            showErrorAlert("Error", textField.getPromptText() + " is required");
            return true;
        } else if (!email.matches("^(.+)@(.+)$")) {
            showErrorAlert("Error", textField.getPromptText() + " must be a valid email address");
            return true;
        }
        return false;
    }

    // pattern is a regular expression
    // ^\d{2}-\d{3}-\d{4}$ is a pattern for a phone number in the format xx-xxx-xxxx
    public static boolean emptyOrNonPattern(TextField textField, String pattern) {
        // Validate input
        String value = textField.getText();
        if (value.isEmpty()) {
            showErrorAlert("Error", textField.getPromptText() + " is required");
            return true;
        } else if (!value.matches(pattern)) {
            showErrorAlert("Error", textField.getPromptText() + " must match the pattern: " + pattern);
            return true;
        }
        return false;
    }

    public static boolean empty(TextField textField) {
        // Validate input
        String value = textField.getText();
        if (value.isEmpty()) {
            showErrorAlert("Error",
                    textField.getPromptText() +
                            " is required");
            return true;
        }
        return false;
    }

    public static boolean lettersOnly(TextField textField) {
        // Validate input
        String value = textField.getText();
        if (!value.matches("\\[a-zA-Z]+")) {
            showErrorAlert("Error", textField.getPromptText() + " must contain only letters");
            return true;
        }
        return false;
    }

    public static boolean empty(DatePicker datePicker) {
        // Validate input
        LocalDate value = datePicker.getValue();
        if (value == null) {
            showErrorAlert("Error", datePicker.getPromptText() + " is required");
            return true;
        }
        return false;
    }

    private static void showErrorAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
