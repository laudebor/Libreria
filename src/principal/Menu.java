package principal;

import java.util.Scanner;
import serivicios.AutorServicio;
import serivicios.EditorialServicio;
import serivicios.LibroServicio;

public class Menu {

    private final AutorServicio autorServicio;
    private final LibroServicio libroServicio;
    private final EditorialServicio editorialServicio;
    private Scanner scan = new Scanner(System.in);

    public Menu() {
        this.autorServicio = new AutorServicio();
        this.libroServicio = new LibroServicio();
        this.editorialServicio = new EditorialServicio();
    }

    public void Ejecucion() {
        System.out.println("");
        System.out.println("----LIBRERÍA----");
        System.out.println("");
        System.out.println("1) Dar de alta/baja un libro");
        System.out.println("2) Dar de alta/baja un autor");
        System.out.println("3) Dar de alta/baja una editorial");
        System.out.println("4) Buscar autor por nombre");
        System.out.println("5) Buscar libro por ISBN");
        System.out.println("6) Buscar libro por título");
        System.out.println("7) Buscar libro/s por nombre de autor");
        System.out.println("8) Buscar libro/s por nombre de editorial");
        System.out.println("9) Salir");
        String resp;
        try {

            do {
                System.out.println("");
                System.out.print("Ingrese una opción (1-9): ");
                resp = scan.next();

                while (!resp.equals("1") && !resp.equals("2") && !resp.equals("3") && !resp.equals("4") && !resp.equals("5") && !resp.equals("6") && !resp.equals("7") && !resp.equals("8") && !resp.equals("9")) {
                    System.out.println("La respuesta ingresada es incorrecta. Debe ingresar un número del 1 al 9.");
                    System.out.print("Ingrese una opción: ");
                    resp = scan.next();
                }

                System.out.println("1) Dar de alta/baja un libro");
                System.out.println("2) Dar de alta/baja un autor");
                System.out.println("3) Dar de alta/baja una editorial");
                System.out.println("4) Buscar autor por nombre");
                System.out.println("5) Buscar libro por ISBN");
                System.out.println("6) Buscar libro por título");
                System.out.println("7) Buscar libro/s por nombre de autor");
                System.out.println("8) Buscar libro/s por nombre de editorial");
                System.out.println("9) Salir");

                switch (resp) {
                    case "1":
                        System.out.println("Has seleccionado la opción 'dar de alta/baja un libro'");
                        System.out.print("Deseas dar de alta o baja? (A/B): ");
                        String altaOBajaL = scan.next();
                        while (!altaOBajaL.equalsIgnoreCase("A") && !altaOBajaL.equalsIgnoreCase("B")) {
                            System.out.println("Respuesta inválida.");
                            System.out.print("Deseas dar de alta o baja? (A/B): ");
                            altaOBajaL = scan.next();
                        }
                        if (altaOBajaL.equalsIgnoreCase("A")) {
                            libroServicio.darAltaLibro();
                        } else {
                            libroServicio.darBajaLibro();
                        }
                        break;

                    case "2":
                        System.out.println("Has seleccionado la opción 'dar de alta/baja un autor'");
                        System.out.print("Deseas dar de alta o baja? (A/B): ");
                        String altaOBajaA = scan.next();
                        while (!altaOBajaA.equalsIgnoreCase("A") && !altaOBajaA.equalsIgnoreCase("B")) {
                            System.out.println("Respuesta inválida.");
                            System.out.print("Deseas dar de alta o baja? (A/B): ");
                            altaOBajaA = scan.next();
                        }
                        if (altaOBajaA.equalsIgnoreCase("A")) {
                            autorServicio.darAltaAutor();
                        } else {
                            autorServicio.darBajaAutor();
                        }
                        break;

                    case "3":
                        System.out.println("Has seleccionado la opción 'dar de alta/baja una editorial'");
                        System.out.print("Deseas dar de alta o baja? (A/B): ");
                        String altaOBajaE = scan.next();
                        while (!altaOBajaE.equalsIgnoreCase("A") && !altaOBajaE.equalsIgnoreCase("B")) {
                            System.out.println("Respuesta inválida.");
                            System.out.print("Deseas dar de alta o baja? (A/B): ");
                            altaOBajaE = scan.next();
                        }
                        if (altaOBajaE.equalsIgnoreCase("A")) {
                            autorServicio.darAltaAutor();
                        } else {
                            autorServicio.darBajaAutor();
                        }
                        break;

                    case "4":
                        System.out.println("Has seleccionado la opción 'buscar autor por nombre'");
                        autorServicio.BuscarAutoresNombre();
                        break;

                    case "5":
                        System.out.println("Has seleccionado la opción 'buscar libro por ISBN'");
                        libroServicio.buscarLibroISBN();
                        break;

                    case "6":
                        System.out.println("Has seleccionado la opción 'buscar libro por título'");
                        libroServicio.buscarLibrosNombre();
                        break;

                    case "7":
                        System.out.println("Has seleccionado la opción 'buscar libro por nombre de autor'");
                        libroServicio.buscarLibrosNombreAutor();
                        break;

                    case "8":
                        System.out.println("Has seleccionado la opción 'buscar libro por nombre de editorial'");
                        libroServicio.buscarLibrosNombreEditorial();
                        break;

                    case "9":
                        System.out.println("ADIOS");
                        break;

                }

            } while (!resp.equals("9"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
