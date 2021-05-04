package stackjava.com.springbootkafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Topic {
  public static final String STATISTICS = "chozoi.statistical.test.1";

  @Value("${spring.kafka.topic.num-partitions}")
  private int numPartitions;

  @Value("${spring.kafka.topic.replication-factor}")
  private short replicationFactor;

  @Bean
  public NewTopic domainEventTopic() {
    return new NewTopic(STATISTICS, numPartitions, replicationFactor);
  }
}
