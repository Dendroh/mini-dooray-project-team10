package com.example.minidoorayproject.entity;


import com.example.minidoorayproject.entity.compositekey.TaskMileStoneBundlePk;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task_milestone_bundle")
public class TaskMileStoneBundle {

    @EmbeddedId
    private TaskMileStoneBundlePk TMpk;


}