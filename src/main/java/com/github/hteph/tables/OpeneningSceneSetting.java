package com.github.hteph.tables;

import com.github.hteph.creators.IndividualCreator;
import com.github.hteph.model.StoryEntity;

import java.util.Random;

public class OpeneningSceneSetting {

    private OpeneningSceneSetting() {
    }

    private static Random random = new Random();

    public static String getPersonAttribute() {

        return TableMaker.pickOne(WordLists.STORY_GIVER_ATTRIBUTE).orElse("Faulty");

    }

    public static StoryEntity getIndividual() {

         String storyGiverString = TableMaker.pickOne(WordLists.STORY_GIVER).orElse("Dumbass");

        return IndividualCreator.storyGiver(storyGiverString);
    }
}
