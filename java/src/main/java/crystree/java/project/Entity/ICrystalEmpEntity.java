package crystree.java.project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name ="icrystal_emp")
public class ICrystalEmpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long icrystal_employee_id;
    private Long icrystal_companyid;
    private String icrystal_employee_name;
    
}
