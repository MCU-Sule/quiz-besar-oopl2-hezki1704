package com.example.kuis_1972004.Controller;

import com.example.kuis_1972004.DAO.AnggotaDAO;
import com.example.kuis_1972004.DAO.BukuDAO;
import com.example.kuis_1972004.Model.AnggotaEntity;
import com.example.kuis_1972004.Model.BukuEntity;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class BukuController implements Initializable {
    @FXML
    private TableView<BukuEntity> tableView;
    @FXML
    private TableColumn<BukuEntity,String> col1;
    @FXML
    private TableColumn<BukuEntity,String> col2;
    @FXML
    private TableColumn<BukuEntity,String> col3;
    @FXML
    private TableColumn<BukuEntity,String> col4;
    @FXML
    private TableColumn<BukuEntity,String> col5;
    @FXML
    private TableColumn<BukuEntity,String> col6;
    @FXML
    private TextField txt1;
    @FXML
    private TextField txt2;
    @FXML
    private TextField txt3;
    @FXML
    private TextField txt4;
    @FXML
    private TextField txt5;
    @FXML
    private TextField txt6;

    private PeminjamanController pc;
    private boolean isError ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col1.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getId())));
        col2.setCellValueFactory(data->new SimpleStringProperty(data.getValue().getJudul()));
        col3.setCellValueFactory(data->new SimpleStringProperty(data.getValue().getPenerbit()));
        col4.setCellValueFactory(data->new SimpleStringProperty(data.getValue().getTahunTerbit()));
        col5.setCellValueFactory(data->new SimpleStringProperty(data.getValue().getPengarang()));
        col6.setCellValueFactory(data->new SimpleStringProperty(data.getValue().getJenisBuku()));
    }

    public void saveAction(ActionEvent actionEvent) {
        BukuEntity buku = new BukuEntity();
        if (txt1.getText().trim().isEmpty() || txt2.getText().isEmpty() || txt3.getText().isEmpty() || txt4.getText().isEmpty() || txt5.getText().isEmpty() || txt6.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please Fill All Fields");
            a.showAndWait();
        }else if (pc.getBukus().size()!=0){
            for (int i=0; i <pc.getBukus().size();i++){
                if (Integer.parseInt(txt1.getText()) == pc.getBukus().get(i).getId()){
                    Alert a =new Alert(Alert.AlertType.ERROR);
                    isError = true;
                    a.setContentText("Duplicate Buku Name");
                    a.showAndWait();
                    break;
                } else {
                    buku.setId(Integer.valueOf(txt1.getText()));
                    buku.setJudul(txt2.getText());
                    buku.setPenerbit(txt3.getText());
                    buku.setTahunTerbit(txt4.getText());
                    buku.setPengarang(txt5.getText());
                    buku.setJenisBuku(txt6.getText());
                    BukuDAO bukudao = new BukuDAO();
                    bukudao.addData(buku);
                    pc.getBukus().clear();
                    pc.getBukus().addAll(bukudao.showData());
                    tableView.refresh();
                    break;
                }
            }
        }
    }

    public void setController(PeminjamanController pc){
        tableView.setItems(pc.getBukus());
        this.pc =pc;
    }
}
