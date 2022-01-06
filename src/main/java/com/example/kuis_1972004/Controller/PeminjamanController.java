package com.example.kuis_1972004.Controller;

import com.example.kuis_1972004.DAO.AnggotaDAO;
import com.example.kuis_1972004.DAO.BukuDAO;
import com.example.kuis_1972004.Model.AnggotaEntity;
import com.example.kuis_1972004.Model.BukuEntity;
import com.example.kuis_1972004.Model.PeminjamanEntity;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class PeminjamanController implements Initializable {
    @FXML
    private TableView<PeminjamanEntity> tableView;
    @FXML
    private TableColumn<PeminjamanEntity,String> col1;
    @FXML
    private TableColumn<PeminjamanEntity,String> col2;
    @FXML
    private TableColumn<PeminjamanEntity,String> col3;
    @FXML
    private TableColumn<PeminjamanEntity,String> col4;
    @FXML
    private TableColumn<PeminjamanEntity,String> col5;
    @FXML
    private TextField txt1;
    @FXML
    private DatePicker date1;
    @FXML
    private DatePicker date2;
    @FXML
    private ComboBox<String> cmb1;
    @FXML
    private ComboBox<AnggotaEntity> cmb2;
    @FXML
    private ComboBox<BukuEntity> cmb3;

    private ObservableList<String> list = FXCollections.observableArrayList();
    private ObservableList<AnggotaEntity> anggotas;
    public ObservableList<AnggotaEntity> getAnggotas(){return anggotas;}
    private ObservableList<BukuEntity> bukus;
    public ObservableList<BukuEntity> getBukus(){return bukus;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list.add("Indonesia");
        list.add("English");
        cmb1.setItems(list);

        AnggotaDAO anggotadao = new AnggotaDAO();
        anggotas=(ObservableList<AnggotaEntity>) anggotadao.showData();
        BukuDAO bukudao = new BukuDAO();
        bukus=(ObservableList<BukuEntity>) bukudao.showData();
        cmb2.setItems(anggotas);
        cmb3.setItems(bukus);

        col1.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getId())));
        col2.setCellValueFactory(data->new SimpleStringProperty(data.getValue().getAnggotaByIdAnggota().getNama()));
        col3.setCellValueFactory(data->new SimpleStringProperty(data.getValue().getBukuByIdBuku().getJudul()));
        col4.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTanggalPinjam())));
        col5.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTanggalPengembalian())));
    }


}
