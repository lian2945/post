package post.post.presentation.dto.req;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostAddRequestDto {
    private String title;
    private String contents;
    private String writer;
}
