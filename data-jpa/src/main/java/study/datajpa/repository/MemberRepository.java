package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import study.datajpa.entity.Member;

import java.util.List;

/**
 * 구현체는 스프링 데이터 JPA 가 프록시를 이용하여 만들어서 주입해준다
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

//    @Query(name="Member.findByUsername")
    List<Member> findByUsername(@Param("username") String username);
}
