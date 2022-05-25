package proyecto.daw.anonygram.models.request;

public class ModelRegisterUser {

    private String name;

    private String usuario;

    private String password;

    public ModelRegisterUser() {
    }

    public ModelRegisterUser(
        String usuario,
        String name,
        String password) {
        this.usuario = usuario;
        this.name = name;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
