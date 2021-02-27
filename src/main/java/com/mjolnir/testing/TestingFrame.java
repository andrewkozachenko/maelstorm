package com.mjolnir.testing;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TestingFrame extends JFrame {

    JPanel mainPanel = new JPanel();
    User user = new User();
    int quizResult =0;


    public TestingFrame() throws HeadlessException {
        init();
    }


    public void init() {
        setJMenuBar(getMenu());
        initMainPanel();
        add(mainPanel);
        String s = JOptionPane.showInputDialog("What is your name?");
        setTitle("Test for: " + s);
        user.setName(s);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private List<Question> getQuestion(){
        return new ArrayList<Question>(){{
           new Question("2+2", "4", "3","4","5",4);
           new Question("2+3", "4", "3","4","5",5);
           new Question("2+4", "4", "3","4","5",6);
           new Question("2+5", "4", "3","4","5",7);
           new Question("2+6", "4", "3","4","5",8);
           new Question("2+7", "4", "3","4","5",9);
        }};
    }


    private JMenuBar getMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem scoresItem = new JMenuItem("Scores");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(scoresItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        return menuBar;
    }

    private void initMainPanel() {
        mainPanel.setPreferredSize(new Dimension(800, 500));


        QuestionPanel questionPanel = new QuestionPanel(getQuestion().get(0));
        QuestionPanel questionPanel1 = new QuestionPanel(getQuestion().get(1));
        QuestionPanel questionPanel2 = new QuestionPanel(getQuestion().get(2));
        QuestionPanel questionPanel3 = new QuestionPanel(getQuestion().get(3));
        QuestionPanel questionPanel4 = new QuestionPanel(getQuestion().get(4));
        QuestionPanel questionPanel6 = new QuestionPanel(getQuestion().get(5));

        JPanel currentPanel = questionPanel;


        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e ->{
            quizResult=+questionPanel.getQuestionResult();
            currentPanel.setVisible(false);


        });
        nextButton.setBounds(125, 90, 80, 30);
        mainPanel.add(questionPanel);
        mainPanel.add(nextButton);

    }

    class QuestionPanel extends JPanel implements ActionListener {

        private int questionResult = 0;

        public QuestionPanel(Question question) {
            GridLayout gridLayout = new GridLayout(5, 0);
            setLayout(gridLayout);
            setSize(new Dimension(300, 300));
            JRadioButton jRadioButton1 = new JRadioButton(question.answer);
            jRadioButton1.setActionCommand("" + question.mark);
            JRadioButton jRadioButton2 = new JRadioButton(question.variant1);
            jRadioButton2.setActionCommand("0");
            JRadioButton jRadioButton3 = new JRadioButton(question.variant2);
            jRadioButton3.setActionCommand("0");
            JRadioButton jRadioButton4 = new JRadioButton(question.variant3);
            jRadioButton4.setActionCommand("0");

            ButtonGroup buttonGroup = new ButtonGroup();
            JLabel questionLabel = new JLabel(question.getQuestion());
            jRadioButton1.setBounds(120, 30, 120, 50);
            jRadioButton2.setBounds(250, 30, 80, 50);

            questionLabel.setBounds(20, 30, 150, 50);
            add(questionLabel);
            add(jRadioButton1);
            add(jRadioButton2);
            add(jRadioButton3);
            add(jRadioButton4);
            buttonGroup.add(jRadioButton1);
            buttonGroup.add(jRadioButton2);
            buttonGroup.add(jRadioButton4);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int questionMark = Integer.parseInt(e.getActionCommand());
            if(questionMark>0){
                this.questionResult=questionMark;
            }
        }

        public int getQuestionResult() {
            return questionResult;
        }

    }
}
