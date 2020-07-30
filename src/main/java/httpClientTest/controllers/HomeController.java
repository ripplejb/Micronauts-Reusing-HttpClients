package httpClientTest.controllers;

import httpClientTest.packages.MyWebClient;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@Controller()
public class HomeController {

  @Inject
  List<MyWebClient> myWebClients;

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

}
