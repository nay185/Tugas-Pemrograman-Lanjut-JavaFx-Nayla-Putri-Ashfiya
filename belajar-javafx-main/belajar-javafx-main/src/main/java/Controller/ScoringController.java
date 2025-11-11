package Controller;

import Model.Scoring;
import Model.ScoringData;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller untuk Scoring Management
 * 
 * @author AERO
 */
public class ScoringController implements Initializable {

    @FXML
    private TextField namaPesertaInput;

    @FXML
    private TextField deskripsiInput;

    @FXML
    private TextField namaKaryaInput;

    @FXML
    private TextField scoreInput;

    @FXML
    private TableView<Scoring> data;

    @FXML
    private TableColumn<Scoring, String> colNamaPeserta;

    @FXML
    private TableColumn<Scoring, String> colDeskripsi;

    @FXML
    private TableColumn<Scoring, String> colNamaKarya;

    @FXML
    private TableColumn<Scoring, Integer> colScore;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonEdit;

    @FXML
    private Button buttonDelete;

    private ScoringData scoringData;
    private ObservableList<Scoring> scoringList;
    private int selectedIndex = -1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inisialisasi data
        scoringData = new ScoringData();
        scoringList = scoringData.getScoringList();

        // Setup table columns
        colNamaPeserta.setCellValueFactory(new PropertyValueFactory<>("namaPeserta"));
        colDeskripsi.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));
        colNamaKarya.setCellValueFactory(new PropertyValueFactory<>("namaKarya"));
        colScore.setCellValueFactory(new PropertyValueFactory<>("score"));

        // Bind data ke table
        data.setItems(scoringList);

        // Listener untuk selection change
        data.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedIndex = data.getSelectionModel().getSelectedIndex();
                loadSelectedData(newSelection);
            }
        });
    }

    @FXML
    private void buttonAdd() {
        if (validateInput()) {
            try {
                String namaPeserta = namaPesertaInput.getText().trim();
                String deskripsi = deskripsiInput.getText().trim();
                String namaKarya = namaKaryaInput.getText().trim();
                int score = Integer.parseInt(scoreInput.getText().trim());

                Scoring newScoring = new Scoring(namaPeserta, deskripsi, namaKarya, score);
                scoringData.addScoring(newScoring);

                clearFields();
                showAlert(Alert.AlertType.INFORMATION, "Success", "Data berhasil ditambahkan!");
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Error", "Score harus berupa angka!");
            }
        }
    }

    @FXML
    private void buttonEdit() {
        if (selectedIndex < 0) {
            showAlert(Alert.AlertType.WARNING, "Warning", "Pilih data yang ingin diedit terlebih dahulu!");
            return;
        }

        if (validateInput()) {
            try {
                String namaPeserta = namaPesertaInput.getText().trim();
                String deskripsi = deskripsiInput.getText().trim();
                String namaKarya = namaKaryaInput.getText().trim();
                int score = Integer.parseInt(scoreInput.getText().trim());

                Scoring updatedScoring = new Scoring(namaPeserta, deskripsi, namaKarya, score);
                scoringData.updateScoring(selectedIndex, updatedScoring);

                clearFields();
                selectedIndex = -1;
                data.getSelectionModel().clearSelection();
                showAlert(Alert.AlertType.INFORMATION, "Success", "Data berhasil diubah!");
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Error", "Score harus berupa angka!");
            }
        }
    }

    @FXML
    private void buttonDelete() {
        if (selectedIndex < 0) {
            showAlert(Alert.AlertType.WARNING, "Warning", "Pilih data yang ingin dihapus terlebih dahulu!");
            return;
        }

        Scoring selectedScoring = data.getSelectionModel().getSelectedItem();
        if (selectedScoring != null) {
            scoringData.removeScoring(selectedScoring);
            clearFields();
            selectedIndex = -1;
            data.getSelectionModel().clearSelection();
            showAlert(Alert.AlertType.INFORMATION, "Success", "Data berhasil dihapus!");
        }
    }

    private void loadSelectedData(Scoring scoring) {
        namaPesertaInput.setText(scoring.getNamaPeserta());
        deskripsiInput.setText(scoring.getDeskripsi());
        namaKaryaInput.setText(scoring.getNamaKarya());
        scoreInput.setText(String.valueOf(scoring.getScore()));
    }

    private void clearFields() {
        namaPesertaInput.clear();
        deskripsiInput.clear();
        namaKaryaInput.clear();
        scoreInput.clear();
    }

    private boolean validateInput() {
        if (namaPesertaInput.getText().trim().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Nama Peserta tidak boleh kosong!");
            return false;
        }

        if (deskripsiInput.getText().trim().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Deskripsi tidak boleh kosong!");
            return false;
        }

        if (namaKaryaInput.getText().trim().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Nama Karya tidak boleh kosong!");
            return false;
        }

        if (scoreInput.getText().trim().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Score tidak boleh kosong!");
            return false;
        }

        try {
            int score = Integer.parseInt(scoreInput.getText().trim());
            if (score < 0 || score > 100) {
                showAlert(Alert.AlertType.WARNING, "Validation Error", "Score harus antara 0-100!");
                return false;
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Score harus berupa angka!");
            return false;
        }

        return true;
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

