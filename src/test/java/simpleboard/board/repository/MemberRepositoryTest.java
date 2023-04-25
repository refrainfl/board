package simpleboard.board.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import simpleboard.board.domain.Member;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;


    @Test
    @Transactional
    @Rollback
    public void testMember() {
        Member member1 = new Member();
        member1.setName("memberA");
        Long savedId1 = memberRepository.save(member1);
        Member findMember1 = memberRepository.find(savedId1);

        Member member2 = new Member();
        member2.setName("memberB");
        Long savedId2 = memberRepository.save(member2);
        Member findMember2 = memberRepository.find(savedId2);

        assertThat(findMember1.getId()).isEqualTo(member1.getId());
        assertThat(findMember1).isNotSameAs(findMember2);


    }


}