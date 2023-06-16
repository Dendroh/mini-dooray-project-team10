package com.example.minidoorayproject.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import javax.validation.constraints.NotNull;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class TagDto {
    private Integer tagId;

    private String tagName;

    private String tagColor;
    @NotNull
    private Integer projectId;

}
