module Donations {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;


    opens donations to javafx.fxml;
    exports donations;
}