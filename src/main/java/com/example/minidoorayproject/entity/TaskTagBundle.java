package com.example.minidoorayproject.entity;


import com.example.minidoorayproject.entity.compositekey.TaskTagBundlePk;
import lombok.*;

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

}