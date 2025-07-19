package com.footprints.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("test_options")
public class TestOptions {

    @Id
    @Column("id")
    private Long id;

    @Column("answer")
    private String answer;

}
