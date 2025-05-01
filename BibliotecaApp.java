import java.util.List;
import java.util.Scanner;

/**
 * Clase principal 
 * @author Yael Franco Toledo
 * @version 1.0
 */
public class BibliotecaApp {
    
    private static BibliotecaServicio servicio = BibliotecaServicio.getInstance();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        servicio.inicializarDatos();
        
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- SISTEMA DE BIBLIOTECA ---");
            System.out.println("1. Registrar nuevo libro");
            System.out.println("2. Registrar nuevo usuario");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Buscar libros");
            System.out.println("6. Ver todos los libros");
            System.out.println("7. Ver todos los usuarios");
            System.out.println("8. Ver préstamos activos");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();  
            
            switch (opcion) {
                case 1:
                    registrarLibro();
                    break;
                case 2:
                    registrarUsuario();
                    break;
                case 3:
                    prestarLibro();
                    break;
                case 4:
                    devolverLibro();
                    break;
                case 5:
                    buscarLibros();
                    break;
                case 6:
                    mostrarLibros();
                    break;
                case 7:
                    mostrarUsuarios();
                    break;
                case 8:
                    mostrarPrestamosActivos();
                    break;
                case 9:
                    salir = true;
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    /**
 * Método para registrar un nuevo libro con validación de ID.
 */
private static void registrarLibro() {
    System.out.println("--- REGISTRAR NUEVO LIBRO ---");
    

    int id;
    boolean idValido = false;
    
    do {
        System.out.print("ID: ");
        id = scanner.nextInt();
        scanner.nextLine();  
        
        // Verificar si el ID ya existe
        if (servicio.buscarLibroPorId(id)) {
            System.out.println("Error: Ya existe un libro con el ID " + id + ". Ingrese otro ID.");
        } else {
            idValido = true;
        }
    } while (!idValido);
    
    System.out.print("Título: ");
    String titulo = scanner.nextLine();
    
    System.out.print("Autor: ");
    String autor = scanner.nextLine();
    
    System.out.print("Año: ");
    int anio = scanner.nextInt();
    scanner.nextLine();  // Consumir el salto de línea
    
    System.out.print("Género: ");
    String genero = scanner.nextLine();
    
    System.out.println("Tipo de libro:");
    System.out.println("1. Físico");
    System.out.println("2. Digital");
    System.out.print("Seleccione una opción: ");
    int tipoOpcion = scanner.nextInt();
    scanner.nextLine();  // Consumir el salto de línea
    
    Libro nuevoLibro = null;
    
    switch (tipoOpcion) {
        case 1:
            nuevoLibro = new LibroFisico(id, titulo, autor, anio, genero, true);
            break;
        case 2:
            System.out.print("Formato (Audiolibro o Digital(PDF, etc)): ");
            String formato = scanner.nextLine();
            nuevoLibro = new LibroDigital(id, titulo, autor, anio, genero, true, formato);
            break;
        default:
            System.out.println("Tipo de libro no válido.");
            return;
    }
    
    servicio.registrarLibro(nuevoLibro);
    System.out.println("Libro registrado con éxito.");
}

    /**
 * Método para registrar un nuevo usuario con validación de ID.
 */
private static void registrarUsuario() {
    System.out.println("--- REGISTRAR NUEVO USUARIO ---");
    
    // Solicitar y validar ID
    int id;
    boolean idValido = false;
    
    do {
        System.out.print("ID: ");
        id = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        
        // Verificar si el ID ya existe
        if (servicio.buscarUsuarioPorId(id)) {
            System.out.println("Error: Ya existe un usuario con el ID " + id + ". Ingrese otro ID.");
        } else {
            idValido = true;
        }
    } while (!idValido);
    
    System.out.print("Nombre: ");
    String nombre = scanner.nextLine();
    
    System.out.print("Email: ");
    String email = scanner.nextLine();
    
    System.out.print("Teléfono: ");
    String telefono = scanner.nextLine();
    
    System.out.println("Tipo de usuario:");
    System.out.println("1. Estudiante");
    System.out.println("2. Profesor");
    System.out.print("Seleccione una opción: ");
    int tipoOpcion = scanner.nextInt();
    scanner.nextLine();  // Consumir el salto de línea
    
    Usuario nuevoUsuario = null;
    
    switch (tipoOpcion) {
        case 1:
            System.out.print("Carrera: ");
            String carrera = scanner.nextLine();
            nuevoUsuario = new Estudiante(id, nombre, email, telefono, carrera);
            break;
        case 2:
            nuevoUsuario = new Profesor(id, nombre, email, telefono);
            break;
        default:
            System.out.println("Tipo de usuario no válido.");
            return;
    }
    
    servicio.registrarUsuario(nuevoUsuario);
    System.out.println("Usuario registrado con éxito.");
}

    /**
     * Realiza el préstamo de un libro a un usuario.
     */
    private static void prestarLibro() {
        System.out.println("--- PRESTAR LIBRO ---");
        
        System.out.print("ID del libro: ");
        int idLibro = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        
        System.out.print("ID del usuario: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        
        Prestamo prestamo = servicio.prestarLibro(idLibro, idUsuario);
        
        if (prestamo != null) {
            System.out.println("Préstamo realizado con éxito.");
        }
    }

    /**
     * Registra la devolución de un libro.
     */
    private static void devolverLibro() {
        System.out.println("--- DEVOLVER LIBRO ---");
        
        System.out.print("ID del libro: ");
        int idLibro = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        
        boolean devuelto = servicio.devolverLibro(idLibro);
        
        if (devuelto) {
            System.out.println("Libro devuelto con éxito.");
        }
    }

    /**
     * Busca libros por diferentes criterios.
     */
    private static void buscarLibros() {
        System.out.println("--- BUSCAR LIBROS ---");
        System.out.println("1. Buscar por título");
        System.out.println("2. Buscar por autor");
        System.out.println("3. Buscar por género");
        System.out.print("Seleccione una opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();  
        
        System.out.print("Ingrese término de búsqueda: ");
        String termino = scanner.nextLine();
        
        List<Libro> resultados = null;
        
        switch (opcion) {
            case 1:
                resultados = servicio.buscarLibrosPorTitulo(termino);
                break;
            case 2:
                resultados = servicio.buscarLibrosPorAutor(termino);
                break;
            case 3:
                resultados = servicio.buscarLibrosPorGenero(termino);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }
        
        mostrarResultadosBusqueda(resultados);
    }

    /**
     * Muestra resultados de búsqueda de libros.
     * 
     * @param libros Lista de libros a mostrar
     */
    private static void mostrarResultadosBusqueda(List<Libro> libros) {
        System.out.println("Resultados:");
        
        if (libros.isEmpty()) {
            System.out.println("No se encontraron libros que coincidan con la búsqueda.");
            return;
        }
        
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    /**
     * Muestra todos los libros registrados.
     */
    private static void mostrarLibros() {
        System.out.println("--- LISTADO DE LIBROS ---");
        
        List<Libro> libros = servicio.obtenerTodosLosLibros();
        
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    /**
     * Muestra todos los usuarios registrados.
     */
    private static void mostrarUsuarios() {
        System.out.println("--- LISTADO DE USUARIOS ---");
        
        List<Usuario> usuarios = servicio.obtenerTodosLosUsuarios();
        
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    /**
     * Muestra los préstamos activos.
     */
    private static void mostrarPrestamosActivos() {
        System.out.println("--- PRÉSTAMOS ACTIVOS ---");
        
        List<Prestamo> prestamos = servicio.obtenerPrestamosActivos();
        
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos activos.");
            return;
        }
        
        for (Prestamo prestamo : prestamos) {
            // Verificar si el libro y el usuario existen
            if (servicio.buscarLibroPorId(prestamo.getIdLibro()) && servicio.buscarUsuarioPorId(prestamo.getIdUsuario())) {
                Libro libro = servicio.obtenerLibroPorId(prestamo.getIdLibro());
                Usuario usuario = servicio.obtenerUsuarioPorId(prestamo.getIdUsuario());
                
                if (libro != null && usuario != null) {
                    System.out.println("ID Préstamo: " + prestamo.getId() + 
                                     " | Libro: " + libro.getTitulo() + 
                                     " | Usuario: " + usuario.getNombre() + 
                                     " | Fecha: " + prestamo.getFechaPrestamo());
                }
            }
        }
    }
}