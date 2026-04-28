package org.example.Notificaciones;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class NotificadorEmail implements CanalNotificacion {

    private final String correoRemitente;
    private final String passwordApp;

    // Pasamos las credenciales
    public NotificadorEmail(String correoRemitente, String passwordApp) {
        this.correoRemitente = correoRemitente;
        this.passwordApp = passwordApp;
    }

    @Override
    public void enviar(String destino, String mensaje) {
        // 1. Configuración del servidor SMTP de Gmail
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Seguridad requerida por Gmail
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // 2. Creación de la sesión con tus credenciales
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(correoRemitente, passwordApp);
            }
        });

        try {
            // 3. Armado del correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destino));
            message.setSubject("Notificación Importante - Sistema Bancario");
            message.setText(mensaje);

            // 4. Envío por la red
            System.out.println("Conectando con Google para enviar a " + destino + "...");
            Transport.send(message);
            System.out.println("¡Correo real enviado exitosamente!");

        } catch (MessagingException e) {
            System.err.println("Falló el envío del correo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}