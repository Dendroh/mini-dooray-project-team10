package com.example.minidoorayproject.entity;


import com.example.minidoorayproject.entity.compositekey.TaskMileStoneBundlePk;
import com.example.minidoorayproject.entity.compositekey.TaskTagBundlePk;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Setter
@Getter
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task_tag_bundle")
public class TaskTagBundle {
   @EmbeddedId
    private TaskTagBundlePk TTpk;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @MapsId(value = "taskId")
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @MapsId(value = "tagId")
    @JoinColumn(name = "tag_id")
    private Tag tag;


    public void setTag(Tag tag) {
       this.tag = tag;
       if (TTpk == null) {
         TTpk = new TaskTagBundlePk();
       }
       TTpk.setTagId(tag.getTagId());
      }

    public void setTask(Task task) {
       this.task = task;
       if (TTpk == null) {
          TTpk = new TaskTagBundlePk();
       }
       TTpk.setTaskId(task.getTaskId());
      }

}