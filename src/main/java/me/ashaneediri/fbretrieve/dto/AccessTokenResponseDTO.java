package me.ashaneediri.fbretrieve.dto;

import lombok.Data;

/**
 * Domain class for Access Token Response
 *
 */
@Data
public class AccessTokenResponseDTO {

    private String access_token;
    private String token_type;
    private String expires_in;
}
