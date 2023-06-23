package com.cement.CodysseyBackend.domain.board.project.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "project")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id", updatable = false)
    private Long projectId;

    @Column(name = "writer_id", nullable = false)
    private Long writerId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "save_count", nullable = false)
    private Long saveCount;

    @Column(name = "front_num", nullable = false)
    private int frontNum;

    @Column(name = "back_num", nullable = false)
    private int backNum;

    @Column(name = "design_num", nullable = false)
    private int designNum;

    @Column(name = "isClosed", nullable = false)
    private boolean isClosed;

    @Column(name = "createAt", nullable = false)
    @CreationTimestamp
    private Timestamp createAt;

    @Column(name = "updateAt", nullable = false)
    @UpdateTimestamp
    private Timestamp updateAt;

    @Column(name = "isDeleted", nullable = false)
    private boolean isDeleted;

    @Builder
    public Project(
                   Long writerId,
                   String title,
                   String content,
                   int frontNum,
                   int backNum,
                   int designNum
                   ) {

        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.saveCount = 0L;
        this.frontNum = frontNum;
        this.backNum = backNum;
        this.designNum = designNum;
        this.isClosed = false;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.isDeleted = false;
    }
}
