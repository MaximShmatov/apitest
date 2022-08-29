package com.test.mshmatov.mappers;

public interface Mapper<F, T> {

    T mapEntityToDto(F entity);

    F mapDtoToEntity(T dto);
}
