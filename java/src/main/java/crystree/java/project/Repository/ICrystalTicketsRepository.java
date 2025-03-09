package crystree.java.project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import crystree.java.project.Entity.ICrystalTicketsEntity;

@Repository
public interface ICrystalTicketsRepository extends JpaRepository<ICrystalTicketsEntity,Long> {

@Query("SELECT COUNT(t) FROM ICrystalTicketsEntity t")
    Long countTotalTickets();  
    
    @Query("FROM ICrystalTicketsEntity  t WHERE t.icrystal_ticket_status_id = :iCrystalTicketStatusId ")
    public List<ICrystalTicketsEntity>  findByiCrystalTicketStatusId(@Param("iCrystalTicketStatusId") Long iCrystalTicketStatusId);
} 