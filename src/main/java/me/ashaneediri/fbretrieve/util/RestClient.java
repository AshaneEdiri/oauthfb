package me.ashaneediri.fbretrieve.util;

import me.ashaneediri.fbretrieve.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.net.URI;

/**
 * Util class used for http usages.
 *
 */
@Component
public class RestClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${fb.auth.client_id}")
    private String clientId;

    @Value("${fb.auth.client_secret}")
    private String clientSecret;

    /**
     * Set the header name to "Authorization"
     * Set the header value to "Basic <Encoded<clientId:ClientSecret>>"
     *
     * @return HttpHeaders
     */
    private HttpHeaders getRequestHeader() {

        HttpHeaders headers = new HttpHeaders();
        headers.add(Constants.Headers.AUTHORIZATION, Constants.Headers.BASIC.concat(EncodingUtility.getBase64EncodedString(clientId.concat(":").concat(clientSecret))));
        headers.add(Constants.Headers.CONTENT_TYPE, Constants.Headers.APPLICATION_JSON);
        return headers;
    }

    /**
     * Set the header name to "Authorization"
     * Set the header value to "Bearer <token>"
     *
     * @param token Access Token
     * @return HttpHeaders
     */
    private HttpHeaders getRequestHeader(String token) {

        HttpHeaders headers = new HttpHeaders();
        headers.add(Constants.Headers.AUTHORIZATION, Constants.Headers.BEARER.concat(token));
        return headers;
    }

    /**
     * Generic method for GET requests with the access token
     *
     * @param url        service url
     * @param token      auth token
     * @param classObj   Response Type <T>
     * @param <T>        response
     * @return ResponseEntity<T>
     */
    public <T> ResponseEntity<T> restExchange(String url, String token, Class<T> classObj) {
        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(this.getRequestHeader(token)), classObj);
    }

    /**
     * Generic method for GET requests with the access token
     * This is suitable to the requests with complex query params
     *
     * @param url        service url
     * @param token      auth token
     * @param classObj   Response Type <String>
     * @return ResponseEntity<String>
     */
    public <T> ResponseEntity<T> restExchangeWithParams(URI url, String token, Class<T> classObj) {
        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(this.getRequestHeader(token)), classObj);
    }

    /**
     * Retrieve the response with access token,token_type and expires_in for the given request
     *
     * @param url           request url
     * @param entity        request body
     * @param httpMethod    http request method
     * @param classObj      Response Type <T>
     * @param <T>           response
     * @return ResponseEntity<T>
     */
    public <T> ResponseEntity<T> tokenExchange(String url, Object entity, HttpMethod httpMethod, Class<T> classObj) {
        return restTemplate.exchange(url, httpMethod, new HttpEntity<>(entity, this.getRequestHeader()), classObj);
    }
}
