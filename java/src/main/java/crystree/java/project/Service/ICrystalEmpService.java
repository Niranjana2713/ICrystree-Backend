package crystree.java.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crystree.java.project.Entity.ICrystalEmpEntity;
import crystree.java.project.Repository.ICrystalEmpRepository;

@Service
public class ICrystalEmpService {
    @Autowired
    private ICrystalEmpRepository iCrystalEmpRepository;


    public ICrystalEmpEntity create(ICrystalEmpEntity employee) {
        return iCrystalEmpRepository.save(employee);
    }

    public List<ICrystalEmpEntity> getAll() {
        return iCrystalEmpRepository.findAll();
    }

    public ICrystalEmpEntity getById(Long id) {
        return iCrystalEmpRepository.findById(id).orElse(null);
    }

    public ICrystalEmpEntity update(ICrystalEmpEntity employee) {
        return iCrystalEmpRepository.save(employee);
    }

    public void deleteById(Long id) {
        iCrystalEmpRepository.deleteById(id);
    }
}
