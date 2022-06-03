module com.example.port_scan_with_gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.port_scan_with_gui to javafx.fxml;
    exports com.example.port_scan_with_gui;
}