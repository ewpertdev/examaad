package modeloexam;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombre;

    public Usuario(String nombre, String pw, String roleplay) {
        this.nombre = nombre;
        this.pw = pw;
        this.roleplay = roleplay;
    }

    private String pw;
    private String roleplay;

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Roleplay: " + roleplay;
    }
    public String toStringOculto(){
        return "Nombre: " + nombre + ", Contraseña: " + "*".repeat(pw.length())+ ", Rol: "+ roleplay;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getRoleplay() {
        return roleplay;
    }

    public void setRoleplay(String roleplay) {
        this.roleplay = roleplay;
    }
}
