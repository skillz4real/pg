package corp.vortex.retr0.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Data
public class DevNode {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
