package org.example.Notificaciones;

public class Notificador {
    public void enviarNotificacionPorEmail(String destino, String mensaje) {
        System.out.println("Enviando correo a " + destino + ": " + mensaje);
    }
}
