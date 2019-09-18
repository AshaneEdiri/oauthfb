package me.ashaneediri.fbretrieve.dto.page;

import lombok.Data;

/**
 * Domain class for Facebook Page Attributes
 *
 */
@Data
class PagesDTO {

    private String category;
    private double fan_count;
    private String id;
    private String name;
}
