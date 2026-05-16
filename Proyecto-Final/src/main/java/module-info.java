module com.example.gympos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    // Esto permite que JavaFX cargue tus archivos FXML
    opens com.example.gympos.view to javafx.fxml;

    opens com.example.gympos.model to javafx.base, javafx.fxml;

    // Esto permite que JavaFX ejecute tu aplicación principal
    opens com.example.gympos.app to javafx.graphics;

    // Exporta los paquetes para que sean visibles
    exports com.example.gympos.app;
    exports com.example.gympos.view;
}