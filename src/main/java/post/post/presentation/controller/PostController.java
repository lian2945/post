package post.post.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import post.post.application.PostService;
import post.post.presentation.dto.res.PostResponseDto;

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
    public Optional<PostResponseDto> getPost(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @PostMapping("/")
    public void addPost()
}