package com.spring.dockercompose;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/monster")
public class MonsterController {

    private final MonsterService monsterService;

    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @GetMapping()
    public ResponseEntity<List<Monster>> getMonsters() {
        return new ResponseEntity<>(monsterService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Monster> getMonster(@PathVariable Long id) {
        return new ResponseEntity<>(monsterService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Monster> createMonster(@RequestBody Monster monster) {
        return new ResponseEntity<>(monsterService.save(monster), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Monster> updateMonster(@RequestBody Monster monster, @PathVariable Long id) {
        monster.setId(id);
        return new ResponseEntity<>(monsterService.save(monster), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteMonster(@PathVariable Long id) {
        monsterService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
