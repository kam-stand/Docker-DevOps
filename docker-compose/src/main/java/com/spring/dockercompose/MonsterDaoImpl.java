package com.spring.dockercompose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MonsterDaoImpl implements MonsterDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Monster> getMonsters() {
        String sql = "SELECT * FROM monster";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Monster.class));
    }

    @Override
    public Monster getMonster(Long id) {
        String sql = "SELECT * FROM monster WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Monster.class), id);
    }

    @Override
    public Monster createMonster(Monster monster) {
        String sql = "INSERT INTO monster (name, health, attacks, defense, damage) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, monster.getName(), monster.getHealth(), monster.getAttacks(), monster.getDefense(), monster.getDamage());
        return monster;
    }

    @Override
    public Monster updateMonster(long id, Monster monster) {
        String sql = "UPDATE monster SET name = ?, health = ?, attacks = ?, defense = ?, damage = ? WHERE id = ?";
        jdbcTemplate.update(sql, monster.getName(), monster.getHealth(), monster.getAttacks(), monster.getDefense(), monster.getDamage(), id);
        monster.setId(id);
        return monster;
    }

    @Override
    public void deleteMonster(long id) {
        String sql = "DELETE FROM monster WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
