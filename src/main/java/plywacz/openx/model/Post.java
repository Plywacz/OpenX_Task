package plywacz.openx.model;
/*
Author: BeGieU
Date: 05.03.2020
*/

import java.util.Objects;

public class Post {
    private Long userId;
    private Long id;
    private String title;
    private String body;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) &&
                Objects.equals(title, post.title) &&
                Objects.equals(body, post.body) &&
                Objects.equals(userId, post.userId);
    }

    @Override public int hashCode() {
        return Objects.hash(id, title, body, userId);
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", title = " + title + ", body = " + body + ", userId = " + userId + "]";
    }
}
