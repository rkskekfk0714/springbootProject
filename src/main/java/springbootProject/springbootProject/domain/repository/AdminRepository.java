package springbootProject.springbootProject.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootProject.springbootProject.domain.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>  {
}
