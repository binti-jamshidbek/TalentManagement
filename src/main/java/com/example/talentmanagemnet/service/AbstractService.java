package com.example.talentmanagemnet.service;

import com.example.talentmanagemnet.mapper.BaseMapper;
import com.example.talentmanagemnet.repository.BaseRepository;

public abstract class AbstractService <R extends BaseRepository, M extends BaseMapper>{
    protected final R repository;
    protected final M mapper;

    public AbstractService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
