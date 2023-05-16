package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    public List<Player> getAllPlayers() {
        return Game.getPlayerList();
    }
}
