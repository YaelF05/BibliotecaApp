public class LibroDigital extends Libro {
    private String formato;
    
    /**
     * Constructor para crear un nuevo libro digital.
     * 
     * @param id Identificador único del libro
     * @param titulo Título del libro
     * @param autor Autor del libro
     * @param anio Año de publicación
     * @param genero Género literario
     * @param disponible Estado de disponibilidad
     * @param formato Formato del archivo digital (audiolibro o digital)
     */
    public LibroDigital(int id, String titulo, String autor, int anio, String genero, boolean disponible, String formato) {
        super(id, titulo, autor, anio, genero, disponible, "Digital");
        this.formato = formato;
    }
    
    /**
     * @return Formato del archivo digital
     */
    public String getFormato() {
        return formato;
    }
    
    /**
     * @param formato Nuevo formato del archivo
     */
    public void setFormato(String formato) {
        this.formato = formato;
    }
    
    @Override
    public String toString() {
        return super.toString() + " | Formato: " + formato;
    }
}
