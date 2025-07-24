package com.spring.dockercompose;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonsterService {

    private final MonsterDao monsterDao;

    public MonsterService(MonsterDao monsterDao) {
        this.monsterDao = monsterDao;
    }

    public List<Monster> findAll() {
        return monsterDao.getMonsters();
    }

    public Monster save(Monster monster) {
        return monsterDao.createMonster(monster);
    }

    public Monster update(long id, Monster monster) {
        return monsterDao.updateMonster(id, monster);
    }

    public void delete(long id) {
        monsterDao.deleteMonster(id);
    }
    public Monster findById(long id) {
        return monsterDao.getMonster(id);
    }

}
