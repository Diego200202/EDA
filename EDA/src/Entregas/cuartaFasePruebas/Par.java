package Entregas.cuartaFasePruebas;

public class Par {
    String actor;
    double pageRank;

    public Par(String actor, double pr) {
        this.actor = actor;
        this.pageRank = pr;
    }

    public String getActor() {
        return this.actor;
    }

    public double getPr() {
        return this.pageRank;
    }
}
