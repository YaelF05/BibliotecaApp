import java.util.ArrayList;
import java.util.List;

/**
 * Clase que maneja la lógica de la biblioteca.
 */
public class BibliotecaServicio {
    private static BibliotecaServicio instance;
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;
    
    /**
     * Constructor privado para Singleton.
     */
    private BibliotecaServicio() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }
    
    /**
     * Obtiene la instancia única del servicio.
     * 
     * @return La instancia única del servicio
     */
    public static synchronized BibliotecaServicio getInstance() {
        if (instance == null) {
            instance = new BibliotecaServicio();
        }
        return instance;
    }
    
    /**
     * Inicializa la clase con datos de ejemplo.
     */
    public void inicializarDatos() {
        // Libros de ejemplo
        libros.add(new LibroFisico(1, "Don Quijote de la Mancha", "Miguel de Cervantes",1605, "Ficción", true));
        libros.add(new LibroFisico(2, "Cien años de soledad", "Gabriel García Márquez", 1967, "Novela", true));
        libros.add(new LibroDigital(3, "El principito", "Antoine de Saint-Exupéry", 1943, "Fábula", true, "PDF"));
        
        // Usuarios de ejemplo
        usuarios.add(new Estudiante(101, "Yael F", "yael@gmail.com", "123456789", "Ingeniería de Software"));
        usuarios.add(new Profesor(102, "José Antonio", "JosAn@gmail.com", "987654321"));
    }
    

    /**
     * Registra un nuevo libro verificando que su ID no exista.
     * 
     * @param libro El libro a registrar
     * @return El libro registrado o null si el ID ya existe
     */
    public Libro registrarLibro(Libro libro) {
        // Verificar que no exista un libro con el mismo ID
        if (buscarLibroPorId(libro.getId())) {
            System.out.println("Error: Ya existe un libro con el ID " + libro.getId());
            return null;
        }
        
        libros.add(libro);
        return libro;
    }
    
    /**
     * Busca un libro por su ID.
     * 
     * @param id ID del libro
     * @return true si el libro existe, false en caso contrario
     */
    public Boolean buscarLibroPorId(int id) {
        for (Libro l : libros) {
            if (l.getId() == id) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Obtiene un libro por su ID.
     * 
     * @param id ID del libro
     * @return El libro si existe, null en caso contrario
     */
    public Libro obtenerLibroPorId(int id) {
        for (Libro l : libros) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }
    
    /**
     * Obtiene todos los libros.
     * 
     * @return Lista de todos los libros
     */
    public List<Libro> obtenerTodosLosLibros() {
        return new ArrayList<>(libros);
    }
    
    /**
     * Busca libros por título.
     * 
     * @param titulo Texto a buscar en el título
     * @return Lista de libros que coinciden
     */
    public List<Libro> buscarLibrosPorTitulo(String titulo) {
        String terminoBusqueda = titulo.toLowerCase();
        List<Libro> resultado = new ArrayList<>();
        
        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(terminoBusqueda)) {
                resultado.add(libro);
            }
        }
        
        return resultado;
    }
    
    /**
     * Busca libros por autor.
     * 
     * @param autor Texto a buscar en el autor
     * @return Lista de libros que coinciden
     */
    public List<Libro> buscarLibrosPorAutor(String autor) {
        String terminoBusqueda = autor.toLowerCase();
        List<Libro> resultado = new ArrayList<>();
        
        for (Libro libro : libros) {
            if (libro.getAutor().toLowerCase().contains(terminoBusqueda)) {
                resultado.add(libro);
            }
        }
        
        return resultado;
    }
    
    /**
    * Busca libros por género.
    * 
    * @param genero Texto a buscar en el género
    * @return Lista de libros que coinciden
    */
    public List<Libro> buscarLibrosPorGenero(String genero) {
        String terminoBusqueda = genero.toLowerCase();
        List<Libro> resultado = new ArrayList<>();
            
        for (Libro libro : libros) {
            if (libro.getGenero().toLowerCase().contains(terminoBusqueda)) {
                resultado.add(libro);
            }
        }
            
        return resultado;
    }
    
    /**
     * Registra un nuevo usuario verificando que su ID no exista.
     * 
     * @param usuario El usuario a registrar
     * @return El usuario registrado o null si el ID ya existe
     */
    public Usuario registrarUsuario(Usuario usuario) {
        // Verificar que no exista un usuario con el mismo ID
        if (buscarUsuarioPorId(usuario.getId())) {
            System.out.println("Error: Ya existe un usuario con el ID " + usuario.getId());
            return null;
        }
        
        usuarios.add(usuario);
        return usuario;
    }
    
    /**
     * Busca un usuario por su ID.
     * 
     * @param id ID del usuario
     * @return true si el usuario existe, false en caso contrario
     */
    public boolean buscarUsuarioPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Obtiene un usuario por su ID.
     * 
     * @param id ID del usuario
     * @return El usuario si existe, null en caso contrario
     */
    public Usuario obtenerUsuarioPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }
    
    /**
     * Obtiene todos los usuarios.
     * 
     * @return Lista de todos los usuarios
     */
    public List<Usuario> obtenerTodosLosUsuarios() {
        return new ArrayList<>(usuarios);
    }
    
    
    /**
     * Realiza un préstamo de libro a un usuario.
     * 
     * @param idLibro ID del libro a prestar
     * @param idUsuario ID del usuario que solicita el préstamo
     * @return El préstamo realizado o null si no se pudo realizar
     */
    public Prestamo prestarLibro(int idLibro, int idUsuario) {
        // Buscar libro y usuario
        Usuario usuario = null;
        Libro libro = null;
        
        if (!buscarLibroPorId(idLibro)) {
            System.out.println("Error: Libro no encontrado.");
            return null;
        } else {
            for (Libro l : libros) {
                if (l.getId() == idLibro) {
                    libro = l;
                }
            }
        }
        
        if (!buscarUsuarioPorId(idUsuario)) {
            System.out.println("Error: Usuario no encontrado.");
            return null;
        } else {
            for (Usuario u : usuarios) {
                if (u.getId() == idUsuario) {
                    usuario = u;
                }
            }
        }
        
        if (!libro.isDisponible()) {
            System.out.println("Error: El libro no está disponible actualmente.");
            return null;
        }
        
        // Verificar límite de préstamos del usuario
        int prestamosActivos = contarPrestamosActivosPorUsuario(idUsuario);
        if (prestamosActivos >= usuario.getLimitePrestamos()) {
            System.out.println("Error: El usuario ya tiene el máximo de libros permitidos.");
            return null;
        }
    
        Prestamo nuevoPrestamo = new Prestamo(prestamos.size() + 1, idLibro, idUsuario);
        prestamos.add(nuevoPrestamo);
        
        libro.setDisponible(false);
        
        return nuevoPrestamo;
    }
    
    /**
     * Registra la devolución de un libro.
     * 
     * @param idLibro ID del libro a devolver
     * @return true si se realizó la devolución, false en caso contrario
     */
    public boolean devolverLibro(int idLibro) {
        Prestamo prestamo = buscarPrestamoActivoPorLibro(idLibro);
        
        if (prestamo == null) {
            System.out.println("Error: No hay préstamos activos para este libro.");
            return false;
        }
        
        prestamo.realizarDevolucion();
        
        if (buscarLibroPorId(idLibro)) {
            for (Libro l : libros) {
                if (l.getId() == idLibro) {
                    l.setDisponible(true);
                    break;
                }
            }
        }
        
        return true;
    }
    
    /**
     * Busca un préstamo activo por ID de libro.
     * 
     * @param idLibro ID del libro
     * @return true si existe un préstamo activo para el libro, false en caso contrario
     */
    public boolean existePrestamoActivoPorLibro(int idLibro) {
        for (Prestamo p : prestamos) {
            if (p.getIdLibro() == idLibro && !p.isDevuelto()) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Obtiene un préstamo activo por ID de libro.
     * 
     * @param idLibro ID del libro
     * @return El préstamo activo si existe, null en caso contrario
     */
    public Prestamo buscarPrestamoActivoPorLibro(int idLibro) {
        for (Prestamo p : prestamos) {
            if (p.getIdLibro() == idLibro && !p.isDevuelto()) {
                return p;
            }
        }
        return null;
    }
    
    /**
     * Cuenta los préstamos activos de un usuario.
     * 
     * @param idUsuario ID del usuario
     * @return Número de préstamos activos
     */
    public int contarPrestamosActivosPorUsuario(int idUsuario) {
        int contador = 0;
        for (Prestamo p : prestamos) {
            if (p.getIdUsuario() == idUsuario && !p.isDevuelto()) {
                contador++;
            }
        }
        return contador;
    }
    
    /**
     * Obtiene los préstamos activos.
     * 
     * @return Lista de préstamos activos
     */
    public List<Prestamo> obtenerPrestamosActivos() {
        List<Prestamo> resultado = new ArrayList<>();
        for (Prestamo p : prestamos) {
            if (!p.isDevuelto()) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}