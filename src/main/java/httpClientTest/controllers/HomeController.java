package httpClientTest.controllers;

import httpClientTest.clients.LowLevelClient;
import httpClientTest.clients.MyWebClient;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Maybe;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@Controller()
public class HomeController {

  @Inject
  List<MyWebClient> myWebClients;

  @Inject
  LowLevelClient lowLevelClient;

  @Get("/{code}")
  public String GetHome(String code) {
    Optional<MyWebClient> myWebClient = myWebClients
        .stream()
        .filter(client -> client.getClass()
            .getSimpleName()
            .toLowerCase()
            .startsWith(code.toLowerCase()))
        .findFirst();
    if (myWebClient.isPresent()) {
      return myWebClient.get().get().blockingGet();
    }
    return "Wrong Code";
  }

  @Get("/2/{code}")
  public String GetHome2(String code) {
    return lowLevelClient.get(code).blockingFirst();
  }
}
