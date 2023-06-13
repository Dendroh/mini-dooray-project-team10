package com.example.minidoorayproject.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class StatusCodeDto {
    @NotNull
    private Integer codeId;
    private String statusName;
}
