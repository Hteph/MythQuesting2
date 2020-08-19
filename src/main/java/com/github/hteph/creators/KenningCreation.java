package com.github.hteph.creators;

import com.github.hteph.tables.OpeneningSceneSetting;
import com.github.hteph.tables.TableMaker;
import com.github.hteph.tables.WordLists;

import java.util.Optional;

public class KenningCreation {

    private KenningCreation() {
    }

    public static Optional<String> find(String type) {

        Optional<String> kenning;

        switch (type.toLowerCase().trim()) {

            case "alchemist":
            case "magic-user":
                kenning = TableMaker.pickOne(WordLists.MAGIC_USER);
                break;
            case "godtalker":
                kenning = TableMaker.pickOne(WordLists.GODTALKER);
                break;
            case "rogue":
                kenning = TableMaker.pickOne(WordLists.ROGUE);
                break;
            case "chaos warrior":
                kenning = TableMaker.pickOne(WordLists.CHAOS_WARRIOR);
                break;
            case "wild warrior":
                kenning = TableMaker.pickOne(WordLists.WILD_WARRIOR);
                break;
            case "bard":
                kenning = TableMaker.pickOne(WordLists.BARD);
                break;
            case "druid":
                kenning = TableMaker.pickOne(WordLists.DRUID);
                break;
            case "fighter":
                kenning = TableMaker.pickOne(WordLists.FIGHTER);
                break;
            case "honor warrior":
                kenning = TableMaker.pickOne(WordLists.HONOR_WARRIOR);
                break;
             case "hunter":
                kenning = TableMaker.pickOne(WordLists.HUNTER);
                break;
             case "illusionist":
                kenning = TableMaker.pickOne(WordLists.ILLUSIONIST);
                break;
             case "jester":
                kenning = TableMaker.pickOne(WordLists.JESTER);
                break;
             case "mountebank":
                kenning = TableMaker.pickOne(WordLists.MOUNTEBANK);
                break;
             case "mystic":
                kenning = TableMaker.pickOne(WordLists.MYSTIC);
                break;
             case "holy warrior":
                kenning = TableMaker.pickOne(WordLists.HOLY_WARRIOR);
                break;
             case "ranger":
                kenning = TableMaker.pickOne(WordLists.RANGER);
                break;
             case "thief":
                kenning = TableMaker.pickOne(WordLists.THIEF);
                break;
            case "savant":
                kenning = TableMaker.pickOne(WordLists.SAVANT);
                break;
            case "none":
                kenning = Optional.of("");
                break;
            default:
                kenning = Optional.of(type);
        }

        return kenning.map(base -> OpeneningSceneSetting.getPersonAttribute() + " " + base);
    }


}
