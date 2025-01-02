import java.util.ArrayList;
import  java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    private ArrayList<String> guessMovies  = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private boolean exit = false;

    public static void main(String[] args) {
        Main programa = new Main();
        programa.inicio();
    }
    public void inicio() {
        try{
            File file = new File("ListadoPeliculas.txt");
            Scanner input = new Scanner(file);

            while (input.hasNextLine()){
                guessMovies.add(input.nextLine());
        }
        input.close();

            System.out.println("️¡Bienvenido a 'Adivina la Película'! ️🎬");
            mostrarMenu();

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se pudo encontrar el archivo 'ListadoPeliculas.txt'.");
        }
    }
    public void mostrarMenu() {
        while (!exit) {

            System.out.println("Menú de opciones. Seleccione una opción");
            System.out.println("[1] 🎦 Adivina una letra ");
            System.out.println("[2] 🎞️ Adivina el título de la película");
            System.out.println("[3] ❌Salir");
            System.out.println("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                int opcionMenu = scanner.nextInt();
                scanner.nextLine();

                switch (opcionMenu) {
                    case 1:
                        adivinaLetra();
                        break;
                    case 2:
                        adivinaPelicula();
                        break;
                   case 3:
                        System.out.println("Ha escogido Salir. Gracias por su colaboración");
                        exit = true;
                        break;
                }
            } else {
                System.out.println("Opción incorrecta. Vuelva a introducir la opción deseada");
                scanner.nextLine();
            }
        }
    }

        System.out.println("") ;
    }
