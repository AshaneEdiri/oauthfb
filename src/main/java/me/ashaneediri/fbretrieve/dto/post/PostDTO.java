package me.ashaneediri.fbretrieve.dto.post;

import lombok.Data;
import java.util.Date;

/**
 * Domain class for Facebook Post Attributes
 *
 */
@Data
class PostDTO {

    private String message;
    private Date created_time;
    private String id;
    private String name;
}
