package fr.uphf.PABLClient.service;
import fr.uphf.PABLClient.entity.Client;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiverService {
    @RabbitListener(queues = "client_created_queue")
    public void receiveMessage(final String message) {
        System.out.println("Received a new message: " + message);
    }
}