package Main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class ConsumerController {
	
	@Autowired
    private Gson gson;
 
    @KafkaListener(topics = { "test" })
    public void getTopics(@RequestBody String od) {
        System.out.println("Kafka event consumed is: " + od);
        OrderDetails model = gson.fromJson(od, OrderDetails.class);
        System.out.println("Model converted value: " + model.toString());
    }

}
