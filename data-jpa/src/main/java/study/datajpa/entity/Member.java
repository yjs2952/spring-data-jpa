package study.datajpa.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String username;

    // 기본 생성자가 반드시 있어야 하고 private 으로 설정하면 안된다.
    // 프록시 객체 생성시 문제가 생길 수 있다.
    protected Member() {
    }

    public Member(String username) {
        this.username = username;
    }

}
