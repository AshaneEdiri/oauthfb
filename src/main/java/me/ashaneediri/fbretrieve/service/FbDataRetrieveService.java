package me.ashaneediri.fbretrieve.service;

import me.ashaneediri.fbretrieve.dto.AccessTokenDTO;
import me.ashaneediri.fbretrieve.dto.page.PageDataDTO;
import me.ashaneediri.fbretrieve.dto.post.PostListDTO;
import me.ashaneediri.fbretrieve.util.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import java.io.UnsupportedEncodingException;

/**
 * Service Class for Facebook posts and pages retrieval
 *
 */
@Service
public class FbDataRetrieveService {

    @Autowired
    private RestClient restClient;

    @Autowired
    private AccessTokenDTO accessTokenDTO;

    @Value("${fb.graph.url.posts}")
    private String postUrl;

    @Value("${fb.graph.url.likedPages}")
    private String likedPagesUrl;

    /**
     * Retrieve the facebook posts of user for given request
     *
     * @return PostListDTO
     */
    public PostListDTO getPosts() {

        return restClient.restExchange(postUrl, accessTokenDTO.getAccessToken(),PostListDTO.class).getBody();
    }

    /**
     * Retrieve the facebook pages liked by the user
     *
     * @return PageDataDTO
     */
    public PageDataDTO getPages() throws UnsupportedEncodingException {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(likedPagesUrl)
                .queryParam("fields","likes.limit(10){category,fan_count,name}");

        return restClient.restExchangeWithParams(builder.build().encode().toUri(), accessTokenDTO.getAccessToken(), PageDataDTO.class).getBody();
    }
}
