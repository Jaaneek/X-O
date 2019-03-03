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
import javafx.stage.Stage;

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
    //String[] winComb;  
     public FXMLDocumentController(){
        this.boxY = new StateOfBox("");
        this.boxX = new StateOfBox("");
        playerChange = false;
        result = false;
        i = 0;
        j = 0;
        arrayX =  new String[5];
        arrayY =  new String[5];
      //  winComb = new String [8];
     }
     
    @FXML
    public void operateButton(ActionEvent evt){
        //button1.setText("X");
      
        
        
        
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
    if(Contain.useList(arrayX,winComb0)){
        System.out.println("XDDDDDDDD");

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Wynik.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        Stage xd = new Stage();
        xd.setScene(scene);
        xd.show();
    }
    else if(Contain.useList(arrayX,winComb1)){
        System.out.println("XDDDDDDDD");


    }
    else if(Contain.useList(arrayX,winComb2)){
        System.out.println("XDDDDDDDD");
    }
    else if(Contain.useList(arrayX,winComb3)){
        System.out.println("XDDDDDDDD");
    }
    else if(Contain.useList(arrayX,winComb4)){
        System.out.println("XDDDDDDDD");
    }
    else if(Contain.useList(arrayX,winComb5)){
        System.out.println("XDDDDDDDD");
    }
    else if(Contain.useList(arrayX,winComb6)){
        System.out.println("XDDDDDDDD");
    }
    else if(Contain.useList(arrayX,winComb7)){
        System.out.println("XDDDDDDDD");
    }


    //Sprawdzam czy Y wygrał
        else if(Contain.useList(arrayY,winComb0)){
            System.out.println("XDDDDDDDD");
        }
        else if(Contain.useList(arrayY,winComb1)){
            System.out.println("XDDDDDDDD");
        }
        else if(Contain.useList(arrayY,winComb2)){
            System.out.println("XDDDDDDDD");
        }
        else if(Contain.useList(arrayY,winComb3)){
            System.out.println("XDDDDDDDD");
        }
        else if(Contain.useList(arrayY,winComb4)){
            System.out.println("XDDDDDDDD");
        }
        else if(Contain.useList(arrayY,winComb5)){
            System.out.println("XDDDDDDDD");
        }
        else if(Contain.useList(arrayY,winComb6)){
            System.out.println("XDDDDDDDD");
        }
        else if(Contain.useList(arrayY,winComb7)){
            System.out.println("XDDDDDDDD");
        }




    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}