package org.example.Notificaciones;

import java.util.List;

public class GestorNotificaciones {
    private List<CanalNotificacion> canalesActivos;

    public GestorNotificaciones(List<CanalNotificacion> canalesActivos) {
        this.canalesActivos = canalesActivos;
    }

    public void notificar(String destino, String mensaje) {
        for (CanalNotificacion canal : canalesActivos) {
            canal.enviar(destino, mensaje);
        }
    }
}
