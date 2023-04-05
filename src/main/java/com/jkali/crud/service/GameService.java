package com.jkali.crud.service;

import com.jkali.crud.entity.Game;
import com.jkali.crud.exception.ResourceNotFoundException;
import com.jkali.crud.repository.GameRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GameService  {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getGames() {
        return gameRepository.findAll();
    }

    public Game getGame(Long id) {
        return gameRepository.findById(id).orElse(null);
    }

    public ResponseEntity<Game> updateGame(Long id, Game game) {

        Game gameToUpdate = gameRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Non existant game with id: " + id));;

        gameToUpdate.setName(game.getName());
        gameToUpdate.setPrice(game.getPrice());

        gameRepository.save(gameToUpdate);

        return ResponseEntity.ok(gameToUpdate);

    }

    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    public String deleteGame(Long id) {
        try {
            gameRepository.findById(id).get();
            gameRepository.deleteById(id);
            return "Game deleted successfully";
        } catch (Exception e) {
            return "Game not found";
        }

    }
}
