package dk.dd.rabbit;

import org.springframework.boot.SpringApplication;

public class RabbitCamelProducer {
    public static void main(String[] args) {
        String message = "YEEEEW";
        try {
            RabbitConfig rabbitConfig = new RabbitConfig();
            rabbitConfig.configConnection(message);

        } catch (Exception e){
            e.printStackTrace();
        }
        SpringApplication.run(RabbitCamelProducer.class,args);
    }
}
