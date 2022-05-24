package spring.mvc.service.dto;

public class PostResponseDto {

    private String title;
    private String contents;

    private PostResponseDto() {
    }

    public PostResponseDto(final String title, final String contents) {
        this.title = title;
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }
}
