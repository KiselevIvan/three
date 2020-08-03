package sample;
import com.sun.javafx.scene.control.IntegerField;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

public class Controller {
    @FXML
    private TableView table1;

    public void setData(){
        Integer[][] arr= new Integer[5][5];

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                arr[i][j]=ThreadLocalRandom.current().nextInt(-50, 50 + 1);
            }
        }
        ObservableList<Integer[]> observableList = FXCollections.observableArrayList();
        observableList.addAll(Arrays.asList(arr));

        table1.getColumns().clear();
        for (int i = 0; i < arr[0].length; i++) {
            int columnNumber = i;
            TableColumn tableColumn = new TableColumn("C"+String.valueOf(columnNumber+1));


            tableColumn.setCellValueFactory(
                    new Callback<TableColumn.CellDataFeatures<Integer[], Integer>,
                            ObservableValue<String>>()
                    {
                        @Override
                        public ObservableValue<String> call( TableColumn.CellDataFeatures<Integer[],
                                Integer> p )
                        {
                            return new ReadOnlyStringWrapper(
                                    String.valueOf(p.getValue()[columnNumber])
                            );
                        }
                    } );

            table1.getColumns().add(tableColumn);
        }
        table1.setItems(observableList);
    }

}

