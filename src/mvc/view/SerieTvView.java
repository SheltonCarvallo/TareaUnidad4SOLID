package mvc.view;

import mvc.models.documental.DocumentalModel;
import mvc.models.documental.InvestigadorModel;
import mvc.models.serieTv.SerieTvModel;
import mvc.models.serieTv.TemporadaModel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SerieTvView {
    Scanner scanner = new Scanner(System.in);

    public int mostrarSerieTvMenu() {
        System.out.println("Seleccione una de las siguientes opciones");
        System.out.println("1. Agregar serie de tv");
        System.out.println("2. Mostrar serie de tv");
        System.out.println("3. Exit");
        try{
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return switch (opcion) {
                case 1 -> 1;
                case 2 -> 2;
                case 3 -> 3;
                default -> 0;
            };
        } catch(InputMismatchException ex){
            System.out.println("Por favor ingrese un opción que corresponda al menú mostrado en formato número");
            scanner.nextLine();
            return 0;
        }
    }

    public String ingresarTituloSerieTv() {
        System.out.print("Ingrese el titulo del documental: ");
        return scanner.nextLine();
    }

    public int ingresarDuracionMinutos() {
        System.out.print("Ingrese la duracion en minutos: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, ingrese un número entero válido:");
            scanner.next();  // Limpia input invalido
        }
        return scanner.nextInt();
    }

    public String ingresarGeneroSerieTv() {
        scanner.nextLine();
        System.out.print("Ingrese el genero de la serie de tv: ");
        return scanner.nextLine();
    }

    public ArrayList<TemporadaModel> ingresarTemporadas() {
        boolean exit = false;
        ArrayList<TemporadaModel> temporadas = new ArrayList<>();
        System.out.println("Ingrese las temporadas");
        do {
            System.out.println("Nombre temporada: ");
            String nombreTemporada = scanner.next();
            System.out.println("Ingrese numero de temporada");
            int numTemporada = scanner.nextInt();
            System.out.println("Ingrese numero de capítulos");
            int numCapitulos = scanner.nextInt();
            TemporadaModel temporada = new TemporadaModel(nombreTemporada, numTemporada, numCapitulos);
            temporadas.add(temporada);
            System.out.println("Deseas agregar otra temporada? (Y/N)");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("n")) {
                exit = true;
            }
        } while (!exit);
        return temporadas;
    }

    public void mostrarInformacionSerieTv(ArrayList<SerieTvModel> seriesTv) {
        if (seriesTv.isEmpty()) {
            System.out.println("No hay series de tv registradas");
            return;
        }
        System.out.println("--------------------SERIES TV-----------------------");
        for (SerieTvModel serieTv : seriesTv) {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("\tTitulo: " + serieTv.getTitulo());
            System.out.println("\tDuracion en minutos: " + serieTv.getDuracionEnMinutos());
            System.out.println("\tGenero: " + serieTv.getGenero());
            System.out.println("\tTemporadas: ");
            for (TemporadaModel temporada : serieTv.getListaTemporadas()) {
                System.out.println("\t\t" + temporada.getNombre() + " Numero temporada: " + temporada.getNumeroTemporada() + " Número de capítulos: " + temporada.getCapitulos());
            }
            System.out.println("---------------------------------------------------------------------------");
        }
    }
}
