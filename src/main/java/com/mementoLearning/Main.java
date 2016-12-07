package com.mementoLearning;

/**
 * Created by zhengchao on 2016/11/5.
 */
public class Main {
    public static void main(String[] args) {
        GameRole lixiaoyao = new GameRole();
        lixiaoyao.getInitState();
        lixiaoyao.stateDisplay();

        RoleStateCareTaker stateAdmin = new RoleStateCareTaker();
        stateAdmin.setMemento(lixiaoyao.saveRoleState());

        lixiaoyao.fight();
        lixiaoyao.stateDisplay();

        lixiaoyao.recoverState(stateAdmin.getMemento());
        lixiaoyao.stateDisplay();
    }
}
