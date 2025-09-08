package kr.ac.kopo.leehanseock.springboot_jdbctest.repository;

import jakarta.transaction.Transactional;
import kr.ac.kopo.leehanseock.springboot_jdbctest.domain.Member;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MemberRepository03 extends JpaRepository<Member, Integer> {
    @Transactional
    @Query(value = "SELECT entity FROM Member entity")
    public List<Member> selectMethod();
}
