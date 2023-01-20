package com.example.post.port;

import com.example.post.usecase.command.PostCreateCommand;

public interface VoteCreatePort {

    Long createVote(PostCreateCommand.VoteCommand voteCommand);
}
