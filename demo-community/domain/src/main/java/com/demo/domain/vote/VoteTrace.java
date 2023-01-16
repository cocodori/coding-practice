package com.demo.domain.vote;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class VoteTrace implements Serializable {

    @Id
    private Long voteId;

    @Id
    private Long memberUid;

    private Long voteItemId;

    private LocalDateTime createdAt;

}
