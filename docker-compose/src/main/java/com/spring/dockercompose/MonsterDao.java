package com.spring.dockercompose;

import java.util.List;

public interface MonsterDao {
    List<Monster> getMonsters();
    Monster getMonster(Long id);
    Monster createMonster(Monster monster);
    Monster updateMonster(long id, Monster monster);
    void deleteMonster(long id);
}
