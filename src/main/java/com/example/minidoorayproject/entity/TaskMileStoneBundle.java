package com.example.minidoorayproject.entity;


import com.example.minidoorayproject.entity.compositekey.ProjectMemberBundlePk;
import com.example.minidoorayproject.entity.compositekey.TaskMileStoneBundlePk;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToOne
    @MapsId(value = "milestoneId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "milestone_id")
    private Milestone milestone;

    @ManyToOne
    @MapsId(value = "taskId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "task_id")
    private Task task;

    public void setMilestone(Milestone milestone) {
        this.milestone = milestone;
        if (TMpk == null) {
            TMpk = new TaskMileStoneBundlePk();
        }
        TMpk.setMilestoneId(milestone.getMilestoneId());
    }

    public void setTask(Task task) {
        this.task = task;
        if (TMpk == null) {
            TMpk = new TaskMileStoneBundlePk();
        }
        TMpk.setTaskId(task.getTaskId());
    }

}