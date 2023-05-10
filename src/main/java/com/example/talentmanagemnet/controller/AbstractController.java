package com.example.talentmanagemnet.controller;


import com.example.talentmanagemnet.service.BaseService;

public abstract class AbstractController<S extends BaseService> implements BaseController{
    protected final S service;
    public AbstractController(S service) {
        this.service = service;
    }
}

