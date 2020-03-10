package plywacz.openx.dto;
/*
Author: BeGieU
Date: 10.03.2020
*/

import plywacz.openx.model.User;

import java.util.Objects;

public class ClosestUserPairDto {
    private  User user1;
    private  User user2;

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ClosestUserPairDto that = (ClosestUserPairDto) o;
        return Objects.equals(user1, that.user1) &&
                Objects.equals(user2, that.user2);
    }

    @Override public int hashCode() {
        return Objects.hash(user1, user2);
    }

    @Override public String toString() {
        return "ClosestUserPairDto{" +
                "user1=" + user1 +
                ", user2=" + user2 +
                '}';
    }
}
