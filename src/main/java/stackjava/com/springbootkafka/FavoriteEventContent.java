package stackjava.com.springbootkafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteEventContent {
  private Integer userId;
  private Long productId;
  private Integer shopId;
  private String type;
  private String productType;
}
