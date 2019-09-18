package me.ashaneediri.fbretrieve.dto.post;

import lombok.Data;
import java.util.List;

/**
 * Domain class to retrieve Facebook Post as list
 *
 */
@Data
public class PostListDTO {

    private List<PostDTO> data;
}
