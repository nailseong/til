package spring.mvc.controller.dto;

public class PostResponse {

    private String title;
    private String contents;

    private PostResponse() {
    }

    public PostResponse(final String title, final String contents) {
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
