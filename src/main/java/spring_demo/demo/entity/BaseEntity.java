package spring_demo.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass // 부모 클래스로만 사용하고, 테이블로 생성되지 않음
public class BaseEntity {

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createDataTime;

    @CreationTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedTime;

    // getter, setter, equals, hashCode 메소드 생략
}
