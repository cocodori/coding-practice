package com.demo.domain.tag;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class TagPost implements Serializable {
    @Id
    @Column(name = "post_id")
    private Long postId;
    @Id
    @Column(name = "tag_id")
    private Long tagId;

    protected TagPost() {}
}
