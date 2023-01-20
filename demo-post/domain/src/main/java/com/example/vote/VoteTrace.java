package com.example.vote;

import lombok.NoArgsConstructor;

public record VoteTrace(
        Long voteId,
        Long voteItemId
) {

}
