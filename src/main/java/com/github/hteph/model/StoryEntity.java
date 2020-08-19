package com.github.hteph.model;

import java.util.ArrayList;
import java.util.List;

public class StoryEntity extends StoryAttributes {

    private String baseGeneratedString;
    private String archetype;
    private String kenning;
    private List<StoryAttributes> attributes = new ArrayList<>();
    private String location;
    private String title;
    private List<String> questRewards;

    public StoryEntity(Builder builder) {
        super(builder.name, builder.description);
        this.attributes = builder.attributes;
        this.baseGeneratedString = builder.baseGeneratedString;
        this.archetype = builder.archetype;
        this.kenning = builder.kenning;
        this.location = builder.location;
        this.title = builder.title;
        this.questRewards =builder.questRewards;
    }

    public void addAttributes(List<StoryAttributes> attributesList){
        attributes.addAll(attributesList);
    }

    public List<String> getQuestRewards() {
        return questRewards;
    }

    public String getTitle() {

        return title == null ?"":title;
    }

    public String getBaseGeneratedString() {
        return baseGeneratedString;
    }

    public String getArchetype() {
        return archetype;
    }

    public String getKenning() {
        return kenning;
    }

    public List<StoryAttributes> getAttributes() {
        return attributes;
    }

    public String getLocation() {
        return location;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String description;
        private List<StoryAttributes> attributes = new ArrayList<>();
        private String baseGeneratedString;
        private String archetype;
        private String kenning;
        private String location;
        private String title;
        private List<String> questRewards;


        public Builder withQuestRewards(List<String> questRewards) {
            this.questRewards = questRewards;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder withBaseGeneratedString(String baseGeneratedString) {
            this.baseGeneratedString = baseGeneratedString;
            return this;
        }

        public Builder withArchetype(String archetype) {
            this.archetype = archetype;
            return this;
        }

        public Builder withKenning(String kenning) {
            this.kenning = kenning;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withAttributes(List<StoryAttributes> attributes) {
            this.attributes = attributes;
            return this;
        }

        public StoryEntity build() {

            return new StoryEntity(this);
        }
    }
}
