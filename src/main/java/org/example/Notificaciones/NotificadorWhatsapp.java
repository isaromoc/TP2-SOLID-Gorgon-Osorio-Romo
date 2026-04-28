package org.example.Notificaciones;

public class NotificadorWhatsapp implements CanalNotificacion {
    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("Enviando WhatsApp a " + destino + ": " + mensaje);
    }
}