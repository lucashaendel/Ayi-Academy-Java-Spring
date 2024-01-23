package org.example;

import org.example.entities.Persona;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();        while (true) {
            System.out.println("1. Leer personas");
            System.out.println("2. Crear persona");
            System.out.println("3. Actualizar datos");
            System.out.println("4. Eliminar persona");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    leerPersonas(sessionFactory);
                    break;
                case 2:
                    crearPersona(sessionFactory);
                    break;
                case 3:
                    actualizarDatos(sessionFactory);
                    break;
                case 4:
                    eliminarPersona(sessionFactory);
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    sessionFactory.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void leerPersonas(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Persona> personas = session.createQuery("FROM Persona", Persona.class).list();
            for (Persona persona : personas) {
                System.out.println("ID: " + persona.getId() + ", Nombre: " + persona.getNombre() + ", Apellido: " + persona.getApellido());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void crearPersona(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el apellido: ");
            String apellido = scanner.nextLine();

            Persona nuevaPersona = new Persona();
            nuevaPersona.setNombre(nombre);
            nuevaPersona.setApellido(apellido);

            session.save(nuevaPersona);

            session.getTransaction().commit();
            System.out.println("Persona creada exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void actualizarDatos(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el ID de la persona que desea actualizar: ");
            Long id = scanner.nextLong();

            Persona persona = session.get(Persona.class, id);
            if (persona != null) {
                System.out.print("Ingrese el nuevo nombre: ");
                String nuevoNombre = scanner.next();
                System.out.print("Ingrese el nuevo apellido: ");
                String nuevoApellido = scanner.next();

                persona.setNombre(nuevoNombre);
                persona.setApellido(nuevoApellido);

                session.update(persona);
                session.getTransaction().commit();
                System.out.println("Datos actualizados exitosamente.");
            } else {
                System.out.println("Persona no encontrada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void eliminarPersona(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el ID de la persona que desea eliminar: ");
            Long id = scanner.nextLong();

            Persona persona = session.get(Persona.class, id);
            if (persona != null) {
                session.delete(persona);
                session.getTransaction().commit();
                System.out.println("Persona eliminada exitosamente.");
            } else {
                System.out.println("Persona no encontrada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}