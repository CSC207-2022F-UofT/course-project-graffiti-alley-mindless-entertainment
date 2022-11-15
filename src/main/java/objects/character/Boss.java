package objects.character;

import Enemy_Entities.Gimmick;

public class Boss extends Enemy {
    /**
     * This is a constructor of the enemy.
     *
     * @param name:
     */
    private Gimmick gimmickSet;
    private boolean GimmickUsed;

    public Boss(String name, int reputation)
    /**
     * This is a constructor of the enemy.
     *
     * @param name:
     */{
        super(name, reputation);

        this.gimmickSet = null;
        this.GimmickUsed = false;
    }
    public boolean checkGimmick()
    /**
     * This is a constructor of the enemy.
     *
     * @param name:
     */{
        return this.GimmickUsed;
    }

    public void usedGimmick()
    /**
     * This is a constructor of the enemy.
     *
     * @param name:
     */{
        this.GimmickUsed = true;
    }

    public void setGimmick(Gimmick gimmick)
    /**
     * This is a constructor of the enemy.
     *
     * @param name:
     */{
        this.gimmickSet = gimmick;
    }




}
