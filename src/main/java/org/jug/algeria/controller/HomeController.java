package org.jug.algeria.controller;

import org.jug.algeria.domain.AppUser;
import org.jug.algeria.domain.IUserService;
import org.jug.algeria.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    private final IUserRepository userRepo;
    private final IUserService userService;

    @Autowired
    public HomeController(IUserRepository userRepo, IUserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }

    @GetMapping(value = "/hello")
    public ResponseEntity<String> sayHello() {
        String work = userService.doWork();
        return ResponseEntity.ok().body("Hello there! " + work);
    }

    @PostMapping(value = "/user/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppUser> create(@PathVariable String username) {
        AppUser appUser = new AppUser();
        appUser.setUsername(username);
        AppUser saved = userRepo.save(appUser);
        return ResponseEntity.ok().body(saved);
    }

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AppUser>> findAll() {
        final List<AppUser> resultList = new ArrayList<>();
        final Iterable<AppUser> all = userRepo.findAll();
        all.forEach(resultList::add);
        return ResponseEntity.ok().body(resultList);
    }

}
