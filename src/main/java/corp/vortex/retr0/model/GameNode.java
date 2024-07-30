package corp.vortex.retr0.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameNode {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;
    private String title;

    @Relationship(type = "PUBLISHED_BY", direction = Relationship.Direction.OUTGOING)
    private List<PublisherNode> publisherNodes = new ArrayList<>();

    @Relationship(type = "DEVELOPED_BY", direction = Relationship.Direction.OUTGOING)
    private List<DevNode> devNodes = new ArrayList<>();
}