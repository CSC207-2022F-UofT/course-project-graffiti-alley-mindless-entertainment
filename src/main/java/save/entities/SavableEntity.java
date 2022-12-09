package save.entities;

public interface SavableEntity {

    /**
     * @return a string representation of the object to be saved
     */
    String toSavableString();

    /**
     * @param str a string representation
     * map the string representation to the corresponding object
     */
    void fromSavableString(String str);

    /**
     * @return the id of this entity in the saved entities list
     */
    SaveEntityId getId();
}

