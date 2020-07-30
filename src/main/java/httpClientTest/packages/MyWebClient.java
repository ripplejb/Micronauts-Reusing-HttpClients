package httpClientTest.packages;

import io.micronaut.http.annotation.Get;
import io.reactivex.Maybe;

public interface MyWebClient {

  @Get()
  Maybe<String> get();

}
