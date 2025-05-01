import java.util.Date;

/**
 * Clase que representa un préstamo de libro.
 */
public class Prestamo {
    private int id;
    private int idLibro;
    private int idUsuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private boolean devuelto;

    /**
     * Constructor para crear un nuevo préstamo.
     * 
     * @param id Identificador único del préstamo
     * @param idLibro Identificador del libro prestado
     * @param idUsuario Identificador del usuario que realiza el préstamo
     * @param fechaPrestamo Fecha en que se realiza el préstamo
     * @param fechaDevolucion Fecha en que se devuelve el libro (null si aún no ha sido devuelto)
     * @param devuelto Indica si el libro ha sido devuelto
     */
    public Prestamo(int id, int idLibro, int idUsuario, Date fechaPrestamo, Date fechaDevolucion, boolean devuelto) {
        this.id = id;
        this.idLibro = idLibro;
        this.idUsuario = idUsuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.devuelto = devuelto;
    }

    /**
     * Constructor simplificado para cuando se realiza el prestamo
     * 
     * @param id Identificador único del préstamo
     * @param idLibro Identificador del libro prestado
     * @param idUsuario Identificador del usuario que realiza el préstamo
     */
    public Prestamo(int id, int idLibro, int idUsuario) {
        this.id = id;
        this.idLibro = idLibro;
        this.idUsuario = idUsuario;
        this.fechaPrestamo = new Date();  // La fecha actual
        this.fechaDevolucion = null;
        this.devuelto = false;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    /**
     * Registra la devolución del libro.
     */
    public void realizarDevolucion() {
        this.devuelto = true;
        this.fechaDevolucion = new Date();  
    }
    
    @Override
    public String toString() {
        return "ID Préstamo: " + id + 
               " | ID Libro: " + idLibro + 
               " | ID Usuario: " + idUsuario + 
               " | Fecha Préstamo: " + fechaPrestamo + 
               " | Fecha Devolución: " + (fechaDevolucion != null ? fechaDevolucion : "Pendiente") +
               " | Devuelto: " + (devuelto ? "Sí" : "No");
    }
}