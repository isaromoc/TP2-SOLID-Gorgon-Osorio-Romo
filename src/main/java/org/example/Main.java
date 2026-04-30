package org.example;

import org.example.Cuentas.CuentaBancaria;
import org.example.Cuentas.CuentaCorriente;
import org.example.Cuentas.CuentaDeAhorro;
import org.example.Cuentas.ImpresorCuenta;
import org.example.Notificaciones.CanalNotificacion;
import org.example.Notificaciones.GestorNotificaciones;
import org.example.Notificaciones.NotificadorEmail;

import java.util.Arrays;

// App Bancaria
public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaDeAhorro("Pepe", "12345678", 1000);
        CuentaBancaria cuenta2 = new CuentaCorriente("Pepa", "789456123", 1000, 1000);
        ImpresorCuenta impresor = new ImpresorCuenta();

        String miCorreo = "ambargorgon@gmail.com";
        String miPasswordApp = "tkfl pmyy eaho nsed";

        CanalNotificacion emailReal = new NotificadorEmail(miCorreo, miPasswordApp);

        GestorNotificaciones gestor = new GestorNotificaciones(Arrays.asList(emailReal));

        cuenta1.depositar(500);
        cuenta1.retirar(200);
        cuenta2.depositar(100);
        cuenta2.retirar(2000);

        impresor.imprimirDetallesCuenta(cuenta1);
        String correoCliente = "ambargrogon@gmail.com";
        float montoDepositado = 150000f;

        gestor.notificar(
                correoCliente,
                "Hola. Se ha registrado un depósito de $" + montoDepositado + " en tu cuenta. Saludos."
        );

    }
}