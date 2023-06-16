package com.example.minidoorayproject.entity.compositekey;

import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.entity.Project;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ProjectMemberBundlePk implements Serializable {

    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "member_id")
    private Integer memberId;


    public ProjectMemberBundlePk(int projectId, int memberId) {
        this.projectId = projectId;
        this.memberId = memberId;
    }
}
