package spring.mvc.controller.dto;

public class PostRequest {

    private String title;
    private String contents;

    private PostRequest() {
    }

    public PostRequest(final String title, final String contents) {
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
