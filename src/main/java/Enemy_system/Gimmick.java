package Enemy_system;

import Enemy_Entities.Boss;

public interface Gimmick {

    public boolean use_gimmick(Boss boss, Player player); //return true if the gimmick has used

    public boolean check_gimmick(Boss boss);


}
