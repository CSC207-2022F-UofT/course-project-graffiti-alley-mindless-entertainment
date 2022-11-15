package Enemy_system;

import objects.character.Enemy;

public abstract class Turn {



    public boolean dictateTurn(Player player, Enemy enemy){
        if(player.getSpeed > enemy.getSpeed()){
            return true; //returns true of the user gets the first turn
        } else{
            return false;
        }
    }

    public int calculateDamage(Skill skill, Character character){
        String skill_type = skill.getType();
        String char_type = character.gettype();
        if((skill_type.equals("water") && char_type.equals("fire")) || (skill_type.equals("grass") && char_type.equals("water"))
        || (skill_type.equals("fire") && char_type.equals("grass")) ) {
            return (int)Math.ceil(skill.getDamage()*1.2);
        } if((skill_type.equal("fire") && char_type.equals("water")) || (skill_type.equals("grass") && char_type.equals("fire"))
        || (skill_type.equals("water") && char_type.equals("grass")) ) {
            return (int) Math.ceil(skill.getDamage * 0.8);
        } else{
            return skill.getDamage();
        }
    }

    public abstract Object handleAction(String input);
}
