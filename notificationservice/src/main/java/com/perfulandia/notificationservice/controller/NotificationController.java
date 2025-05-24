package com.perfulandia.notificationservice.controller;

import com.perfulandia.notificationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificationController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public String enviarCorreo(@RequestBody NotificationRequest request) {
        emailService.enviarCorreo(
                request.getDestinatario(),
                request.getAsunto(),
                request.getMensaje()
        );
        return "Correo enviado a " + request.getDestinatario();
    }
}