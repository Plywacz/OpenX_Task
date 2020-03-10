package plywacz.openx.service;
/*
Author: BeGieU
Date: 06.03.2020
*/

import plywacz.openx.dto.ClosestUserPairDto;
import plywacz.openx.model.UserPostContainer;

import java.util.List;
import java.util.Set;

public interface DataServiceFacade {

    /**
     * Returns users joined with their comments
     *
     * @return set of objects which represents user and his posts
     */
    Set<UserPostContainer> getJoinedData();

    /**
     * Counts particular user posts and returns list of
     * strings. One string contains name of user and count
     * of his posts
     *
     * @return list of strings that says how many posts belongs to particular user.
     */
    List<String> getPostsCount();

    /**
     * Returns list of title duplicates
     *
     * @return list of duplicate titles found in given set of posts.
     */
    List<String> findDuplicateTitles();

    /**
     * @return map where key is one user and value is user who lives closest to key user.
     */
    Set<ClosestUserPairDto> findClosestUsers();
}
