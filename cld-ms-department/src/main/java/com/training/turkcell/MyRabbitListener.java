package com.training.turkcell;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "dep_event_q",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "dep_exch",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "department.it"))
    @SendTo("dep_response_exch/department.reponse")
    public String listenIT(final Department dep) {
        System.out.println("IT data : " + dep);
        return "IT data processed id : " + dep.getId();
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "finans_event_q",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "dep_exch",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "department.finans"))
    @SendTo("dep_response_exch/department.reponse")
    public String listenFINANS(final Department dep) {
        System.out.println("FINANS data : " + dep);
        return "FINANS data processed id : " + dep.getId();
    }

}
