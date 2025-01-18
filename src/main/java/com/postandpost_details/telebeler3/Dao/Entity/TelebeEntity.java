package com.postandpost_details.telebeler3.Dao.Entity;

import com.postandpost_details.telebeler3.Model.Enum.TelebeStatus;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of="id")
@Entity
@Table(name="telebeler3")
public class TelebeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private TelebeStatus status;
}
