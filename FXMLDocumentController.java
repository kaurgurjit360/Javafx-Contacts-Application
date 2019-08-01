/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contacts;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

/**
 *
 * @author Gurjit
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private ListView<Contact> list;
    @FXML
    private Button addbtn_id;
    @FXML
    private Button deletebtn_id1;
    @FXML
    private Button sort_id1;
    @FXML
    private Button reset_id1;
    @FXML
    private Button deletebtn_id2;
    @FXML
    private Button reset_id2;
    @FXML
    private Button sort_id2;
    @FXML
    private Button clearfield_id;
    @FXML
    private TextField firstname_id;
    @FXML
    private TextField lastname_id;
    @FXML
    private TextField email_id;
    @FXML
    private TextField number_id;
    @FXML
    private ListView<Contact> list2;
    
    ObservableList<Contact> observe = FXCollections.observableArrayList(new Contact("Gurjit","Kaur","email1@gmail.com","111111"),
                                                                        new Contact("Sumaiya","Ali","email2@gmail.com","222222"),
                                                                        new Contact("Risa","Zahn","email3@gmail.com","333333"),
                                                                        new Contact("Michael","Chow","email4@gmail.com","444444"));
    
    ObservableList<Contact> observe2 = FXCollections.observableArrayList(new Contact("Gurjit","Kaur","email1@gmail.com","111111"),
                                                                        new Contact("Sumaiya","Ali","email2@gmail.com","222222"),
                                                                        new Contact("Risa","Zahn","email3@gmail.com","333333"),
                                                                        new Contact("Michael","Chow","email4@gmail.com","444444"));

    private final Image image1  = new Image("pictures/ccny.png",50,50,false,false);
    private final Image image2  = new Image("pictures/ccny1.png",50,50,false,false);
    private final Image image3  = new Image("pictures/ccny2.png",50,50,false,false);
    private final Image image4  = new Image("pictures/ccny3.png",50,50,false,false);
    private final Image[] listOfImages = {image1, image2,image3,image4};  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    list.setItems(observe);
    list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Contact>() {
    @Override
    public void changed(ObservableValue<? extends Contact> observable,
            Contact oldValue, Contact newValue) {
        firstname_id.setText(newValue.getFirst());
        lastname_id.setText(newValue.getLast());
        email_id.setText(newValue.getEmail());
        number_id.setText(newValue.getNumber());
    } 
});
    list2.setItems(observe2);
    list2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Contact>() {
    @Override
    public void changed(ObservableValue<? extends Contact> observable,
            Contact oldValue, Contact newValue) {
        firstname_id.setText(newValue.getFirst());
        lastname_id.setText(newValue.getLast());
        email_id.setText(newValue.getEmail());
        number_id.setText(newValue.getNumber());
    } 
});
            list2.setCellFactory(new Callback<ListView<Contact>,ListCell<Contact>>() {
              @Override
              public ListCell<Contact> call(ListView<Contact> arg0) 
              {
                  ListCell<Contact> cell;
                  cell = new ListCell<Contact>() {
                      ImageView imageView2 = new ImageView();
                      @Override
                      public void updateItem(Contact person, boolean btl) {
                          super.updateItem(person, btl);
                          if(person!= null) 
                          {
                              if (person.getLast().equals("Kaur")) 
                                {
                                imageView2.setImage(listOfImages[0]); 
                                setGraphic(imageView2);
                                setText(person.getFirst()+" " + person.getLast());
                                }
                             else if(person.getLast().equals("Ali")) 
                                {
                                imageView2.setImage(listOfImages[1]); 
                                setGraphic(imageView2);
                                setText(person.getFirst()+" " + person.getLast());
                                }
                              else if(person.getLast().equals("Zahn")) 
                                {  
                                imageView2.setImage(listOfImages[2]);
                                setGraphic(imageView2);
                                setText(person.getFirst()+" " + person.getLast());
                                }
                              else if(person.getLast().equals("Chow")) 
                                {
                                imageView2.setImage(listOfImages[3]); 
                                setGraphic(imageView2);
                                setText(person.getFirst()+ " " + person.getLast()); 
                          }
                          }
                              else 
                              {
                                setGraphic(null);
                                setText(null);
                              }
                       
                      };
                  };
                return cell;
 
              }
            });
          list2.setItems(observe2); 

    }
    //USED FOR SORTING
    public class ContactComparator implements Comparator<Contact> {
  @Override
  public int compare(Contact Contact1, Contact Contact2) {
      return Contact1.getLast().compareToIgnoreCase(Contact2.getLast());
  }
}
    //CLEAR TEXTFIELDS
     @FXML
    private void clearFields(ActionEvent event) {
     firstname_id.setText("");
     lastname_id.setText("");
     number_id.setText("");
     email_id.setText("");
    }
    //ALL FUNCTIONS FOR LIST 1

    @FXML
    private void addContact(ActionEvent event) {
     
        String s = firstname_id.getText();
        firstname_id.setText(s);
        String e = lastname_id.getText();
        lastname_id.setText(e);
        String n = number_id.getText();
        number_id.setText(n);
        String em = email_id.getText();
        email_id.setText(em); 
        Contact x = new Contact(s,e,em,n);
        observe.add(x);
        list.setItems(observe);
     firstname_id.setText("");
     lastname_id.setText("");
     number_id.setText("");
     email_id.setText("");
    }

    @FXML
    private void deletecontact1(ActionEvent event) {
                final int selectedIdx = list.getSelectionModel().getSelectedIndex();
        if (selectedIdx != -1) {
          String itemToRemove = list.getSelectionModel().getSelectedItem().toString();
 
          final int newSelectedIdx =
            (selectedIdx == list.getItems().size() - 1)
               ? selectedIdx - 1
               : selectedIdx;
 
          list.getItems().remove(selectedIdx);
          list.getSelectionModel().select(newSelectedIdx);
        }
    }

  
    @FXML
    private void sort1(ActionEvent event) {
         FXCollections.sort(observe, new ContactComparator());
        list.getSelectionModel().clearSelection();
    }

    @FXML
    private void resetcontact(ActionEvent event) {
observe = FXCollections.observableArrayList(new Contact("Gurjit","Kaur","email1@gmail.com","111111"),
                                                                        new Contact("Sumaiya","Ali","email2@gmail.com","222222"),
                                                                        new Contact("Risa","Zahn","email3@gmail.com","333333"),
                                                                        new Contact("Michael","Chow","email4@gmail.com","444444"));
    
        list.setItems(observe);
    }
  
//ALL FUNCTIONS FOR LIST 2
    
    
    @FXML
    private void deletecontact2(ActionEvent event) {
        final int selectedIdx = list2.getSelectionModel().getSelectedIndex();
        if (selectedIdx != -1) {
          String itemToRemove = list2.getSelectionModel().getSelectedItem().toString();
 
          final int newSelectedIdx =
            (selectedIdx == list2.getItems().size() - 1)
               ? selectedIdx - 1
               : selectedIdx;
 
         list2.getItems().remove(selectedIdx);
     //     list2.getSelectionModel().select(newSelectedIdx);
          
      //    observe.remove(selectedIdx,selectedIdx);
          
        }
    }

    @FXML
    private void sort2(ActionEvent event) {
        FXCollections.sort(observe2, new ContactComparator());
        list2.getSelectionModel().clearSelection();
        
    }

    @FXML
    private void resetcontact2(ActionEvent event) {
 observe2 = FXCollections.observableArrayList(new Contact("Gurjit","Kaur","email1@gmail.com","111111"),
                                                                        new Contact("Sumaiya","Ali","email2@gmail.com","222222"),
                                                                        new Contact("Risa","Zahn","email3@gmail.com","333333"),
                                                                        new Contact("Michael","Chow","email4@gmail.com","444444"));
        list2.setItems(observe2);
    }

      public static class Contact {

        /**
         * @param first the first to set
         */
        public void setFirst(String first) {
            this.first = first;
        }

        /**
         * @param last the last to set
         */
        public void setLast(String last) {
            this.last = last;
        }

        /**
         * @param number the number to set
         */
        public void setNumber(String number) {
            this.number = number;
        }

        /**
         * @param email the email to set
         */
        public void setEmail(String email) {
            this.email = email;
        }

        /**
         * @return the first
         */
        public String getFirst() {
            return first;
        }

        /**
         * @return the last
         */
        public String getLast() {
            return last;
        }

        /**
         * @return the number
         */
        public String getNumber() {
            return number;
        }

        /**
         * @return the email
         */
        public String getEmail() {
            return email;
        }

    private String first;
    private String last;
    private String number;
    private String email;
       private Contact(String f_name, String l_name, String email, String numb)  {
        this.first= new String(f_name);
        this.last = new String(l_name);
        this.email = new String(email);
        this.number = new String(numb);
       }
       @Override
public String toString(){
    return (this.getLast());
}
    }   
}
