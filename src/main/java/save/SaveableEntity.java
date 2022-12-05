package save;

public interface SaveableEntity {

    /**
     * @return a string representation of the object to be saved
     */
    @Override
    public String toString();

    /**
     * @param str a string representation
     * map the string representation to the corresponding object
     */
    public void fromString(String str);

    /**
     * @return the id of this entity in the saved entities list
     */
    public SaveEntityId getId();
}

