module mindmingle {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires javafx.graphics;
    requires javafx.base;
    requires mysql.connector.java;
    requires com.jfoenix;
    //requires com.dlsc.pdfviewfx;
    //requires PDFViewerFX;


    opens project to javafx.fxml;
     exports project;
    opens project.controllers to javafx.fxml;
    opens project.viewer to javafx.fxml;
    opens project.services.student_services to javafx.fxml;
    opens project.models to javafx.fxml;
    opens project.middlewares to javafx.fxml;
    opens project.enums to javafx.fxml;

    exports project.models;
    exports project.services.student_services;
    exports project.controllers;
    exports project.enums;
    exports project.middlewares;
    exports project.viewer;


}