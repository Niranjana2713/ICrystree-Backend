package crystree.java.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crystree.java.project.Entity.ICrystreeCompanyEntity;
import crystree.java.project.Repository.ICrystreeCompanyRepository;

@Service
public class ICrystreeCompanyService {
    
    @Autowired
    private ICrystreeCompanyRepository iCrystreeCompanyRepository;

    public ICrystreeCompanyEntity create(ICrystreeCompanyEntity iCrystreeCompanyEntity)
    {
        return iCrystreeCompanyRepository.save(iCrystreeCompanyEntity);
    }
    public List<ICrystreeCompanyEntity> getall()
    {
        return iCrystreeCompanyRepository.findAll();
    }
    public ICrystreeCompanyEntity getByID(Long id)
    {
        return iCrystreeCompanyRepository.findById(id).orElse(null);
    }
    public ICrystreeCompanyEntity updatecompany(ICrystreeCompanyEntity iCrystreeCompanyEntity)
    {
        return iCrystreeCompanyRepository.save(iCrystreeCompanyEntity);
    }
    public void deletebyid(Long id)
    {
        iCrystreeCompanyRepository.deleteById(id);
    }


}
