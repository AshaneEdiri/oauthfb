package me.ashaneediri.fbretrieve.dto;

import lombok.Data;

/**
 * Domain class for Access Token Request
 *
 */
@Data
public class AccessTokenRequestDTO {

    private String grant_type;
    private String client_id;
    private String redirect_uri;
    private String code;
}
