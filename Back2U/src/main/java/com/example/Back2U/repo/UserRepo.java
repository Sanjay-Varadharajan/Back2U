    package com.example.Back2U.repo;

    import com.example.Back2U.model.User;
    import org.springframework.data.jpa.repository.JpaRepository;

    import java.util.Optional;

    public interface UserRepo extends JpaRepository<User, Integer> {
        Optional<User> findByUserMail(String userMail);

        void deleteByUserMail(String userMail);

    }
