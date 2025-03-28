package com.miapp.prueba.controller;

import com.miapp.prueba.service.MqttPublisher;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mqtt")
public class MqttController {

    private final MqttPublisher mqttPublisher;

    public MqttController(MqttPublisher mqttPublisher) {
        this.mqttPublisher = mqttPublisher;
    }

    @PostMapping("/publish")
    public String publishMessage(@RequestParam String topic, @RequestParam String message) {
        try {
            mqttPublisher.publish(topic, message);
            return "Mensaje enviado al topic " + topic;
        } catch (MqttException e) {
            return "Error al enviar mensaje: " + e.getMessage();
        }
    }
}
