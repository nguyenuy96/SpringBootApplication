package com.app.model.response;

import java.util.List;
import lombok.Data;

@Data
public class PaginationResponse<T> {
    private Integer page;
    private Integer size;
    private Long total;
    private List<T> content;
}
