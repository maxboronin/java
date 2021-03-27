package geekbrains;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
//        JMenuItem menuItem = (JMenuItem) e.getSource();
//        System.out.println(menuItem);
//        System.out.println("Text: " + menuItem.getText());
//        System.out.println("EXIT");
        System.exit(1);
    }
}
