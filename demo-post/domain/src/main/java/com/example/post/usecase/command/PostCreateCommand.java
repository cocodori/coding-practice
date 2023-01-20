package com.example.post.usecase.command;

import com.example.common.SelfValid;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class PostCreateCommand extends SelfValid<PostCreateCommand>{

    @NotNull(message = "제목을 입력하세요.")
    @Length(min = 2, max = 50)
    public final String title;
    @NotNull(message = "내용을 입력하세요.")
    @Length(min = 2, max = 2000)
    public final String content;

    @NotNull
    public final String categoryTag;

    public final Set<String> hashtags;

    public final VoteCommand voteCommand;
    public final Set<String> images;


    public PostCreateCommand(String title, String content, String categoryTag, Set<String> hashtags, String voteTitle, Set<String> voteItems, Set<String> images) {
        this.title = title;
        this.content = content;
        this.categoryTag = categoryTag;
        this.hashtags = hashtags == null ? Set.of() : hashtags;
        this.voteCommand = VoteCommand.of(voteTitle, voteItems);
        this.images = images;
    }

    public static class VoteCommand extends SelfValid<VoteCommand> {
        @NotNull
        String title;

        @NotNull
        Set<String> items;

        VoteCommand(String title, Set<String> items) {
            this.title = title;
            this.items = items;
        }

        public static VoteCommand of(String voteTitle, Set<String> voteItems) {
            return new VoteCommand(voteTitle, voteItems);
        }
    }
}
