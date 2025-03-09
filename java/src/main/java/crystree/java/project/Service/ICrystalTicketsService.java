package crystree.java.project.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crystree.java.project.DTO.ICrystalTicketDTO;
import crystree.java.project.Entity.ICrystalTicketStatusEntity;
import crystree.java.project.Entity.ICrystalTicketsEntity;
import crystree.java.project.Repository.ICrystalTicketStatusRepository;
import crystree.java.project.Repository.ICrystalTicketsRepository;

@Service
public class ICrystalTicketsService {
    @Autowired
    private ICrystalTicketsRepository iCrystalTicketsRepository;
    @Autowired
    private ICrystalTicketStatusRepository iCrystalTicketStatusRepository;

     public ICrystalTicketsEntity create(ICrystalTicketsEntity employee) {
        return iCrystalTicketsRepository.save(employee);
    }

    public List<ICrystalTicketsEntity> getAll() {
        return iCrystalTicketsRepository.findAll();
    }

    public ICrystalTicketsEntity getById(Long id) {
        return iCrystalTicketsRepository.findById(id).orElse(null);
    }

    public ICrystalTicketsEntity update(ICrystalTicketsEntity employee) {
        return iCrystalTicketsRepository.save(employee);
    }

    public void deleteById(Long id) {
        iCrystalTicketsRepository.deleteById(id);
    }

    public Long getTotalTickets() {
        return iCrystalTicketsRepository.countTotalTickets();
    }

    public Long getOpenTicketCount() {
    // Retrieve all ICrystalTicketStatusEntity records
    List<ICrystalTicketStatusEntity> statusEntities = iCrystalTicketStatusRepository.findAll();
    Long openStatusId = null;

    // Find the status ID for "open" statuses
    for (ICrystalTicketStatusEntity statusEntity : statusEntities) {
        if (statusEntity.getIcrystal_ticket_status_name().toLowerCase().contains("open")) {
            openStatusId = statusEntity.getIcrystal_ticket_status_id();
            break;  // Exit the loop once we find the first open status
        }
    }

    // If no open status found, return 0
    if (openStatusId == null) {
        return 0L;
    }

    // Find tickets with the found "open" status ID
    List<ICrystalTicketsEntity> openTickets = iCrystalTicketsRepository.findByiCrystalTicketStatusId(openStatusId);

    // Return the count of open tickets
    return (long) openTickets.size();
}
public Long getClosedTicketCount() {
    // Retrieve all ICrystalTicketStatusEntity records
    List<ICrystalTicketStatusEntity> statusEntities = iCrystalTicketStatusRepository.findAll();
    Long openStatusId = null;

    // Find the status ID for "open" statuses
    for (ICrystalTicketStatusEntity statusEntity : statusEntities) {
        if (statusEntity.getIcrystal_ticket_status_name().toLowerCase().contains("closed")) {
            openStatusId = statusEntity.getIcrystal_ticket_status_id();
            break;  // Exit the loop once we find the first open status
        }
    }

    // If no open status found, return 0
    if (openStatusId == null) {
        return 0L;
    }

    // Find tickets with the found "open" status ID
    List<ICrystalTicketsEntity> openTickets = iCrystalTicketsRepository.findByiCrystalTicketStatusId(openStatusId);

    // Return the count of open tickets
    return (long) openTickets.size();
}
 public List<ICrystalTicketDTO> getAllTicketsWithStatusNames() {
        List<ICrystalTicketsEntity> tickets = iCrystalTicketsRepository.findAll();

        return tickets.stream().map(ticket -> {
            String statusName = iCrystalTicketStatusRepository.findStatusNameById(ticket.getIcrystal_ticket_status_id());

            return new ICrystalTicketDTO(
                ticket.getIcrystal_ticket_id(),
                ticket.getIcrystal_ticket_subject(),
                ticket.getIcrystal_companyid(),
                ticket.getIcrystal_ticket_number(),
                ticket.getIcrystal_ticket_desc(),
                ticket.getIcrystal_ticket_notes(),
                statusName,  // Only Status Name (No ID)
                ticket.getIcrystal_ticket_creation_date(),
                ticket.getIcrystal_ticket_last_update_date(),
                ticket.getIcrystal_ticket_attachments(),
                ticket.getCreated_at(),
                ticket.getCreated_by(),
                ticket.getModified_at(),
                ticket.getModified_by()
            );
        }).collect(Collectors.toList());
    }

}
