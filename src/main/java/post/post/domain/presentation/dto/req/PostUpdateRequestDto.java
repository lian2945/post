package post.post.domain.presentation.dto.req;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostUpdateRequestDto {
    @NotNull(message = "아이디는 NULL이 되서는 안 됩니다.")
    private Long id;
    @NotNull(message = "제목은 NULL이 되서는 안 됩니다.")
    private String title;
    @NotNull(message = "내용은 NULL이 되서는 안 됩니다.")
    private String contents;
    @NotNull(message = "작가는 NULL이 되서는 안 됩니다.")
    private String writer;
}
