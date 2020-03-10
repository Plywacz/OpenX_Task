package plywacz.openx.service;
/*
Author: BeGieU
Date: 05.03.2020
*/

import plywacz.openx.dto.ClosestUserPairDto;
import plywacz.openx.model.Post;
import plywacz.openx.model.User;
import plywacz.openx.model.UserPostContainer;

import java.util.List;
import java.util.Set;

/**
 * Performs operations on given data
 */
public interface DataManipulator {
    int EARTH_RADIUS_KM = 6371;


    /**
     * Takes set of all users and all posts.
     * Maps particular user with his posts.
     *
     * @param users set of all users
     * @param posts set of all posts
     * @return set of objects which represents user and his posts, returns empty set if no data
     */
    Set<UserPostContainer> joinData(Set<User> users, Set<Post> posts);

    /**
     * Counts particular user posts and returns list of
     * strings. One string contains name of user and count
     * of his posts
     *
     * @param users set of objects that contains user and his posts
     * @return list of strings that says how many posts belongs to particular user.
     * Returns empty list if no users given.
     */
    List<String> countPosts(Set<UserPostContainer> users);

    /**
     * Takes set of posts and finds duplicates.
     * Duplicates are returned as list of String
     *
     * @param posts set of posts to be searched.
     * @return list of duplicate titles found in given set of posts.
     */
    List<String> findDuplicateTitles(Set<Post> posts);

    /**
     * Takes set of users, and maps every user with one user who is closest to him.
     *
     * @param users set of users.
     * @return set of pairs that one pair object contain two closest users.
     * Returns empty set when no users given or when given set that contains one user
     */
    Set<ClosestUserPairDto> findClosestUser(Set<User> users);
}
