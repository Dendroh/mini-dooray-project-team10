package com.example.minidoorayproject.entity.compositekey;

import com.example.minidoorayproject.entity.Milestone;
import com.example.minidoorayproject.entity.Tag;
import com.example.minidoorayproject.entity.Task;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class TaskTagBundlePk implements Serializable {


    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;



    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

}
