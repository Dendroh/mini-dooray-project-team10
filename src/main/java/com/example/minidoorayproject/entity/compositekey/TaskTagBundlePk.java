package com.example.minidoorayproject.entity.compositekey;

import com.example.minidoorayproject.entity.Milestone;
import com.example.minidoorayproject.entity.Tag;
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
public class TaskTagBundlePk implements Serializable {

    @Column(name = "task_id")
    private Integer taskId;

    @Column(name = "tag_id")
    private Integer tagId;

}
