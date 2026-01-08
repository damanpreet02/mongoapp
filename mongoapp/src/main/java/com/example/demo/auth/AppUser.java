package com.example.demo.auth;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="accounts")
public class AppUser {

    @Id
    private String id;
    private String username;
    private String password;

    public AppUser() {}

    public String getId(){ return id; }
    public String getUsername(){ return username; }
    public String getPassword(){ return password; }

    public void setId(String id){ this.id = id; }
    public void setUsername(String u){ this.username = u; }
    public void setPassword(String p){ this.password = p; }
}
