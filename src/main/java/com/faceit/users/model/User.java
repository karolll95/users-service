package com.faceit.users.model;

import com.neovisionaries.i18n.CountryCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @NonNull
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private final UUID id = UUID.randomUUID();

    @NonNull
    @Column(updatable = false, nullable = false)
    private final LocalDateTime createdAt = LocalDateTime.now();

    @NonNull
    @Column(nullable = false)
    private LocalDateTime updatedAt = createdAt;

    @NonNull
    @Column(nullable = false)
    private String firstName;

    @NonNull
    @Column(nullable = false)
    private String lastName;

    @NonNull
    @Column(nullable = false)
    private String nickName;

    @NonNull
    @Column(nullable = false)
    private String password;

    @NonNull
    //@Email //TODO
    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @NonNull
    @Column(nullable = false)
    private CountryCode country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
