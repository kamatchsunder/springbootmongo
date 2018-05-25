package com.sunder.mongospringbootexample.config;

import com.sunder.mongospringbootexample.service.EventReceiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfiguration {

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }


    @Bean
    public TopicExchange topicExchange(){

        return new TopicExchange("sunder.log.exchange");
    }

    @Bean
    public Queue queue(){

        return new Queue("sunder.log.queue",false);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("sunder.log.#");
    }


    @Bean
    public RabbitTemplate eventTemplate(){

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setExchange("sunder.log.exchange");
        rabbitTemplate.setRoutingKey("sunder.log.queue");
        return rabbitTemplate;
    }



    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(MessageListenerAdapter messageListenerAdapter){

        SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer(connectionFactory());
        listenerContainer.setQueues(queue());
        listenerContainer.setMessageListener(messageListenerAdapter);

        return listenerContainer;
    }


    @Bean
    public MessageListenerAdapter messageListenerAdapter(){

        return new MessageListenerAdapter(new EventReceiver(),"receiveMessage");
    }


}
