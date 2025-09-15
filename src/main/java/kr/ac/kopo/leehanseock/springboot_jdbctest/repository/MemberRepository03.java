package kr.ac.kopo.leehanseock.springboot_jdbctest.repository;

import jakarta.transaction.Transactional;
import kr.ac.kopo.leehanseock.springboot_jdbctest.domain.Member;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MemberRepository03 extends JpaRepository<Member, Integer> {
    @Transactional
    @Query(value = "SELECT entity FROM Member entity")
    public List<Member> selectMethod();

    @Transactional
    @Query(value = "SELECT entity FROM Member entity WHERE id = :e_id")
    public Member selectMethodById(@Param("e_id") int id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Member (name, age, email) VALUES (:e_name, :e_age, :e_email)")
    public int insertMethod(@Param("e_name") String name, @Param("e_age") int age, @Param("e_email") String email);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Member SET name=:e_name, age=:e_age, email=:e_email WHERE id = :e_id")
    public int updateMethod(@Param("e_name") String name, @Param("e_age") int age, @Param("e_email") String email, @Param("e_id") int id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Member WHERE id = :e_id")
    public int deleteMethod(@Param("e_id") int id);
}