package spring.mvc.service.dto;

public class PostRequestDto {

    private String title;
    private String contents;

    private PostRequestDto() {
    }

    public PostRequestDto(final String title, final String contents) {
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
