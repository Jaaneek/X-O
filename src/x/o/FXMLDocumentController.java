/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x.o;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.xml.transform.Source;

/**
 *
 * @author miljan003
 */
public class FXMLDocumentController implements Initializable {
    
    private boolean playerChange;
    StateOfBox boxY;
    StateOfBox boxX;
    String[] arrayX;
    String[] arrayY;
    Contain containX;
    Contain containY;
    private boolean result;
    private int i;
    private int j;
    int countOfMoves;
    @FXML
    private Button resultX;



    //String[] winComb;  
     public FXMLDocumentController(){
        this.boxY = new StateOfBox("");
        this.boxX = new StateOfBox("");
        playerChange = false;
        result = false;
        i = 0;
        j = 0;
        arrayX =  new String[5];
        arrayY =  new String[6];
      //  winComb = new String
     }
     
    @FXML
    public void operateButton(ActionEvent evt){
        //button1.setText("X");

        
        
        countOfMoves++;
        Button button = (Button)evt.getSource();
        System.out.println(button.getId()); 
        
        if(playerChange){
            button.setText("X");            
            playerChange = false;
            boxX = new StateOfBox(button.getId()); 
            j++;
            arrayX[j] = boxX.getState();
            
        }else{
        button.setText("O");
        
        playerChange = true;
         boxY = new StateOfBox(button.getId());
         i++;
         arrayY[i] = boxY.getState();

        }

        //Disable button
    button.setDisable(true);

        String[] winComb0 = {"button1","button5","button9"};
        String[] winComb1 = {"button1","button2","button3"};
        String[] winComb2 = {"button4","button5","button6"};
        String[] winComb3 = {"button7","button8","button9"};
        String[] winComb4 = {"button3","button5","button7"};
        String[] winComb5 = {"button1","button4","button7"};
        String[] winComb6 = {"button2","button5","button8"};
        String[] winComb7 = {"button3","button6","button9"};
        
        System.out.println(boxX.getState());
        System.out.println(arrayX[j]);
        System.out.println(arrayY[i]);
       // this.containX = new Contain(arrayX,winComb);

        //Sprawdzam czy X wygrał
    if(Contain.useList(arrayX,winComb0)||Contain.useList(arrayX,winComb1)||Contain.useList(arrayX,winComb2)||Contain.useList(arrayX,winComb3)||Contain.useList(arrayX,winComb4)||Contain.useList(arrayX,winComb5)||Contain.useList(arrayX,winComb6)||Contain.useList(arrayX,winComb7)){
        System.out.println("XDDDDDDDD");

        // testuje zamykanie biezaego okna


        AnchorPane root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Wynik.fxml"));
            loader.setController(this); // use this intance as the controller
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        Stage xd = new Stage();
        xd.setScene(scene);
        xd.show();

        xd.setTitle("X WON");

        resultX.setText("X WON");
    }



    //Sprawdzam czy Y wygrał

       else if(Contain.useList(arrayY,winComb0)||Contain.useList(arrayY,winComb1)||Contain.useList(arrayY,winComb2)||Contain.useList(arrayY,winComb3)||Contain.useList(arrayY,winComb4)||Contain.useList(arrayY,winComb5)||Contain.useList(arrayY,winComb6)||Contain.useList(arrayY,winComb7)){
            System.out.println("XDDDDDDDD");

            AnchorPane root = null;
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Wynik.fxml"));
                loader.setController(this); // use this intance as the controller
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Scene scene = new Scene(root);
            Stage xd = new Stage();
            xd.setScene(scene);
            xd.show();
        xd.setTitle("O WON");



        resultX.setText("O WON");
        }
       else if(countOfMoves ==9) {
           AnchorPane root = null;
           try {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("Wynik.fxml"));
               loader.setController(this); // use this intance as the controller
               root = loader.load();
           } catch (IOException e) {
               e.printStackTrace();
           }

           Scene scene = new Scene(root);
           Stage xd = new Stage();
           xd.setScene(scene);
           xd.show();
           xd.setTitle("REMIS");
           resultX.setText("REMIS");
       }

        System.out.println(countOfMoves);

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
