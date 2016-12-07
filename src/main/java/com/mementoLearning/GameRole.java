package com.mementoLearning;

/**
 * Created by zhengchao on 2016/11/5.
 */
public class GameRole {
    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    private int vit;
    private int atk;
    private int def;

    public void stateDisplay() {
        System.out.println("Current Role state:");
        System.out.println("体力: " + this.vit);
        System.out.println("攻击力: " + this.atk);
        System.out.println("防御力: " + this.def);
    }

    public void getInitState() {
        this.vit = 100;
        this.atk = 100;
        this.def = 100;
    }

    public void fight() {
        this.vit = 0;
        this.atk = 0;
        this.def = 0;
    }

    public RoleStateMemento saveRoleState() {
        return new RoleStateMemento(this.vit, this.atk, this.def);
    }

    public void recoverState(RoleStateMemento memento) {
        this.vit = memento.getVit();
        this.atk = memento.getAtk();
        this.def = memento.getDef();
    }
}
