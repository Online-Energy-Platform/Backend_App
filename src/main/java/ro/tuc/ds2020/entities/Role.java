package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "position", nullable = false)
    private String position;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL) //fetch = FetchType.EAGER nu lasa entitatea sa se stearga -> ce am gasit e ca dupa ce se sterge, EAGER face sa se persiste la loc.
    private Set<User> userSet;

    public Role(){

    }

    public Role(String position) {
        this.position = position;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
