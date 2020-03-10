package plywacz.openx.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plywacz.openx.dto.ClosestUserPairDto;
import plywacz.openx.model.UserPostContainer;
import plywacz.openx.service.DataServiceFacade;


import java.util.List;
import java.util.Set;

/*
Author: BeGieU
Date: 10.03.2020
*/
@RestController()
@RequestMapping("/api")
public class MainController {
    private final DataServiceFacade dataService;

    public MainController(DataServiceFacade dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/data")
    public Set<UserPostContainer> getJoinedData() {
        return dataService.getJoinedData();
    }

    @GetMapping("/posts-count")
    public List<String> getPostCount() {
        return dataService.getPostsCount();
    }

    @GetMapping("/duplicate-post-titles")
    public List<String> getDuplicatePostTitles() {
        return dataService.findDuplicateTitles();
    }

    @GetMapping(value = "/closest-users",produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<ClosestUserPairDto> findClosestUsers() {
        return dataService.findClosestUsers();
    }


}
