package httpClientTest.packages;

import io.micronaut.http.client.annotation.Client;

@Client("${client.google}")
public interface GoogleClient extends MyWebClient{

}
