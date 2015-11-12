
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.ActionListener;

public class mainGame extends JFrame implements ActionListener {

    gamePanel game;
    JLabel label;
    String text = "Othello - 2010 ";
    String t = "Visit www.centralconnector.com";
    int response = 0;

    public mainGame() {

        super("Othello");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);

        JMenu file = new JMenu("File");
        menubar.add(file);


        JMenuItem ngame = new JMenuItem("New Game");
        file.add(ngame);
        ngame.addActionListener(this);

        JMenuItem exit = new JMenuItem("Exit");
        file.add(exit);
        exit.addActionListener(this);

        JMenu help = new JMenu("Help");
        menubar.add(help);

        JMenuItem contents = new JMenuItem("Contents");
        help.add(contents);
        contents.addActionListener(this);


        JMenuItem about = new JMenuItem("About");
        help.add(about);
        about.addActionListener(this);

        setSize(500, 500);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("New Game")) {
            String options[] = new String[3];
            options[0] = "Easy";
            options[1] = "Medium";
            options[2] = "Difficult";
            // response=JOptionPane.showOptionDialog(null,"New game","Choose Difficulty:",0,JOptionPane.QUESTION_MESSAGE, null, options,options[1]);
            game = new gamePanel(70, 70, 40, 40, response);

            add(game);


        }

        if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }

        if (e.getActionCommand().equals("Contents")) {
            JOptionPane.showMessageDialog(this, t);


            setLayout(new FlowLayout());
        }

        if (e.getActionCommand().equals("About")) {
            JOptionPane.showMessageDialog(this, text);


            setLayout(new FlowLayout());



        }


    }

    public static void main(String args[]) throws IOException {
        mainGame m = new mainGame();
    }
}



