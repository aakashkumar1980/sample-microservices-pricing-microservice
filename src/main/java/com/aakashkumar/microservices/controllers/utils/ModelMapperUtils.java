package com.aakashkumar.microservices.controllers.utils;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperUtils<T> {

    @Autowired ModelMapper modelMapper;
    
    public List<T> mapEntityToDto(List list, Class<T> destinationType) {
        List<T> result= new ArrayList<T>();
        for (Object source : list) {
            result.add(modelMapper.map(source, destinationType));
        }
        
        return result;

    }
    
    public T mapEntityToDto(Object source, Class<T> destinationType) {
        return modelMapper.map(source, destinationType);

    }    
}