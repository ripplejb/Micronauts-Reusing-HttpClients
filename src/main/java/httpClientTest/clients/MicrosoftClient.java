package httpClientTest.clients;

import io.micronaut.http.client.annotation.Client;

@Client("${client.microsoft}")
public interface MicrosoftClient extends MyWebClient {

}
