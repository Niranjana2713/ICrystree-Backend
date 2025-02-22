package crystree.java.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import crystree.java.project.Entity.ICrystalEmpEntity;
import crystree.java.project.Entity.ICrystalUsersEntity;
import crystree.java.project.Entity.ICrystreeCompanyEntity;
import crystree.java.project.Response.ApiResponse;
import crystree.java.project.Service.EmailService;
import crystree.java.project.Service.ICrystalEmpService;
import crystree.java.project.Service.ICrystalUsersService;
import crystree.java.project.Service.ICrystreeCompanyService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/icrystreecompany")
public class Controller {
    
    @Autowired
    private ICrystreeCompanyService iCrystreeCompanyService;
    @Autowired
    private ICrystalEmpService iCrystalEmpService;
    @Autowired
    private ICrystalUsersService iCrystalUsersService;
    @Autowired
    private EmailService emailService;

    @PostMapping("/company/create")
    public ICrystreeCompanyEntity createCompany(@RequestBody ICrystreeCompanyEntity iCrystreeCompanyEntity) {
        return iCrystreeCompanyService.create(iCrystreeCompanyEntity);
    }
     @GetMapping("/company/getall")
    public List<ICrystreeCompanyEntity> getAllCompanies() {
        return iCrystreeCompanyService.getall();
    }

    @GetMapping("/company/get/{id}")
    public ResponseEntity<ICrystreeCompanyEntity> getCompanyById(@PathVariable Long id) {
        ICrystreeCompanyEntity company = iCrystreeCompanyService.getByID(id);
        return company != null ? ResponseEntity.ok(company) : ResponseEntity.notFound().build();
    }

    @PutMapping("/company/update/{id}")
    public ResponseEntity<ICrystreeCompanyEntity> updateCompany(@PathVariable Long id, @RequestBody ICrystreeCompanyEntity companyDetails) {
        if (iCrystreeCompanyService.getByID(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(iCrystreeCompanyService.updatecompany(companyDetails));
    }
    

    @DeleteMapping("/company/delete/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        if (iCrystreeCompanyService.getByID(id) == null) {
            return ResponseEntity.notFound().build();
        }
        iCrystreeCompanyService.deletebyid(id);
        return ResponseEntity.noContent().build();
    }

    // Employee
     
    @PostMapping("/employee/create")
    public ICrystalEmpEntity createEmployee(@RequestBody ICrystalEmpEntity employee) {
        return iCrystalEmpService.create(employee);
    }

    @GetMapping("/employee/getall")
    public List<ICrystalEmpEntity> getAllEmployees() {
        return iCrystalEmpService.getAll();
    }

    @GetMapping("/employee/get/{id}")
    public ResponseEntity<ICrystalEmpEntity> getEmployeeById(@PathVariable Long id) {
        ICrystalEmpEntity employee = iCrystalEmpService.getById(id);
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    @PutMapping("/employee/update/{id}")
    public ResponseEntity<ICrystalEmpEntity> updateEmployee(@PathVariable Long id, @RequestBody ICrystalEmpEntity employeeDetails) {
        if (iCrystalEmpService.getById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(iCrystalEmpService.update(employeeDetails));
    }

    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        iCrystalEmpService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // user


    @PostMapping("/user/create")
    public ICrystalUsersEntity createUser(@RequestBody ICrystalUsersEntity user) {
        return iCrystalUsersService.create(user);
    }

    @GetMapping("/user/getall")
    public List<ICrystalUsersEntity> getAllUsers() {
        return iCrystalUsersService.getAll();
    }

    @GetMapping("/user/get/{id}")
    public ResponseEntity<ICrystalUsersEntity> getUserById(@PathVariable Long id) {
        ICrystalUsersEntity user = iCrystalUsersService.getById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<ICrystalUsersEntity> updateUser(@PathVariable Long id, @RequestBody ICrystalUsersEntity userDetails) {
        if (iCrystalUsersService.getById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(iCrystalUsersService.update(userDetails));
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        iCrystalUsersService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    //***************************************************************************************** */

     @PostMapping("/login")
    public ResponseEntity<ApiResponse<?>> loginUser(@RequestParam String username, @RequestParam String password) {
        ApiResponse<?> response = iCrystalUsersService.authenticateUser(username, password);
        return ResponseEntity.status(response.getstatus()).body(response);
    }

    @PostMapping("/email")
  public String emailChecking(@RequestParam String email) {
    emailService.sendVerificationEmail(email, null, email);
    return "Done";
  }
}
