package com.github.hteph.model;

public abstract class StoryAttributes {

    private String name;
    private String description;

    public StoryAttributes() {
    }

    public StoryAttributes(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
