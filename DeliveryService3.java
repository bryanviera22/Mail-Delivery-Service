import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane; //POP-UP Box

public class DeliveryService3 extends JFrame implements ActionListener { //CLASS
  
  private JLabel weightInPoundsLabel, typeOfDeliveryLabel, emptyLabel, emptyLabel2;
  private JTextField poundsTextField;
  private JPanel northPanel, centerPanel, centerPanel2, southPanel;
  private JRadioButton localButton, longDistanceButton;
  private ButtonGroup typeOfDeliveryGroup;
  private JCheckBox insuranceBox;
  private JButton goButton, resetButton;
  
  public DeliveryService3() { //CONSTRUCTOR
    super("Delivery Service");
    
    weightInPoundsLabel = new JLabel("Enter Weight in Pounds: ");
    poundsTextField = new JTextField(10);
    northPanel = new JPanel();
    northPanel.add(weightInPoundsLabel);
    northPanel.add(poundsTextField);
    add(northPanel, BorderLayout.NORTH);
    
    typeOfDeliveryLabel = new JLabel("Type of Delivery: ");
    localButton = new JRadioButton("Local");
    longDistanceButton = new JRadioButton("Long Distance");
    insuranceBox = new JCheckBox("Insurance");
    emptyLabel = new JLabel(" ");
    emptyLabel2 = new JLabel(" ");
    typeOfDeliveryGroup = new ButtonGroup();
    typeOfDeliveryGroup.add(localButton);
    typeOfDeliveryGroup.add(longDistanceButton);
    centerPanel = new JPanel();
    centerPanel.setLayout(new GridLayout(2, 3));
    centerPanel.add(typeOfDeliveryLabel);
    centerPanel.add(localButton);
    centerPanel.add(longDistanceButton);
    centerPanel.add(insuranceBox);
    centerPanel.add(emptyLabel);
    centerPanel.add(emptyLabel2);
    centerPanel2 = new JPanel();
    centerPanel2.add(centerPanel);
    add(centerPanel2, BorderLayout.CENTER);
    
    goButton = new JButton("Go");
    resetButton = new JButton("Reset");
    goButton.addActionListener(this);
    resetButton.addActionListener(this);
    southPanel = new JPanel();
    southPanel.add(goButton, BorderLayout.SOUTH);
    southPanel.add(resetButton, BorderLayout.SOUTH);
    add(southPanel, BorderLayout.SOUTH);
    
    setVisible(true);
    setSize(400,200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
  }
  
  public void actionPerformed(ActionEvent event) { //EVENT THAT DETECTS WHAT IS BEING CLICKED
     
    if(event.getSource() == goButton) {
      String pounds = poundsTextField.getText();
      double weight = Double.parseDouble(pounds); //converts String pounds to double
      
      String delivery = " "; //declare empty String variable 
      if(localButton.isSelected()){
        delivery = "Local";
      }
      else if(longDistanceButton.isSelected()) {
        delivery = "Long Distance";
      }
      
      String insurance = "No";
      if(insuranceBox.isSelected()) {
        insurance = "Yes";
      }
      
      double fee = 0.0;
      if(delivery.equals("Local") && weight <5) {
        fee = 5.75;
      }
      if(delivery.equals("Local") && weight >= 5 && weight <= 20) {
        fee = 10.75;
      }
      if(delivery.equals("Local") && weight > 20) {
        fee = 20.75;
      }
      else if(delivery.equals("Long Distance") && weight < 5) {
        fee = 35.75;
      }
      if(delivery.equals("Long Distance") && weight >= 5) {
        fee = 47.75;
      }
      
      int insuranceFee = 4;
      if(insuranceBox.isSelected()) {
        fee+= insuranceFee;
      }
      
      String output = "\nDelivery Information" +
                               "\nWeight: " + weight +
                               "\nType of Delivery: " + delivery +
                               "\nInsurance: " + insurance +
                               "\nFee: $" + fee;
        
      JOptionPane.showMessageDialog(null, output);
      
       } //end of if statement
    
    else if(event.getSource() == resetButton) { //reset Button
      poundsTextField.setText(" "); //reset textField
      typeOfDeliveryGroup.clearSelection(); //reset buttonGroup
      insuranceBox.setSelected(false); //reset insurance box
    }
    
    
  }//end of event that detects what is being clicked

   
   public static void main(String [] args) { //MAIN METHOD
     DeliveryService3 app = new DeliveryService3(); //executes GUI
   }
  
}