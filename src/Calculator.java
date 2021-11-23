import Exceptions.InvalidCharacterException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.util.regex.Pattern;


public class Calculator extends JFrame {

    private JPanel contentPane;
    private JTextField intParam;
    private JComboBox boxList;

    /**
     * Start der Applikation.
     */
    public static void main(String[] args) {

        try {
            Calculator frame = new Calculator();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


   double regexWhitelistValidation(String param) throws InvalidCharacterException {

    if (!Pattern.matches("[0-9.-]+", param)) {
        throw new InvalidCharacterException("Invalid Syntax");
    }else{
        return Double.parseDouble(param);
}
   }

    public String calculatorInit(){

        UnitConverter unitConverter = new UnitConverter();

        try {

           String inputParam = intParam.getText();
           double userInputParam = regexWhitelistValidation(inputParam);

           Object selectedItem = boxList.getSelectedItem();

           double result = unitConverter.assignUnitToCalc(selectedItem, userInputParam);

           return userInputParam + " sind " + String.format("%.5f", result) + " " + selectedItem.toString() ;

            }

        catch (Exception e) {

            intParam.setText("");
            return "Geben sie einen gültigen Wert ein!";
        }

    }

    /**
     * Erzeugung des Frame im Konstruktor
     */

    public Calculator() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 250, 300, 250);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblConverter = new JLabel("PS/KW Converter");
        lblConverter.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblConverter.setBounds(10, 0, 250, 33);

        JLabel lblIntParam = new JLabel("Wert :");
        lblIntParam.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblIntParam.setBounds(10, 45, 100, 17);

        JLabel lblText = new JLabel("Umrechnen in ");
        lblText.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblText.setBounds(10, 70, 100, 20);

        intParam = new JTextField();
        intParam.setFont(new Font("Tahoma", Font.PLAIN, 14));
        intParam.setBounds(92, 45, 60, 20);


        boxList = new JComboBox();
        boxList.setFont(new Font("Tahoma", Font.PLAIN, 14));
        boxList.setBounds(110, 70, 60, 20);
        boxList.addItem("KW");
        boxList.addItem("PS");

        JButton calculateBtn = new JButton("Calculate");
        calculateBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
        calculateBtn.setBounds(10, 108, 100, 45);

        JLabel lblResult = new JLabel("Ergebnis:");
        lblResult.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblResult.setBounds(10, 152, 512, 33);


        contentPane.add(lblConverter);
        contentPane.add(lblIntParam);
        contentPane.add(lblText);
        contentPane.add(intParam);
        contentPane.add(boxList);

        contentPane.add(calculateBtn);
        contentPane.add(lblResult);

        calculateBtn.addActionListener(arg0 -> {

                lblResult.setText(calculatorInit());

        });
    }
};