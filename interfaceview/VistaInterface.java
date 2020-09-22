package interfaceview;

public interface VistaInterface {
    void setController(Controlador cont);

    public String getFileName();

    public String getText();

    public void setText(String s);

    static final String ENCRYPT = "ENCRYPT";
    static final String DECRYPT = "DECRYPT";
    static final String ABRIR = "ABRIR";
    static final String GUARDAR = "GUARDAR";

}
