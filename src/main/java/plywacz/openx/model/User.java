package plywacz.openx.model;
/*
Author: BeGieU
Date: 05.03.2020
*/

import java.util.Objects;

public class User {
    private Long id;
    private String name;
    private String username;
    private String email;

    private Address address;

    private String phone;
    private String website;

    private Company company;


    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(website, user.website) &&
                Objects.equals(address, user.address) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(name, user.name) &&
                Objects.equals(company, user.company) &&
                Objects.equals(id, user.id) &&
                Objects.equals(email, user.email) &&
                Objects.equals(username, user.username);
    }

    @Override public int hashCode() {
        return Objects.hash(website, address, phone, name, company, id, email, username);
    }

    @Override
    public String toString() {
        return "ClassPojo [website = " + website + ", address = " + address + ", phone = " + phone + ", name = " + name + ", company = " + company + ", id = " + id + ", email = " + email + ", username = " + username + "]";
    }
}
