package post.post.domain.presentation.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import post.post.domain.application.PostService;
import post.post.domain.presentation.dto.req.PostAddRequestDto;
import post.post.domain.presentation.dto.req.PostUpdateRequestDto;
import post.post.domain.presentation.dto.res.PostResponseDto;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    public List<PostResponseDto> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/{postId}")
    public PostResponseDto getPost(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @PostMapping("/")
    public void addPost(@RequestBody @Valid PostAddRequestDto postAddRequestDto) {
        postService.save(postAddRequestDto);
    }

    @PatchMapping("/")
    public void updatePost(@RequestBody @Valid PostUpdateRequestDto postUpdateRequestDto) {
        postService.update(postUpdateRequestDto);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.delete(postId);
    }
}