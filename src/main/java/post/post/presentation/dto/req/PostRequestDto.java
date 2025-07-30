package post.post.presentation.dto.req;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostRequestDto {
    private String title;
    private String contents;
    private String writer;
}
