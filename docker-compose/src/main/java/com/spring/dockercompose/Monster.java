package com.spring.dockercompose;

public class Monster {

    private long id;
    private String name;
    private int health;
    private int attacks;
    private int defense;
    private int damage;

    public Monster() {

    }

    public Monster(String name, int health, int attacks, int defense, int damage) {
        this.name = name;
        this.health = health;
        this.attacks = attacks;
        this.defense = defense;
        this.damage = damage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttacks() {
        return attacks;
    }

    public void setAttacks(int attacks) {
        this.attacks = attacks;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
