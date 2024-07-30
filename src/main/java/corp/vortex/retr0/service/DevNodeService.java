package corp.vortex.retr0.service;

import corp.vortex.retr0.model.DevNode;
import corp.vortex.retr0.repository.DevNodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@Service
public class DevNodeService {
    private final DevNodeRepository devNodeRepository;

    public void createDevNode(String name) {
        DevNode devNode = new DevNode();
        devNode.setName(name);
        devNodeRepository.save(devNode);
    }

    public List<DevNode> getAllDevNodes() {
        return devNodeRepository.findAll();
    }

    public DevNode findDevNodeByName(String name) {
        return devNodeRepository.findByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void updateDevNode(String name, String new_name) {
        DevNode devNode = findDevNodeByName(name);
        devNode.setName(new_name);
        devNodeRepository.save(devNode);
    }

    public void deleteDevNode(String name) {
        DevNode devNode = findDevNodeByName(name);
        devNodeRepository.delete(devNode);
    }
}