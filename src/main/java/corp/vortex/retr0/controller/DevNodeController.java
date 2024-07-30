package corp.vortex.retr0.controller;

import corp.vortex.retr0.model.DevNode;
import corp.vortex.retr0.service.DevNodeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dev/")
@AllArgsConstructor
public class DevNodeController {

    private final DevNodeService devNodeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("{name}")
    public void createDevNode(@PathVariable String name){
        devNodeService.createDevNode(name);
    }

    @GetMapping("")
    public ResponseEntity<List<DevNode>> devIndex(){
        return ResponseEntity.ok(devNodeService.getAllDevNodes());
    }

//    @GetMapping("{title}/publisher")
//    public PublisherNode getPublisherNode(@PathVariable String title){
//        return gameNodeService.getPublisherNode(title);
//    }

    @GetMapping("{name}")
    public DevNode getDevNode(@PathVariable String name){
        return devNodeService.findDevNodeByName(name);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("{name}")
    public void updateDevNode(@PathVariable String name, @RequestParam String new_name){
        devNodeService.updateDevNode(name, new_name);
    }

    @DeleteMapping("{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDevNode(@PathVariable String name){
        devNodeService.deleteDevNode(name);
    }

}
