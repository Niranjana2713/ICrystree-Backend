package crystree.java.project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crystree.java.project.Entity.ICrystalUsersEntity;
import crystree.java.project.Repository.ICrystalUsersRepository;
import crystree.java.project.Response.ApiResponse;

@Service
public class ICrystalUsersService {
    @Autowired
    private ICrystalUsersRepository iCrystalUsersRepository;

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


    public ApiResponse<?> authenticateUser(String username, String password) {
        Optional<ICrystalUsersEntity> userOpt = iCrystalUsersRepository.findByIcrystalUserName(username);

        if (userOpt.isPresent()) {
            ICrystalUsersEntity user = userOpt.get();

            if (password.equals(user.getIcrystal_user_password())) {
                return new ApiResponse<>(true, "Credentials are correct!", 200, null);
            } else {
                return new ApiResponse<>(false, "Invalid password!", 401, null);
            }
        }
        return new ApiResponse<>(false, "User not found!", 404, null);
    }
}
