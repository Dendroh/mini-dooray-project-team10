package com.example.minidoorayproject.entity;

import com.example.minidoorayproject.entity.compositekey.ProjectMemberBundlePk;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project_member_bundle")
public class ProjectMemberBundle {

    @EmbeddedId
    private ProjectMemberBundlePk PMpk;

    @Column(name = "register_time")
    private LocalDateTime registerTime;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @MapsId(value = "projectId")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @MapsId(value = "memberId")
    private Member member;

    public void setProject(Project project) {
        this.project = project;
        if (PMpk == null) {
            PMpk = new ProjectMemberBundlePk();
        }
        PMpk.setProjectId(project.getProjectId());
    }

    public void setMember(Member member) {
        this.member = member;
        if (PMpk == null) {
            PMpk = new ProjectMemberBundlePk();
        }
        PMpk.setMemberId(member.getMemberId());
    }


}
