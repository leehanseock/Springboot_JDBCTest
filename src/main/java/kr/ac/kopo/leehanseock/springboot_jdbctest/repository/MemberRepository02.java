package kr.ac.kopo.leehanseock.springboot_jdbctest.repository;

import kr.ac.kopo.leehanseock.springboot_jdbctest.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository02 extends JpaRepository<Member, Integer> {

}
