package plywacz.openx.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import plywacz.openx.model.*;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class DataManipulatorImplTest {

    DataManipulator dataManipulator;

    @BeforeEach
    void setUp() {
        dataManipulator = new DataManipulatorImpl();
    }

    @Test
    void joinData_Success() {
        var user = new User();
        user.setId(1L);

        var user2 = new User();
        user2.setId(2L);
        var userSet = new HashSet<User>();

        userSet.add(user);
        userSet.add(user2);

        var post1 = new Post();
        post1.setUserId(1L);
        post1.setTitle("1");
        var post2 = new Post();
        post2.setUserId(2L);
        post2.setTitle("2");
        var post3 = new Post();
        post3.setUserId(2L);
        post3.setTitle("3");


        var postSet = new HashSet<Post>();
        postSet.add(post1);
        postSet.add(post2);
        postSet.add(post3);

        var joinedData = dataManipulator.joinData(userSet, postSet);

        assertEquals(2, joinedData.size());
        for (var upc : joinedData) {
            if (upc.getUserId().equals(1L))
                assertEquals(1, upc.getPosts().size());
            else if (upc.getUserId().equals(2L))
                assertEquals(2, upc.getPosts().size());
        }

    }

    @Test
    void joinData_FaultyPost_NoUserId() {
        var user = new User();
        user.setId(1L);

        var user2 = new User();
        user2.setId(2L);
        var userSet = new HashSet<User>();

        var post1 = new Post();
        var postSet = new HashSet<Post>();
        postSet.add(post1);

        dataManipulator.joinData(userSet, postSet);
    }

    @Test
    void joinData_nullParams() {
        var res = dataManipulator.joinData(null, null);
        assertEquals(0, res.size());
    }

    @Test
    void joinData_usersNull() {
        var res = dataManipulator.joinData(null, new HashSet<>());
        assertEquals(0, res.size());
    }

    @Test
    void joinData_postsNull() {
        var user = new User();
        user.setId(1L);

        var user2 = new User();
        user2.setId(2L);
        var userSet = new HashSet<User>();
        userSet.add(user);
        userSet.add(user2);

        var res = dataManipulator.joinData(userSet, null);
        assertEquals(2, res.size());
        assertEquals(0, res.iterator().next().getPosts().size());
    }

    @Test
    void joinData_emptyParams() {
        var res = dataManipulator.joinData(new HashSet<User>(), new HashSet<Post>());
        assertEquals(0, res.size());
    }

    @Test
    void countPosts_Success() {
        var user1 = new User();
        user1.setUsername("user1");
        user1.setId(1L);

        var user2 = new User();
        user2.setUsername("user2");
        user2.setId(2L);

        var upc1 = new UserPostContainer(user1);
        var upc2 = new UserPostContainer(user2);

        var post1 = new Post();
        post1.setUserId(1L);
        var post2 = new Post();
        post2.setUserId(2L);
        post2.setTitle("2");
        var post3 = new Post();
        post3.setUserId(2L);
        post3.setTitle("3");

        upc1.addPost(post1);

        upc2.addPost(post2);
        upc2.addPost(post3);

        var upcSet = new HashSet<UserPostContainer>();
        upcSet.add(upc1);
        upcSet.add(upc2);


        var strList = dataManipulator.countPosts(upcSet);

        assertEquals(2, strList.size());
        for (var str : strList) {
            if (str.contains("user1"))
                assertEquals("user1 napisał(a) 1 postów", str);
            else if (str.contains("user2"))
                assertEquals("user2 napisał(a) 2 postów", str);
        }

    }

    //not possible
    //    @Test
    //    void countPosts_NullParam() {
    //        assertThrows(RuntimeException.class, () -> dataManipulator.countPosts(null));
    //    }

    @Test
    void countPosts_noUsersGiven() {
        var res = dataManipulator.countPosts(new HashSet<>());
        assertEquals(0, res.size());
    }

    @Test
    void countPosts_usersDontHavePosts() {
        var user1 = new User();
        user1.setUsername("user1");
        user1.setId(1L);

        var user2 = new User();
        user2.setUsername("user2");
        user2.setId(2L);

        var upc1 = new UserPostContainer(user1);
        var upc2 = new UserPostContainer(user2);

        var upcSet = new HashSet<UserPostContainer>();
        upcSet.add(upc1);
        upcSet.add(upc2);


        var res = dataManipulator.countPosts(upcSet);
        assertEquals(2, res.size());

        for (var str : res) {
            if (str.contains("user1"))
                assertEquals("user1 napisał(a) 0 postów", str);
            else if (str.contains("user2"))
                assertEquals("user2 napisał(a) 0 postów", str);
        }
    }

    @Test
    void findDuplicateTitles() {
        var post1 = new Post();
        post1.setTitle("title");
        post1.setId(1L);
        var post2 = new Post();
        post2.setTitle("title");
        post2.setId(2L);
        var post3 = new Post();
        post3.setTitle("t1");
        post3.setId(3L);
        var post4 = new Post();
        post4.setTitle("t2");
        post4.setId(4L);
        var post5 = new Post();
        post5.setTitle("t1");
        post5.setId(5L);

        var postSet = new HashSet<Post>();
        postSet.add(post1);
        postSet.add(post2);
        postSet.add(post3);
        postSet.add(post4);
        postSet.add(post5);
        var res = dataManipulator.findDuplicateTitles(postSet);

        assertEquals(2, res.size());
        assertTrue(res.contains("title"));
        assertTrue(res.contains("t1"));

    }

    @Test
    void findDuplicateTitles_EmptyPosts() {
        var res = dataManipulator.findDuplicateTitles(new HashSet<Post>());
        assertEquals(0, res.size());
    }

    @Test
    void findClosestUser_success() {
        var geo1 = new Geo(); //tarnów
        geo1.setLat("50.01");
        geo1.setLng("20.99");

        var geo2 = new Geo();
        geo2.setLat("50.06143");
        geo2.setLng("19.93658"); //kraków

        var geo3 = new Geo();
        geo3.setLat("51.1");
        geo3.setLng("17.03333"); //wroclow

        var adr1 = new Address();
        adr1.setGeo(geo1);

        var adr2 = new Address();
        adr2.setGeo(geo2);

        var adr3 = new Address();
        adr3.setGeo(geo3);

        var user1 = new User();
        user1.setAddress(adr1);
        user1.setUsername("user1");

        var user2 = new User();
        user2.setAddress(adr2);
        user2.setUsername("user2");

        var user3 = new User();
        user3.setAddress(adr3);
        user3.setUsername("user3");

        var userSet = new HashSet<User>();
        userSet.add(user1);
        userSet.add(user2);
        userSet.add(user3);

        var pairs = dataManipulator.findClosestUser(userSet);

        assertEquals(3, pairs.size());
        //                assertEquals(user2, map.get(user1));// tarnow -> krakow
        //                assertEquals(user1, map.get(user2));// krakow -> tarnow
        //                assertEquals(user2, map.get(user3));// wroclaw -> krk
        for (var pair : pairs) {
            if (pair.getFirstUser().getUsername().equals("user1")){ //tarnow -> krakow
                assertEquals(user2,pair.getSecondUser());
            }else if(pair.getFirstUser().getUsername().equals("user2")){// krakow -> tarnow
                assertEquals(user1,pair.getSecondUser());
            }else{// wroclaw -> krk
                assertEquals(user2,pair.getSecondUser());
            }


        }
    }

    @Test
    void findClosestUser_noUsers() {
        var res = dataManipulator.findClosestUser(new HashSet<User>());
        assertEquals(0, res.size());
    }

    @Test
    void findClosestUser_OneUser() {
        var set = new HashSet<User>();
        var u1 = new User();
        set.add(u1);

        var res = dataManipulator.findClosestUser(set);
        assertEquals(0, res.size());
        //   assertEquals(null,res.get(u1));
    }
}