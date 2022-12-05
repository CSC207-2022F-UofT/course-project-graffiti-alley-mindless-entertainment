package save;

public interface SavableEntity {

    /**
     * @return a string representation of the object to be saved
     */
    public String toSavableString();

    /**
     * @param str a string representation
     * map the string representation to the corresponding object
     */
    public void fromSavableString(String str);

    /**
     * @return the id of this entity in the saved entities list
     */
    public SaveEntityId getId();
}

