import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner(System.in);
        Archivo archivo = new Archivo();
        ArrayList<Contacto> contactos = new ArrayList<>();
        ArrayList<Contacto> contactosCoinsidentes = new ArrayList<>();

        String nombre, apellido, email, telefono;
        int dni;
        int opcion = 0;
        boolean salir = false;

        do {
            boolean salirOpcion = false;
            do {
                System.out.println(" ---- Menu -----");
                System.out.println("1- Nuevo contacto.");
                System.out.println("2- Listar todos los contactos.");
                System.out.println("3- Buscar contacto por nombre o apellido");
                System.out.println("4- Buscar contacto por DNI.");
                System.out.println("5- Eliminar contacto por DNI");
                System.out.println("6- imprimir en un archivo.");
                System.out.println("7- Editar contacto.");
                System.out.println("99- salir.");

                try {
                    opcion = sc.nextInt();
                    salirOpcion = true;

                } catch (InputMismatchException ex){
                    System.out.println("Debe de ingresar un numero como opcion!");
                }
                sc.nextLine();
            } while (!salirOpcion);


            switch (opcion){
                case 1:
                    do {
                        salirOpcion = false;
                        try {
                            System.out.println(" -- Nuevo contacto -- ");
                            System.out.println("Nombre: ");
                            nombre = sc.nextLine();
                            System.out.println("Apellido: ");
                            apellido = sc.nextLine();
                            System.out.println("Telefono: ");
                            telefono = sc.nextLine();
                            System.out.println("Correo electronico: ");
                            email = sc.nextLine();
                            System.out.println("DNI:");
                            dni = sc.nextInt();
                            salirOpcion = true;
                            contactos.add(new Contacto(nombre,apellido,dni,telefono,email));
                        } catch (InputMismatchException ex){
                            System.out.println("ERROR EN EL INGRESO DE DATOS!");
                        }
                        sc.nextLine();
                    } while (!salirOpcion);

                    break;
                case 2:
                    System.out.println(" --- Lista de contactos ---");
                    for (Contacto c: contactos) {
                        System.out.println(c.toString());
                    }
                    System.out.println("Existen "+contactos.size() + " contactos.");

                    break;
                case 3:
                    System.out.println(" --- Buscar contacto por nombre o apellido ---");
                    System.out.println("Ingrese nombre o apellido: ");
                    nombre = sc.nextLine();

                    contactosCoinsidentes.clear();
                    for (Contacto c: contactos) {
                        if (c.encontrarContacto(nombre)){
                            contactosCoinsidentes.add(c);
                        }
                    }

                    if (contactosCoinsidentes.size() > 0){
                        for (Contacto c:contactosCoinsidentes) {
                            System.out.println(c.toString());
                        }
                    } else {
                        System.out.println("NO EXISTEN CONTACTOS QUE COINCIDAN CON EL CRITERIO!");
                    }

                    break;
                case 4:
                    System.out.println("--- Buscar contacto por DNI ---");
                    do {
                        salirOpcion = false;

                        try {
                            System.out.println("Ingrese el dni: ");
                            dni = sc.nextInt();

                            contactosCoinsidentes.clear();
                            for (Contacto c: contactos) {
                                if (c.contactoCoincide(dni)){
                                    contactosCoinsidentes.add(c);
                                }
                            }

                            if (contactosCoinsidentes.size() > 0){
                                System.out.println(contactosCoinsidentes.toString());
                            } else {
                                System.out.println("NO EXISTE CONTACTO CON DNI = "+dni);
                            }
                            salirOpcion = true;
                        } catch (InputMismatchException e){
                            System.out.println("Debe de ingresar un numero como DNI");
                        }
                        sc.nextLine();
                    } while (!salirOpcion);

                    break;
                case 5:
                    System.out.println(" --- Eliminar contacto por DNI ---");

                    do {
                        salirOpcion = false;

                        try {
                            boolean borroContacto = false;
                            System.out.println("Ingrese el dni: ");
                            dni = sc.nextInt();

                            contactosCoinsidentes.clear();
                            for (Contacto c: contactos) {
                                if (c.contactoCoincide(dni)){
                                    contactosCoinsidentes.add(c);
                                    //contactos.remove(contactoBorrar); // error ConcurrentModificationExeption
                                    borroContacto = true;
                                }
                            }

                            if (!borroContacto){
                                System.out.println("NO EXISTE CONTACTO CON EL DNI "+ dni);
                            } else {
                                for (Contacto cc: contactosCoinsidentes) {
                                    contactos.remove(cc);
                                }
                            }

                            salirOpcion = true;
                        }catch (InputMismatchException e){
                            System.out.println("Debe de ingresar un numero para el DNI");
                        }
                        sc.nextLine();
                    } while (!salirOpcion);

                    break;
                case 6:
                    System.out.println(" --- Imrpimir en un archivo .txt");
                    archivo.imprimir(contactos.toString());

                    break;
                case 7:
                    System.out.println(" --- Editar contacto ---");

                    do {
                        salirOpcion = false;

                        try {
                            System.out.println("Ingrese el DNI para buscar el contacto: ");
                            dni = sc.nextInt();
                            sc.nextLine();

                            boolean existeContacto = false;
                            for (Contacto c: contactos) {
                                if (c.contactoCoincide(dni)){
                                    System.out.println(" --- Modificando contacto ---");
                                    System.out.println("Nombre: ");
                                    nombre = sc.nextLine();
                                    System.out.println("Apellido: ");
                                    apellido = sc.nextLine();
                                    System.out.println("Telefono: ");
                                    telefono = sc.nextLine();
                                    System.out.println("Correo electronico: ");
                                    email = sc.nextLine();

                                    c.modificarContacto(nombre,apellido,telefono,email);
                                    existeContacto = true;
                                }
                            }

                            if (!existeContacto) {
                                System.out.println("NO EXISTE EL CONTACTO CON EL DNI: "+ dni);
                            }

                            salirOpcion = true;
                        }catch (InputMismatchException e){
                            System.out.println("DEBE DE INGRESAR NUMEROS PARA EL DNI");
                        }
                        sc.nextLine();
                    } while (!salirOpcion);

                    break;
                case 99:
                    salir = true;
                    break;
                default:
                    System.out.println("OPCION INCORRECTA!");
            }

        } while (!salir);

    }

}
