package kr.ac.kopo.leehanseock.springboot_jdbctest.repository;

import kr.ac.kopo.leehanseock.springboot_jdbctest.domain.Detail;
import kr.ac.kopo.leehanseock.springboot_jdbctest.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Detail,Integer> {
}
