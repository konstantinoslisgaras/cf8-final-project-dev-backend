package solipsismal.olympiacosfcapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import solipsismal.olympiacosfcapp.core.enums.GenderType;
import solipsismal.olympiacosfcapp.core.enums.Role;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User extends AbstractEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 30)
    private String username;
    private String password;

    @Column(nullable = false, length = 30)
    private String firstname;

    @Column(nullable = false, length = 30)
    private String lastname;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private GenderType genderType = GenderType.PREFER_NOT_TO_DISCLOSE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supported_player_id", nullable = false)
    private Player supportedPlayer;

    @Column(name = "favorite_legend", length = 100)
    private String favoriteLegend;

    @Column(name = "is_olympiacos_fan", nullable = false)
    @Builder.Default
    private Boolean isOlympiacosFan = true;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Role role = Role.USER;

    @Column(name = "is_active")
    @ColumnDefault("true")
    @Builder.Default
    private Boolean isActive = true;

    public String getFullName() {
        return (lastname == null) ? firstname : (firstname + " " + lastname.charAt(0) + ".");
    }

    private void deactivateAccount() {
        this.isActive = false;
    }

    private void activateAccount() {
        this.isActive = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
