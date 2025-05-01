public class Estudiante extends Usuario {
    private String carrera;
    
    /**
     * Constructor para crear un nuevo estudiante.
     * 
     * @param id Identificador único del usuario
     * @param nombre Nombre completo del estudiante
     * @param email Correo electrónico del estudiante
     * @param telefono Número de teléfono del estudiante
     * @param carrera Carrera que estudia
     */
    public Estudiante(int id, String nombre, String email, String telefono, String carrera) {
        super(id, nombre, email, telefono, "Estudiante", 3); 
        this.carrera = carrera;
    }
    
    /**
     * @return Carrera que estudia
     */
    public String getCarrera() {
        return carrera;
    }
    
    /**
     * @param carrera Nueva carrera
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    @Override
    public String toString() {
        return super.toString() + " | Carrera: " + carrera;
    }
}
