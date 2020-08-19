package com.github.hteph.model;

import java.util.ArrayList;
import java.util.List;

public class Quest extends StoryAttributes{

    private String baseGeneratedString;
    private String archetype;
    private String kenning;
    private List<StoryAttributes> attributes = new ArrayList<>();
    private String location;
    private String title;

    public Quest(Quest.Builder builder) {
        super(builder.name, builder.description);
        this.attributes = builder.attributes;
        this.baseGeneratedString = builder.baseGeneratedString;
        this.archetype = builder.archetype;
        this.kenning = builder.kenning;
        this.location = builder.location;
        this.title = builder.title;
    }

    public void addAttributes(List<StoryAttributes> attributesList){
        attributes.addAll(attributesList);
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

    public static Quest.Builder getBuilder() {
        return new Quest.Builder();
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

        public Quest.Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Quest.Builder withLocation(String location) {
            this.location = location;
            return this;
        }

        public Quest.Builder withBaseGeneratedString(String baseGeneratedString) {
            this.baseGeneratedString = baseGeneratedString;
            return this;
        }

        public Quest.Builder withArchetype(String archetype) {
            this.archetype = archetype;
            return this;
        }

        public Quest.Builder withKenning(String kenning) {
            this.kenning = kenning;
            return this;
        }

        public Quest.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Quest.Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Quest.Builder withAttributes(List<StoryAttributes> attributes) {
            this.attributes = attributes;
            return this;
        }

        public Quest build() {

            return new Quest(this);
        }
    }
}
