package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Data storage untuk menyimpan list Scoring
 * 
 * @author AERO
 */
public class ScoringData {
    private ObservableList<Scoring> scoringList;

    public ScoringData() {
        scoringList = FXCollections.observableArrayList();
        // Data sample untuk testing
        initializeSampleData();
    }

    public ObservableList<Scoring> getScoringList() {
        return scoringList;
    }

    public void addScoring(Scoring scoring) {
        scoringList.add(scoring);
    }

    public void removeScoring(Scoring scoring) {
        scoringList.remove(scoring);
    }

    public void updateScoring(int index, Scoring scoring) {
        if (index >= 0 && index < scoringList.size()) {
            scoringList.set(index, scoring);
        }
    }

    private void initializeSampleData() {
        // Data sample untuk testing
        addScoring(new Scoring("Ahmad Fauzi", "Karya seni lukis", "Lukisan Alam", 85));
        addScoring(new Scoring("Siti Nurhaliza", "Karya seni musik", "Lagu Tradisional", 90));
        addScoring(new Scoring("Budi Santoso", "Karya sastra", "Puisi Modern", 78));
        addScoring(new Scoring("Dewi Lestari", "Karya film pendek", "Drama Pendek", 92));
    }
}

