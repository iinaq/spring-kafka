package com.iinaq.json.consumer;

import com.iinaq.json.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName Receiver
 * @Description TODO
 * @Author zhouzhongshan
 * @Date 2019/7/30  16:16
 **/
public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${kafka.topic.json}")
    public void receive(Car car) {
        LOGGER.info("received car='{}'", car.toString());
        latch.countDown();
    }
}
