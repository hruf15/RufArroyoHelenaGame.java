import java.util.ArrayList;
import  java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    private ArrayList<String> listadoPeliculas  = new ArrayList<>();
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
                listadoPeliculas.add(input.nextLine());
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
                        adivinaLetraPelicula();
                        break;
                    case 2:
                        adivinaNombrePelicula();
                        break;
                   case 3:
                        System.out.println("Ha escogido Salir. Gracias por su colaboración");
                        exit = true;
                        break;
                    default:
                        System.out.println("Enrada no válida. Seleccione una opción");
                }
            } else {
                System.out.println("Opción incorrecta. Vuelva a introducir la opción deseada");
                scanner.nextLine();
            }
        }
    }

    public void adivinaLetraPelicula(){

        if (listadoPeliculas.isEmpty()){
            System.out.println("No hay película disponible para poder jugar.");
            return;
        }
        String pelicula =listadoPeliculas.get(new Random().nextInt(listadoPeliculas.size()));
        String estado = pelicula.replaceALL("[a-zA-Z]", "*");
        ArrayList<Character> letrasAdivinadas = new ArrayList<>();
        ArrayList<Character> letrasIncorrectas = new ArrayList<>();
        int intentosRestantes = 10;
        int puntuacion = 0;


        file = new File("ListadoPeliculas.txt");
        Scanner input = new Scanner(file);
        while (input.hasNextInt()){
            int value =input.nextInt();
            System.out.println("Letra escogida:");


        }
    }

            public void adivinaNombrePelicula(){}

        System.out.println("") ;
    }
