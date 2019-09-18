package me.ashaneediri.fbretrieve.dto.page;

import lombok.Data;
import java.util.List;

/**
 * Domain class to retrieve liked facebook page data as list
 *
 */
@Data
class PageListDTO {

    private List<PagesDTO> data;
}
