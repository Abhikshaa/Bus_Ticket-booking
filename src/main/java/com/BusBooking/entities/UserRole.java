package com.BusBooking.entities;



import com.BusBooking.utils.UserRoleId;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
@Table(name = "user_roles")
@NoArgsConstructor
public class UserRole implements Serializable {

    @EmbeddedId
    private UserRoleId id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;
}
