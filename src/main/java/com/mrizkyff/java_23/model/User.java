package com.mrizkyff.java_23.model;

import com.mrizkyff.java_23.model.baseModel.Auditable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity(name = "tbl_users")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners({AuditingEntityListener.class})
@AttributeOverrides({
        @AttributeOverride(name = "createdDate", column = @Column(name = "created_date", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)),
        @AttributeOverride(name = "lastModifiedDate", column = @Column(name = "last_modified_date", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)),
        @AttributeOverride(name = "createdBy", column = @Column(name = "created_by", nullable = false)),
        @AttributeOverride(name = "lastModifiedBy", column = @Column(name = "last_modified_by", nullable = false))
})
public class User extends Auditable implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, name = "full_name")
    private String fullName;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @PrePersist
    public void prePersist() {
        this.setCreatedBy(UUID.fromString("00000000-0000-0000-0000-000000000000"));
        this.setLastModifiedBy(UUID.fromString("00000000-0000-0000-0000-000000000000"));
        this.setCreatedDate(Instant.now());
        this.setLastModifiedDate(Instant.now());
    }

    @PreUpdate
    public void preUpdate() {
        this.setLastModifiedBy(UUID.fromString("00000000-0000-0000-0000-000000000000"));
        this.setLastModifiedDate(Instant.now());
    }
}