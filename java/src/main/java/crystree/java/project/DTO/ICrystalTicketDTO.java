package crystree.java.project.DTO;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ICrystalTicketDTO {
     private Long icrystal_ticket_id;
    private String icrystal_ticket_subject;
    private Long icrystal_companyid;
    private String icrystal_ticket_number;
    private String icrystal_ticket_desc;
    private String icrystal_ticket_notes;
    private String icrystal_ticket_status_name; // Replace ID with Name
    private Date icrystal_ticket_creation_date;
    private Date icrystal_ticket_last_update_date;
    private String icrystal_ticket_attachments;
    private LocalDateTime created_at;
    private Long created_by;
    private LocalDateTime modified_at;
    private Long modified_by;
}
