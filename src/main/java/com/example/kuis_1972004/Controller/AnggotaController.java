package com.example.kuis_1972004.Controller;

import com.example.kuis_1972004.DAO.AnggotaDAO;
import com.example.kuis_1972004.Model.AnggotaEntity;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class AnggotaController implements Initializable {
    @FXML
    private TableView<AnggotaEntity> tableView;
    @FXML
    private TableColumn<AnggotaEntity,String> col1;
    @FXML
    private TableColumn<AnggotaEntity,String> col2;
    @FXML
    private TableColumn<AnggotaEntity,String> col3;
    @FXML
    private TableColumn<AnggotaEntity,String> col4;
    @FXML
    private TableColumn<AnggotaEntity,String> col5;
    @FXML
    private TextField txt1;
    @FXML
    private TextField txt2;
    @FXML
    private TextField txt3;
    @FXML
    private DatePicker date1;
    @FXML
    private DatePicker date2;

    private PeminjamanController pc;
    private boolean isError ;

    public void saveAction(ActionEvent actionEvent) {
        AnggotaEntity anggota = new AnggotaEntity();
        if (txt1.getText().trim().isEmpty() || txt2.getText().isEmpty() || txt3.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please Fill Id/Nama/NoTelp");
            a.showAndWait();
        }else if (pc.getAnggotas().size()!=0){
            for (int i=0; i <pc.getAnggotas().size();i++){
                if (Integer.parseInt(txt1.getText()) == pc.getAnggotas().get(i).getId()){
                    Alert a =new Alert(Alert.AlertType.ERROR);
                    isError = true;
                    a.setContentText("Duplicate Anggota Name");
                    a.showAndWait();
                    break;
                } else {
                    anggota.setId(Integer.valueOf(txt1.getText()));
                    anggota.setNama(txt2.getText());
                    anggota.setNotelp(txt3.getText());
                    anggota.setTglLahir(Date.valueOf(date1.getValue()));
                    anggota.setTglMasuk(Date.valueOf(date2.getValue()));
                    AnggotaDAO anggotadao = new AnggotaDAO();
                    anggotadao.addData(anggota);
                    pc.getAnggotas().clear();
                    pc.getAnggotas().addAll(anggotadao.showData());
                    tableView.refresh();
                    break;
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col1.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getId())));
        col2.setCellValueFactory(data->new SimpleStringProperty(data.getValue().getNama()));
        col3.setCellValueFactory(data->new SimpleStringProperty(data.getValue().getNotelp()));
        col4.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTglLahir())));
        col5.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTglMasuk())));
    }

    public void setController(PeminjamanController pc){
        tableView.setItems(pc.getAnggotas());
        this.pc =pc;
    }
}
