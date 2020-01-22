package org.kizilay.yusuf.caveatemptor.controller;

import org.kizilay.yusuf.caveatemptor.domain.*;
import org.kizilay.yusuf.caveatemptor.resource.ItemResource;
import org.kizilay.yusuf.caveatemptor.resource.UserResource;
import org.kizilay.yusuf.caveatemptor.service.DummyUserService;
import org.kizilay.yusuf.caveatemptor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.text.bidi.BidiLine;

import java.util.Set;

@RestController
public class UserController extends BaseController {

    private UserService userService;

    @Autowired
    private DummyUserService dummyUserService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserResource> createUser(@RequestBody UserResource userResource){
       userService.saveUser(userResource.toDomain());

       // dummyUserService.save(userResource.toDomain());

        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
    }

    @PutMapping("/user")
    public ResponseEntity<UserResource> updateUser(@RequestBody UserResource userResource){
       userService.updateUser(userResource.toDomain());

       // User user=dummyUserService.find();

        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userName}")
    public void getUser(@PathVariable String userName){
        User user=userService.findUser(userName);
    }
}
