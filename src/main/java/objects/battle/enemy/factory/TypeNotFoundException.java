package objects.battle.enemy.factory;

public class TypeNotFoundException extends Exception{
    public TypeNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
