package mihajlo.rac.demo.repository;

import mihajlo.rac.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
