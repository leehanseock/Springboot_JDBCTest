package kr.ac.kopo.leehanseock.springboot_jdbctest.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;

@Entity
@Data
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private float weight;
    private float height;
    private float width;

    @OneToOne
    @JoinColumn(name = "product_id")
    @MapsId
    private Product product;
}
