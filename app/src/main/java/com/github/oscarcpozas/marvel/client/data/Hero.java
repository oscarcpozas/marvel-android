package com.github.oscarcpozas.marvel.client.data;

public class Hero {

    private final String name;
    private final String realName;
    private final String photo;
    private final String description;

    public Hero(String name, String realName, String photo, String description) {
        this.name = name;
        this.realName = realName;
        this.photo = photo;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public String getPhoto() {
        return photo;
    }

    public String getDescription() {
        return description;
    }
}
