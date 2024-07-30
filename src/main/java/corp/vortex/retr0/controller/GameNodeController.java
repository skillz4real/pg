package corp.vortex.retr0.controller;

import corp.vortex.retr0.model.GameNode;
import corp.vortex.retr0.model.PublisherNode;
import corp.vortex.retr0.service.DevNodeService;
import corp.vortex.retr0.service.GameNodeService;
import corp.vortex.retr0.service.PublisherNodeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games/")
@AllArgsConstructor
public class GameNodeController {
    private final GameNodeService gameNodeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("{title}")
    public void createGameNode(@PathVariable String title){
        gameNodeService.createGameNode(title);
    }

    @GetMapping("")
    public ResponseEntity<List<GameNode>> gameIndex(){
        return ResponseEntity.ok(gameNodeService.getAllGameNodes());
    }

    @GetMapping("{title}")
    public ResponseEntity<GameNode> getGameNode(@PathVariable String title){
        return ResponseEntity.ok(gameNodeService.findGameNodeByTitle(title));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("{title}")
    public void updateGameNode(@PathVariable String title, @RequestParam String new_title){
        gameNodeService.updateGameNode(title, new_title);
    }

    @DeleteMapping("{title}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGameNode(@PathVariable String title){
        gameNodeService.deleteGameNode(title);
    }

}
