package corp.vortex.retr0.repository;

import corp.vortex.retr0.model.DevNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface DevNodeRepository extends Neo4jRepository<DevNode, Long> {

    Optional<DevNode> findByName(String name);
}
