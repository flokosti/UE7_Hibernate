import javax.persistence.*;

@Entity
@Table(name = "Trainer")
public class Trainer implements ISaveAndDelete {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trainerId")
    int trainerId;

    @Column(name = "name")
    String name;

    @OneToOne
    Team team;

    public Trainer() {
    }

    public Trainer(String name, Team team) {
        this.name = name;
        this.team = team;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public boolean saveToDB() {

        if(!HibernateSupport.commit(this)){
            return false;
        }
        return true;
    }

    @Override
    public void deleteFromDB() {
        HibernateSupport.deleteObject(this);
    }
}
