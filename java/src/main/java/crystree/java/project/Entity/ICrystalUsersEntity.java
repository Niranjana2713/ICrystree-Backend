package crystree.java.project.Entity;


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
@Table(name = "icrystal_users")
public class ICrystalUsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long icrystal_user_id;
    private Long icrystal_companyid;
    private Long icrystal_employee_id;
    private String icrystal_user_name;
    private String icrystal_user_password;
    private LocalDateTime creation_date;
    private LocalDateTime last_update_date;
    private LocalDateTime last_login_date;
    private LocalDateTime last_pwd_chng_dt;
    private LocalDateTime created_at;
    private Long created_by;
    private LocalDateTime modified_at;
    private Long modified_by;



    
}
