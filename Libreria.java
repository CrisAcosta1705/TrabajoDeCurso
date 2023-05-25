package GestionamientoDeLibreria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Libreria {
    private List<Libro> libros;
    private String username;
    private String password;
    private String studentID;
    private String career;
    public Libreria() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void login(String username, String password, String studentID, String career) {
        this.username = username;
        this.password = password;
        this.studentID = studentID;
        this.career = career;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    
        public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

		public void realizarLogin() {
        	Scanner scanner = new Scanner(System.in);

        	while (true) {
        	    System.out.print("Ingrese su nombre de usuario: ");
        	    username = scanner.nextLine();
        	    if (username.matches("^[A-Za-z\\s]+$")) {
        	        break;
        	    } else {
        	        System.out.println("El nombre de usuario solo puede contener letras. Inténtelo nuevamente.");
        	    }
        	
        	}
            while (true) {
                System.out.print("Ingrese su contraseña: ");
                password = scanner.nextLine();
                if (password.matches("^[A-Za-z0-9]+$")) {
                    break;
                } else {
                    System.out.println("La contraseña solo puede contener letras y números. Inténtelo nuevamente.");
                }
            }

            while (true) {
                System.out.print("Ingrese su carnet estudiantil: ");
                studentID = scanner.nextLine();
                if (studentID.matches("^[A-Za-z0-9]+$")) {
                    break;
                } else {
                    System.out.println("El carnet estudiantil solo puede contener letras y números. Inténtelo nuevamente.");
                }
            }
            System.out.println("\nSeleccione su carrera de ingeniería:");
            System.out.println("1. Ingeniería Informática");
            System.out.println("2. Ingeniería Electrónica");
            System.out.println("3. Ingeniería Mecánica");
            System.out.println("4. Ingeniería Civil");
            System.out.println("5. Ingeniería Industrial");
            
            int opcion;
            while (true) {
                System.out.print("Ingrese el número de la opción deseada: ");
                String input = scanner.nextLine();
                if (input.matches("^[1-5]$")) {
                    opcion = Integer.parseInt(input);
                    break;
                } else {
                    System.out.println("Opción inválida. Inténtelo nuevamente.");
                }
            }

            String career;
            switch (opcion) {
                case 1:
                    career = "Ingeniería Informática";
                    break;
                case 2:
                    career = "Ingeniería Electrónica";
                    break;
                case 3:
                    career = "Ingeniería Mecánica";
                    break;
                case 4:
                    career = "Ingeniería Civil";
                    break;
                case 5:
                    career = "Ingeniería Industrial";
                    break;
                default:
                    career = "Carrera no especificada";
                    break;
            }

            System.out.println("\nDatos ingresados correctamente:");
            System.out.println("Nombre de usuario: " + username);
            System.out.println("Contraseña: " + password);
            System.out.println("Carnet estudiantil: " + studentID);
            System.out.println("Carrera seleccionada: " + career);

            
        }
    	
		
        public void mostrarMenu() {
            Scanner scanner = new Scanner(System.in);
            int opcion;
            do {
                System.out.println("==== MENÚ DE LA BIBLIOTECA ====");
                System.out.println("1. Registrar libro");
                System.out.println("2. Buscar libro");
                System.out.println("3. Informe del estudiante");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                
                try {
                     opcion = scanner.nextInt();
                     scanner.nextLine();
                    switch (opcion) {
                        case 1:
                            registrarLibro();
                            break;
                        case 2:
                            buscarLibro();
                            break;
                        case 3:
                            generarInformeUsuario();
                            break;
                        case 4:
                            System.out.println("Saliendo del programa...");
                            break;
                        default:
                            System.out.println("Opción inválida. Por favor, seleccione nuevamente.");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un número válido. Inténtelo nuevamente.");
                    scanner.nextLine(); 
                    opcion = 0; 
                }
            } while (opcion != 4);
            
        
        }

    private void registrarLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese la editorial del libro: ");
        String editorial = scanner.nextLine();
        System.out.print("Ingrese el año del libro: ");

        try {
            int año = scanner.nextInt();

            Libro libro = new Libro(titulo, autor, editorial, año);
            agregarLibro(libro);
            System.out.println("Libro registrado correctamente.");
        } catch (InputMismatchException e) {
            System.out.println("El año debe ser un número entero. No se pudo registrar el libro.");
        }
    }

    private void buscarLibro() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados en la biblioteca.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el título o autor del libro a buscar: ");
        String busqueda = scanner.nextLine();

        List<Libro> resultados = new ArrayList<>();

        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(busqueda) || libro.getAutor().equalsIgnoreCase(busqueda)) {
                resultados.add(libro);
            }
        }

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron resultados para la búsqueda.");
        } else {
            System.out.println("Resultados de la búsqueda:");
            for (int i = 0; i < resultados.size(); i++) {
                Libro libro = resultados.get(i);
                System.out.println((i + 1) + ". " + libro.getTitulo() + " - " + libro.getAutor());
            }

            try {
                System.out.print("Seleccione el número del libro que desea prestar: ");
                int seleccion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                if (seleccion > 0 && seleccion <= resultados.size()) {
                    Libro libroSeleccionado = resultados.get(seleccion - 1);
                    libroSeleccionado.setPrestado(true);

                    LocalDate fechaPrestamo = LocalDate.now();
                    LocalDate fechaRetorno = fechaPrestamo.plusDays(7);
                    System.out.println("El libro '" + libroSeleccionado.getTitulo() + "' se ha prestado correctamente.");
                    System.out.println("Fecha de retorno: " + fechaRetorno);
                } else {
                    System.out.println("Opción inválida. No se realizó el préstamo del libro.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número válido. No se realizó el préstamo del libro.");
            }
        }
    }

    private void generarInformeUsuario() {
        int librosPrestados = 0;
        List<Libro> librosPrestadosLista = new ArrayList<>();

        for (Libro libro : libros) {
            if (libro.isPrestado()) {
                librosPrestados++;
                librosPrestadosLista.add(libro);
            }
        }

        System.out.println("=== INFORME DE USUARIO ===");
        System.out.println("Nombre de usuario: " + username);
        System.out.println("Número de carnet: " + studentID);
        System.out.println("Carrera del estudiante: " + career);
        System.out.println("Cantidad de libros prestados: " + librosPrestados);

        if (librosPrestados > 0) {
            System.out.println("Libros prestados:");

            for (Libro libro : librosPrestadosLista) {
                System.out.println("- " + libro.getTitulo() + " - " + libro.getAutor());
                System.out.println("Fecha de retorno: " + libro.getFechaRetorno());
            }
        } else {
            System.out.println("No tiene libros prestados.");
        }
    }
}
