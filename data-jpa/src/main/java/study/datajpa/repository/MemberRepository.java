package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    // 이게 없으면 singleResult 나 resultList 를 호출한다.
    @Modifying(clearAutomatically = true )  // clearAutomatically : 벌크 연산 이후 영속성 컨텍스트를 clear 해준다.
    @Query("update Member m set m.age = m.age + 1 where m.age >= :age")
    int bulkAgePlus(@Param("age") int age);
}
