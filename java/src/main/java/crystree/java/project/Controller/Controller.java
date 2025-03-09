package crystree.java.project.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import crystree.java.project.DTO.ICrystalTicketDTO;
import crystree.java.project.DTO.UserDTO;
import crystree.java.project.Entity.ICrystalEmpEntity;
import crystree.java.project.Entity.ICrystalTicketStatusEntity;
import crystree.java.project.Entity.ICrystalTicketsEntity;
import crystree.java.project.Entity.ICrystalUsersEntity;
import crystree.java.project.Entity.ICrystreeCompanyEntity;
import crystree.java.project.Response.ApiResponse;
import crystree.java.project.Service.EmailService;
import crystree.java.project.Service.ICrystalEmpService;
import crystree.java.project.Service.ICrystalTicketStatusService;
import crystree.java.project.Service.ICrystalTicketsService;
import crystree.java.project.Service.ICrystalUsersService;
import crystree.java.project.Service.ICrystreeCompanyService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/crystree")
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

    @Autowired
    private ICrystreeCompanyService iCrystreeCompanyService;
    @Autowired
    private ICrystalEmpService iCrystalEmpService;
    @Autowired
    private ICrystalUsersService iCrystalUsersService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private ICrystalTicketsService iCrystalTicketsService;
    @Autowired
    private ICrystalTicketStatusService iCrystalTicketStatusService;

    @PostMapping("/company/create")
    public ICrystreeCompanyEntity createCompany(@RequestBody ICrystreeCompanyEntity iCrystreeCompanyEntity) {
        return iCrystreeCompanyService.create(iCrystreeCompanyEntity);
    }

    public String postMethodName(@RequestBody String entity) {
        // TODO: process POST request

        return entity;
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
    public ResponseEntity<ICrystreeCompanyEntity> updateCompany(@PathVariable Long id,
            @RequestBody ICrystreeCompanyEntity companyDetails) {
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
    public ResponseEntity<ICrystalEmpEntity> updateEmployee(@PathVariable Long id,
            @RequestBody ICrystalEmpEntity employeeDetails) {
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
    public ResponseEntity<ICrystalUsersEntity> updateUser(@PathVariable Long id,
            @RequestBody ICrystalUsersEntity userDetails) {
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

    // *****************************************************************************************
    // */

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<UserDTO>> loginUser(
            @RequestParam String username, 
            @RequestParam String password) {
        
        ApiResponse<UserDTO> response = iCrystalUsersService.authenticateUser(username, password);
        
        return ResponseEntity.status(response.getstatus()).body(response);
    }
    // public ResponseEntity<ApiResponse<?>> loginUser(@RequestParam String username, @RequestParam String password) {
    //     ApiResponse<?> response = iCrystalUsersService.authenticateUser(username, password);
    //     return ResponseEntity.status(response.getstatus()).body(response);
    // }

    // @PostMapping("/email")
    // public String emailChecking(@RequestParam String email) {
    // emailService.sendVerificationEmail(email, null, email);
    // return "Done";
    // }

    // @PostMapping("/send-user-id")
    // public ResponseEntity<?> sendUserIdToEmail(@RequestParam String input) {
    // try {
    // String response = iCrystalUsersService.sendUserIdToEmail(input);
    // return ResponseEntity.ok(response);
    // } catch (Exception e) {
    // return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
    // }
    // }
    @PostMapping("/send-user-id")
    public ResponseEntity<Map<String, Object>> sendUserIdToEmail(@RequestParam String input) {
        try {
            String response = iCrystalUsersService.sendUserIdToEmail(input);
            return ResponseEntity.ok(Map.of("success", true, "message", response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("success", false, "message", "Error: " + e.getMessage()));
        }
    }

    @PutMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody Map<String, Object> request) {
        try {
            System.out.println("Received request: " + request); // Log the incoming request

            if (!request.containsKey("userId") || request.get("userId") == null) {
                return ResponseEntity.badRequest().body("User ID is missing.");
            }

            Long userId = Long.parseLong(request.get("userId").toString());
            String newPassword = request.get("newPassword").toString();
            String confirmPassword = request.get("confirmPassword").toString();

            System.out.println("Processing reset password for userId: " + userId);

            String result = iCrystalUsersService.resetPassword(userId, newPassword, confirmPassword);

            System.out.println("Password reset result: " + result);
            return ResponseEntity.ok(result);
        } catch (NumberFormatException e) {
            System.err.println("Invalid userId format: " + e.getMessage());
            return ResponseEntity.badRequest().body("Invalid userId format.");
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
//ticket status 

@PostMapping("/ticket/status/create")
public ICrystalTicketStatusEntity createTicketStatus(@RequestBody ICrystalTicketStatusEntity iCrystalTicketStatusEntity) {
    return iCrystalTicketStatusService.create(iCrystalTicketStatusEntity);
}
@GetMapping("/ticket/status/getall")
public List<ICrystalTicketStatusEntity> getallTicketstatus() {
    return iCrystalTicketStatusService.getAll();
}

    // ticket
    @PostMapping("/ticket/create")
    public ICrystalTicketsEntity createTicket(@RequestBody ICrystalTicketsEntity iCrystalTicketsEntity) {
        return iCrystalTicketsService.create(iCrystalTicketsEntity);
    }

    @GetMapping("/ticket/getall")
    public List<ICrystalTicketsEntity> getallTicket() {
        return iCrystalTicketsService.getAll();
    }

    @GetMapping("/ticket/get/{id}")
    public ResponseEntity<ICrystalTicketsEntity> getByIdTicket(@PathVariable Long id) {
        ICrystalTicketsEntity ticket = iCrystalTicketsService.getById(id);
        return ticket != null ? ResponseEntity.ok(ticket) : ResponseEntity.notFound().build();
    }

    @PutMapping("/ticket/update/{id}")
    public ResponseEntity<ICrystalTicketsEntity> updateTicket(@PathVariable Long id,
            @RequestBody ICrystalTicketsEntity iCrystalTicketsEntity) {
        if (iCrystalTicketsService.getById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(iCrystalTicketsService.update(iCrystalTicketsEntity));
    }

    @DeleteMapping("/ticket/delete/{id}")
    public ResponseEntity<Void> deleteticket(@PathVariable Long id) {
        iCrystalTicketsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/total/count")
    public Long getTotalTickets() {
        return iCrystalTicketsService.getTotalTickets();
    }

    @GetMapping("/count/open")
    public Long getOpenTicketCount() {
        return iCrystalTicketsService.getOpenTicketCount();
    }
    @GetMapping("/count/closed")
    public Long getClosedTicketCount() {
        return iCrystalTicketsService.getClosedTicketCount();
    }

    @GetMapping("/getall")
    public ResponseEntity<List<ICrystalTicketDTO>> getAllTickets() {
        return ResponseEntity.ok(iCrystalTicketsService.getAllTicketsWithStatusNames());
    }
}
