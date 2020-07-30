package httpClientTest.clients;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;
import javax.inject.Inject;

public class LowLevelClient {

  String urlBase;

  public LowLevelClient() {
  }

  @Client() @Inject
  RxHttpClient client;

  @Get()
  public Flowable<String> get(String code) {
    if (code.equals("google")) {
      urlBase = "https://www.google.com";
    }
    if (code.equals("microsoft")) {
      urlBase = "https://www.microsoft.com";
    }
   return client.retrieve(urlBase);
  }


}
