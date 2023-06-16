package com.example.minidoorayproject.entity.compositekey;

import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.entity.Milestone;
import com.example.minidoorayproject.entity.Project;
import com.example.minidoorayproject.entity.Task;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class TaskMileStoneBundlePk implements Serializable {

    @Column(name = "task_id")
    private Integer taskId;

    @Column(name = "milestone_id")
    private Integer milestoneId;

}
