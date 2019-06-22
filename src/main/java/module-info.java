module org.example.richtextfx {
    requires javafx.controls;
    requires richtextfx;
    requires reactfx;
    requires flowless;

    opens org.example.richtextfx to javafx.graphics;
}
