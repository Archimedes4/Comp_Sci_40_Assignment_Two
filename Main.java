/*
  Andrew Mainella
  Ms. Latimer
  Second Assignment
  Level: Gold
  Rock Paper Scissors
  Started: 26 October 2023 
  HandedIn : 27 October 2023
*/

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

//Rock Icon <a href="https://www.flaticon.com/free-icons/rock" title="rock icons">Rock icons created by Icongeek26 - Flaticon</a>
//Sissors Icon https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.flaticon.com%2Ffree-icon%2Fscissors_541957&psig=AOvVaw30E7OEsbahTQRnmED8HeGg&ust=1698430836016000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCMDWpYeqlIIDFQAAAAAdAAAAABAE
//Paper Icon https://www.google.com/url?sa=i&url=https%3A%2F%2Ftoppng.com%2Ffree-image%2Fpaper-icon-note-icon-black-PNG-free-PNG-Images_126874&psig=AOvVaw3VjNXHULaZobHqcr7tEvdE&ust=1698430889012000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCMj1sKCqlIIDFQAAAAAdAAAAABAF
//Vs Icon https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.onlygfx.com%2Fcomic-vs-versus-png-transparent%2F&psig=AOvVaw1Qg-Errp1dwQs_njgYnZje&ust=1698431496218000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPjRksKslIIDFQAAAAAdAAAAABAK 

//0 Rock
//1 Paper
//2 Sissorrs

//Return type of calculate result
class CalculateResultType {
  String text;
  Integer computerChoice; //0 Rock, 1 Paper, 2 Sissors
  Integer result; //0 Won 1 Lost 2 Tied
  public CalculateResultType (String textIn, Integer computerChoiceIn, Integer resultIn) {
    text = textIn;
    computerChoice = computerChoiceIn;
    result = resultIn;
  }
}

// class holding logic for rock paper scissors
class CalculateResult {
  //get random integer with a domain of [0, 2]
  //Main method
  public static CalculateResultType getResult(Integer offset) { //Offset can only be 0, 1 or 2
    String[] results = {"Tied", "You Won", "You Lost"}; //Calibrated based on rock
    Integer[] enumResult = {2, 0, 1};
    Random randomChoice = new Random();
    Integer computerChoice = randomChoice.nextInt(3);

    switch (computerChoice) {
      case 0: //Rock
        return new CalculateResultType(results[offset] +  " Computer Picked Rock", computerChoice, enumResult[offset]);
      case 1: //Paper
        if (offset == 0) { //So that offset - 1 works and has a valid index
          return new CalculateResultType("You Lost Computer Picked Paper", computerChoice, 1);
        } else {
          return new CalculateResultType(results[offset - 1]  + " Computer Picked Paper", computerChoice, enumResult[offset - 1]);
        }
      case 2: //Sissors
        if (offset == 2) { //So that offset + 1 works and has a valid index
          return new CalculateResultType("You Tied Computer Picked Sissors", computerChoice, 2);
        } else {
          return new CalculateResultType(results[offset + 1] + " Computer Picked Sissors", computerChoice, enumResult[offset + 1]);
        }
      default:
        //This should never happen b/c the computer choice will always be 0, 1, or 2
        return new CalculateResultType("Something went wrong", computerChoice, 1);
    }
  }
}

//Icon class holding icons
class Icons {
  public static ImageIcon Rock() {
    //https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
    ImageIcon rockIcon = new javax.swing.ImageIcon("Stone.png"); // load the image to a imageIcon
    Image image = rockIcon.getImage(); // transform it 
    Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    rockIcon = new ImageIcon(newimg);  // transform it back
    return rockIcon;
  }
  public static ImageIcon Paper() {
    //https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
    ImageIcon rockIcon = new javax.swing.ImageIcon("Paper.png"); // load the image to a imageIcon
    Image image = rockIcon.getImage(); // transform it 
    Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    rockIcon = new ImageIcon(newimg);  // transform it back
    return rockIcon;
  }
  public static ImageIcon Sissors() {
    //https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
    ImageIcon rockIcon = new javax.swing.ImageIcon("Scissors.png"); // load the image to a imageIcon
    Image image = rockIcon.getImage(); // transform it 
    Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    rockIcon = new ImageIcon(newimg);  // transform it back
    return rockIcon;
  }
  public static ImageIcon VSIcon() {
    //https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
    ImageIcon rockIcon = new javax.swing.ImageIcon("comic-vs-versus-2.png"); // load the image to a imageIcon
    Image image = rockIcon.getImage(); // transform it 
    Image newimg = image.getScaledInstance(30, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    rockIcon = new ImageIcon(newimg);  // transform it back
    return rockIcon;
  }
}

//Main Class
class Main {
  public static void main(String[] args) {
    //Main Frame
    JFrame frame = new JFrame();
    frame.setSize(300, 250);
    
    JPanel container = new JPanel();

    // Top label
    JLabel resultLabel = new JLabel("You Haven't Play Yet", SwingConstants.CENTER);
    resultLabel.setBounds(0, 0, 300, 50);
    resultLabel.setBackground(Color.YELLOW);
    frame.add(resultLabel);

    //Left label holding icon users choice
    JLabel leftLabel = new JLabel();
    leftLabel.setBounds(0, 100, 100, 100);
    frame.add(leftLabel);

    //Vs Label
    JLabel vsLabel = new JLabel();
    frame.add(vsLabel);
    vsLabel.setBounds(135, 100, 50, 100);
    vsLabel.setIcon(Icons.VSIcon());

    //Right label holding icon computers choice
    JLabel rightLabel = new JLabel();
    rightLabel.setBounds(200, 100, 100, 100);
    frame.add(rightLabel);

    //Logic for Rock Button
    JButton rock = new JButton("rock");
    rock.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
        CalculateResultType result = CalculateResult.getResult(0);
        resultLabel.setText(result.text);
        leftLabel.setIcon(Icons.Rock());
        if (result.result == 0) {
          rightLabel.setIcon(Icons.Sissors());//win
          container.setBackground(Color.YELLOW);//update colour
          frame.getLayeredPane().moveToBack(container);
        } else if (result.result == 1) {
          rightLabel.setIcon(Icons.Paper());//loss
          container.setBackground(Color.RED);//update colour
          frame.getLayeredPane().moveToBack(container);
        } else {
          rightLabel.setIcon(Icons.Rock());//tie
          container.setBackground(Color.GRAY);//update colour
          frame.getLayeredPane().moveToBack(container);
        }
      }  
    });
    frame.add(rock);
    rock.setBounds(0, 50, 100, 50);

    //Logic for Paper button
    JButton paper = new JButton("paper");
    paper.addActionListener(new ActionListener(){  
      //Event handle
      public void actionPerformed(ActionEvent e){   
        CalculateResultType result = CalculateResult.getResult(1); //calculate
        //update icons and text
        resultLabel.setText(result.text);
        leftLabel.setIcon(Icons.Paper());
        if (result.result == 0) {
          rightLabel.setIcon(Icons.Rock());//win
          container.setBackground(Color.YELLOW);//update colour
          frame.getLayeredPane().moveToBack(container);
        } else if (result.result == 1) {
          rightLabel.setIcon(Icons.Sissors());//loss
          container.setBackground(Color.RED);//update colour
          frame.getLayeredPane().moveToBack(container);
        } else {
          rightLabel.setIcon(Icons.Paper());//tie
          container.setBackground(Color.GRAY);//update colour
          frame.getLayeredPane().moveToBack(container);
        }
      }  
    });
    frame.add(paper);
    paper.setBounds(100, 50, 100, 50);

    //Sissors
    JButton scissors = new JButton("scissors");
    scissors.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
        CalculateResultType result = CalculateResult.getResult(2);
        resultLabel.setText(result.text);
        leftLabel.setIcon(Icons.Sissors());
        if (result.result == 0) {
          rightLabel.setIcon(Icons.Paper());//win
          container.setBackground(Color.YELLOW);//update colour
          frame.getLayeredPane().moveToBack(container);
        } else if (result.result == 1) {
          rightLabel.setIcon(Icons.Rock());//loss
          container.setBackground(Color.RED);//update colour
          frame.getLayeredPane().moveToBack(container);
        } else {
          rightLabel.setIcon(Icons.Sissors());//tie
          container.setBackground(Color.GRAY); //update colour
          frame.getLayeredPane().moveToBack(container);
        }
      }  
    });
    frame.add(scissors);
    scissors.setBounds(200, 50, 100, 50);

    frame.add(container);
    container.setBackground(Color.GRAY); //set default color
    frame.setVisible(true);
    
  }
}