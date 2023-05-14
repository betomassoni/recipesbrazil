package com.robertomassoni.recipesbrazil.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.nio.charset.StandardCharsets;

@Mapper
public class CommonsMapper {

    public static final CommonsMapper INSTANCE = Mappers.getMapper(CommonsMapper.class);

    public String byteToString(byte[] value) {
        return value != null ? new String(value, StandardCharsets.UTF_8) : null;
    }

    public byte[] stringToByte(String value) {
        return value != null ? value.getBytes() : null;
    }
}
