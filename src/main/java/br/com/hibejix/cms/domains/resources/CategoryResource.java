package br.com.hibejix.cms.domains.resources;

import br.com.hibejix.cms.domains.models.Category;
import br.com.hibejix.cms.domains.vo.CategoryRequest;
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
@RequestMapping("/api/category")
@Api(tags = "category", description = "Category API")
public class CategoryResource {

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find Category", notes = "Find the category by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category found"),
            @ApiResponse(code = 404, message = "Category not found")
    })
    public ResponseEntity<Category> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(new Category());
    }

    @GetMapping
    @ApiOperation(value = "List Category", notes = "List all categories")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category found"),
            @ApiResponse(code = 404, message = "Category not found")
    })
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(Arrays.asList(new Category(), new Category()));
    }

    @PostMapping
    @ApiOperation(value = "Create Category", notes = "It permits to create a new category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category found"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    public ResponseEntity<Category> newCategory(CategoryRequest categoryRequest) {
        return new ResponseEntity<>(new Category(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Remove Category", notes = "It permits remove a category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category found"),
            @ApiResponse(code = 404, message = "Category not found")
    })
    public void removeCategory(@PathVariable("id") String id) {

    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Category", notes = "It permits to update a category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category found"),
            @ApiResponse(code = 404, message = "Category not found"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    public ResponseEntity<Category> updateCategory(@PathVariable("id") String id
            , CategoryRequest categoryRequest){
        return new ResponseEntity<>(new Category(), HttpStatus.OK);
    }
}
