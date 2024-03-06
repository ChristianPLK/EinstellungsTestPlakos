import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

/**
 * @author Christian Pahlke
 * 2024-03-06 15:50
 */

public class Anwendung extends JFrame implements ActionListener {
    private static JFrame frame = new JFrame();
    private static final JLabel label1 = new JLabel("Gebe Schrittweise das erste Datum ein:");
    private static final JLabel label2 = new JLabel("Gebe Schrittweise das zweite Datum ein:");

    private static final JLabel ergebnisLabel = new JLabel("Das Ergebnis lautet: ");
    private static JTextField tag1 = new JTextField();
    private static JTextField monat1 = new JTextField();
    private static JTextField jahr1 = new JTextField();
    private static JTextField tag2 = new JTextField();
    private static JTextField monat2 = new JTextField();
    private static JTextField jahr2 = new JTextField();

    private static JButton rechneButton = new JButton("Ergebnis berechnen");

    Anwendung() {


    frame.setSize(550, 700);
        frame.setLayout(null);
        frame.setBackground(Color.decode("#FEF5EB"));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        label1.setBounds(30, 25, 400, 25);
        label1.setText("Gebe Schrittweise das erste Datum ein:");
        frame.add(label1);

        tag1.setBounds(30, 55, 30, 25);
        frame.add(tag1);
        monat1.setBounds(60, 55, 30, 25);
        frame.add(monat1);
        jahr1.setBounds(90, 55, 40, 25);
        frame.add(jahr1);

        label2.setBounds(30, 80, 400, 25);
        label2.setText("Gebe Schrittweise das zweite Datum ein:");
        frame.add(label2);

        tag2.setBounds(30, 110, 30, 25);
        frame.add(tag2);
        monat2.setBounds(60, 110, 30, 25);
        frame.add(monat2);
        jahr2.setBounds(90, 110, 40, 25);
        frame.add(jahr2);



        rechneButton.setBounds(30, 135, 90, 25);
        rechneButton.addActionListener(this);
        frame.add(rechneButton);

        ergebnisLabel.setBounds(30, 160, 400, 25);
        frame.add(ergebnisLabel);
        ergebnisLabel.setVisible(false);


}

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == rechneButton) {
            int eingabeTag1 = Integer.parseInt(tag1.getText());
            int eingabeMonat1 = Integer.parseInt(monat1.getText());
            int eingabeJahr1 = Integer.parseInt(jahr1.getText());

            int eingabeTag2 = Integer.parseInt(tag2.getText());
            int eingabeMonat2 = Integer.parseInt(monat2.getText());
            int eingabeJahr2 = Integer.parseInt(jahr2.getText());

            GregorianCalendar ersterTag = new GregorianCalendar();
            ersterTag.set(eingabeJahr1, eingabeMonat1, eingabeTag1);

            GregorianCalendar zweiterTag = new GregorianCalendar();
            zweiterTag.set(eingabeJahr2, eingabeMonat2, eingabeTag2);


            //Umrechnen von Millisekunden zu Tagen
            int tagesDifferenz = (int)((zweiterTag.getTimeInMillis() - ersterTag.getTimeInMillis()) / (1000 * 60 * 60 * 24));


            ergebnisLabel.setText("Das Ergebnis lautet: " + tagesDifferenz + " Tag(e)");
            ergebnisLabel.setVisible(true);

            System.out.println(tagesDifferenz);

        }
    }

}
