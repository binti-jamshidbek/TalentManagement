package com.example.talentmanagemnet.mapper;


import java.util.List;

public interface AbstractMapper<E, D, CD, UD> extends BaseMapper {

    D toDto(E e);

    List<D> toDto(List<E> e);

    E fromCreateDto(CD cd);

    E fromUpdateDto(UD d);
}