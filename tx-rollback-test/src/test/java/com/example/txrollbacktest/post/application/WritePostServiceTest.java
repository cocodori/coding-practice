package com.example.txrollbacktest.post.application;

import static org.assertj.core.api.Assertions.*;

import com.example.txrollbacktest.repository.entity.ImageJpaRepository;
import com.example.txrollbacktest.repository.entity.PostJpaRepository;
import com.example.txrollbacktest.repository.entity.TagJpaRepository;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class WritePostServiceTest {

    @Autowired
    private WritePostService writePostService;
    @Autowired
    private PostJpaRepository postRepository;
    @Autowired
    private ImageJpaRepository imageRepository;
    @Autowired
    private TagJpaRepository tagRepository;


    @BeforeEach
    void setUp() {
        postRepository.deleteAll();
        imageRepository.deleteAll();
        tagRepository.deleteAll();
    }

    @Test
    void write() {
        var title = RandomString.make();
        var content = RandomString.make();
        var images = List.of(RandomString.make(), RandomString.make());
        var tags = List.of(RandomString.make(), RandomString.make());

        var actual = writePostService.write(
            title,
            content,
            images,
            tags
        );

        assertThat(postRepository.findById(actual))
            .isNotEmpty()
            .satisfies(post -> {
                assertThat(post.get().getTitle()).isEqualTo(title);
                assertThat(post.get().getContent()).isEqualTo(content);
            });
        assertThat(imageRepository.findAllByPostId(actual))
            .hasSize(images.size())
            .allSatisfy(image -> assertThat(images).contains(image.getPath()));
        assertThat(tagRepository.findAllByPostId(actual))
            .hasSize(tags.size())
            .allSatisfy(tag -> assertThat(tags).contains(tag.getName()));

    }
}