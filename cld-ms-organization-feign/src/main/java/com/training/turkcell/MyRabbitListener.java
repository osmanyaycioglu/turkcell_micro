package com.training.turkcell;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "dep_response_q",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "dep_response_exch",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "department.reponse"))
    public void listenIT(final String response) {
        System.out.println(response);
    }


}
