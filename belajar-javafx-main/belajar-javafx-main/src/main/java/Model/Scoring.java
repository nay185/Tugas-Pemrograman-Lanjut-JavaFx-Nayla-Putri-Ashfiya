package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class untuk data Scoring
 * 
 * @author AERO
 */
public class Scoring {
    private StringProperty namaPeserta;
    private StringProperty deskripsi;
    private StringProperty namaKarya;
    private IntegerProperty score;

    public Scoring() {
        this(null, null, null, 0);
    }

    public Scoring(String namaPeserta, String deskripsi, String namaKarya, int score) {
        this.namaPeserta = new SimpleStringProperty(namaPeserta);
        this.deskripsi = new SimpleStringProperty(deskripsi);
        this.namaKarya = new SimpleStringProperty(namaKarya);
        this.score = new SimpleIntegerProperty(score);
    }

    // Nama Peserta
    public String getNamaPeserta() {
        return namaPeserta.get();
    }

    public void setNamaPeserta(String namaPeserta) {
        this.namaPeserta.set(namaPeserta);
    }

    public StringProperty namaPesertaProperty() {
        return namaPeserta;
    }

    // Deskripsi
    public String getDeskripsi() {
        return deskripsi.get();
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi.set(deskripsi);
    }

    public StringProperty deskripsiProperty() {
        return deskripsi;
    }

    // Nama Karya
    public String getNamaKarya() {
        return namaKarya.get();
    }

    public void setNamaKarya(String namaKarya) {
        this.namaKarya.set(namaKarya);
    }

    public StringProperty namaKaryaProperty() {
        return namaKarya;
    }

    // Score
    public int getScore() {
        return score.get();
    }

    public void setScore(int score) {
        this.score.set(score);
    }

    public IntegerProperty scoreProperty() {
        return score;
    }
}

