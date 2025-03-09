package crystree.java.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import crystree.java.project.Entity.ICrystalTicketStatusEntity;

@Repository
public interface ICrystalTicketStatusRepository extends JpaRepository<ICrystalTicketStatusEntity,Long> {

    @Query("SELECT s.icrystal_ticket_status_name FROM ICrystalTicketStatusEntity s WHERE s.icrystal_ticket_status_id = :statusId")
    String findStatusNameById(@Param("statusId") Long statusId);
}