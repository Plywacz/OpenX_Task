package plywacz.openx.model;
/*
Author: BeGieU
Date: 05.03.2020
*/

import java.util.Objects;

public class Company {
    private String name;
    private String catchPhrase;
    private String bs;

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Company company = (Company) o;
        return Objects.equals(bs, company.bs) &&
                Objects.equals(catchPhrase, company.catchPhrase) &&
                Objects.equals(name, company.name);
    }

    @Override public int hashCode() {
        return Objects.hash(bs, catchPhrase, name);
    }

    @Override
    public String toString() {
        return "ClassPojo [bs = " + bs + ", catchPhrase = " + catchPhrase + ", name = " + name + "]";
    }
}
