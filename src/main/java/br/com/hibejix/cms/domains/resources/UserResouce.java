package br.com.hibejix.cms.domains.resources;

import br.com.hibejix.cms.domains.models.User;
import br.com.hibejix.cms.domains.vo.UserRequest;
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
@RequestMapping("/api/user")
@Api(tags = "user", description = "User API")
public class UserResouce {

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find User", notes = "Find the User by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User found"),
            @ApiResponse(code = 404, message = "User not found")
    })
    public ResponseEntity<User> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(new User());
    }

    @GetMapping
    @ApiOperation(value = "List User", notes = "List Users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User found"),
            @ApiResponse(code = 404, message = "User not found")
    })
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(Arrays.asList(new User(), new User()));
    }

    @PostMapping
    @ApiOperation(value = "Create User", notes = "It permits to create a new User")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User found"),
            @ApiResponse(code = 404, message = "User not found")
    })
    public ResponseEntity<User> newUser(UserRequest userRequest) {
        return new ResponseEntity<>(new User(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Remove User", notes = "It permits to remove a new User by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User found"),
            @ApiResponse(code = 404, message = "User not found")
    })
    public void removeUser(@PathVariable("id") String id) {

    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update User", notes = "It permits to atualize a User")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User found"),
            @ApiResponse(code = 404, message = "User not found")
    })
    public ResponseEntity<User> updateUser(@PathVariable("id") String id
            , UserRequest userRequest) {
        return new ResponseEntity<>(new User(), HttpStatus.OK);
    }
}
