package com.example.demo.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperUtil {

    private ModelMapper modelMapper;

    public ModelMapperUtil(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <D, E> D convertToDomain(E source, Class<? extends D> classLiteral) {
        return modelMapper.map(source, classLiteral);
    }
}
