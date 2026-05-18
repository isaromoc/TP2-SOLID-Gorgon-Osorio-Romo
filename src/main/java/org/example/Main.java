package org.example;

import org.example.Cuentas.CuentaCorriente;
import org.example.Cuentas.CuentaDeAhorro;
import org.example.Cuentas.ImpresorCuenta;
import org.example.Repositorios.RepositorioCuentas;
import org.example.Notificaciones.CanalNotificacion;
import org.example.Notificaciones.GestorNotificaciones;
import org.example.Notificaciones.NotificadorEmail;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ImpresorCuenta impresor = new ImpresorCuenta();
        RepositorioCuentas repositorio = new RepositorioCuentas();

        // Mail por donde se envia la notificaciones
        String miCorreo = "ambargorgon@gmail.com";
        String miPasswordApp = "htij gvvc tvlq fhop";

        CanalNotificacion emailReal = new NotificadorEmail(miCorreo, miPasswordApp);
        GestorNotificaciones gestor = new GestorNotificaciones(Arrays.asList(emailReal));

        // Carga de los 10 usuarios
        repositorio.agregarCuenta(new CuentaDeAhorro("Ambar", "11111111", 5000));
        repositorio.agregarCuenta(new CuentaCorriente("Pablo", "22222222", 2000, 1000));
        repositorio.agregarCuenta(new CuentaDeAhorro("Isabella", "33333333", 1500));
        repositorio.agregarCuenta(new CuentaCorriente("Juan", "44444444", 3000, 500));
        repositorio.agregarCuenta(new CuentaDeAhorro("Maria", "55555555", 8000));
        repositorio.agregarCuenta(new CuentaCorriente("Pedro", "66666666", 1000, 200));
        repositorio.agregarCuenta(new CuentaDeAhorro("Lucia", "77777777", 4500));
        repositorio.agregarCuenta(new CuentaCorriente("Marcos", "88888888", 6000, 1500));
        repositorio.agregarCuenta(new CuentaDeAhorro("Sofia", "99999999", 7200));
        repositorio.agregarCuenta(new CuentaCorriente("Diego", "10101010", 9000, 2000));

        MenuTerminal menu = new MenuTerminal(repositorio, impresor, gestor) ;
        menu.iniciar();
    }
}