package project2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FirstPage implements ActionListener {

    private StringBuffer winner = new StringBuffer("The winner is ");

    private String user1;
    private String user2;
    private String gameMode;

    public @Override String toString()
    {
        if(gameMode =="Single Player")
        {
            user2 = "Computer";
        }
            String result = "This game was played by   " + user1 + "and by "+ user2 +" in game mod: " +gameMode;
            return result;
    }

    private List<Integer> availableButtons = new ArrayList<>();

    public void check() {
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
			xWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			xWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			xWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(2,4,6);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			oWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			oWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			oWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(2,4,6);
		}
	}
	
   
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title = new JPanel();
    JPanel button = new JPanel();
    JButton[] buttons = new JButton[9];
    JLabel textfield = new JLabel();

    boolean player1_turn ;
    public FirstPage(String user1, String gameMode) {
        this.user1 = user1;
        this.gameMode = gameMode;
        this.user2 = null;

        initializeFrame();
    }

    public FirstPage(String user1, String user2, String gameMode) {
        this.user1 = user1;
        this.user2 = user2;
        this.gameMode = gameMode;

        initializeFrame();
    }


    public void initializeFrame()
    {
        try{
            for (int i = 0; i < 9; i++) {
                availableButtons.add(i);
            }
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(Color.white);

        textfield.setHorizontalAlignment(JLabel.CENTER);        
        textfield.setText("X and 0");
    
        textfield.setOpaque(true);
        Font font = new Font("Arial", Font.PLAIN, 36);
        textfield.setFont(font);
        title.setLayout(new BorderLayout());
        title.setBounds(0, 0, 800, 100);
        
        button.setLayout(new GridLayout(3,3));
        button.setBackground(new Color(150,150,150));

        for(int i=0;i<9;i++)
        {
            buttons[i] = new JButton();
            button.add(buttons[i]);
            buttons[i].setFont(new Font("",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title.add(textfield);
        frame.add(title, BorderLayout.NORTH);
        frame.add(button);

        firstTurn();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    private void selectRandomAvailableButton() {
        if (!availableButtons.isEmpty()) {
            int randomIndex = random.nextInt(availableButtons.size());
            int selectedIndex = availableButtons.get(randomIndex);
            buttons[selectedIndex].setForeground(Color.red);
            buttons[selectedIndex].setText("O");
            textfield.setText("Next is X");
            player1_turn = true;
            availableButtons.remove(randomIndex);
        }
    }
    
    private void computerMakeMove() {
        if (player1_turn) {
            return;
        }
        selectRandomAvailableButton();
        check();
    }
    
    public void firstTurn() {
        textfield.setText("X AND O");

        if (user2 == null && gameMode.equals("Single Player")) {
            player1_turn=false;//computerul incepe primul
            computerMakeMove(); 
        } else {
           
                    if (random.nextInt(2) == 0) {
                        player1_turn = true;
                        textfield.setText("X turn");
                    } else {
                        player1_turn = false;
                        textfield.setText("O turn");
                    }
                
            

        }
    }
    private void disableOtherButtons(int a,int b ,int c)
    {
        for(int i=0;i<9;i++)
        {
            if(i!=a && i!=b && i!=c)
            {
                buttons[i].setBackground(Color.red);
            }
        }
    }

    private void xWins(int a,int b,int c)
    {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        this.disableOtherButtons(a,b,c);
        this.winner.append("user x");
        textfield.setText(this.winner.toString());   
        displayGameResult();

    }
    private void oWins(int a,int b,int c)
    {
         buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        this.disableOtherButtons(a,b,c);
        this.winner.append("user 0");
        textfield.setText(this.winner.toString());
        displayGameResult();


    }
    
  
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i] && buttons[i].getText().isEmpty()) {//validare extra pt text empty
                /*if (gameMode.equals("Single Player") && !player1_turn) {//daca e singleplayer si nu e userul la rand
                    return;
                }*/
    
                if (player1_turn) {
                    buttons[i].setForeground(Color.blue);
                    buttons[i].setText("X");
                    textfield.setText("Next is O");
                    availableButtons.remove(Integer.valueOf(i));
                    check();
                    player1_turn = !player1_turn; 
                    if (gameMode.equals("Single Player")) {
                    computerMakeMove();//daca e singleplayer- dupa ce userul a ales,instant alege computerul
                }
                } else {
                    buttons[i].setForeground(Color.red);
                    buttons[i].setText("O");
                    textfield.setText("Next is X");
                    player1_turn = !player1_turn;
                    availableButtons.remove(Integer.valueOf(i));
                    check();
                }
    
             
    
                
            }
        }
    }
    
    
    private void displayGameResult() {
        String gameResult = toString();
        JOptionPane.showMessageDialog(frame, gameResult, "Game Result", JOptionPane.INFORMATION_MESSAGE);
    
        Thread closingThread = new Thread(() -> {
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
            SwingUtilities.invokeLater(() -> {
                frame.dispose();
                System.exit(0); 
            });
        });
    
        closingThread.start();
    }
    

}
