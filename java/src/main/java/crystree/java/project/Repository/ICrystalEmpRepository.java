package crystree.java.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crystree.java.project.Entity.ICrystalEmpEntity;

@Repository
public interface ICrystalEmpRepository extends JpaRepository<ICrystalEmpEntity,Long> {

    
}