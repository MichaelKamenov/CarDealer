package bg.softuni.cardealer.model.entity;

import bg.softuni.cardealer.model.enums.UserRoleEnum;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "roles")
public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }
}
