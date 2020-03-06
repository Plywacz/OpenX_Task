package plywacz.openx.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import plywacz.openx.model.Post;
import plywacz.openx.model.User;
import plywacz.openx.model.UserPostContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.when;

class DataServiceFacadeImplTest {

    DataServiceFacade dataServiceFacade;

    @Mock
    DataDownloader downloader;

    @Mock
    DataManipulator manipulator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        dataServiceFacade = new DataServiceFacadeImpl(downloader, manipulator);
    }

    @Test
    void getJoinedData() {
        when(downloader.fetchUserData()).thenReturn(new HashSet<User>());
        when(downloader.fetchPostData()).thenReturn(new HashSet<Post>());
        when(manipulator.joinData(anySet(), anySet())).thenReturn(new HashSet<UserPostContainer>());

        var res = dataServiceFacade.getJoinedData();
        assertNotNull(res);
    }

    @Test
    void getPostsCount() {
        when(downloader.fetchUserData()).thenReturn(new HashSet<User>());
        when(downloader.fetchPostData()).thenReturn(new HashSet<Post>());
        when(manipulator.joinData(anySet(), anySet())).thenReturn(new HashSet<UserPostContainer>());

        when(manipulator.countPosts(anySet())).thenReturn(new ArrayList<String>());

        var res = dataServiceFacade.getPostsCount();

        assertNotNull(res);

    }

    @Test
    void findDuplicateTitles() {
        when(downloader.fetchPostData()).thenReturn(new HashSet<Post>());
        when(manipulator.findDuplicateTitles(anySet())).thenReturn(new ArrayList<String>());

        var res = dataServiceFacade.findDuplicateTitles();
        assertNotNull(res);
    }

    @Test
    void findClosestUsers() {
        when(downloader.fetchUserData()).thenReturn(new HashSet<User>());
        when(manipulator.findClosestUser(anySet())).thenReturn(new HashMap<User,User>());

        var res = dataServiceFacade.findClosestUsers();
        assertNotNull(res);
    }
}