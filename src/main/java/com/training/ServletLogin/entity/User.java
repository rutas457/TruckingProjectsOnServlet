package com.training.ServletLogin.entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private Integer id;
    private String email;
    private String name;
    private String surname;
    private String password;
    private String role;

    public static Builder builder() {
        return new User().new Builder();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getSurname(), user.getSurname()) &&
                Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getName(), getSurname(), getPassword(), getRole());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public class Builder {

        private Builder() {
        }

        public Builder id(Integer id) {
            User.this.id = id;
            return this;
        }

        public Builder email(String email) {
            User.this.email = email;

            return this;
        }

        public Builder name(String name) {
            User.this.name = name;

            return this;
        }

        public Builder surname(String surname) {
            User.this.surname = surname;

            return this;
        }

        public Builder password(String password) {
            User.this.password = password;

            return this;
        }

        public Builder roles(String role) {
            User.this.role = role;

            return this;
        }


        public User build() {
            return User.this;
        }

    }
}
