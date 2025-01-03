package RufHelenaJuegoPeliculas;

import java.util.ArrayList;
import  java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class RufHelenaMain {

    public static void main(String[] args) {
        RufHelenaMain programa = new RufHelenaMain();
        programa.inicio();
            }
    private ArrayList<String> listadoPeliculas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private boolean exit = false;
    String pelicula;
    String peliculaOculta;

    public void inicio() {
        try {
            File file = new File("ListadoPeliculas.txt");
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                listadoPeliculas.add(input.nextLine());
            }
            input.close();

            System.out.println("️¡Bienvenido a 'Adivina la Película'! ️🎬");
            mostrarMenu();

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se pudo encontrar el archivo 'ListadoPeliculas.txt.txt'.");
        }
    }

    public void mostrarMenu() {
        while (!exit) {

            System.out.println("Menú de opciones. Seleccione una opción");
            System.out.println("[1] 🎦 Adivina una letra ");
            System.out.println("[2] 🎞️ Adivina el título de la película");
            System.out.println("[3] ❌Salir");
            System.out.println("Selecciona una opción: ");

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
    public void adivinaNombrePelicula () {
        if (listadoPeliculas.isEmpty()) {
            System.out.println("No hay películas disponibles para jugar.");
            return;
        }

        pelicula = listadoPeliculas.get(new Random().nextInt(listadoPeliculas.size())).toLowerCase();
        peliculaOculta = pelicula.replaceAll("[a-zA-Z]", "*");

        System.out.print("Adivina el título de la película: "+ peliculaOculta);

        String tituloUsuario = scanner.nextLine().toLowerCase();


        if (tituloUsuario.equals(pelicula.toLowerCase())) {
            System.out.println("¡Correcto! Adivinaste el título.");
            System.out.println("Puntuación: 20 puntos.");
        } else {
            System.out.println("Incorrecto. El título era: " + pelicula);
            System.out.println("Puntuación: -20 puntos.");
        }
    }

    public void adivinaLetraPelicula() {

        if (listadoPeliculas.isEmpty()) {
            System.out.println("No hay película disponible para poder jugar.");
            return;
        }
        pelicula = listadoPeliculas.get(new Random().nextInt(listadoPeliculas.size())).toLowerCase();
        peliculaOculta = pelicula.replaceAll("[a-zA-Z]", "*");
        ArrayList<Character> letrasAdivinadas = new ArrayList<>();
        ArrayList<Character> letrasIncorrectas = new ArrayList<>();
        int intentosRestantes = 10;
        int puntuacion = 0;

        while (intentosRestantes > 0 && peliculaOculta.contains("*")) {

            System.out.println("Estado actual: " + peliculaOculta);
            System.out.println("Letras incorrectas: " + letrasIncorrectas);
            System.out.println("Intentos restantes: " + intentosRestantes);
            System.out.print("Introduce una letra: ");

            char letra = scanner.nextLine().toLowerCase().charAt(0);

            if (letrasAdivinadas.contains(letra) || letrasIncorrectas.contains(letra)) {
                System.out.println("Ya has adivinado esta letra. Intenta otra.");

            } else if (pelicula.toLowerCase().contains(String.valueOf(letra))) {
                letrasAdivinadas.add(letra);
                puntuacion += 10;
                peliculaOculta = actualizaEstado(pelicula, letrasAdivinadas);

            } else {
                letrasIncorrectas.add(letra);
                puntuacion -= 10;
                intentosRestantes--;
            }
        }
        if (!peliculaOculta.contains("*")) {
            System.out.println("¡Felicidades! Has adivinado el título: " + pelicula);
            System.out.println("Puntuación final: " + puntuacion);
        } else {
            System.out.println("Lo siento, no has adivinado el título. El título era: " + pelicula);
            System.out.println("Puntuación final: " + puntuacion);
        }
    }
        public String actualizaEstado (String pelicula, ArrayList<Character> letrasAdivinadas){
            StringBuilder estadoBuilder = new StringBuilder();

            for (char c : pelicula.toCharArray()) {
                if (letrasAdivinadas.contains(c)) {
                    estadoBuilder.append(c);
                } else {
                    estadoBuilder.append('*');
                }
            }

            return estadoBuilder.toString();
        }


    }





