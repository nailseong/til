package spring.mvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.mvc.controller.dto.PostRequest;
import spring.mvc.controller.dto.PostResponse;
import spring.mvc.service.PostService;
import spring.mvc.service.dto.PostRequestDto;
import spring.mvc.service.dto.PostResponseDto;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(final PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/v1")
    public ResponseEntity<PostResponse> create(@RequestBody PostRequest request) {
        final PostRequestDto requestDto = new PostRequestDto(
                request.getTitle(),
                request.getContents()
        );

        final PostResponseDto responseDto = postService.create2(requestDto);

        final PostResponse response = new PostResponse(
                responseDto.getTitle(),
                responseDto.getContents()
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping("v2")
    public ResponseEntity<PostResponseDto> create2(@RequestBody PostRequest request) {
        final PostRequestDto requestDto = new PostRequestDto(
                request.getTitle(),
                request.getContents()
        );

        final PostResponseDto responseDto = postService.create2(requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
