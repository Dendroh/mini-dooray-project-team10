package com.example.minidoorayproject.domain;

import com.example.minidoorayproject.entity.Project;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class TagDto {
    @NotNull
    private int tagId;

    private String tagName;

    private String tagColor;
    @NotNull
    private int projectId;


}
