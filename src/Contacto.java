import java.util.Objects;

public class Contacto extends Persona{

    public Contacto(String nombre, String apellido, int dni, String telefono, String email) {
        super(nombre, apellido, dni, telefono, email);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public boolean encontrarContacto(String nom_o_ap){
        return Objects.equals(this.getNombre(), nom_o_ap) || Objects.equals(this.getApellido(), nom_o_ap);
    }

    public boolean contactoCoincide(int dni){
        return this.getDni() == dni;
    }

    public void modificarContacto(String nombre, String apellido, String telefono, String email){
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setTelefono(telefono);
        this.setEmail(email);
    }
}
