package com.miapp.prueba.service;

import org.eclipse.paho.client.mqttv3.MqttClient;

public class MqttPublisherServiceBuilder {
    private MqttClient mqttClient;

    public MqttPublisherServiceBuilder setMqttClient(MqttClient mqttClient) {
        this.mqttClient = mqttClient;
        return this;
    }

    public MqttPublisher createMqttPublisherService() {
        return new MqttPublisher(mqttClient);
    }
}