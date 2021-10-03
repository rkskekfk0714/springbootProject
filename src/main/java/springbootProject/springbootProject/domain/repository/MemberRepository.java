package springbootProject.springbootProject.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootProject.springbootProject.domain.entity.Member;


public interface MemberRepository extends JpaRepository<Member, Long> {

}
