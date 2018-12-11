package base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="people"
    ,catalog="library"
)
public class People implements java.io.Serializable {

	private Integer idMine;
     private String name;
     private String lastName;

    public People() {
    }

    public People(String name, String lastName) {
       this.name = name;
       this.lastName = lastName;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    @Column(name="idMine", unique=true, nullable=false)
    public Integer getIdMine() {
        return this.idMine;
    }
    
    public void setIdMine(Integer idMine) {
        this.idMine = idMine;
    }

    @Column(name="name", length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Column(name="last_name", length=45)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }




}


