package me.ashaneediri.fbretrieve.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Access Token Domain class
 *
 */
@Component
@Data
public class AccessTokenDTO {

    private String accessToken;
}
