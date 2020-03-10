package plywacz.openx.dto;
/*
Author: BeGieU
Date: 10.03.2020
*/

import plywacz.openx.model.User;

import java.util.Objects;

public class ClosestUserPairDto {
    private  User firstUser;
    private  User secondUser;

    public ClosestUserPairDto() {
    }

    public ClosestUserPairDto(User firstUser, User secondUser) {
        this.firstUser = firstUser;
        this.secondUser = secondUser;
    }

    public void setFirstUser(User firstUser) {
        this.firstUser = firstUser;
    }

    public void setSecondUser(User secondUser) {
        this.secondUser = secondUser;
    }

    public User getFirstUser() {
        return firstUser;
    }

    public User getSecondUser() {
        return secondUser;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ClosestUserPairDto that = (ClosestUserPairDto) o;
        return Objects.equals(firstUser, that.firstUser) &&
                Objects.equals(secondUser, that.secondUser);
    }

    @Override public int hashCode() {
        return Objects.hash(firstUser, secondUser);
    }

    @Override public String toString() {
        return "ClosestUserPairDto{" +
                "user1=" + firstUser +
                ", user2=" + secondUser +
                '}';
    }
}
