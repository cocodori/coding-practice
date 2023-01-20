package com.example.post.usecase.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PostCreateCommandTest {

    @Test
    @DisplayName("null일 때 ConstraintViolationException")
    void givenTitleIsNull() {
        assertThatThrownBy(() -> new PostCreateCommand(null, null, null, null, null, null, null))
                .isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    @DisplayName("제목이 2글자 이하일 때 ConstraintViolationException")
    void givenLessThan2Characters() {
        assertThatThrownBy(() -> new PostCreateCommand("h", "h", "zzzz", null, null, null, null))
                .isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    @DisplayName("정상값 입력 시 생성된다.")
    void testCreate() {
        String title = "그렇습니까?";
        String content = "기린입니다.";
        PostCreateCommand command = new PostCreateCommand(title, content, "question", null, null, null, null);

        assertThat(command.title).isEqualTo(title);
        assertThat(command.content).isEqualTo(content);
    }


}