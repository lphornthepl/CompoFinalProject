package compofinalproject.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import compofinalproject.demo.config.json.View;
import compofinalproject.demo.entity.security.Authority;
import compofinalproject.demo.entity.security.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@JsonIgnoreType
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @JsonView(View.Login.class)
    String studentId;
    @JsonView(View.Login.class)
    String name;
    @JsonView(View.Login.class)
    String surname;
    double gpa;
    @JsonView(View.Login.class)
    String image;
    boolean feature;
    int penAmount;
    String description;

    @OneToOne(mappedBy = "visitor")
    @JsonManagedReference
    User user;

    @JsonView(View.Login.class)
    public List<Authority> getAuthorities(){
        return user.getAuthorities();
    }

}
