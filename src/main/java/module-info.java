module cs.strangeshop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;

    opens controller to javafx.fxml;
    exports principal;
}
