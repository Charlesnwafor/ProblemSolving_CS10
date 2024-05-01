public class Team {
    private String mascotName;
    private int score;
    public Team (String name) {

        mascotName = name;
        score = 0;
    }
    public String GetMascotName() {
        return this.mascotName;
    }

    public void Score () {
        this.score = this.score + 2;
    }

    public int getCurrentScore (){
        return this.score;
    }

    public static void main(String[] args) {
        Team Arsenal = new Team("Arsenal");
        Team Chelsea = new Team("Chelsea");

        Arsenal.Score();
        Chelsea.Score();
        Chelsea.Score();

        if (Arsenal.getCurrentScore() < Chelsea.getCurrentScore()) {
            System.out.println(Chelsea.mascotName);
        }

        if (Arsenal.getCurrentScore() > Chelsea.getCurrentScore()) {
            System.out.println(Arsenal.mascotName);
        }

    }
}
