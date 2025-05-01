public class Profesor extends Usuario {
    
    /**
     * Constructor para crear un nuevo profesor.
     * 
     * @param id Identificador único del usuario
     * @param nombre Nombre completo del profesor
     * @param email Correo electrónico del profesor
     * @param telefono Número de teléfono del profesor
     */
    public Profesor(int id, String nombre, String email, String telefono) {
        super(id, nombre, email, telefono, "Profesor", 5); 
    }
    
    
    @Override
    public String toString() {
        return super.toString();
    }
}