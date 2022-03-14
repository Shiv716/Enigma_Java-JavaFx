package EnigmaFolder;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class EnigmaController implements Initializable {

    public Label Rotor1Display;
    public Label Rotor2Display;
    public Label Rotor3Display;
    public Label  Ciphertext;
    public TextField EnterText;
    public Slider Rotor1;
    public Slider Rotor2;
    public Slider Rotor3;
    public Button CipherGenerator;
    public Spinner <String> plugKey1A;
    public Spinner <String> plugKey1B;
    public Spinner <String> plugKey2A;
    public Spinner <String> plugKey2B;
    public Spinner <String> plugKey3A;
    public Spinner <String> plugKey3B;
    public Spinner <String> plugKey4A;
    public Spinner <String> plugKey4B;
    public Spinner <String> plugKey5A;
    public Spinner <String> plugKey5B;
    public Spinner <String> plugKey6A;
    public Spinner <String> plugKey6B;

    //Creating hashmap for mapping numbers to letters to be used later:-

    public static HashMap<Integer,String> letterByNumber= new HashMap<Integer,String>();

    //mapping them:-
    static{
        letterByNumber.put(0," ");
        letterByNumber.put(1,"A");
        letterByNumber.put(2,"B");
        letterByNumber.put(3,"C");
        letterByNumber.put(4,"D");
        letterByNumber.put(5,"E");
        letterByNumber.put(6,"F");
        letterByNumber.put(7,"G");
        letterByNumber.put(8,"H");
        letterByNumber.put(9,"I");
        letterByNumber.put(10,"J");
        letterByNumber.put(11,"K");
        letterByNumber.put(12,"L");
        letterByNumber.put(13,"M");
        letterByNumber.put(14,"N");
        letterByNumber.put(15,"O");
        letterByNumber.put(16,"P");
        letterByNumber.put(17,"Q");
        letterByNumber.put(18,"R");
        letterByNumber.put(19,"S");
        letterByNumber.put(20,"T");
        letterByNumber.put(21,"U");
        letterByNumber.put(22,"V");
        letterByNumber.put(23,"W");
        letterByNumber.put(24,"X");
        letterByNumber.put(25,"Y");
        letterByNumber.put(26,"Z");

    }


    //Storing the letter provided by the user:-
    public static String d1;


    //Setting values at Rotor2 Slider:-(First need to check if will work nicely.)

    //Setting values at Rotor3 Slider:-(First need to check if will work nicely.)


    //Inputs letter from the user:-
    public void cipherInput(javafx.event.ActionEvent actionEvent) {
        try{
            d1 = EnterText.getText();
        }
        catch(Exception e){
            System.out.println("Please enter Capital Letters only");
        }

        EnterText.setText(""+d1);
    }


    //Outputs ciphertext:-
    public void generateCipher(javafx.event.ActionEvent actionEvent) throws IOException, InterruptedException {
        String d1 = new String(EnterText.getText());
        Ciphertext.setText(""+d1.toUpperCase());
        EnterText.clear();
    }



    //To display Slider values in a Label.
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Rotor 1 value displays:-
        Rotor1.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int value = (int) Rotor1.getValue();
                if (letterByNumber.containsKey(value)) {
                    String letter_needed = letterByNumber.get(value);
                    Rotor1Display.setText(letter_needed);
                }
            }
        });


        //Rotor 2 value displays:-
        Rotor2.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int value = (int) Rotor2.getValue();
                if (letterByNumber.containsKey(value)) {
                    String letter_needed = letterByNumber.get(value);
                    Rotor2Display.setText(letter_needed);
                }
            }
        });


        //Rotor 3 value displays:-
        Rotor3.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int value = (int) Rotor3.getValue();
                if (letterByNumber.containsKey(value)) {
                    String letter_needed = letterByNumber.get(value);
                    Rotor3Display.setText(letter_needed);
                }
            }
        });


        //USER GETS 6 PLUGBOARD KEYS TO SWAP THE VALUES SO 6 OPTIONS TO CHOOSE FROM IF WANTED
        // - FOR ADDING CHANGING VALUES BEFORE THE ELEMENT ENTERS THE ROTORS.

        //Making the spinners:-

        //Making an observable list of all values of our hashmap to be used in spinner factory as Strings:-
        ObservableList<String> justLetters = FXCollections.observableArrayList();
        justLetters.addAll(letterByNumber.values());


        //Spinners :
        SpinnerValueFactory<String> valueFactory1A = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);

        valueFactory1A.setValue(" ");

        //Spinner 1A:-
        plugKey1A.setValueFactory(valueFactory1A);
        //LIKEWISE:-

        //Spinner 1B:-
        SpinnerValueFactory<String> valueFactory1B = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);

        valueFactory1B.setValue(" ");
        plugKey1B.setValueFactory(valueFactory1B);

        //Spinner 2A:-
        SpinnerValueFactory<String> valueFactory2A = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);

        valueFactory2A.setValue(" ");
        plugKey2A.setValueFactory(valueFactory2A);

        //Spinner 2B:-
        SpinnerValueFactory<String> valueFactory2B = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);

        valueFactory2B.setValue(" ");
        plugKey2B.setValueFactory(valueFactory2B);

        //Spinner 3A:-
        SpinnerValueFactory<String> valueFactory3A = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);

        valueFactory3A.setValue(" ");
        plugKey3A.setValueFactory(valueFactory3A);

        //Spinner 3B:-
        SpinnerValueFactory<String> valueFactory3B = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);

        valueFactory3B.setValue(" ");
        plugKey3B.setValueFactory(valueFactory3B);

        //Spinner 4A:-
        SpinnerValueFactory<String> valueFactory4A = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);

        valueFactory4A.setValue(" ");
        plugKey4A.setValueFactory(valueFactory4A);

        //Spinner 4B:-
        SpinnerValueFactory<String> valueFactory4B = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);

        valueFactory4B.setValue(" ");
        plugKey4B.setValueFactory(valueFactory4B);

        //Spinner 5A:-
        SpinnerValueFactory<String> valueFactory5A = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);

        valueFactory5A.setValue(" ");
        plugKey5A.setValueFactory(valueFactory5A);

        //Spinner 5B:-
        SpinnerValueFactory<String> valueFactory5B = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);

        valueFactory5B.setValue(" ");
        plugKey5B.setValueFactory(valueFactory5B);

        //Spinner 6A:-
        SpinnerValueFactory<String> valueFactory6A = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);

        valueFactory6A.setValue(" ");
        plugKey6A.setValueFactory(valueFactory6A);

        //Spinner 6B:-
        SpinnerValueFactory<String> valueFactory6B = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);

        valueFactory6B.setValue(" ");
        plugKey6B.setValueFactory(valueFactory6B);


    /*
    //use spinners for rotors
    // - and then assign letters to the textfield
     - Give 6 plugboard key options as spinners or menu box
    // Use Enigma file to complete the architecture.
     */
    }
}
