package com.blck.springdemo.repository;


public interface Repository<T> {
    T getOne(Long id);

    T save(T data);

    void deleteById(Long id);
}
