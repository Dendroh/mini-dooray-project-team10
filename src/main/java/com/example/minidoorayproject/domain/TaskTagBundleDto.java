package com.example.minidoorayproject.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class TaskTagBundleDto {

    private int taskId;

    private int tagId;

    private String taskName;

    private String tagName;
}
