package com.blck.springdemo.model;



import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PagedResponse<T> {

    private long size;
    private long totalElements;
    private long totalPages;
	private long number;
    private List<T> data;

    public PagedResponse() {
        //Default constructor
    }


}
