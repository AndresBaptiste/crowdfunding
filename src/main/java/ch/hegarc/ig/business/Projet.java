package ch.hegarc.ig.business;

import java.util.ArrayList;
import java.util.List;

public class Projet {

    private long id;
    private String name;
    private List<Donateur> donateurs = new ArrayList<Donateur>();

    public Projet() {
    }

    /**
     * @param donateurs
     * @param name
     * @param id
     */
    public Projet(long id, String name, List<Donateur> donateurs) {
        super();
        this.id = id;
        this.name = name;
        this.donateurs = donateurs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Donateur> getDonateurs() {
        return donateurs;
    }

    public void setDonateurs(List<Donateur> donateurs) {
        this.donateurs = donateurs;
    }

}