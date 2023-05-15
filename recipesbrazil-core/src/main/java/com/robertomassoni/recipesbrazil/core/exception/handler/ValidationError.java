package com.robertomassoni.recipesbrazil.core.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ValidationError {
    private String message;
}
