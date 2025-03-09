package crystree.java.project.Entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="icrystal_tickets")
public class ICrystalTicketsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long icrystal_ticket_id;
    private String icrystal_ticket_subject; 
    private Long icrystal_companyid;
    private String icrystal_ticket_number;
    private String icrystal_ticket_desc;
    private String icrystal_ticket_notes;
    private Long icrystal_ticket_status_id;
    private Date icrystal_ticket_creation_date;
    private Date icrystal_ticket_last_update_date;
    private String icrystal_ticket_attachments;
    private LocalDateTime created_at;
    private Long created_by;
    private LocalDateTime modified_at;
    private Long modified_by;
}
