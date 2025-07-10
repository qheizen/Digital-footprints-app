package com.footprints.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("user_session_logs")
public class UserCourseStatus {

    @Id
    @Column("ucs_id")
    private Long id;

    @Column("ucs_user_id")
    private Long userId;

    @Column("ucs_course_id")
    private Long courseId;

    @Column("ucs_completion_percentage")
    private Integer completionPercentage;

    @Column("ucs_correctness_percentage")
    private Integer correctnessPercentage;

    @Version
    @Column("c_version")
    private Integer version;

}