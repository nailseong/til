package spring.mvc.service;

import org.springframework.stereotype.Service;
import spring.mvc.service.dto.PostRequestDto;
import spring.mvc.service.dto.PostResponseDto;

@Service
public class PostService {

    public PostResponseDto create2(final PostRequestDto request) {
        return new PostResponseDto(
                request.getTitle(),
                request.getContents()
        );
    }
}
