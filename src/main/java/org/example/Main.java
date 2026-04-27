package org.example;

// App Bancaria
public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Pepe", "12345678", 1000);
        ImpresorCuenta impresor = new ImpresorCuenta();
        Notificador notificador = new Notificador();

        cuenta.depositar(500);
        cuenta.retirar(200);

        impresor.imprimirDetallesCuenta(cuenta);
        notificador.enviarNotificacionPorEmail(cuenta.getTitular(), "Notificación exitosa!");
    }
}