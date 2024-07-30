package corp.vortex.retr0.repository;

import corp.vortex.retr0.model.PublisherNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface PublisherNodeRepository extends Neo4jRepository<PublisherNode, Long> {

    Optional<PublisherNode> findByName(String name);

}
