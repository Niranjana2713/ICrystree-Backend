package crystree.java.project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import crystree.java.project.Entity.ICrystalUsersEntity;

@Repository
public interface ICrystalUsersRepository extends JpaRepository<ICrystalUsersEntity,Long>{

     @Query("SELECT u FROM ICrystalUsersEntity u WHERE u.icrystal_user_name = :username")
    Optional<ICrystalUsersEntity> findByIcrystalUserName(@Param("username") String username);
} 