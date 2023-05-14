package com.robertomassoni.recipesbrazil.persistence.mapper;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonsMapperTest {

    private CommonsMapper mapper = new CommonsMapper();

    @Test
    public void shoudParseStringToByte() {
        final var actualString = "This is a string";

        final var expectedByte = mapper.stringToByte(actualString);

        assertThat(expectedByte).isNotNull();
    }

    @Test
    public void shoudReturnNullWhenTryParseStringToByteButStringIsNull() {
        final var expectedByte = mapper.stringToByte(null);

        assertThat(expectedByte).isNull();
    }

    @Test
    public void shoudParseByteToString() {
        final var actualString = "This is a string";
        final var actualBytes = actualString.getBytes(StandardCharsets.UTF_8);

        final var expectedString = mapper.byteToString(actualBytes);

        assertThat(actualString).isEqualTo(expectedString);
    }

    @Test
    public void shoudReturnNullWhenTryParseByteToByteButStringIsNull() {
        final var expectedString = mapper.byteToString(null);

        assertThat(expectedString).isNull();
    }
}