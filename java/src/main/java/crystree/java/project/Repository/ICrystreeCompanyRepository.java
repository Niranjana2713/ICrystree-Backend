package crystree.java.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crystree.java.project.Entity.ICrystreeCompanyEntity;

@Repository
public interface ICrystreeCompanyRepository extends JpaRepository<ICrystreeCompanyEntity,Long> {

    
} 