import javax.persistence.*;

@Entity
@Table(name = "Player")
public class Player implements ISaveAndDelete{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "playerId")
    int playerId;

    @Column(name = "name")
    String name;

    @Column(name = "age")
    int age;

    @ManyToOne
    Team team;


    public Player() {
    }

    public Player(String name, int age, Team team) {
        this.name = name;
        this.age = age;
        this.team = team;
    }


    public int getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
