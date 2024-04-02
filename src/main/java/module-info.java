module donations {

    requires javafx.controls;
    requires javafx.fxml;

    opens mx.edu.greengates.cs.donations to javafx.fxml;
    opens mx.edu.greengates.cs.donations.controller to javafx.fxml;

    exports mx.edu.greengates.cs.donations;
    exports mx.edu.greengates.cs.donations.controller;
}
