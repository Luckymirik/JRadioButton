import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class Main {
    static JPanel panel = new JPanel();
    static void addObject(JComponent component){
        component.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(component);
        panel.add(Box.createVerticalStrut(10));
    }
    public static void main(String[] args) {
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalStrut(10));
        JFrame frame = new JFrame("JRadioButton");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        frame.setLocationRelativeTo(null);
        int month = Calendar.getInstance().get(Calendar.MONTH)+1;
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton one = new JRadioButton("Весна", month > 2 && month < 6);
        JRadioButton two = new JRadioButton("Лето", month > 5 && month < 9);
        JRadioButton three = new JRadioButton("Осень", month > 8 && month < 12);
        JRadioButton four = new JRadioButton("Зима", month > 11 || month < 3);
        one.setActionCommand("Весна");
        two.setActionCommand("Лето");
        three.setActionCommand("Осень");
        four.setActionCommand("Зима");
        buttonGroup.add(one);
        buttonGroup.add(two);
        buttonGroup.add(three);
        buttonGroup.add(four);
        addObject(one);
        addObject(two);
        addObject(three);
        addObject(four);

        JButton button = new JButton("Ответить");
        addObject(button);

        JLabel label = new JLabel("Ответ:");
        addObject(label);

        button.addActionListener(e -> label.setText("Ответ: " + buttonGroup.getSelection().getActionCommand()));
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);




    }
}