package mihajlo.rac.demo.repository;

import mihajlo.rac.demo.model.Monument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentRepository extends JpaRepository<Monument,Long>{
}
