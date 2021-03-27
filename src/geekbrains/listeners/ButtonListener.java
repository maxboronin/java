package geekbrains.listeners;

import geekbrains.View;
import geekbrains.cntr.CalcCntr;
import geekbrains.model.Model;

import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        CalcCntr cntr = CalcCntr.getInstance();

        System.out.println(btn.getText());

        switch (btn.getText()){
            case "C":
                cntr.clearExpression();
                break;
            case "sqrt":
                try {
                    cntr.processSqrt();
                } catch (ScriptException scriptException) {
                    scriptException.printStackTrace();
                }
                break;
            case "=":
                try {
                    cntr.process();
                } catch (ScriptException scriptException) {
                    scriptException.printStackTrace();
                }
                break;
            default:
                cntr.appendExpression(btn.getText().charAt(0));
        }
        View.getInstance().showExpression();
    }
}
