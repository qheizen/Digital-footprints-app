# REPOSITORIES
### CourseRepository
```java
package com.footprints.repositories;
public interface CourseRepository extends CrudRepository<Course, Long>, PagingAndSortingRepository<Course, Long>
```
- **Page<Course> findByDifficultyLevel(Integer difficultyLevel, Pageable pageable)**
- **Optional<Course> findByTitle(String title)** 
- **Page<Course> findByKeywordContainingIgnoreCase(@Param("keyword") String keyword, Pageable pageable)**

### KeywordRepository
```java
package com.footprints.repositories;
public interface KeywordRepository extends CrudRepository<Keyword, Long>, PagingAndSortingRepository<Keyword, Long> 
```

### LectureContentRepository
```java
package com.footprints.repositories;
public interface LectureContentRepository extends CrudRepository<LectureContent, Long> 
```

### LessonRepository
```java
package com.footprints.repositories;
public interface LessonRepository extends CrudRepository<Lesson, Long> 
```
- **List<Lesson> findByCourseId(Long courseId)**
- **Optional<Lesson> findByOrderIndexAndCourseId(Integer orderIndex, Long courseId)**
- **boolean existsByTitle(String title)**

### LessonSectionRepository
```java
package com.footprints.repositories;
public interface LessonSectionRepository extends CrudRepository<LessonSection, Long> 
```
- **List<LessonSection> findByLessonId(Long lessonId)**
- **Optional<LessonSection> findByOrderIndexAndLessonId(Integer orderIndex, Long lessonId)**

### PracticeContentRepository
```java
package com.footprints.repositories;
public interface PracticeContentRepository extends CrudRepository<PracticeContent, Long> 
```
- **List<PracticeContent> findBySectionId(Long sectionId)**
- **Optional<PracticeContent> findByOrderIndexAndSectionId(Integer orderIndex, Long sectionId)** 

### TestContentRepository
```java
package com.footprints.repositories;
public interface TestContentRepository extends CrudRepository<TestContent, Long>
```
- **List<TestContent> findBySectionId(Long sectionId)**

### TestOptionsRepository
```java
package com.footprints.repositories;
public interface TestOptionsRepository extends CrudRepository<TestOptions, Long> 
```

### UserCourseStatusRepository
```java
package com.footprints.repositories;
public interface UserCourseStatusRepository extends CrudRepository<UserCourseStatus, Long>
```
- **Optional<UserCourseStatus> findByUserIdAndCourseId(Long userId, Long courseId)**
- **List<UserCourseStatus> findByUserId(Long userId)**

### UserRepository
```java
package com.footprints.repositories;
public interface UserRepository extends CrudRepository<User, Long>, PagingAndSortingRepository<User, Long> 
```
- **Optional<User> findByUserEmail(String email)**
- **List<User> findByUsername(String username)**
- **boolean existsByUserEmail(String email)** 

### UserRolesRepository
```java
package com.footprints.repositories;
public interface UserRolesRepository extends CrudRepository<UserRoles, Integer> 
```

### UserSectionStatusRepository
```java
package com.footprints.repositories;
public interface UserSectionStatusRepository extends CrudRepository<UserSectionStatus, Integer> 
```
- **Optional<UserSectionStatus> findByUserIdAndSectionId(Long userId, Long sectionId)**
- **List<UserSectionStatus> findByUserId(Long userId)**
- **List<UserSectionStatus> findByUserIdAndIsCompleted(Long userId, Boolean isCompleted)** 

### UserSessionLogsRepository
```java
package com.footprints.repositories;
public interface UserSessionLogsRepository extends CrudRepository<UserSessionLogs, Long>, PagingAndSortingRepository<UserSessionLogs, Long> 
```
- **Page<UserSessionLogs> findByUserId(Long userId, Pageable pageable)**

### UserStatusRepository
```java
package com.footprints.repositories;
public interface UserStatusRepository extends CrudRepository<UserStatus, Long> 
```
- **Optional<UserStatus> findByUserId(Long userId)**