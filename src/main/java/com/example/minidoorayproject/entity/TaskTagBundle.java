package com.example.minidoorayproject.entity;


import com.example.minidoorayproject.entity.compositekey.TaskTagBundlePk;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "task_tag_bundle")
public class TaskTagBundle {


   @EmbeddedId
    private TaskTagBundlePk TTpk;

}