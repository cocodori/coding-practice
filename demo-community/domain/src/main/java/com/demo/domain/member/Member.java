package com.demo.domain.member;

import com.demo.domain.code.MemberGroup;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Member {

    @Id
    @Column(name = "member_uid")
    private Long uid;

    private Long memberId;

    private String nickname;

    @Column(name = "member_group")
    @Enumerated(EnumType.STRING)
    private MemberGroup group;

    private int postCount;

    private int commentCount;

    private LocalDateTime approvedAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    protected Member() {}
}
