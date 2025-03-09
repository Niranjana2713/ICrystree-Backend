package crystree.java.project.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="icrystal_ticket_status")
public class ICrystalTicketStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long icrystal_ticket_status_id;
    private String icrystal_ticket_status_name;

}
