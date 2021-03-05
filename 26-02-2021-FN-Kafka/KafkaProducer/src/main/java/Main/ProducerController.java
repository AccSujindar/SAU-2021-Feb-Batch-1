package Main;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class ProducerController {

	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
 
    @Autowired
    private Gson gson;
    
    @PostMapping("/produce")
    public ResponseEntity<String> postModelToKafka(@RequestBody OrderDetails od)
            throws InterruptedException, ExecutionException {
    	System.out.println(od);
        ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send("test", gson.toJson(od));
        return new ResponseEntity<String>(result.get().getProducerRecord().value(), HttpStatus.OK);
    }
}
