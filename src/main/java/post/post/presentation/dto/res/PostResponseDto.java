package post.post.presentation.dto.res;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponseDto {
    private String title;
    private String writer;
    private String contents;
}
