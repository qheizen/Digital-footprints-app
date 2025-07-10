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
@Table("user_roles")
public class UserRoles {

    @Id
    @Column("r_id")
    private Long id;

    @Column("r_name")
    private String name;

    @Column("r_permissions")
    private Byte[] permissions;

}
