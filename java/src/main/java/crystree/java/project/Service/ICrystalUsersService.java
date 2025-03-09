package crystree.java.project.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import crystree.java.project.DTO.UserDTO;
import crystree.java.project.Entity.ICrystalUsersEntity;
import crystree.java.project.Repository.ICrystalUsersRepository;
import crystree.java.project.Response.ApiResponse;



@Service
public class ICrystalUsersService {
    @Autowired
    private ICrystalUsersRepository iCrystalUsersRepository;
    @Autowired
    private EmailService emailService;

      public ICrystalUsersEntity create(ICrystalUsersEntity user) {
        return iCrystalUsersRepository.save(user);
    }

    public List<ICrystalUsersEntity> getAll() {
        return iCrystalUsersRepository.findAll();
    }

    public ICrystalUsersEntity getById(Long id) {
        return iCrystalUsersRepository.findById(id).orElse(null);
    }

    public ICrystalUsersEntity update(ICrystalUsersEntity user) {
        return iCrystalUsersRepository.save(user);
    }

    public void deleteById(Long id) {
        iCrystalUsersRepository.deleteById(id);
    }


    // public ApiResponse<?> authenticateUser(String username, String password) {
    //     Optional<ICrystalUsersEntity> userOpt = iCrystalUsersRepository.findByIcrystalUserName(username);

    //     if (userOpt.isPresent()) {
    //         ICrystalUsersEntity user = userOpt.get();

    //         if (password.equals(user.getIcrystal_user_password())) {
    //             return new ApiResponse<>(true, "Credentials are correct!", 200, null);
    //         } else {
    //             return new ApiResponse<>(false, "Invalid password!", 401, null);
    //         }
    //     }
    //     return new ApiResponse<>(false, "User not found!", 404, null);
    // }

    public ApiResponse<UserDTO> authenticateUser(String username, String password) {
        Optional<ICrystalUsersEntity> userOpt = iCrystalUsersRepository.findByIcrystalUserName(username);
    
        if (userOpt.isPresent()) {
            ICrystalUsersEntity user = userOpt.get();
    
            if (password.equals(user.getIcrystal_user_password())) {
                // ✅ Return user details including userId
                UserDTO userData = new UserDTO(user.getIcrystal_user_id(), user.getIcrystal_user_name());
                return new ApiResponse<>(true, "Credentials are correct!", 200, userData);
            } else {
                return new ApiResponse<>(false, "Invalid password!", 401, null);
            }
        }
        return new ApiResponse<>(false, "User not found!", 404, null);
    }
    


   
    public String sendUserIdToEmail(String input) {
        List<ICrystalUsersEntity> users;

        // Check if input is a phone number (only digits)
        if (input.matches("\\d+")) {
            users = iCrystalUsersRepository.findByPhone(Long.parseLong(input));
        } else {
            users = iCrystalUsersRepository.findByEmailOrUsername(input);
        }

        if (users.isEmpty()) {
            return "User not found.";
        }

        if (users.size() > 1) {
            return "Multiple users found with this input. Please contact support.";
        }

        // Single user found, send email
        ICrystalUsersEntity user = users.get(0);
        emailService.sendUserIdByEmail(user.getIcrystal_user_email_id(), user.getIcrystal_user_id());

        return "User ID has been sent to your registered email.";
    }
    
    
    public String resetPassword(Long userId, String newPassword, String confirmPassword) {
        if (!newPassword.equals(confirmPassword)) {
            return "Passwords do not match.";
        }

        ICrystalUsersEntity user = iCrystalUsersRepository.findById(userId)
                .orElse(null);

        if (user == null) {
            System.out.println("User not found with ID: " + userId);
            return "User not found.";
        }

        // Update last password change date with the current timestamp
        user.setLast_pwd_chng_dt(LocalDateTime.now());

        // Save the new password without encryption
        user.setIcrystal_user_password(newPassword);

        iCrystalUsersRepository.save(user);
        System.out.println("Password updated successfully for userId: " + userId);

        return "Password has been successfully reset.";
    }
}
