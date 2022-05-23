package spring.mvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.mvc.dto.PathResponse;
import spring.mvc.dto.request.DefaultAndSetterRequest;
import spring.mvc.dto.request.DifferentFieldNameAndDefaultConstructor;
import spring.mvc.dto.request.ManyPublicAndDefaultConstructorRequest;
import spring.mvc.dto.request.ManyPublicAndNoDefaultConstructorRequest;
import spring.mvc.dto.request.ManyPublicAndNoSetterRequest;
import spring.mvc.dto.request.PrimaryConstructorDifferentFieldRequest;
import spring.mvc.dto.request.PrimaryConstructorRequest;

@RestController
@RequestMapping("/paths")
public class PathController {

    @GetMapping("/v1")
    public ResponseEntity<PathResponse> showPath(final PrimaryConstructorRequest request) {
        final PathResponse response = new PathResponse(
                request.getSource(),
                request.getTarget(),
                request.getAge()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v2")
    public ResponseEntity<PathResponse> showPath(final DefaultAndSetterRequest request) {
        final PathResponse response = new PathResponse(
                request.getSource(),
                request.getTarget(),
                request.getAge()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v3")
    public ResponseEntity<PathResponse> showPath(final PrimaryConstructorDifferentFieldRequest request) {
        final PathResponse response = new PathResponse(
                request.getSourceStationId(),
                request.getTargetStationId(),
                request.getAge()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v4")
    public ResponseEntity<PathResponse> showPath(final ManyPublicAndDefaultConstructorRequest request) {
        final PathResponse response = new PathResponse(
                request.getSource(),
                request.getTarget(),
                request.getAge()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v5")
    public ResponseEntity<PathResponse> showPath(final ManyPublicAndNoSetterRequest request) {
        final PathResponse response = new PathResponse(
                request.getSource(),
                request.getTarget(),
                request.getAge()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v6")
    public ResponseEntity<PathResponse> showPath(final ManyPublicAndNoDefaultConstructorRequest request) {
        final PathResponse response = new PathResponse(
                request.getSource(),
                request.getTarget(),
                request.getAge()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v7")
    public ResponseEntity<PathResponse> showPath(final DifferentFieldNameAndDefaultConstructor request) {
        final PathResponse response = new PathResponse(
                request.getSourceStationId(),
                request.getTargetStationId(),
                request.getAge()
        );
        return ResponseEntity.ok(response);
    }
}
