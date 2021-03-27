package geekbrains.listeners;

import geekbrains.EngineFactory;
import geekbrains.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem menuItem = (JMenuItem) e.getSource();
        System.out.println(menuItem.getActionCommand());

        EngineFactory.getInstance().setEngine(EngineFactory.engineType.valueOf(menuItem.getActionCommand()));
        View.getInstance().setTitle(EngineFactory.getInstance().getEngine().toString());
        View.getInstance().clearIn();
    }
}
