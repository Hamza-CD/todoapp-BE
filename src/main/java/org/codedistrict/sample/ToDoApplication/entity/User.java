package org.codedistrict.sample.ToDoApplication.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ToDoItem> todoItems;

    public User() {
    }

    public User(Long userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
