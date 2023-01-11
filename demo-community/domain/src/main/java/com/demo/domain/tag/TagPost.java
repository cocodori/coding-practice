package com.demo.domain.tag;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TagPost {
    @Id
    @Column(name = "post_id")
    private Long postId;
    @Id
    @Column(name = "tag_id")
    private Long tagId;

    public TagPost() {}
}
