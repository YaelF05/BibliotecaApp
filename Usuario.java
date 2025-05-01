public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private String tipo;
    private int limitePrestamos;

    /**
     * Constructor para crear un nuevo usuario.
     * 
     * @param id Identificador único del usuario
     * @param nombre Nombre completo del usuario
     * @param email Correo electrónico del usuario
     * @param telefono Número de teléfono del usuario
     * @param tipo Tipo de usuario
     * @param limitePrestamos Límite de préstamos permitidos
     */
    public Usuario(int id, String nombre, String email, String telefono, String tipo, int limitePrestamos) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.tipo = tipo;
        this.limitePrestamos = limitePrestamos;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public int getLimitePrestamos() {
        return limitePrestamos;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + 
               " | Nombre: " + nombre + 
               " | Email: " + email + 
               " | Teléfono: " + telefono +
               " | Tipo: " + tipo +
               " | Límite préstamos: " + limitePrestamos;
    }
}