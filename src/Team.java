
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Team")
public class Team implements ISaveAndDelete{


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teamId")
    int teamId;

    @Column(name = "name")
    String name;

    @OneToMany
    List <Player> playerList = new ArrayList<Player>();

    @OneToOne
    Trainer trainer;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public int getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void addPlayer (Player player){
        playerList.add(player);
    }

    @Override
    public boolean saveToDB() {
        if(this.playerList!=null)
            for(Player p : this.playerList)
                p.saveToDB();
        if(!HibernateSupport.commit(this))
            return false;
        return true;
    }

    @Override
    public void deleteFromDB() {
        if(this.playerList!=null)
            for(Player p:this.playerList)
                p.deleteFromDB();
            HibernateSupport.deleteObject(this);
    }
}
