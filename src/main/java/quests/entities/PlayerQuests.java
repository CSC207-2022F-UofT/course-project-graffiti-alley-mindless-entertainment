package quests.entities;

import character.entities.Bystander;

import save.entities.SavableEntity;
import save.entities.SaveEntityId;


import java.util.ArrayList;
import java.util.List;

/**
 * This class manages all the quests that are completed by the player.
 */
public class PlayerQuests {
    /**
     * Attributes.
     */
    // Stores the quests completed and ongoing in the game.
    private List<Quest> quests;


    /**
     * Constructor.
     */
    public PlayerQuests() {
        this.quests = new ArrayList<>();

    }

    /**
     * Adds the quest retrieved to the quest started by the player.
     * @param quest: that is added.
     */
    public void addNewQuest(Quest quest) {
        this.quests.add(quest);
    }

    /**
     * @return list of quests.
     */
    public List<Quest> getQuests() {
        return this.quests;
    }

    public class SaveQuests implements SavableEntity {
        /**
         * @return a string representation of the object to be saved
         */
        @Override
        public String toSavableString() {
            String questsInformation = "";

            for (Quest quest : quests) {
                if (!questsInformation.equals("")) {
                    questsInformation += "§";
                }
                questsInformation += quest.new SaveQuest().toSavableString();
            }

            return questsInformation;
        }

        /**
         * @param str a string representation
         *            map the string representation to the corresponding object
         */
        @Override
        public void fromSavableString(String str) {
            quests = getQuests(str);
        }

        /**
         * @param str contains the information of all the quests.
         * @return a list of the quests based on information in the String.
         */
        private List<Quest> getQuests(String str) {
            String[] questsInformation = str.split("§");

            List<Quest> quests = new ArrayList<>();

            for (String questInformation : questsInformation) {
                quests.add(questFromString(questInformation));
            }

            return quests;
        }

        /**
         * @param str contains the information needed for the Quest.
         * @return a quest based on information in the parameter.
         */
        private Quest questFromString(String str) {
            Quest quest = this.getGenericQuest();
            quest.new SaveQuest().fromSavableString(str);

            return quest;
        }

        /**
         * @return generic quest.
         */
        private Quest getGenericQuest() {
            return new Quest("", "", new Bystander("", false),
                    null, new ArrayList<>());
        }

        /**
         * @return the id of this entity in the saved entities list
         */
        @Override
        public SaveEntityId getId() {
            return SaveEntityId.QUESTS;
        }
    }
}
