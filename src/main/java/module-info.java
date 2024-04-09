module com.projectpizza.projectpizza {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.projectpizza.projectpizza to javafx.fxml;
    exports com.projectpizza.projectpizza;
}