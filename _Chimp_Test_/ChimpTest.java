package _Chimp_Test_;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChimpTest extends JFrame implements ActionListener{
    JFrame frame;
    JPanel gamePanel;
    int step=1;
    JButton[][] grid=new JButton[6][6];

    public static void main(String[]args){
        new ChimpTest();
    }

    public ChimpTest(){
        super("Chimp Test");
        setLayout(null);
        setBounds(100,100,640,640);
        setVisible (true);

        gamePanel = new JPanel();
        gamePanel.setLayout(null);
        gamePanel.setBounds(-15,-15,640,640);
        gamePanel.setVisible (true);

        add(gamePanel);

        int x=20;
        int y=20;

        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                JButton btn = new JButton("");
                btn.setBounds(x, y, 100, 100);
                btn.setPreferredSize(new Dimension(90,90));
                btn.setBackground(Color.BLACK);
                btn.addActionListener(this);
                btn.setVisible(true);
                gamePanel.add(btn);
                grid[i][j] = btn;
                x+=100;
            }

            x=20;
            y+=100;
        }

        for(int i=1;i<=12;i++){
            int row=(int)(Math.random()*5);
            int col=(int)(Math.random()*5);

            while(grid[row][col].getText()!=""){
              row=(int)(Math.random()*5);
              col=(int)(Math.random()*5);
            }

            grid[row][col].setText(Integer.toString(i));
            grid[row][col].setForeground(Color.BLACK);
            grid[row][col].setBackground(new Color(3, 252, 244));
        }
        add(gamePanel);
        gamePanel.repaint();
    }

    public void actionPerformed(ActionEvent e){
        if(step==1){
            for(int i=0;i<6;i++){
                for(int j=0;j<6;j++){
                    grid[i][j].setForeground(new Color(3, 252, 244));
                }
            }
        }

        JButton button=(JButton) e.getSource();
        if (button.getText().equals(Integer.toString(step))){
            button.setForeground(Color.BLACK);
            step++;
        }
        else{
            gamePanel.setVisible(false);
            JPanel endScreen=new JPanel();
            endScreen.setSize(640,640);
            JLabel lost=new JLabel();
            lost.setText("Game Over :(");
            lost.setFont(new Font("Arial",Font.BOLD,60));
            lost.setForeground(new Color(3, 252, 244));
            endScreen.add(lost);
            endScreen.setBackground(new Color( 69, 72, 97));
            add(endScreen);
        }
    }
}
