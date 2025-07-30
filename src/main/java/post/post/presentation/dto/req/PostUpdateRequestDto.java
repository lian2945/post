package post.post.presentation.dto.req;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostUpdateRequestDto {
    private Long id;
    private String title;
    private String writer;
    private String contents;
}
