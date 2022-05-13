module com.pathfinder.pathfinder {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.pathfinder.pathfinder to javafx.fxml;
    exports com.pathfinder.pathfinder;
}