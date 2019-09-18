package me.ashaneediri.fbretrieve.service;

import me.ashaneediri.fbretrieve.constant.Constants;
import me.ashaneediri.fbretrieve.dto.AccessTokenRequestDTO;
import me.ashaneediri.fbretrieve.dto.AccessTokenResponseDTO;
import me.ashaneediri.fbretrieve.dto.AccessTokenDTO;
import me.ashaneediri.fbretrieve.util.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * Service Class to Authentication
 *
 */
@Service
public class FbAuthService {

    @Value("${fb.graph.url.accessToken}")
    private String accessTokenUrl;

    @Value("${fb.redirect.url}")
    private String redirectUrl;

    @Value("${fb.auth.client_id}")
    private String clientId;

    @Autowired
    private RestClient restClient;

    @Autowired
    private AccessTokenDTO accessTokenDTO;

    /**
     * Retrieve the access_token,token_type,expires_in for given request
     *
     * @param code  The authorization code received
     * @return token_type
     */
    public String obtainAccessToken(String code) {

        AccessTokenRequestDTO request = new AccessTokenRequestDTO();
        request.setClient_id(clientId);
        request.setGrant_type(Constants.AUTHORIZATION_CODE);
        request.setRedirect_uri(redirectUrl);
        request.setCode(code.concat("#_=_"));

        // retrieve access_token,token_type,expires_in
        AccessTokenResponseDTO response = restClient.tokenExchange(accessTokenUrl, request, HttpMethod.POST, AccessTokenResponseDTO.class).getBody();
        accessTokenDTO.setAccessToken(response.getAccess_token());

        return response.getToken_type();
    }
}
