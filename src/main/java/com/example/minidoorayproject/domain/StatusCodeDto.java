package com.example.minidoorayproject.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class StatusCodeDto {
    private int codeId;
    private String statusName;
}
