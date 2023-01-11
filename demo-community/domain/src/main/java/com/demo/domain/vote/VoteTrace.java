package com.demo.domain.vote;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class VoteTrace {

    @Id
    private Long voteId;

    @Id
    private String memberUid;

    private Long voteItemId;

    private LocalDateTime createdAt;

}
