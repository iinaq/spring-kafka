package com.iinaq.json.producer;

import com.iinaq.json.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @ClassName Sender
 * @Description TODO
 * @Author zhouzhongshan
 * @Date 2019/7/30  16:17
 **/
public class Sender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Value("${kafka.topic.json}")
    private String jsonTopic;

    @Autowired
    private KafkaTemplate<String, Car> kafkaTemplate;

    public void send(Car car) {
        LOGGER.info("sending car='{}'", car.toString());
        kafkaTemplate.send(jsonTopic, car);
    }
}
