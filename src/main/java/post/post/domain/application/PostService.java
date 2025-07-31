package post.post.domain.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import post.post.domain.domain.entity.PostEntity;
import post.post.domain.domain.repository.PostRepository;
import post.post.domain.presentation.dto.req.PostAddRequestDto;
import post.post.domain.presentation.dto.req.PostUpdateRequestDto;
import post.post.domain.presentation.dto.res.PostResponseDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostResponseDto> getPosts() {
        List<PostEntity> posts = postRepository.findAll();
        return posts.stream().map(
                post -> PostResponseDto.builder()
                        .title(post.getTitle())
                        .writer(post.getWriter())
                        .contents(post.getContents())
                        .build()
        ).toList();
    }

    public PostResponseDto getPostById(Long postId) {
        PostEntity post = postRepository.findById(postId).orElseThrow(IllegalArgumentException::new);
        return PostResponseDto.builder()
                .title(post.getTitle())
                .writer(post.getWriter())
                .contents(post.getContents())
                .build();
    }

    @Transactional
    public void save(PostAddRequestDto postAddRequestDto) {
        postRepository.save(PostEntity.saveBuilder()
                        .title(postAddRequestDto.getTitle())
                        .contents(postAddRequestDto.getContents())
                        .writer(postAddRequestDto.getWriter())
                .build());
    }

    @Transactional
    public void update(PostUpdateRequestDto postUpdateRequestDto) {
        PostEntity postEntity = postRepository.findById(postUpdateRequestDto.getId()).orElseThrow(IllegalArgumentException::new);
        postEntity.changePostEntity(postUpdateRequestDto.getTitle(), postUpdateRequestDto.getWriter(), postUpdateRequestDto.getContents());
        postRepository.save(postEntity);
    }

    @Transactional
    public void delete(Long postId) {
        postRepository.deleteById(postId);
    }
}



