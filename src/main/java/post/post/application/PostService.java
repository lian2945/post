package post.post.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import post.post.domain.entity.PostEntity;
import post.post.domain.repository.PostRepository;
import post.post.presentation.dto.req.PostRequestDto;
import post.post.presentation.dto.res.PostResponseDto;

import java.util.List;
import java.util.Optional;

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

    public Optional<PostResponseDto> getPostById(Long postId) {
        Optional<PostEntity> post = postRepository.findById(postId);
        Optional<PostResponseDto> postResponseDto;
        postResponseDto = post.map(postEntity -> PostResponseDto.builder()
                .title(postEntity.getTitle())
                .writer(postEntity.getWriter())
                .contents(postEntity.getContents())
                .build());
        return postResponseDto;
    }

    @Transactional
    public void save(PostRequestDto postRequestDto) {
        postRepository.save(PostEntity.saveBuilder()
                        .title(postRequestDto.getTitle())
                        .contents(postRequestDto.getContents())
                        .writer(postRequestDto.getWriter())
                .build());
    }
}



