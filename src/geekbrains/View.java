package geekbrains;

import geekbrains.cntr.CalcCntr;
import geekbrains.engines.NachorntEngine;
import geekbrains.engines.RecurciveDescentEngine;
import geekbrains.engines.SimpleEngine;
import geekbrains.listeners.ButtonListener;
import geekbrains.listeners.MenuListener;
import geekbrains.model.Model;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private String title = "Калькулятор";
    private JTextField in;

    private static View instance;

    private View(){}

    public static View getInstance(){
        if(instance == null){
            instance = new View();
            instance.init();
        }
        return instance;
    }

    public void init(){
        setTitle(EngineFactory.getInstance().getEngine().toString());

        setBounds(50, 50, 400, 500);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setJMenuBar(createMenuBar());

        setLayout(new BorderLayout());

        JPanel top = createTop();
        add(top, BorderLayout.NORTH);

        Component component = top.getComponent(0);
        add(createBottom((JTextField) component), BorderLayout.CENTER);

        setResizable(false);
    }

    private JPanel createBottom(JTextField in) {
        JPanel bottom = new JPanel();

        bottom.setLayout(new GridLayout(5, 3));

        ButtonListener buttonListener = new ButtonListener();
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(buttonListener);
            bottom.add(btn);
        }

        JButton minus = new JButton("-");
        minus.addActionListener(buttonListener);
        bottom.add(minus);

        JButton dot = new JButton(".");
        dot.addActionListener(buttonListener);
        bottom.add(dot);

        JButton plus = new JButton("+");
        plus.addActionListener(buttonListener);
        bottom.add(plus);

        JButton mul = new JButton("*");
        mul.addActionListener(buttonListener);
        bottom.add(mul);

        JButton div = new JButton("/");
        div.addActionListener(buttonListener);
        bottom.add(div);

        JButton lb = new JButton("(");
        lb.addActionListener(buttonListener);
        bottom.add(lb);

        JButton rb = new JButton(")");
        rb.addActionListener(buttonListener);
        bottom.add(rb);

        JButton sqrt = new JButton("sqrt");
        sqrt.addActionListener(buttonListener);
        bottom.add(sqrt);

        JButton clear = new JButton("C");
        clear.addActionListener(buttonListener);
        bottom.add(clear);

        JButton calc = new JButton("=");
        calc.addActionListener(buttonListener);
        bottom.add(calc);

        return bottom;
    }

    private JPanel createTop() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        in = new JTextField();
        in.setEditable(false);

        in.setFont(new Font("Dialog", Font.PLAIN, 22));
        in.setHorizontalAlignment(JTextField.RIGHT);

        top.add(in, BorderLayout.NORTH);

        clearIn();

        return top;
    }

    private JMenuBar createMenuBar() {
        MenuListener menuListener = new MenuListener();

        JMenuBar menuBar = new JMenuBar();
        JMenu menuEngine = menuBar.add(new JMenu("Движок"));

        menuEngine.add(getEngineMenuItem(SimpleEngine.title, EngineFactory.engineType.SIMPLE.name(), menuListener));
        menuEngine.add(getEngineMenuItem(NachorntEngine.title, EngineFactory.engineType.SCRIPT.name(), menuListener));
        menuEngine.add(getEngineMenuItem(RecurciveDescentEngine.title, EngineFactory.engineType.RECURSIVE.name(), menuListener));

        JMenu menuHelp = menuBar.add(new JMenu("Помощь"));
        menuHelp.add(new JMenuItem("Выход")).addActionListener(menuListener);

        return menuBar;
    }

    private JMenuItem getEngineMenuItem(String title, String actionCommand, MenuListener menuListener){
        JMenuItem item = new JMenuItem(title);
        item.setActionCommand(actionCommand);
        item.addActionListener(menuListener);
        return item;
    }

    @Override
    public void setTitle(String subTitle) {
        super.setTitle(title + ": " + subTitle);
    }

    public void clearIn(){
        Model.getInstance().setExpression("");
        in.setText("");
    }

    public void showExpression(){
        in.setText(Model.getInstance().getExpression());
    }
}
