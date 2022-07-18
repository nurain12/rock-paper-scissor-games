import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;


class Main extends JFrame
{    

	public static final int GameOverState = 0;

	//Create label for Computer Choice and result
	JLabel computerChoice,result;

	//Create label for display score
	JLabel computerScore, playerScore;
	int player_score = 0;
	int computer_score = 0;
	int round = 0;
	ImageIcon image_rock,image_paper,image_scissors,image_start;
	
	public void setup(){
		


			image_rock = new ImageIcon(new ImageIcon("rock.png").getImage()
						.getScaledInstance(80,80,Image.SCALE_DEFAULT));

			image_paper = new ImageIcon(new ImageIcon("paper.png").getImage()
						.getScaledInstance(80,80,Image.SCALE_DEFAULT));

			image_scissors = new ImageIcon(new ImageIcon("scissors.png").getImage()
						.getScaledInstance(80,80,Image.SCALE_DEFAULT));

			//label
			JLabel label_computer = new JLabel();
			label_computer.setText("COMPUTER");
			label_computer.setBounds(260, 180, 100, 100);
			
			JLabel label_vs = new JLabel();
			label_vs.setText("VS");
			label_vs.setBounds(280, 200, 100, 100);	

			JLabel label_player = new JLabel();
			label_player.setText("PLAYER");
			label_player.setBounds(264, 220, 100, 100);	

			//Computer Label
			JLabel score = new JLabel("Score");
			score.setBounds(500, 0, 100, 100);

			computerScore = new JLabel();
			computerScore.setText("Computer : 0");
			computerScore.setBounds(500,15,100,100);

			playerScore = new JLabel();
			playerScore.setText("Player : 0");
			playerScore.setBounds(500, 30, 100, 100);

			computerChoice = new JLabel();
			computerChoice.setHorizontalTextPosition(JLabel.CENTER);
			computerChoice.setVerticalTextPosition(JLabel.BOTTOM);
			computerChoice.setBounds(250,90,100,100);

			result = new JLabel();
			result.setFont(new Font("Serif",Font.BOLD,20));
			result.setBounds(250,450,100,100);


			//ROCK label
			JLabel label_rock = new JLabel();
			label_rock.setText("Rock");
			label_rock.setIcon(image_rock); // set icon
			label_rock.setHorizontalTextPosition(JLabel.CENTER);
			label_rock.setVerticalTextPosition(JLabel.BOTTOM);
			label_rock.setBounds(150,300,100,100);

			//PAPER label
			JLabel label_paper = new JLabel();
			label_paper.setText("Paper");
			label_paper.setIcon(image_paper); // set icon
			label_paper.setHorizontalTextPosition(JLabel.CENTER);
			label_paper.setVerticalTextPosition(JLabel.BOTTOM);
			label_paper.setBounds(250,300,100,100);

			//SCISSORS label
			JLabel label_scissors = new JLabel();
			label_scissors.setText("Scissors");
			label_scissors.setIcon(image_scissors); // set icon
			label_scissors.setHorizontalTextPosition(JLabel.CENTER);
			label_scissors.setVerticalTextPosition(JLabel.BOTTOM);
			label_scissors.setBounds(350,300,100,100);

			//add Mouse Listener to labels
			label_rock.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					round ++;					
					if(round == 1)
					{
						//call calculated method
						calculate(label_rock.getText());
					}
					else
					{
						if (player_score >= computer_score && round <= 3)
						{
							//call calculated method
							calculate(label_rock.getText());

						}
						else 
						{
							drawGameOverScreen();
						}
					}					
				}
			});

			label_paper.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					round ++;
					if(round == 1)
					{
						//call calculated method
						calculate(label_paper.getText());
					}
					else 
					{
						if(player_score >= computer_score && round <= 3)
						{
							//call calculated method
							calculate(label_paper.getText());

						}
						else
						{
							drawGameOverScreen();
						}
						

					}					
				}
			});

			label_scissors.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
				round++;
					if(round == 1)
					{
						//call calculated method
						calculate(label_scissors.getText());

					}
					else
					{
						if(player_score >= computer_score && round <= 3)
						{
							//call calculated method
							calculate(label_scissors.getText());

						}
						else 
						{
							drawGameOverScreen();
						}
						
					}
				}
			});
			
			add(computerChoice);
			add(label_rock);
			add(label_paper);
			add(label_scissors);
			add(computerScore);
			add(playerScore);
			add(result);
			add(label_computer);
			add(label_vs);
			add(label_player);
			setLayout(null);

	}

	
	public void GameOver(){

		image_start = new ImageIcon(new ImageIcon("start.jpg").getImage()
						.getScaledInstance(80,80,Image.SCALE_DEFAULT));
		
						//label
		JLabel label_GameOver = new JLabel();
		label_GameOver.setText("GAME OVER !");
		label_GameOver.setFont(new Font("Serif",Font.BOLD,30));
		label_GameOver.setForeground(Color.WHITE);
		label_GameOver.setBounds(200,30,300,300);

		//PAPER label
		JLabel label_replay = new JLabel();
		label_replay.setText("Replay");
		label_replay.setIcon(image_start); // set icon
		label_replay.setHorizontalTextPosition(JLabel.CENTER);
		label_replay.setVerticalTextPosition(JLabel.BOTTOM);
		label_replay.setBounds(250,300,100,100);


		//add Mouse Listener to labels
		label_replay.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){		

				setup();			
			}
		});

		add(label_GameOver);
		add(label_replay);
		setLayout(null);
	}
	public void drawGameOverScreen(){

		Main frame2 = new Main();
		frame2.setTitle("ROCK PAPER SCISSOR");
		frame2.setBounds(200,200,600,600);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setBackground(Color.BLACK);
		frame2.GameOver();
		frame2.setResizable(false);
		frame2.setVisible(true);

		

	}
	public void calculate (String player){
		String[] list = {"Rock","Paper","Scissors"};
		int random_choice = (int)((Math.random()*10)%3);
		String computer = list[random_choice];

		//display computer choice on frame
		computerChoice.setText(computer);
		if(random_choice==0){
			computerChoice.setIcon(image_rock);
		}
		else if (random_choice==1){
			computerChoice.setIcon(image_paper);
		}
		else {
			computerChoice.setIcon(image_scissors);
		}
		//Logic
		String resultText ="";

		if (player.equals(computer)){
			resultText = "It's a draw";
			player_score ++;
			computer_score ++;
		} 
		else if (player.equals("Scissors")){
			if(computer.equals("Rock")){
				resultText = "You lose!";
				computer_score +=2;
			}
			else {

				resultText = "You win!";
				player_score += 2;
			}
		}
		else if (player.equals("Paper")){
			if(computer.equals("Scissors")){
				resultText = "You lose!";
				computer_score +=2;
			}
			else {
				resultText = "You win!";
				player_score += 2;
			}
		}
		else if (player.equals("Rock")){
			if(computer.equals("Paper")){
				resultText = "You lose!";
				computer_score += 2;
				
			}
			else {
				resultText = "You win!";
				player_score +=2;
			}
		}
		else {
			if(computer.equals("Rock")){
				resultText="You lose!";
				computer_score += 2;
			}
			else{
				resultText ="You win!";
				player_score += 2;
			}

		}
		result.setText(resultText);
		playerScore.setText("Player: " +player_score);
		computerScore.setText("Computer: " +computer_score);

 	}
	public static void main(String args[]) {
	    
	    Main g = new Main();
		g.setTitle("ROCK PAPER SCISSOR");
		g.setBounds(200,200,600,600);
		g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g.getContentPane().setBackground(Color.WHITE);
		g.setup();
		g.setResizable(false);
		g.setVisible(true);



	}   
}
