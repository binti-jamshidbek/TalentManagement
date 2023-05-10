package com.example.talentmanagemnet.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.Objects;

@Getter
public class GenericDto implements BaseDto{
    @NotBlank
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericDto that = (GenericDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
