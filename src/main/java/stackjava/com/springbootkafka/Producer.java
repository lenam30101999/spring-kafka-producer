package stackjava.com.springbootkafka;

import chozoi.statistical.content.Statistics;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Service
@Log4j2
public class Producer {

  @Autowired
  private KafkaTemplate<String, Statistics> kafkaTemplate;

  public void send(FavoriteEventContent favoriteEventContent) {
    LocalDateTime now = LocalDateTime.now();
    long seconds = now.toEpochSecond(ZoneOffset.UTC);
    String content = JsonParser.toJson(favoriteEventContent);

    Statistics statistics = new Statistics();
    statistics.setId(UUID.randomUUID().toString());
    statistics.setCreatedAt(seconds);
    statistics.setType("favorite");
    statistics.setContent(content);

    log.info("====SEND====" + statistics.toString());
    kafkaTemplate.send(Topic.STATISTICS, statistics);
  }
}
