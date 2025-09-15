package kr.ac.kopo.leehanseock.springboot_jdbctest.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import kr.ac.kopo.leehanseock.springboot_jdbctest.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//EntityManager를 사용할 때는 JpaRepository를 상속받지 않고 직접 구현해야 한다.
//@PersistenceContext 어노테이션을 사용하여 EntityManager를 참조값을 주입 받는다.

@Repository
public class MemberRepository04 {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Member> selectMethod(){
        String jpql = "SELECT entity FROM Member entity";
        Query query = entityManager.createQuery(jpql);
        List<Member> memberList = query.getResultList();
        return memberList;
    }

    @Transactional
    public void insertMethod(Member member){
        String jpql = "INSERT INTO Member (name, age, email) VALUES (:e_name, :e_age, :e_email)";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("e_name", member.getName());
        query.setParameter("e_age", member.getAge());
        query.setParameter("e_email", member.getEmail());
        query.executeUpdate();
    }

    public Member selectMethodById(int id){
        String jpql = "SELECT entity FROM Member entity WHERE id = :e_id";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("e_id", id);
        Member member = (Member) query.getSingleResult();
        return member;
    }

    @Transactional
    public void updateMethod(Member member){
        String jpql = "UPDATE Member SET name=:e_name, age=:e_age, email=:e_email WHERE id = :e_id";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("e_name", member.getName());
        query.setParameter("e_age", member.getAge());
        query.setParameter("e_email", member.getEmail());
        query.setParameter("e_id", member.getId());
        query.executeUpdate();
    }

    @Transactional
    public void deleteMethod(int id){
        String jpql = "DELETE FROM Member WHERE id = :e_id";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("e_id", id);
        query.executeUpdate();
    }
}
