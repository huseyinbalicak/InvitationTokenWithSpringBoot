package com.blck.springdemo.mapper;

import java.util.stream.Collectors;

import com.blck.springdemo.dto.IdentifiableDto;
import com.blck.springdemo.model.Paged;
import com.blck.springdemo.model.PagedResponse;

public interface Mapper<T, D extends IdentifiableDto> {

    default PagedResponse<D> toPagedResponse(Paged<T> paged) {
        PagedResponse<D> response = new PagedResponse<>();
        response.setData(paged.getData().stream().map(this::toDto).collect(Collectors.toList()));
        response.setNumber(paged.getNumber());
        response.setSize(paged.getSize());
        response.setTotalPages(paged.getTotalPages());
        response.setTotalElements(paged.getTotalElements());
        return response;
    }

    D toDto(T businessObject);

    T toBusinessObject(D dtoObject);
}
