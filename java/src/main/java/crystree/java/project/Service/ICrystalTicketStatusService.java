package crystree.java.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import crystree.java.project.Entity.ICrystalTicketStatusEntity;
import crystree.java.project.Repository.ICrystalTicketStatusRepository;

@Service
public class ICrystalTicketStatusService {
   @Autowired
   private ICrystalTicketStatusRepository iCrystalTicketStatusRepository; 
   
    public ICrystalTicketStatusEntity create(ICrystalTicketStatusEntity employee) {
        return iCrystalTicketStatusRepository.save(employee);
    }
   
    public List<ICrystalTicketStatusEntity> getAll() {
        return iCrystalTicketStatusRepository.findAll();
    }

    public ICrystalTicketStatusEntity getById(Long id) {
        return iCrystalTicketStatusRepository.findById(id).orElse(null);
    }
}
