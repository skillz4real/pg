package corp.vortex.retr0.service;

import corp.vortex.retr0.model.PublisherNode;
import corp.vortex.retr0.repository.DevNodeRepository;
import corp.vortex.retr0.repository.GameNodeRepository;
import corp.vortex.retr0.repository.PublisherNodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@Service
public class PublisherNodeService {
    GameNodeRepository gameNodeRepository;
    DevNodeRepository devNodeRepository;
    PublisherNodeRepository publisherNodeRepository;

    public void createPublisherNode(String name) {
        PublisherNode publisherNode = new PublisherNode();
        publisherNode.setName(name);
        publisherNodeRepository.save(publisherNode);
    }

    public PublisherNode findPublisherNodeByName(String name) {
        return publisherNodeRepository.findByName(name)
                .orElseThrow(()-> new ResponseStatusException(HttpStatusCode.valueOf(404)));
    }

    public List<PublisherNode> getAllPublisherNodes(){
        return publisherNodeRepository.findAll();
    }
    public void updatePublisherNode(String name, String new_name){
        PublisherNode publisherNode = findPublisherNodeByName(name);
        publisherNode.setName(new_name);
        publisherNodeRepository.save(publisherNode);
    }

    public void deletePublisherNode(String name) {
        publisherNodeRepository.delete(findPublisherNodeByName(name));
    }

}
