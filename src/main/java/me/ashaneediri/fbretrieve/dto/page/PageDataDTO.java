package me.ashaneediri.fbretrieve.dto.page;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;

/**
 * Domain class to retrieve liked facebook pages as list
 *
 */
@Data
public class PageDataDTO {

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<PageListDTO> likes;


}
