module com.eiman.ejk {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.eiman.ejk to javafx.fxml;
    exports com.eiman.ejk;
}