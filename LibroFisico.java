/**
 * Clase que representa un libro físico.
 */
public class LibroFisico extends Libro {
    
    /**
     * Constructor para crear un nuevo libro físico.
     * 
     * @param id Identificador único del libro
     * @param titulo Título del libro
     * @param autor Autor del libro
     * @param anio Año de publicación
     * @param genero Género literario
     * @param disponible Estado de disponibilidad
     */
    public LibroFisico(int id, String titulo, String autor, int anio, String genero, boolean disponible) {
        super(id, titulo, autor, anio, genero, disponible, "Físico");
    }
       
    @Override
    public String toString() {
        return super.toString();
    }
}