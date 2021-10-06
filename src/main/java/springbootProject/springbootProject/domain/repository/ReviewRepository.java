package springbootProject.springbootProject.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootProject.springbootProject.domain.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
