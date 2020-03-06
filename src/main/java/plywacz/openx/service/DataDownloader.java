package plywacz.openx.service;/*
Author: BeGieU
Date: 05.03.2020
*/

import plywacz.openx.model.Post;
import plywacz.openx.model.User;

import java.util.Set;

/**
 * Fetches data from given postSource and links,
 * should return null when no data available.
 */
public interface DataDownloader {
    String POST_SOURCE = "https://jsonplaceholder.typicode.com/posts";
    String USER_SOURCE = "https://jsonplaceholder.typicode.com/users";

    /**
     * Downloads every user from given
     * link and maps it to the pojo list.
     *
     * @return list of users
     */
    Set<User> fetchUserData();

    /**
     * Downloads every post from
     * given link and maps it to the pojo list.
     *
     * @return list of users
     */
    Set<Post> fetchPostData();
}
