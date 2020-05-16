package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.datajpa.dto.MemberDto;
import study.datajpa.entity.Member;

import java.util.List;

/**
 * 구현체는 스프링 데이터 JPA 가 프록시를 이용하여 만들어서 주입해준다
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

//    @Query(name="Member.findByUsername")
    List<Member> findByUsername(@Param("username") String username);

    @Query("select m.username from Member m")
    List<String> findUserNameList();

    @Query("select new study.datajpa.dto.MemberDto(m. id, m.username, t.name) from Member m join m.team t")
    List<MemberDto> findMemberDto();
}
