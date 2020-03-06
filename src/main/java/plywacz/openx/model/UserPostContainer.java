package plywacz.openx.model;
/*
Author: BeGieU
Date: 06.03.2020
*/

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Class contains User and his posts
 */
public class UserPostContainer {
    private final User user;
    private final Set<Post> posts = new HashSet<>();

    public UserPostContainer(User user) {
        this.user = user;
    }


    public boolean addPost(Post post) {
        return posts.add(post);
    }

    public Long getUserId() {
        return user.getId();
    }

    public String getPostCountString(){
        return new StringBuilder()
                .append(user.getUsername())
                .append(" napisał(a) ")
                .append(posts.size())
                .append(" postów")
                .toString();
    }

    public boolean containsPost(Post post) {
        return posts.contains(post);
    }

    public User getUser() {
        return user;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserPostContainer that = (UserPostContainer) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(posts, that.posts);
    }

    @Override public int hashCode() {
        return Objects.hash(user, posts);
    }

    @Override public String toString() {
        return "UserPostContainer{" +
                "user=" + user +
                ", posts=" + posts +
                '}';
    }
}
