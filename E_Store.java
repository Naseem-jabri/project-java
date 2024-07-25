package Project;

import java.io.*;
import java.util.*;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.geometry.HPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class E_Store extends Application  
{
    User admin = new User(1034,"1","1","admin");
    User customer = new User(4597,"2","2","customer");
    
    Item electronics = new Electronics();
    Item clothes = new Clothes();
   
    Font font = Font.font("Arial", FontWeight.MEDIUM, 20);
    Font addLabelfont = Font.font("Arial", FontWeight.MEDIUM, 14);
    Stage mainScreen;
    Stage adminScreen;
    Stage customerScreen;
    Stage deleteAnItem;
    Stage addANewItem;
    Stage buyElectronicsScreen;
    Stage buyClothesScreen; 
        
  public  E_Store() throws IOException
    {
        mainScreen = mainScreen();
        adminScreen = adminScreen();
        customerScreen = customerScreen();
        deleteAnItem = deleteAnItem();
        addANewItem = addANewItem();
        buyElectronicsScreen = buyElectronicsScreen();
        buyClothesScreen = buyClothesScreen(); 
    }
   
     @Override 
  public void start(Stage primaryStage) 
    { 
       primaryStage = mainScreen;
       primaryStage.show();       
    }
  
  public Stage mainScreen() throws IOException
    {
          BorderPane logInBorderPane = new BorderPane();
          logInBorderPane.setPadding(new Insets(20, 12.5, 20, 14.5));
          //-----------------------------------------------
          Label logInLabel = new Label("E-Store Management System (EMS)");
          BorderPane.setAlignment(logInLabel, Pos.CENTER);
          logInLabel.setFont(Font.font("Arial", FontWeight.BOLD, 25));
          logInLabel.setTextFill(Color.BLUE);
          logInBorderPane.setTop(logInLabel);
          //-----------------------------------------------
          GridPane logInGridPane = new GridPane();
          logInGridPane.setAlignment(Pos.CENTER);
          logInGridPane.setPadding(new Insets(15, 15, 15, 15));
          logInGridPane.setVgap(10);
          logInGridPane.setHgap(10);

          Font logInLabelfont = Font.font("Arial", FontWeight.MEDIUM, 16);
          //-----L1
          Label logInLabel1 = new Label("Username: ");
          logInLabel1.setFont(logInLabelfont);
          logInGridPane.add(logInLabel1,0,0);
          //-----L2
          Label logInLabel2 = new Label("Password: ");
          logInLabel2.setFont(logInLabelfont);
          logInGridPane.add(logInLabel2,0,1);
          //-----T1
          TextField logInText1 = new TextField();
          logInText1.setFont(logInLabelfont);
          logInGridPane.add(logInText1,1,0);
          //-----T2
          PasswordField logInText2 = new PasswordField();
          logInText2.setFont(logInLabelfont);
          logInGridPane.add(logInText2,1,1);
          //-----B1
          Button logInB1 = new Button("Login");
          logInB1.setFont(font);
          logInB1.setPrefSize(100, 70);
          logInGridPane.add(logInB1,1,2);
          //---adding grid to left border pane
          logInBorderPane.setLeft(logInGridPane);
          //----Warning message----
          Label logInLabel3 = new Label("");
          logInLabel1.setFont(logInLabelfont);
          logInLabel3.setTextFill(Color.RED);
          logInGridPane.add(logInLabel3,0,3,2,4);
          logInLabel3.setFont(logInLabelfont);
          //==============================================
          ImageView imageView = new ImageView(new Image("Project/ShopPic.png"));
          //imageView.setX(30);
          //imageView.setY(50);
          //---adding grid to right border pane
          logInBorderPane.setRight(imageView);
          //-----------

          //==============================================
          logInB1.setOnAction(e ->
                  {
                      if(logInText1.getText().equalsIgnoreCase(admin.getUsername()) && logInText2.getText().equals(admin.getPassword()))
                          {
                             mainScreen.close();
                             clothes.showItems();
                             electronics.showItems();
                             adminScreen.show();
                          }
                      else if(logInText1.getText().equalsIgnoreCase(customer.getUsername()) && logInText2.getText().equals(customer.getPassword()))
                          {
                              mainScreen.close();
                              clothes.showItems();
                              electronics.showItems();
                              customerScreen.show();
                          }
                      else
                          logInLabel3.setText("Wrong username or password\nplease, try again");
                  });
          //==============================================
          Scene scene = new Scene(logInBorderPane,600,450);
          Stage stage = new Stage();
          stage.setTitle("E-Store Management System (Login Screen)"); 
          stage.setScene(scene); 
          return stage;
    }
  //===================
  public Stage adminScreen()
    {
        BorderPane adminBorderPane = new BorderPane();
        adminBorderPane.setPadding(new Insets(20, 12.5, 20, 14.5));
        
        Label adminLabel = new Label("Admin Menu");
        BorderPane.setAlignment(adminLabel, Pos.CENTER);
        adminLabel.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        adminLabel.setTextFill(Color.BLUE);
        adminBorderPane.setTop(adminLabel);
    //====================
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(30, 15, 15, 15));
        vBox.setAlignment(Pos.CENTER);
            //-- B1
        Button b1 = new Button("Add a New Item");
        b1.setFont(font);
        b1.setPrefSize(200, 90);
        vBox.getChildren().add(b1);
            //-- B2
        Button b2 = new Button("Delete an Item");
        b2.setFont(font);
        b2.setPrefSize(200, 90);
        vBox.getChildren().add(b2);
            //-- B3
        Button b3 = new Button("Exit");
        b3.setFont(font);
        b3.setPrefSize(200, 90);
        vBox.getChildren().add(b3);
        
        adminBorderPane.setCenter(vBox);
    //-- events
        b1.setOnAction(e ->
            {
                adminScreen.close();
                addANewItem.show();
            });
          
        b2.setOnAction(e ->
            {
                adminScreen.close();
                deleteAnItem.show();
            });
          
        b3.setOnAction(e ->
            {
               System.out.println("*********Thank You*********");
               adminScreen.close();
               System.exit(0);
            });

          Scene scene = new Scene(adminBorderPane,250,350);
          Stage stage = new Stage();
          stage.setTitle("Admin Screen"); 
          stage.setScene(scene); 
          return stage;
    }
//===================
   public Stage addANewItem()
    {
        BorderPane adminBorderPane = new BorderPane();
        adminBorderPane.setPadding(new Insets(15, 15, 15, 15));
            
    //--- adding electronics
        GridPane addGridPane1 = new GridPane();    
        addGridPane1.setAlignment(Pos.CENTER);
        addGridPane1.setVgap(10);
        addGridPane1.setHgap(10); 
            
        Label electronicLabel = new Label("Add a New Electronic");
        electronicLabel.setFont(addLabelfont);
        electronicLabel.setTextFill(Color.BLUE);
        addGridPane1.add(electronicLabel,0,0,2,1);
            //-----L1
        Label electronicItemLabel1 = new Label("ItemID*: ");
        electronicItemLabel1.setFont(addLabelfont);
        addGridPane1.add(electronicItemLabel1,0,1);
            //-----L2
        Label electronicItemLabel2 = new Label("ItemName*: ");
        electronicItemLabel2.setFont(addLabelfont);
        addGridPane1.add(electronicItemLabel2,0,2);
            //-----L3
        Label electronicItemLabel3 = new Label("Brand*: ");
        electronicItemLabel3.setFont(addLabelfont);
        addGridPane1.add(electronicItemLabel3,0,3);
            //-----L4
        Label electronicItemLabel4 = new Label("Model*: ");
        electronicItemLabel4.setFont(addLabelfont);
        addGridPane1.add(electronicItemLabel4,0,4);
            //-----L5
        Label electronicItemLabel5 = new Label("Year*: ");
        electronicItemLabel5.setFont(addLabelfont);
        addGridPane1.add(electronicItemLabel5,0,5);
            //-----L6
        Label electronicItemLabel6 = new Label("Price*: ");
        electronicItemLabel6.setFont(addLabelfont);
        addGridPane1.add(electronicItemLabel6,0,6);
            //-----T1
        TextField electronicItemText1 = new TextField();
        electronicItemText1.setFont(addLabelfont);
        addGridPane1.add(electronicItemText1,1,1);
            //-----T2
        TextField electronicItemText2 = new TextField();
        electronicItemText2.setFont(addLabelfont);
        addGridPane1.add(electronicItemText2,1,2);
            //-----T3
        TextField electronicItemText3 = new TextField();
        electronicItemText3.setFont(addLabelfont);
        addGridPane1.add(electronicItemText3,1,3);
            //-----T4
        TextField electronicItemText4 = new TextField();
        electronicItemText4.setFont(addLabelfont);
        addGridPane1.add(electronicItemText4,1,4);
            //-----T5
        TextField electronicItemText5 = new TextField();
        electronicItemText5.setFont(addLabelfont);
        addGridPane1.add(electronicItemText5,1,5);
            //-----T6
        TextField electronicItemText6 = new TextField();
        electronicItemText6.setFont(addLabelfont);
        addGridPane1.add(electronicItemText6,1,6);
            //-----Warning
        Label electronicWarning = new Label("");
        electronicWarning.setFont(addLabelfont);
        electronicWarning.setTextFill(Color.RED);
        addGridPane1.add(electronicWarning,1,7);
            
            //-----B1
        Button electronicButton = new Button("Save");
        electronicButton.setFont(font);
        electronicButton.setPrefSize(100, 50);
        addGridPane1.add(electronicButton,1,8);
            
        adminBorderPane.setLeft(addGridPane1);
    //*******************************************
        GridPane addGridPane2 = new GridPane();
        addGridPane2.setAlignment(Pos.CENTER);
        addGridPane2.setVgap(10);
        addGridPane2.setHgap(10); 
            
        Label clothLabel = new Label("Add a New Cloth");
        clothLabel.setFont(addLabelfont);
        clothLabel.setTextFill(Color.BLUE);
        addGridPane2.add(clothLabel,0,0,2,1);
            //-----L1
        Label clothItemLabel1 = new Label("ItemID*: ");
        clothItemLabel1.setFont(addLabelfont);
        addGridPane2.add(clothItemLabel1,0,1);
            //-----L2
        Label clothItemLabel2 = new Label("ItemName*: ");
        clothItemLabel2.setFont(addLabelfont);
        addGridPane2.add(clothItemLabel2,0,2);
            //-----L3
        Label clothItemLabel3 = new Label("Color*: ");
        clothItemLabel3.setFont(addLabelfont);
        addGridPane2.add(clothItemLabel3,0,3);
            //-----L4
        Label clothItemLabel4 = new Label("Department*: ");
        clothItemLabel4.setFont(addLabelfont);
        addGridPane2.add(clothItemLabel4,0,4);
            //-----L5
        Label clothItemLabel5 = new Label("Size*: ");
        clothItemLabel5.setFont(addLabelfont);
        addGridPane2.add(clothItemLabel5,0,5);
            //-----L6
        Label clothItemLabel6 = new Label("Price*: ");
        clothItemLabel6.setFont(addLabelfont);
        addGridPane2.add(clothItemLabel6,0,6);
            //-----T1
        TextField clothItemText1 = new TextField();
        clothItemText1.setFont(addLabelfont);
        addGridPane2.add(clothItemText1,1,1);
            //-----T2
        TextField clothItemText2 = new TextField();
        clothItemText2.setFont(addLabelfont);
        addGridPane2.add(clothItemText2,1,2);
            //-----T3
        TextField clothItemText3 = new TextField();
        clothItemText3.setFont(addLabelfont);
        addGridPane2.add(clothItemText3,1,3);
            //-----T4
        TextField clothItemText4 = new TextField();
        clothItemText4.setFont(addLabelfont);
        addGridPane2.add(clothItemText4,1,4);
            //-----T5
        TextField clothItemText5 = new TextField();
        clothItemText5.setFont(addLabelfont);
        addGridPane2.add(clothItemText5,1,5);
            //-----T6
        TextField clothItemText6 = new TextField();
        clothItemText6.setFont(addLabelfont);
        addGridPane2.add(clothItemText6,1,6);
            
        Label clothWarning = new Label("");
        clothWarning.setFont(addLabelfont);
        clothWarning.setTextFill(Color.RED);
        addGridPane2.add(clothWarning,1,7);
            
            //-----B2
        Button clothButton = new Button("Save");
        clothButton.setFont(font);
        clothButton.setPrefSize(100, 50);
        addGridPane2.add(clothButton,1,8);
        
        adminBorderPane.setRight(addGridPane2);
        
    //-- Back to Admin Menu Button
        Button backButton = new Button("Back to Admin Menu");
        backButton.setStyle("-fx-text-fill: crimson");
        adminBorderPane.setBottom(backButton);
        
    //-- events
        electronicButton.setOnAction(e ->
            {
                if(electronics.searchItems(electronicItemText1.getText()) == false)
                    {
                       electronics.writeItems(electronicItemText1.getText(), electronicItemText2.getText(),electronicItemText3.getText(), electronicItemText4.getText(), electronicItemText5.getText(), electronicItemText6.getText());
                       electronicWarning.setText("Item added successfully");
                    }
                else
                    {
                       electronicWarning.setText("This item is already exist");
                    }
            });
        clothButton.setOnAction(e ->
            {
                if(clothes.searchItems(clothItemText1.getText()) == false)
                    {
                        clothes.writeItems(clothItemText1.getText(), clothItemText2.getText(),clothItemText3.getText(), clothItemText4.getText(), clothItemText5.getText(), clothItemText6.getText());
                        clothWarning.setText("Item added successfully");
                    }
                else
                    {
                        clothWarning.setText("This item is already exist");
                    }
            });    
        backButton.setOnAction(e ->
            {
                addANewItem.close();
                adminScreen.show();
                clothes.showItems();
                electronics.showItems();
            });
            
    //----------
        Scene scene = new Scene(adminBorderPane,600,400);
        Stage stage = new Stage();
        stage.setTitle("Add a New Item Screen"); 
        stage.setScene(scene);  
        return stage; 
    }

//===================
 
public Stage deleteAnItem()
    {
        BorderPane adminBorderPane = new BorderPane();
        adminBorderPane.setPadding(new Insets(15, 15, 15, 15));
            //
        GridPane addGridPane1 = new GridPane();
        addGridPane1.setAlignment(Pos.CENTER);
        addGridPane1.setVgap(10);
        addGridPane1.setHgap(10); 
            
        Label electronicLabel = new Label("Delete an Electronic");
        electronicLabel.setFont(addLabelfont);
        electronicLabel.setTextFill(Color.BLUE);
        addGridPane1.add(electronicLabel,0,0,2,1);
            //-----L1
        Label electronicItemLabel1 = new Label("ItemID*: ");
        electronicItemLabel1.setFont(addLabelfont);
        addGridPane1.add(electronicItemLabel1,0,1);  
            //-----T1
        TextField electronicItemText1 = new TextField();
        electronicItemText1.setFont(addLabelfont);
        addGridPane1.add(electronicItemText1,1,1);
            //-----Warning
        Label electronicWarning = new Label("");
        electronicWarning.setFont(addLabelfont);
        electronicWarning.setTextFill(Color.RED);
        addGridPane1.add(electronicWarning,1,2);
            //-----B1
        Button electronicButton = new Button("Delete");
        electronicButton.setFont(font);
        electronicButton.setPrefSize(100, 50);
        addGridPane1.add(electronicButton,0,3);
            
        adminBorderPane.setLeft(addGridPane1);
            //*******************************************
        GridPane addGridPane2 = new GridPane();
        addGridPane2.setAlignment(Pos.CENTER);
        addGridPane2.setVgap(10);
        addGridPane2.setHgap(10);
        addGridPane2.setStyle("-fx-background-color: beige ");
        addGridPane2.setPadding(new Insets(12, 12, 12, 12));
            
        Label clothLabel = new Label("Delete a Cloth");
        clothLabel.setFont(addLabelfont);
        clothLabel.setTextFill(Color.BLUE);
        addGridPane2.add(clothLabel,0,0,2,1);
            //-----L1
        Label clothItemLabel1 = new Label("ItemID*: ");
        clothItemLabel1.setFont(addLabelfont);
        addGridPane2.add(clothItemLabel1,0,1);
            //-----T1
        TextField clothItemText1 = new TextField();
        clothItemText1.setFont(addLabelfont);
        addGridPane2.add(clothItemText1,1,1);
            //--- warning
        Label clothWarning = new Label("");
        clothWarning.setFont(addLabelfont);
        clothWarning.setTextFill(Color.RED);
        addGridPane2.add(clothWarning,1,2);
        
            //-----B1
        Button clothButton = new Button("Delete");
        clothButton.setFont(font);
        clothButton.setPrefSize(100, 50);
        addGridPane2.add(clothButton,0,3);
            
        adminBorderPane.setRight(addGridPane2);
        
        //-- Back to Admin Menu Button
        Button backButton = new Button("Back to Admin Menu");
        backButton.setStyle("-fx-text-fill: crimson");
        adminBorderPane.setBottom(backButton);
        
            //-- events
        electronicButton.setOnAction(e ->
            {
                if(electronics.searchItems(electronicItemText1.getText()) == false)
                    {
                       electronicWarning.setText("This item dose not exist");
                    }
                else
                    {
                       electronics.deleteItems(electronicItemText1.getText());
                       electronicWarning.setText("Item deleted successfully");
                    }
            });
        clothButton.setOnAction(e ->
            {
                if(clothes.searchItems(clothItemText1.getText()) == false)
                    {
                       clothWarning.setText("This item dose not exist");
                    }
                else
                    {
                       clothes.deleteItems(clothItemText1.getText());
                       clothWarning.setText("Item deleted successfully");
                    }
            });
         backButton.setOnAction(e ->
            {
                deleteAnItem.close();
                adminScreen.show();
                clothes.showItems();
                electronics.showItems();
            });
            
    //--------------        
        Scene scene = new Scene(adminBorderPane,650,300);
        Stage stage = new Stage();
        stage.setTitle("Delete an Item Screen"); 
        stage.setScene(scene);  
        return stage;
    }

//===================   
  public Stage customerScreen()
    {
          BorderPane customerBorderPane = new BorderPane();
          customerBorderPane.setPadding(new Insets(20, 12.5, 20, 14.5));
          //
          Label customerLabel = new Label("Customer Main Menu");
          customerBorderPane.setTop(customerLabel);
          BorderPane.setAlignment(customerLabel, Pos.CENTER);
          customerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 25));
          customerLabel.setTextFill(Color.BLUE);
          //====================
          VBox customervBox = new VBox(15);
          customervBox.setPadding(new Insets(30, 15, 15, 15));;
          customervBox.setAlignment(Pos.CENTER);
            //==B1
          Button customerb1 = new Button("Electronics");
          customerb1.setFont(font);
          customerb1.setPrefSize(200, 90);
          customervBox.getChildren().add(customerb1);
            //==B2
          Button customerb2 = new Button("Clothes");
          customerb2.setFont(font);
          customerb2.setPrefSize(200, 90);
          customervBox.getChildren().add(customerb2);
            //==B3
          Button customerb3 = new Button("Exit");
          customerb3.setFont(font);
          customerb3.setPrefSize(200, 90);
          customervBox.getChildren().add(customerb3);
          
          customerBorderPane.setCenter(customervBox);
          BorderPane.setAlignment(customervBox, Pos.CENTER);
          //-- events
        customerb1.setOnAction(e ->
            {
                customerScreen.close();
                buyElectronicsScreen.show();
            });
          
        customerb2.setOnAction(e ->
            {
                customerScreen.close();
                buyClothesScreen.show();
            });
          
        customerb3.setOnAction(e ->
            {
               System.out.println("*********Thank You*********");
               customerScreen.close();
               System.exit(0);
            });
          Scene scene = new Scene(customerBorderPane,350,400);
          Stage stage = new Stage();
          stage.setTitle("Customer Menu Screen"); 
          stage.setScene(scene); 
          return stage;
    }
//===================
  public Stage buyElectronicsScreen()
    {
          BorderPane electronicItemBorderPane = new BorderPane();
          electronicItemBorderPane.setPadding(new Insets(12, 12, 12, 12));
          //
          Label electronicItemLabel = new Label("Electronic Item Purchase Form"); 
          BorderPane.setAlignment(electronicItemLabel, Pos.CENTER);
          electronicItemLabel.setFont(Font.font("Arial", FontWeight.BOLD, 25));
          electronicItemLabel.setTextFill(Color.BLUE);
          electronicItemBorderPane.setTop(electronicItemLabel);
          //====================
          GridPane electronicItemGridPane = new GridPane();
          Font electronicItemLabelfont = Font.font("Arial", FontWeight.MEDIUM, 16);
          electronicItemGridPane.setAlignment(Pos.CENTER);
          electronicItemGridPane.setVgap(10); 
          
            //-----L1
          Label electronicItemLabel1 = new Label("ItemID*: ");
          electronicItemLabel1.setFont(electronicItemLabelfont);
          electronicItemGridPane.add(electronicItemLabel1,0,0);
            //-----L2
          Label electronicItemLabel2 = new Label("ItemName*: ");
          electronicItemLabel2.setFont(electronicItemLabelfont);
          electronicItemGridPane.add(electronicItemLabel2,0,1);
            //-----L3
          Label electronicItemLabel3 = new Label("Brand: ");
          electronicItemLabel3.setFont(electronicItemLabelfont);
          electronicItemGridPane.add(electronicItemLabel3,0,2);
            //-----L4
          Label electronicItemLabel4 = new Label("Model: ");
          electronicItemLabel4.setFont(electronicItemLabelfont);
          electronicItemGridPane.add(electronicItemLabel4,0,3);
            //-----L5
          Label electronicItemLabel5 = new Label("Quantity: ");
          electronicItemLabel5.setFont(electronicItemLabelfont);
          electronicItemGridPane.add(electronicItemLabel5,0,4);
            //-----T1
          TextField electronicItemText1 = new TextField();
          electronicItemText1.setFont(electronicItemLabelfont);
          electronicItemGridPane.add(electronicItemText1,1,0);
            //-----T2
          TextField electronicItemText2 = new TextField();
          electronicItemText2.setFont(electronicItemLabelfont);
          electronicItemGridPane.add(electronicItemText2,1,1);
            //-----T3
          TextField electronicItemText3 = new TextField();
          electronicItemText3.setFont(electronicItemLabelfont);
          electronicItemGridPane.add(electronicItemText3,1,2);
            //-----T4
          TextField electronicItemText4 = new TextField();
          electronicItemText4.setFont(electronicItemLabelfont);
          electronicItemGridPane.add(electronicItemText4,1,3);
            //-----T5
          TextField electronicItemText5 = new TextField();
          electronicItemText5.setText("1");
          electronicItemText5.setFont(electronicItemLabelfont);
          electronicItemGridPane.add(electronicItemText5,1,4);

            //---adding grid to center border pane
          electronicItemBorderPane.setCenter(electronicItemGridPane);
          //*******************************************************
          GridPane electronicItemGridPane2 = new GridPane();
          electronicItemGridPane2.setAlignment(Pos.CENTER);
          electronicItemGridPane2.setVgap(25);
          electronicItemGridPane2.setHgap(10);
            //-----B1
          Button electronicItemb1 = new Button("Buy");
          electronicItemb1.setFont(font);
          electronicItemb1.setPrefSize(90, 50);
          electronicItemGridPane2.add(electronicItemb1,0,0);
            //-----B2
          Button electronicItemb2 = new Button("Exit");
          electronicItemb2.setFont(font);
          electronicItemb2.setPrefSize(90, 50);
          electronicItemGridPane2.add(electronicItemb2,1,0);
            //-----Warning
          Label worningMessage = new Label("");
          BorderPane.setAlignment(electronicItemLabel, Pos.CENTER);
          worningMessage.setFont(Font.font("Arial", FontWeight.THIN, 15));
          worningMessage.setTextFill(Color.RED);

          electronicItemGridPane2.add(worningMessage, 0, 1, 2, 2);
            //---adding grid to bottom border pane
          electronicItemBorderPane.setBottom(electronicItemGridPane2);
            //----events
          electronicItemb1.setOnAction(e ->
            {
                if(electronicItemText1.getText().isEmpty() || electronicItemText2.getText().isEmpty())
                    worningMessage.setText("ItemID and ItemName are required feild");
                else
                    {
                        if(electronics.searchItems(electronicItemText1.getText()) == false)
                            {
                               worningMessage.setText("Sorry, This item dose not exist..try again");
                            }
                        else
                            {
                                electronics.setItemID(Long.parseLong(electronicItemText1.getText()));
                                electronics.findPrice();
                                worningMessage.setText(electronics.orderSummary(Integer.parseInt(electronicItemText5.getText())));
                            }
                    }
               
                    
            });
           electronicItemb2.setOnAction(e ->
            {
                customerScreen.show();
                buyElectronicsScreen.close();
                //System.exit(0);
            });
          
          Scene scene = new Scene(electronicItemBorderPane,500,400);
          Stage stage = new Stage();
          stage.setTitle("Buying Electronics Screen"); 
          stage.setScene(scene);  
          return stage;   
    }
//===================
  public Stage buyClothesScreen()
    {
            BorderPane clothItemBorderPane = new BorderPane();
            clothItemBorderPane.setPadding(new Insets(12, 12, 12, 12));
            //
            Label clothItemLabel = new Label("Cloth Item Purchase Form"); 
            BorderPane.setAlignment(clothItemLabel, Pos.CENTER);
            clothItemLabel.setFont(Font.font("Arial", FontWeight.BOLD, 25));
            clothItemLabel.setTextFill(Color.BLUE);
            clothItemBorderPane.setTop(clothItemLabel);

            //******************************************
            GridPane clothItemGridPane = new GridPane();
            Font clothItemLabelfont = Font.font("Arial", FontWeight.MEDIUM, 16);
            clothItemGridPane.setAlignment(Pos.CENTER);
            clothItemGridPane.setVgap(10); 
            //-----L1
            Label clothItemLabel1 = new Label("ItemID*: ");
            clothItemLabel1.setFont(clothItemLabelfont);
            clothItemGridPane.add(clothItemLabel1,0,0);
            //-----L2
            Label clothItemLabel2 = new Label("ItemName*: ");
            clothItemLabel2.setFont(clothItemLabelfont);
            clothItemGridPane.add(clothItemLabel2,0,1);
            //-----L3
            Label clothItemLabel3 = new Label("Color: ");
            clothItemLabel3.setFont(clothItemLabelfont);
            clothItemGridPane.add(clothItemLabel3,0,2);
            //-----L4
            Label clothItemLabel4 = new Label("Department: ");
            clothItemLabel4.setFont(clothItemLabelfont);
            clothItemGridPane.add(clothItemLabel4,0,3);
            //-----L5
            Label clothItemLabel5 = new Label("Size: ");
            clothItemLabel5.setFont(clothItemLabelfont);
            clothItemGridPane.add(clothItemLabel5,0,4);
            //-----L6
            Label clothItemLabel6 = new Label("Quantity: ");
            clothItemLabel6.setFont(clothItemLabelfont);
            clothItemGridPane.add(clothItemLabel6,0,5);
            //-----T1
            TextField clothItemText1 = new TextField();
            clothItemText1.setFont(clothItemLabelfont);
            clothItemGridPane.add(clothItemText1,1,0);
            //-----T2
            TextField clothItemText2 = new TextField();
            clothItemText2.setFont(clothItemLabelfont);
            clothItemGridPane.add(clothItemText2,1,1);
            //-----T3
            TextField clothItemText3 = new TextField();
            clothItemText3.setFont(clothItemLabelfont);
            clothItemGridPane.add(clothItemText3,1,2);
            //-----T4
            TextField clothItemText4 = new TextField();
            clothItemText4.setFont(clothItemLabelfont);
            clothItemGridPane.add(clothItemText4,1,3);
            //-----T5
            TextField clothItemText5 = new TextField();
            clothItemText5.setFont(clothItemLabelfont);
            clothItemGridPane.add(clothItemText5,1,4);
            //-----T6
            TextField clothItemText6 = new TextField();
            clothItemText6.setText("1");
            clothItemText6.setFont(clothItemLabelfont);
            clothItemGridPane.add(clothItemText6,1,5);
            //---adding grid to center border pane
            clothItemBorderPane.setCenter(clothItemGridPane);
            //*******************************************
            GridPane clothItemGridPane2 = new GridPane();
            clothItemGridPane2.setAlignment(Pos.CENTER);
            clothItemGridPane2.setVgap(25);
            clothItemGridPane2.setHgap(10);
            clothItemGridPane2.setPadding(new Insets(12, 12, 12, 12));
            //-----B1
            Button clothItemb1 = new Button("Buy");
            clothItemb1.setFont(font);
            clothItemb1.setPrefSize(90, 50);
            clothItemGridPane2.add(clothItemb1,0,0);
            //-----B2
            Button clothItemb2 = new Button("Exit");
            clothItemb2.setFont(font);
            clothItemb2.setPrefSize(90, 50);
            clothItemGridPane2.add(clothItemb2,1,0);
            //-----Warning
            Label worningMessage = new Label("");
            BorderPane.setAlignment(clothItemGridPane, Pos.CENTER);
            worningMessage.setFont(Font.font("Arial", FontWeight.THIN, 15));
            worningMessage.setTextFill(Color.RED);
            //------------
            clothItemGridPane2.add(worningMessage, 0, 1, 2, 2); 
            //---adding grid to bottom border pane
            clothItemBorderPane.setBottom(clothItemGridPane2);
            //---------------------------------------------------
              //----events
          clothItemb1.setOnAction(e ->
            {
                if(clothItemText1.getText().isEmpty() || clothItemText2.getText().isEmpty())
                    worningMessage.setText("ItemID and ItemName are required feild");
                else
                {
                   if(clothes.searchItems(clothItemText1.getText()) == false)
                        {
                           worningMessage.setText("Sorry, This item dose not exist..try again");
                        }
                    else
                        {
                           clothes.setItemID(Long.parseLong(clothItemText1.getText()));
                           clothes.findPrice();
                           worningMessage.setText(clothes.orderSummary(Integer.parseInt(clothItemText6.getText()))); 
                        } 
                }
                
                    
            });
          
          clothItemb2.setOnAction(e ->
            {
                customerScreen.show();
                buyClothesScreen.close();
              //System.exit(0);       
            });
            
            Scene scene = new Scene(clothItemBorderPane,500,450);
            Stage stage = new Stage();
            stage.setTitle("Buying Clothes Screen"); 
            stage.setScene(scene);  
            return stage;   
    }
 
  
  
  public static void main(String[] args) 
    {
      launch(args);
    }  
}
