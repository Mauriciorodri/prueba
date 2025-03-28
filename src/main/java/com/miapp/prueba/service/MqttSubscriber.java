package com.miapp.prueba.service;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class MqttSubscriber implements MqttCallback {

    private final MqttClient mqttClient;

    public MqttSubscriber(MqttClient mqttClient) {
        this.mqttClient = mqttClient;
    }

    @PostConstruct
    public void subscribe() throws MqttException {
        mqttClient.setCallback(this);
        mqttClient.subscribe("mi/topico"); // Suscribirse al topic "mi/topico"
    }

    @Override
    public void connectionLost(Throwable cause) {
        System.out.println("Conexión perdida con el broker MQTT");
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) {
        System.out.println("Mensaje recibido en el topic " + topic + ": " + new String(message.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("Entrega completa");
    }
}
