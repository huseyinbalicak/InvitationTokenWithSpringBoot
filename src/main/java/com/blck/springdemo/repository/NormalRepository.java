package com.blck.springdemo.repository;

import java.util.List;

public interface NormalRepository<T> extends Repository<T> {
    List<T> all();
}
