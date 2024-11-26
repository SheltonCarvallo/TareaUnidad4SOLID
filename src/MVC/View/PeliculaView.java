package MVC.View;

import MVC.Models.Pelicula.ActorModel;
import MVC.Models.Pelicula.PeliculaModel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PeliculaView {
    Scanner scanner = new Scanner(System.in);

    public int mostrarMenuPeliculas() {
        System.out.println("Seleccione una de las siguientes opciones");
        System.out.println("1. Agregar película ");
        System.out.println("2. Mostrar películas");
        System.out.println("3. Salir");
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return switch (opcion) {
                case 1 -> 1;
                case 2 -> 2;
                case 3 -> 3;
                default -> 0;
            };

        } catch (InputMismatchException ex) {
            System.out.println("Por favor ingrese un opción que corresponda al menú mostrado en formato número");
            scanner.nextLine();
            return 0;
        }
    }

    public String ingresarNombrePelicula() {
        System.out.println("Ingrese el nombre de la película: ");
        return scanner.nextLine();
    }

    public int ingreseDuracionMinutos() {
        System.out.print("Ingrese la duracion en minutos: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, ingrese un número entero válido:");
            scanner.next();  // Limpia input invalido
        }
        return scanner.nextInt();
    }

    public int ingreseAnioPelicula() {
        System.out.print("Ingrese el año de la película: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, ingrese un número entero válido:");
            scanner.next();  // Limpia input invalido
        }
        return scanner.nextInt();
    }

    public String ingresarGenero() {
        scanner.nextLine();
        System.out.print("Ingrese el genero de la película: ");
        return scanner.nextLine();
    }

    public ArrayList<ActorModel> ingresarActores() {
        boolean exit = false;
        ArrayList<ActorModel> actores = new ArrayList<>();
        System.out.println("Ingrese los actores");
        do {
            System.out.println("Nombre actor u actriz: ");
            String nombreActor = scanner.next();
            System.out.println("Apellido actor u actriz: ");
            String apellidoActor = scanner.next();
            ActorModel actor = new ActorModel(nombreActor, apellidoActor);
            actores.add(actor);
            System.out.println("Deseas agregar otro actor u actriz? (Y/N)");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("n")) {
                exit = true;
            }
        } while (!exit);
        return actores;
    }

    public void mostrarInformacionPelicula(ArrayList<PeliculaModel> peliculas) {
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas registradas");
            return;
        }
        System.out.println("--------------------PELÍCULAS-----------------------");
        for (PeliculaModel pelicula : peliculas) {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("\tTitulo: " + pelicula.getTitulo());
            System.out.println("\tDuracion en minutos: " + pelicula.getDuracionEnMinutos());
            System.out.println("\tGenero: " + pelicula.getGenero());
            System.out.println("\tAño: " + pelicula.getGenero());
            System.out.println("\tActores: ");
            for (ActorModel actor : pelicula.getActores()) {
                System.out.println("\t\t" + actor.getNombre() + " " + actor.getApellido());
            }
            System.out.println("---------------------------------------------------------------------------");
        }
    }
}
