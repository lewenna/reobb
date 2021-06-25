package com.reofixy.reobb.core;

import org.modelmapper.ModelMapper;

public class Utils {
    private static ModelMapper modelMapper = new ModelMapper();

    public static ModelMapper getModelMapper(){
        return modelMapper;
    }
}
