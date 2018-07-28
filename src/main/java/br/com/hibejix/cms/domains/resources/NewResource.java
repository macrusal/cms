package br.com.hibejix.cms.domains.resources;

import br.com.hibejix.cms.domains.models.News;
import br.com.hibejix.cms.domains.models.Review;
import br.com.hibejix.cms.domains.vo.NewsRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/news")
@Api(tags = "new", description = "New API")
public class NewResource {

    @GetMapping(value = "{/id}")
    @ApiOperation(value = "Find News", notes = "Find the news by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "News found"),
            @ApiResponse(code = 404, message = "News not found")
    })
    public ResponseEntity<News> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(new News());
    }

    @GetMapping
    @ApiOperation(value = "List News", notes = "List all news")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "News found"),
            @ApiResponse(code = 404, message = "News not found")
    })
    public ResponseEntity<List<News>> findAll() {
        return ResponseEntity.ok(Arrays.asList(new News(), new News()));
    }

    @PostMapping
    @ApiOperation(value = "Create News", notes = "It permits to create news")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "News found"),
            @ApiResponse(code = 404, message = "News not found")
    })
    public ResponseEntity<News> newNews() {
        return new ResponseEntity<>(new News(), HttpStatus.CREATED);
    }

    @DeleteMapping("{/id}")
    @ApiOperation(value = "Remove News", notes = "It permits to remove news")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "News found"),
            @ApiResponse(code = 404, message = "News not found")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeNews(@PathVariable("id") String id) {

    }

    @PutMapping("{/id}")
    @ApiOperation(value = "Find News", notes = "It permits to update news")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "News found"),
            @ApiResponse(code = 404, message = "News not found"),
            @ApiResponse(code = 404, message = "News not found")
    })
    public ResponseEntity<News> updateNews(@PathVariable("id") String id, NewsRequest newRequest) {
        return new ResponseEntity<>(new News(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/review/{userId}")
    @ApiOperation(value = "Review News", notes = "It permits to review the news")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "News found"),
            @ApiResponse(code = 404, message = "News not found")
    })
    public ResponseEntity<Review> review(@PathVariable("id") String id
            ,@PathVariable("userId") String userId) {
        return ResponseEntity.ok(new Review());
    }

    @GetMapping(value = "/revised")@ApiOperation(value = "Revised News", notes = "It permits to revise the news")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "News found"),
            @ApiResponse(code = 404, message = "News not found"),
    })
    public ResponseEntity<List<News>> revisedNews() {
        return ResponseEntity.ok(Arrays.asList(new News(), new News()));
    }
}
