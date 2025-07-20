package com.footprints.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("keywords")
public class Keyword {

    @Id
    @Column("id")
    private Long id;

    @Column("keyword")
    private String keyWord;

    @CreatedDate
    @Column("created_at")
    private LocalDateTime createdAt;
}
