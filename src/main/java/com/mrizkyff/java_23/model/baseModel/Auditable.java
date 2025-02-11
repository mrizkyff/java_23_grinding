package com.mrizkyff.java_23.model.baseModel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

@MappedSuperclass
@Setter
@Getter
@SuperBuilder
@EntityListeners( {AuditingEntityListener.class} )
public abstract class Auditable {
    public Auditable() {
    }

    public Auditable(UUID id  , UUID createdBy , Instant createdDate , UUID lastModifiedBy , Instant lastModifiedDate) {
        this.id = id;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID id;

    @CreatedBy
    @Column ( name = "created_by", nullable = false )
    private UUID createdBy;

    @CreatedDate
    @Column ( name = "created_date" )
    private Instant createdDate;

    @LastModifiedBy
    @Column ( name = "last_modified_by" )
    private UUID lastModifiedBy;

    @LastModifiedDate
    @Column ( name = "last_modified_date" )
    private Instant lastModifiedDate;

}