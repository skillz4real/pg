package corp.vortex.retr0.controller;

import corp.vortex.retr0.model.PublisherNode;
import corp.vortex.retr0.service.PublisherNodeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher/")
@AllArgsConstructor
public class PublisherNodeController {

    private final PublisherNodeService publisherNodeService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("{name}")
    public void createPublisherNode(@PathVariable String name){
        publisherNodeService.createPublisherNode(name);
    }

    @GetMapping("")
    public ResponseEntity<List<PublisherNode>> publisherIndex(){
        return ResponseEntity.ok(publisherNodeService.getAllPublisherNodes());
    }

//    @GetMapping("{title}/publisher")
//    public PublisherNode getPublisherNode(@PathVariable String title){
//        return gameNodeService.getPublisherNode(title);
//    }

    @GetMapping("{name}")
    public PublisherNode getPublisherNode(@PathVariable String name){
        return publisherNodeService.findPublisherNodeByName(name);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("{name}")
    public void updatePublisherNode(@PathVariable String name, @RequestParam String new_name){
        publisherNodeService.updatePublisherNode(name, new_name);
    }

    @DeleteMapping("{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisherNode(@PathVariable String name){
        publisherNodeService.deletePublisherNode(name);
    }

}
