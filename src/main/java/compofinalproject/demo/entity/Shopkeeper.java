package compofinalproject.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = false)
@Builder
public class Shopkeeper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;


    int ShopkeeperId;

    String ShopkeeperName;

    String ShopkeeperSurname;

    String username;

    String password;

    String moreInformation;
}
