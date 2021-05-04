package stackjava.com.springbootkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/test")
public class Controller {

  @Autowired Producer producer;

  @PostMapping(path = "/sends")
  public ResponseEntity<?> sendData(@RequestBody FavoriteEventContent favoriteEventContent) {
    producer.send(favoriteEventContent);
    return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
  }
}
