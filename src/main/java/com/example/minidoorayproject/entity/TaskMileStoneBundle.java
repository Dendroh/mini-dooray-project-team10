package com.example.minidoorayproject.entity;


import com.example.minidoorayproject.entity.compositekey.TaskMileStoneBundlePk;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "task_milestone_bundle")
public class TaskMileStoneBundle {

    @EmbeddedId
    private TaskMileStoneBundlePk TMpk;


}