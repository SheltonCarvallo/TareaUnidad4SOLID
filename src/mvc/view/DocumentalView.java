package mvc.view;

import mvc.models.documental.DocumentalModel;
import mvc.models.documental.InvestigadorModel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class DocumentalView {
    Scanner scanner = new Scanner(System.in);

    public int mostrarDocumentalMenu() {
        System.out.println("Seleccione una de las siguientes opciones");
        System.out.println("1. Agregar documental");
        System.out.println("2. Mostrar documentales");
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

    public String ingresarTituloDocumental() {
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

    public String ingresarGeneroDocumental() {
        scanner.nextLine();
        System.out.print("Ingrese el genero del documental: ");
        return scanner.nextLine();
    }

    public ArrayList<InvestigadorModel> ingresarInvestigadoresDocumental() {
        boolean exit = false;
        ArrayList<InvestigadorModel> investigadores = new ArrayList<>();
        System.out.println("Ingrese los investigadores");
        do {
            System.out.println("Nombre investigador: ");
            String nombreInvestigador = scanner.next();
            System.out.println("Apellido investigador: ");
            String apellidoInvestigador = scanner.next();
            InvestigadorModel investigador = new InvestigadorModel(nombreInvestigador, apellidoInvestigador);
            investigadores.add(investigador);
            System.out.println("Deseas agregar otro investigador? (Y/N)");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("n")) {
                exit = true;
            }
        } while (!exit);
        return investigadores;
    }

    public void mostrarInformacionDocumental(ArrayList<DocumentalModel> documentales) {
        if (documentales.isEmpty()) {
            System.out.println("No hay documentales registrados");
            return;
        }
        System.out.println("--------------------DOCUMENTALES-----------------------");
        for (DocumentalModel documental : documentales) {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("\tTitulo: " + documental.getTitulo());
            System.out.println("\tDuracion en minutos: " + documental.getDuracionEnMinutos());
            System.out.println("\tGenero: " + documental.getGenero());
            System.out.println("\tInvestigadores: ");
            for (InvestigadorModel investigador : documental.getInvestigadores()) {
                System.out.println("\t\t" + investigador.getNombre() + " " + investigador.getApellido());
            }
            System.out.println("---------------------------------------------------------------------------");
        }
    }

}


