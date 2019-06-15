public class Trainer {

    int trainerId;
    String name;
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
}
