package corp.vortex.retr0.repository;

import corp.vortex.retr0.model.GameNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.Optional;

public interface GameNodeRepository extends Neo4jRepository<GameNode, Long> {

    Optional<GameNode> findByTitle(String title);

//    @Query("MATCH (g:Game{title : $title}), (p:Publisher{name : $publisher}) CREATE (g)-[:PUBLISHED_BY]->(p)")
//    void setPublishedRelationship(String title, String publisher);
}
