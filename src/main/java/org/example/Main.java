package org.example;

import org.example.Cuentas.CuentaBancaria;
import org.example.Cuentas.ImpresorCuenta;
import org.example.Notificaciones.GestorNotificaciones;
import org.example.Notificaciones.NotificadorEmail;

import java.util.Arrays;

// App Bancaria
public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Pepe", "12345678", 1000);
        ImpresorCuenta impresor = new ImpresorCuenta();

        String miCorreo = "ambargorgon@gmail.com";
        String miPasswordApp = "tkfl pmyy eaho nsed";

        NotificadorEmail emailReal = new NotificadorEmail(miCorreo, miPasswordApp);

        GestorNotificaciones gestor = new GestorNotificaciones(Arrays.asList(emailReal));

        cuenta.depositar(500);
        cuenta.retirar(200);

        impresor.imprimirDetallesCuenta(cuenta);
        String correoCliente = "ambargrogon@gmail.com";
        float montoDepositado = 150000f;

        gestor.notificar(
                correoCliente,
                "Hola. Se ha registrado un depósito de $" + montoDepositado + " en tu cuenta. Saludos."
        );

    }
}