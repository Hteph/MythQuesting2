package com.github.hteph.creators;

import com.github.hteph.model.StoryEntity;
import com.github.hteph.tables.TableMaker;
import com.github.hteph.tables.WordLists;

import java.util.Collections;
import java.util.List;

public class IndividualCreator {

    private IndividualCreator() {
    }

    public static StoryEntity storyGiver(String base) {
        StoryEntity.Builder entity = StoryEntity.getBuilder();

        setPerson(base, entity);
        entity.withQuestRewards(Collections.singletonList(TableMaker.pickOne(WordLists.REWARD).orElse("No Cigar for you")));


        return entity.build();
    }

    private static void setPerson(String base, StoryEntity.Builder entity) {
        String typeString;
        String title = "";
        String archetypePrefixish = "";
        String archetype;
        String archetypeSuffixish = "";
        System.out.println(base);
        if (base.contains("[")) {
            typeString = base.substring(0, base.indexOf('['));
            archetype = typeString.substring(0, typeString.indexOf(':'));
            title = TableMaker.pickOne(base.substring(base.indexOf('[') + 1, base.indexOf(']')).split(",")).orElse(null);
        } else if (base.contains("<faction>")) {
            typeString = base.replace("<faction>", "");
            archetypePrefixish = " member of the ";
            archetypeSuffixish = " named Somename,";
            archetype = typeString.substring(0, typeString.indexOf(':')).replace("<faction>", "");
        } else {
            typeString = base;
            archetype = typeString.contains(":") ? typeString.substring(0, typeString.indexOf(':')) : typeString;
        }
        if (base.contains("Any")) {
            archetype = base.contains(":") ? base.substring(0, base.indexOf(':')) : base;
            typeString = archetype + ":" + TableMaker.pickOne(WordLists.ANY).orElse("of Errorish");
        }
        String diversifiedTypeString = typeString.replace("Warrior", TableMaker.pickOne(WordLists.WARRIOR).orElse("Warrior"))
                                                 .replace("Priest", TableMaker.pickOne(WordLists.PRIEST).orElse("Priest"))
                                                 .replace("Mage", TableMaker.pickOne(WordLists.MAGE).orElse("Mage"))
                                                 .replace("Rogue", TableMaker.pickOne(WordLists.ROGUE).orElse("Rogue"));

        String[] typeArray = diversifiedTypeString.substring(typeString.indexOf(':') + 1).split(",");
        String type = TableMaker.pickOne(typeArray).orElse("of Error");


        entity.withBaseGeneratedString(base)
              .withName("Goodname")
              .withTitle(title)
              .withArchetype(archetypePrefixish + archetype + archetypeSuffixish)
              .withKenning(KenningCreation.find(type).orElse("Stupid Error"));
    }
}
