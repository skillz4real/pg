package corp.vortex.retr0.service;

import corp.vortex.retr0.model.GameNode;
import corp.vortex.retr0.repository.GameNodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@Service
public class GameNodeService {
    private final GameNodeRepository gameNodeRepository;


    public void createGameNode(String title){
        GameNode game = new GameNode();
        game.setTitle(title);
        gameNodeRepository.save(game);
    }

    public List<GameNode> getAllGameNodes(){
        return gameNodeRepository.findAll();
    }

    public GameNode findGameNodeByTitle(String title){
        return gameNodeRepository.findByTitle(title)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    public void updateGameNode(String old_title, String new_title){
        GameNode game = findGameNodeByTitle(old_title);
        game.setTitle(new_title);
        gameNodeRepository.save(game);
    }

    public void deleteGameNode(String title){
        gameNodeRepository.delete(findGameNodeByTitle(title));
    }

//    public void setPublisher(String title, String publisher){
//        gameNodeRepository.setPublishedRelationship(title, publisher);
//    }

}
