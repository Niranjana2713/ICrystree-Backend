package crystree.java.project.Entity;

import java.sql.Date;
import java.time.LocalDateTime;

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
@Table(name = "icrystal_company")
public class ICrystreeCompanyEntity {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long icrystal_companyid;
    private String icrystal_company_name;
    private String company_desc;
    private String cin_number;
    private Date creation_date;
    private Date last_update_date;
    private LocalDateTime created_at;
    private Long created_by;
    private LocalDateTime modified_at;
    private Long modified_by;
}
