package com.example.port_scan_with_gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class HelloApplication extends Application {
    Label ip = new Label("IP Address");
    TextField ipField = new TextField();
    Button scan = new Button("Scan");
    static TextArea ta = new TextArea();
    @Override
    public void start(Stage stage) throws IOException {
        GridPane gp = new GridPane();
        GridPane.setConstraints(ip, 0,0);
        GridPane.setConstraints(ipField, 1,0);
        GridPane.setConstraints(scan, 2,0);
        GridPane.setConstraints(ta, 0,1);
        scan.setOnAction(event->{
            for(int i = 1; i < 65536; i++) {
                Thread thread = new Thread(String.valueOf(scan(ipField.getText(), i)));
            }
        });
        Scene scene = new Scene(gp, 500, 450);
        gp.getChildren().addAll(ip, ipField, scan ,ta);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public static boolean scan(String host, int port) {
        try {
            Socket sock = new Socket(host, port);
            ta.setText("Port " + port + " is open");
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    public static void main(String[] args) {
        launch();
    }
}