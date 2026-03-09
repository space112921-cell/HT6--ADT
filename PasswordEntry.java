public class PasswordEntry {
    private String sitio;
    private String password;

    public PasswordEntry(String sitio, String password) {
        this.sitio = sitio;
        this.password = password;
    }

    public String getSitio() {
        return sitio;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordOculta() {
        String oculto = "";
        for (int i = 0; i < password.length(); i++) {
            oculto += "*";
        }
        return oculto;
    }

    @Override
    public String toString() {
        return "Sitio: " + sitio + " | Contraseña: " + getPasswordOculta();
    }
}