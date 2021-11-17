import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;


public class Calculator extends JFrame {

    private JPanel contentPane;
    private JTextField intParam;
    private JComboBox boxList;

    private double PSmultiplier = 1.3596216173;
    private double KWmultiplier = 0.73549875;


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

    /*
     * Methode zur Berechnung von PS/KW
     */


    public String calculatorInit(){


        double userInputParam;

        UnitConverter unitConverter = new UnitConverter();


        try {

            userInputParam = Double.parseDouble(intParam.getText());

            Object selectedItem = boxList.getSelectedItem();

            if ("KW".equals(selectedItem) && userInputParam > 0 && userInputParam < 5000 ) {

                double result = unitConverter.calc(userInputParam,KWmultiplier);
                return userInputParam + " PS sind " + String.format("%.5f", result) + " KW";


            } else if ("PS".equals(selectedItem) && userInputParam > 0 && userInputParam < 5000) {

                double result = unitConverter.calc(userInputParam,PSmultiplier);
                return userInputParam + " KW sind " + String.format("%.5f", result) + " PS";


            }

            if(userInputParam <= 0){
                intParam.setText("");
                return "Geben sie eine positive Zahl ein";
            }

            if(userInputParam > 5000){
                intParam.setText("");
                return "Benutzen sie eine realistische Zahl";
            }

        } catch (Exception e) {
            intParam.setText("");
            return "Geben sie eine Zahl an!";
        }

        return null;
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