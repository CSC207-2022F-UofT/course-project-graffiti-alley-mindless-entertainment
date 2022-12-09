package quests;

/**
 * This class contains the factory for creating QuestMenuStates (design patter).
 */
public class QuestMenuFactory {
    /**
     * Attribute.
     */
    private final QuestInteractor questInteractor;

    /**
     * Constructor
     */
    public QuestMenuFactory(QuestInteractor questInteractor) {
        this.questInteractor = questInteractor;
    }

    /**
     * @return QuestMenuState.
     */
    public QuestMenuState createQuestMenuState() {
        return new QuestMenuState(this.questInteractor);
    }
}
