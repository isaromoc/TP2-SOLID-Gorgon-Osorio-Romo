package org.example;

import org.example.Cuentas.CuentaBancaria;
import org.example.Cuentas.ImpresorCuenta;
import org.example.Repositorios.RepositorioCuentas;
import org.example.Notificaciones.GestorNotificaciones;

import java.util.Scanner;

public class MenuTerminal {
    private final RepositorioCuentas repositorio;
    private final ImpresorCuenta impresor;
    private final GestorNotificaciones gestorNotificaciones;
    private final Scanner scanner;

    public MenuTerminal(RepositorioCuentas repositorio, ImpresorCuenta impresor, GestorNotificaciones gestorNotificaciones) {
        this.repositorio = repositorio;
        this.impresor = impresor;
        this.gestorNotificaciones = gestorNotificaciones;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- BIENVENIDO AL BANCO ---");
            System.out.print("Ingrese su DNI (o 'salir' para terminar): ");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("salir")) {
                salir = true;
                System.out.println("Gracias por usar nuestro banco.");
                continue;
            }

            CuentaBancaria cuentaActual = repositorio.buscarPorDni(entrada);

            if (cuentaActual != null) {
                mostrarMenuUsuario(cuentaActual);
            } else {
                System.out.println("❌ Usuario no encontrado. Verifique el DNI.");
            }
        }
    }

    private void mostrarMenuUsuario(CuentaBancaria cuenta) {
        boolean cerrarSesion = false;

        while (!cerrarSesion) {
            System.out.println("\n--- Menú de " + cuenta.getTitular() + " ---");
            System.out.println("1. Ver Saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Cerrar Sesión");
            System.out.print("Elija una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    impresor.imprimirDetallesCuenta(cuenta);
                    break;
                case "2":
                    procesarMovimiento(cuenta, "depósito");
                    break;
                case "3":
                    procesarMovimiento(cuenta, "retiro");
                    break;
                case "4":
                    cerrarSesion = true;
                    System.out.println("Sesión cerrada.");
                    break;
                default:
                    System.out.println("❌ Opción no válida.");
            }
        }
    }

    private void procesarMovimiento(CuentaBancaria cuenta, String tipoMovimiento) {
        System.out.print("Ingrese monto a " + (tipoMovimiento.equals("depósito") ? "depositar" : "retirar") + ": ");
        try {
            float monto = Float.parseFloat(scanner.nextLine());

            if (tipoMovimiento.equals("depósito")) {
                cuenta.depositar(monto);
            } else {
                cuenta.retirar(monto);
            }

            System.out.println("✅ " + tipoMovimiento.substring(0, 1).toUpperCase() + tipoMovimiento.substring(1) + " procesado exitosamente.");

            System.out.print("¿A qué correo enviamos el comprobante? (Presione Enter para omitir): ");
            String emailDestino = scanner.nextLine();

            if (!emailDestino.trim().isEmpty()) {
                System.out.println("Enviando correo, por favor espere...");

                String mensaje = "Hola " + cuenta.getTitular() + ".\n\n"
                        + "Se ha registrado un " + tipoMovimiento + " de $" + monto + " en tu cuenta.\n"
                        + "Tu saldo actual es de: $" + cuenta.getSaldo() + "\n\n"
                        + "Gracias por operar con nosotros.";

                gestorNotificaciones.notificar(emailDestino, mensaje);
            } else {
                System.out.println("Comprobante omitido.");
            }

        } catch (NumberFormatException e) {
            System.out.println("❌ Monto inválido. Debe ingresar números.");
        }
    }
}