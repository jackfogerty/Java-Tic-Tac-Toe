import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*; 

public class TicTacToeGame extends JPanel implements MouseListener
{
    Image title;//declaring variables
    Image background;
    Image xImage;
    Image oImage;
    Image xWinScreen;
    Image oWinScreen;
    Image tieScreen;
    Image selectScreen;
    Image hardBoard;
    Image hardX;
    Image hardO;
    Image galaxy;
    Image galaxy3d;
    Image sun;
    Image sun3d;
    Image earth;
    Image earth3d;
    Image ufo;
    Image ufo3d;
    Image playerSelect;
    int playerSelectNum = 1;
    int screen = 1;
    int players;
    int counter;
    int counter2;
    int turn = 1; //turn (1 or 2) 
    int a = 0;
    int b = 0;
    int c = 0;
    int d = 0;
    int e1 = 0;
    int f = 0;
    int g1 = 0;
    int h = 0;
    int i = 0;
    int a2 = 0;
    int b2 = 0;
    int c2 = 0;
    int d2 = 0;
    int e2 = 0;
    int f2 = 0;
    int g2 = 0;
    int h2 = 0;
    int i2 = 0;
    int a3 = 0;
    int b3 = 0;
    int c3 = 0;
    int d3 = 0;
    int e3 = 0;
    int f3 = 0;
    int g3 = 0;
    int h3 = 0;
    int i3 = 0;
    int a4 = 0;
    int b4 = 0;
    int c4 = 0;
    int d4 = 0;
    int e4 = 0;
    int f4 = 0;
    int g4 = 0;
    int h4 = 0;
    int i4 = 0;
    public TicTacToeGame()
    {
        addMouseListener(this);
        //load images
        try
        {
            title = ImageIO.read(new File("tic tac toe.png"));//title screen
            background = ImageIO.read(new File("Background.png"));//background
            xWinScreen = ImageIO.read(new File("xWinScreen.png"));//win screen if x wins
            oWinScreen = ImageIO.read(new File("oWinScreen.png"));//win screen if o wins
            tieScreen = ImageIO.read(new File("TieScreen.png"));//tie screen
            selectScreen = ImageIO.read(new File("selectScreen.png"));//select screen for 3d or normal pvp
            hardBoard = ImageIO.read(new File("3d board.png"));//3d board
            galaxy = ImageIO.read(new File("galaxy piece.png"));
            galaxy3d = ImageIO.read(new File("galaxy piece 3d.png"));
            sun = ImageIO.read(new File("sun piece.png"));
            sun3d = ImageIO.read(new File("sun piece 3d.png"));
            ufo = ImageIO.read(new File("x image.png"));
            earth = ImageIO.read(new File("o image.png"));
            ufo3d = ImageIO.read(new File("x image 3d.png"));
            earth3d = ImageIO.read(new File("o image 3d.png"));
            playerSelect = ImageIO.read(new File("playerSelect.png"));
        }
        catch (IOException e)
        {
        }
    }

    public void paint(Graphics g)//which screen to be on
    {
        if(screen == 1)//title screen
        {
            startScreen(g);
        }
        else if(screen == 2)//normal board
        {
            drawBoard(g);
        }
        else if(screen == 3)//3d board
        {
            hardBoard(g);
        }
        else if(screen == 4)//win screen for ufo
        {
            delay(25000);
            player1Win(g);
        }
        else if(screen == 5)//win screen for earth
        {
            delay(25000);
            player2Win(g);
        }
        else if(screen == 6)//tie screen
        {
            delay(25000);
            tieScreen(g);
        }
        else if(screen == 7)//select screen for 3d or normal pvp
        {
            selectScreen(g);
        }
        else if(screen == 8)
        {
            playerSelect(g);
        }
    }

    public void startScreen(Graphics g)//title screen with buttons
    {
        g.drawImage(title, 0, 0, null);
    }

    public void drawBoard(Graphics g)//normal player vs player mode
    {        
        g.drawImage(background, 0, 0, null);//drawing background and borders
        g.setColor(Color.white);
        g.fillRect(297,0,6,900);
        g.fillRect(597,0,6,900);
        g.fillRect(0,297,900,6);
        g.fillRect(0,597,900,6);

        if(a==1)//drawing pieces on board
        {
            g.drawImage(xImage, 0, 0, null);
        }
        else if(a==2)
        {
            g.drawImage(oImage, 0, 0, null);
        }

        if(b==1)
        {
            g.drawImage(xImage, 303, 0, null);
        }
        else if(b==2)
        {
            g.drawImage(oImage, 303, 0, null);
        }

        if(c==1)
        {
            g.drawImage(xImage, 603, 0, null);
        }
        else if(c==2)
        {
            g.drawImage(oImage, 603, 0, null);
        }

        if(d==1)
        {
            g.drawImage(xImage, 0, 303, null);
        }
        else if(d==2)
        {
            g.drawImage(oImage, 0, 303, null);
        }

        if(e1==1)
        {
            g.drawImage(xImage, 303, 303, null);
        }
        else if(e1==2)
        {
            g.drawImage(oImage, 303, 303, null);
        }

        if(f==1)
        {
            g.drawImage(xImage, 603, 303, null);
        }
        else if(f==2)
        {
            g.drawImage(oImage, 603, 303, null);
        }

        if(g1==1)
        {
            g.drawImage(xImage, 0, 603, null);
        }
        else if(g1==2)
        {
            g.drawImage(oImage, 0, 603, null);
        }

        if(h==1)
        {
            g.drawImage(xImage, 303, 603, null);
        }
        else if(h==2)
        {
            g.drawImage(oImage, 303, 603, null);
        }

        if(i==1)
        {
            g.drawImage(xImage, 603, 603, null);
        }
        else if(i==2)
        {
            g.drawImage(oImage, 603, 603, null);
        }

        checkWinner();//check for winner after each move
    }

    public void playerSelect(Graphics g)//choosing an icon
    {
        g.drawImage(playerSelect, 0, 0, null);
        if(counter == 1 && playerSelectNum == 3)//if vs bot was picked before and both icons are chosen
        {
            screen = 2;
        }
        if(counter == 2 && playerSelectNum == 3)//if vs player easy was picked before
        {
            screen = 2;
        }
        if(counter == 3 && playerSelectNum == 3)//if vs player 3d was picked before
        {
            screen = 3;
        }
        repaint();
    }

    public void computerMove()//bot moves
    {
        if(turn == 2)//fixes bug where player can click on a full square and bot will move
        {
            if (a == 2 && b == 2 && c == 0) //horizontal offensive
                c = 2;
            else if(a == 2 && b == 0 && c == 2)
                b = 2;
            else if(a == 0 && b == 2 && c == 2)
                a = 2;
            else if (d == 2 && e1 == 2 && f == 0)
                f = 2; 
            else if(d == 2 && e1 == 0 && f == 2)
                e1 = 2;
            else if(d == 0 && e1 == 2 && f == 2)
                d = 2;
            else if (g1 == 2 && h == 2 && i == 0)
                i = 2;
            else if(g1 == 2 && h == 0 && i == 2)
                h = 2;
            else if(g1 == 0 && h == 2 && i == 2)
                g1 = 2;

            else if (a == 2 && d == 2 && g1 == 0) //vertical offensive
                g1 = 2;
            else if(a == 2 && d == 0 && g1 == 2)
                d = 2;
            else if(a == 0 && d == 2 && g1 == 2)
                a = 2;
            else if (b == 2 && e1 == 2 && h == 0)
                h = 2;
            else if(b == 2 && e1 == 0 && h == 2)
                e1 = 2;
            else if(b == 0 && e1 == 2 && h == 2)
                b = 2;
            else if (c == 2 && f == 2 && i == 0)
                i = 2;
            else if(c == 2 && f == 0 && i == 2)
                f = 2;
            else if(c == 0 && f == 2 && i == 2)
                c = 2;

            else if(a == 2 && e1 == 2 && i == 0) //diagonal offensive
                i = 2;
            else if(a == 2 && e1 == 0 && i == 2)
                e1 = 2;
            else if(a == 0 && e1 == 2 && i == 2)
                a = 2;
            else if(c == 2 && e1 == 2 && g1 == 0)
                g1 = 2;
            else if(c == 2 && e1 == 0 && g1 == 2)
                e1 = 2;
            else if(c == 0 && e1 == 2 && g1 == 2)
                c = 2;

            else if (a == 1 && b == 1 && c == 0) //horizontal defensive
                c = 2;
            else if(a == 1 && b == 0 && c == 1)
                b = 2;
            else if(a == 0 && b == 1 && c == 1)
                a = 2;
            else if (d == 1 && e1 == 1 && f == 0)
                f = 2;
            else if(d == 1 && e1 == 0 && f == 1)
                e1 = 2;
            else if(d == 0 && e1 == 1 && f == 1)
                d = 2;
            else if (g1 == 1 && h == 1 && i == 0)
                i = 2;
            else if(g1 == 1 && h == 0 && i == 1)
                h = 2;
            else if(g1 == 0 && h == 1 && i == 1)
                g1 = 2;

            else if (a == 1 && d == 1 && g1 == 0) //vertical defensive
                g1 = 2;
            else if(a == 1 && d == 0 && g1 == 1)
                d = 2;
            else if(a == 0 && d == 1 && g1 == 1)
                a = 2;
            else if (b == 1 && e1 == 1 && h == 0)
                h = 2;
            else if(b == 1 && e1 == 0 && h == 1)
                e1 = 2;
            else if(b == 0 && e1 == 1 && h == 1)
                b = 2;
            else if (c == 1 && f == 1 && i == 0)
                i = 2;
            else if(c == 1 && f == 0 && i == 1)
                f = 2;
            else if(c == 0 && f == 1 && i == 1)
                c = 2;

            else if(a == 1 && e1 == 1 && i == 0) //diagonal defensive
                i = 2;
            else if(a == 1 && e1 == 0 && i == 1)
                e1 = 2;
            else if(a == 0 && e1 == 1 && i == 1)
                a = 2;
            else if(c == 1 && e1 == 1 && g1 == 0)
                g1 = 2;
            else if(c == 1 && e1 == 0 && g1 == 1)
                e1 = 2;
            else if(c == 0 && e1 == 1 && g1 == 1)
                c = 2;

            //starting moves
            else if((a == 1  || c == 1 || g1 == 1 || i == 1 || b == 1 || d == 1 || f == 1 || h == 1) && a+b+c+d+e1+f+g1+h+i == 1)
                e1 = 2;
            else if(e1 == 1 && a+b+c+d+e1+f+g1+h+i == 1)
                a = 2;

            //mid game moves
            else if(a == 2 && e1 == 1 && g1 == 0)
                g1 = 2;
            else if(a == 1 && e1 == 2 && i == 1 && h == 0)
                h = 2;
            else if(c == 1 && e1 == 2 && g1 == 1 && h == 0)
                h = 2;
            else if(e1 == 2 && h == 1 && f == 1 && i == 0)
                i = 2;
            else if(e1 == 2 && a == 1 && h == 1 && g1 == 0)
                g1 = 2;
            else if(e1 == 2 && c == 1 && h == 1 && i == 0)
                i = 2;
            else if(f == 1 && g1 == 1 && e1 == 2 && c == 0)
                c = 2;
            else if(a == 0)
                a = 2;
            else if(b == 0)
                b = 2;
            else if(c == 0)
                c = 2;
            else if(d == 0)
                d = 2;
            else if(e1 == 0)
                e1 = 2;
            else if(f == 0)
                f = 2;
            else if(g1 == 0)
                g1 = 2;
            else if(h == 0)
                h = 2;
            else if(i == 0)
                i = 2;
            turn = 1;
        }
    }

    public void checkWinner()
    {
        //check if player 1 wins
        if(a == 1 && b == 1 && c == 1)
        {
            screen = 4;
        }
        else if(d == 1 && e1 == 1 && f == 1)
        {
            screen = 4;
        }
        else if(g1 == 1 && h == 1 && i == 1)
        {
            screen = 4;
        }
        else if(a == 1 && d == 1 && g1 == 1)
        {
            screen = 4;
        }
        else if(b == 1 && e1 == 1 && h == 1)
        {
            screen = 4;
        }
        else if(c == 1 && f == 1 && i == 1)
        {
            screen = 4;
        }
        else if(a == 1 && e1 == 1 && i == 1)
        {
            screen = 4;
        }
        else if(c == 1 && e1 == 1 && g1 == 1)
        {
            screen = 4;
        }

        //check if player 2 wins
        else if(a == 2 && b == 2 && c == 2)
        {
            screen = 5;
        }
        else if(d == 2 && e1 == 2 && f == 2)
        {
            screen = 5;
        }
        else if(g1 == 2 && h == 2 && i == 2)
        {
            screen = 5;
        }
        else if(a == 2 && d == 2 && g1 == 2)
        {
            screen = 5;
        }
        else if(b == 2 && e1 == 2 && h == 2)
        {
            screen = 5;
        }
        else if(c == 2 && f == 2 && i == 2)
        {
            screen = 5;
        }
        else if(a == 2 && e1 == 2 && i == 2)
        {
            screen = 5;
        }
        else if(c == 2 && e1 == 2 && g1 == 2)
        {
            screen = 5;
        }

        //check for tie
        else if (a != 0 && b != 0 && c != 0 && d != 0 && e1 != 0 && f != 0 && g1 != 0 && h != 0 && i != 0)
        {
            screen = 6;
        }

        repaint();
    }

    public void checkWinner3d()//checking winner for 3d mode
    {
        //check if player 1 wins
        //top board normal
        if(a2 == 1 && b2 == 1 && c2 == 1)
        {
            screen = 4;
        }
        else if(d2 == 1 && e2 == 1 && f2 == 1)
        {
            screen = 4;
        }
        else if(g2 == 1 && h2 == 1 && i2 == 1)
        {
            screen = 4;
        }
        else if(a2 == 1 && d2 == 1 && g2 == 1)
        {
            screen = 4;
        }
        else if(b2 == 1 && e2 == 1 && h2 == 1)
        {
            screen = 4;
        }
        else if(c2 == 1 && f2 == 1 && i2 == 1)
        {
            screen = 4;
        }
        else if(a2 == 1 && e2 == 1 && i2 == 1)
        {
            screen = 4;
        }
        else if(c2 == 1 && e2 == 1 && g2 == 1)
        {
            screen = 4;
        }

        //middle board normal
        else if(a3 == 1 && b3 == 1 && c3 == 1)
        {
            screen = 4;
        }
        else if(d3 == 1 && e3 == 1 && f3 == 1)
        {
            screen = 4;
        }
        else if(g3 == 1 && h3 == 1 && i3 == 1)
        {
            screen = 4;
        }
        else if(a3 == 1 && d3 == 1 && g3 == 1)
        {
            screen = 4;
        }
        else if(b3 == 1 && e3 == 1 && h3 == 1)
        {
            screen = 4;
        }
        else if(c3 == 1 && f3 == 1 && i3 == 1)
        {
            screen = 4;
        }
        else if(a3 == 1 && e3 == 1 && i3 == 1)
        {
            screen = 4;
        }
        else if(c3 == 1 && e3 == 1 && g3 == 1)
        {
            screen = 4;
        }

        //bottom board normal
        else if(a4 == 1 && b4 == 1 && c4 == 1)
        {
            screen = 4;
        }
        else if(d4 == 1 && e4 == 1 && f4 == 1)
        {
            screen = 4;
        }
        else if(g4 == 1 && h4 == 1 && i4 == 1)
        {
            screen = 4;
        }
        else if(a4 == 1 && d4 == 1 && g4 == 1)
        {
            screen = 4;
        }
        else if(b4 == 1 && e4 == 1 && h4 == 1)
        {
            screen = 4;
        }
        else if(c4 == 1 && f4 == 1 && i4 == 1)
        {
            screen = 4;
        }
        else if(a4 == 1 && e4 == 1 && i4 == 1)
        {
            screen = 4;
        }
        else if(c4 == 1 && e4 == 1 && g4 == 1)
        {
            screen = 4;
        }

        //vertical^2 wins
        else if(a2 == 1 && a3 == 1 && a4 == 1)
        {
            screen = 4;
        }
        else if(b2 == 1 && b3 == 1 && b4 == 1)
        {
            screen = 4;
        }
        else if(c2 == 1 && c3 == 1 && c4 == 1)
        {
            screen = 4;
        }
        else if(d2 == 1 && d3 == 1 && d4 == 1)
        {
            screen = 4;
        }
        else if(e2 == 1 && e3 == 1 && e4 == 1)
        {
            screen = 4;
        }
        else if(f2 == 1 && f3 == 1 && f4 == 1)
        {
            screen = 4;
        }
        else if(g2 == 1 && g3 == 1 && g4 == 1)
        {
            screen = 4;
        }
        else if(h2 == 1 && h3 == 1 && h4 == 1)
        {
            screen = 4;
        }
        else if(i2 == 1 && i3 == 1 && i4 == 1)
        {
            screen = 4;
        }

        //diagonal^2 wins
        else if(a2 == 1 && b3 == 1 && c4 == 1)
        {
            screen = 4;
        }
        else if(d2 == 1 && e3 == 1 && f4 == 1)
        {
            screen = 4;
        }
        else if(g2 == 1 && h3 == 1 && i4 == 1)
        {
            screen = 4;
        }
        else if(c2 == 1 && b3 == 1 && a4 == 1)
        {
            screen = 4;
        }
        else if(f2 == 1 && e3 == 1 && d4 == 1)
        {
            screen = 4;
        }
        else if(i2 == 1 && h3 == 1 && g4 == 1)
        {
            screen = 4;
        }

        else if(a2 == 1 && d3 == 1 && g4 == 1)
        {
            screen = 4;
        }
        else if(b2 == 1 && e3 == 1 && h4 == 1)
        {
            screen = 4;
        }
        else if(c2 == 1 && f3 == 1 && i4 == 1)
        {
            screen = 4;
        }
        else if(g2 == 1 && d3 == 1 && a4 == 1)
        {
            screen = 4;
        }
        else if(h2 == 1 && e3 == 1 && b4 == 1)
        {
            screen = 4;
        }
        else if(i2 == 1 && f3 == 1 && c4 == 1)
        {
            screen = 4;
        }

        //diagonal^3
        else if(a2 == 1 && e3 == 1 && i4 == 1)
        {
            screen = 4;
        }
        else if(i2 == 1 && e3 == 1 && a4 == 1)
        {
            screen = 4;
        }
        else if(c2 == 1 && e3 == 1 && g4 == 1)
        {
            screen = 4;
        }
        else if(g2 == 1 && e3 == 1 && c4 == 1)
        {
            screen = 4;
        }

        //check if player 2 wins
        //top board normal
        else if(a2 == 2 && b2 == 2 && c2 == 2)
        {
            screen = 5;
        }
        else if(d2 == 2 && e2 == 2 && f2 == 2)
        {
            screen = 5;
        }
        else if(g2 == 2 && h2 == 2 && i2 == 2)
        {
            screen = 5;
        }
        else if(a2 == 2 && d2 == 2 && g2 == 2)
        {
            screen = 5;
        }
        else if(b2 == 2 && e2 == 2 && h2 == 2)
        {
            screen = 5;
        }
        else if(c2 == 2 && f2 == 2 && i2 == 2)
        {
            screen = 5;
        }
        else if(a2 == 2 && e2 == 2 && i2 == 2)
        {
            screen = 5;
        }
        else if(c2 == 2 && e2 == 2 && g2 == 2)
        {
            screen = 5;
        }

        //middle board normal
        else if(a3 == 2 && b3 == 2 && c3 == 2)
        {
            screen = 5;
        }
        else if(d3 == 2 && e3 == 2 && f3 == 2)
        {
            screen = 5;
        }
        else if(g3 == 2 && h3 == 2 && i3 == 2)
        {
            screen = 5;
        }
        else if(a3 == 2 && d3 == 2 && g3 == 2)
        {
            screen = 5;
        }
        else if(b3 == 2 && e3 == 2 && h3 == 2)
        {
            screen = 5;
        }
        else if(c3 == 2 && f3 == 2 && i3 == 2)
        {
            screen = 5;
        }
        else if(a3 == 2 && e3 == 2 && i3 == 2)
        {
            screen = 5;
        }
        else if(c3 == 2 && e3 == 2 && g3 == 2)
        {
            screen = 5;
        }

        //bottom board normal
        else if(a4 == 2 && b4 == 2 && c4 == 2)
        {
            screen = 5;
        }
        else if(d4 == 2 && e4 == 2 && f4 == 2)
        {
            screen = 5;
        }
        else if(g4 == 2 && h4 == 2 && i4 == 2)
        {
            screen = 5;
        }
        else if(a4 == 2 && d4 == 2 && g4 == 2)
        {
            screen = 5;
        }
        else if(b4 == 2 && e4 == 2 && h4 == 2)
        {
            screen = 5;
        }
        else if(c4 == 2 && f4 == 2 && i4 == 2)
        {
            screen = 5;
        }
        else if(a4 == 2 && e4 == 2 && i4 == 2)
        {
            screen = 5;
        }
        else if(c4 == 2 && e4 == 2 && i4 == 2)
        {
            screen = 5;
        }

        //vertical^2 wins
        else if(a2 == 2 && a3 == 2 && a4 == 2)
        {
            screen = 5;
        }
        else if(b2 == 2 && b3 == 2 && b4 == 2)
        {
            screen = 5;
        }
        else if(c2 == 2 && c3 == 2 && c4 == 2)
        {
            screen = 5;
        }
        else if(d2 == 2 && d3 == 2 && d4 == 2)
        {
            screen = 5;
        }
        else if(e2 == 2 && e3 == 2 && e4 == 2)
        {
            screen = 5;
        }
        else if(f2 == 2 && f3 == 2 && f4 == 2)
        {
            screen = 5;
        }
        else if(g2 == 2 && g3 == 2 && g4 == 2)
        {
            screen = 5;
        }
        else if(h2 == 2 && h3 == 2 && h4 == 2)
        {
            screen = 5;
        }
        else if(i2 == 2 && i3 == 2 && i4 == 2)
        {
            screen = 5;
        }

        //diagonal^2 wins
        else if(a2 == 2 && b3 == 2 && c4 == 2)
        {
            screen = 5;
        }
        else if(d2 == 2 && e3 == 2 && f4 == 2)
        {
            screen = 5;
        }
        else if(g2 == 2 && h3 == 2 && i4 == 2)
        {
            screen = 5;
        }
        else if(c2 == 2 && b3 == 2 && a4 == 2)
        {
            screen = 5;
        }
        else if(f2 == 2 && e3 == 2 && d4 == 2)
        {
            screen = 5;
        }
        else if(i2 == 2 && h3 == 2 && g4 == 2)
        {
            screen = 5;
        }

        else if(a2 == 2 && d3 == 2 && g4 == 2)
        {
            screen = 5;
        }
        else if(b2 == 2 && e3 == 2 && h4 == 2)
        {
            screen = 5;
        }
        else if(c2 == 2 && f3 == 2 && i4 == 2)
        {
            screen = 5;
        }
        else if(g2 == 2 && d3 == 2 && a4 == 2)
        {
            screen = 5;
        }
        else if(h2 == 2 && e3 == 2 && b4 == 2)
        {
            screen = 5;
        }
        else if(i2 == 2 && f3 == 2 && c4 == 2)
        {
            screen = 5;
        }

        //diagonal^3
        else if(a2 == 2 && e3 == 2 && i4 == 2)
        {
            screen = 5;
        }
        else if(i2 == 2 && e3 == 2 && a4 == 2)
        {
            screen = 5;
        }
        else if(c2 == 2 && e3 == 2 && g4 == 2)
        {
            screen = 5;
        }
        else if(g2 == 2 && e3 == 2 && c4 == 2)
        {
            screen = 5;
        }

        repaint();
    }

    public void delay(int amount)//delays the switching screens
    {
        for (int i = 1; i<= amount; i++)
        {
            System.out.println(i);
        }
    }

    public void hardBoard(Graphics g)//3d board
    {
        g.drawImage(hardBoard, 0, 0, null);
        //place graphics for pieces
        //top board
        if(a2 == 1)
        {
            g.drawImage(hardX, 331, 5, null);
        }
        else if(a2 == 2)
        {
            g.drawImage(hardO, 331, 5, null);
        }
        if(b2 == 1)
        {
            g.drawImage(hardX, 467, 5, null);
        }
        else if(b2 == 2)
        {
            g.drawImage(hardO, 467, 5, null);
        }
        if(c2 == 1)
        {
            g.drawImage(hardX, 590, 5, null);
        }
        else if(c2 == 2)
        {
            g.drawImage(hardO, 590, 5, null);
        }
        if(d2 == 1)
        {
            g.drawImage(hardX, 274, 110, null);
        }
        else if(d2 == 2)
        {
            g.drawImage(hardO, 274, 110, null);
        }
        if(e2 == 1)
        {
            g.drawImage(hardX, 407, 110, null);
        }
        else if(e2 == 2)
        {
            g.drawImage(hardO, 407, 110, null);
        }
        if(f2 == 1)
        {
            g.drawImage(hardX, 548, 110, null);
        }
        else if(f2 == 2)
        {
            g.drawImage(hardO, 548, 110, null);
        }
        if(g2 == 1)
        {
            g.drawImage(hardX, 226, 216, null);
        }
        else if(g2 == 2)
        {
            g.drawImage(hardO, 226, 216, null);
        }
        if(h2 == 1)
        {
            g.drawImage(hardX, 356, 216, null);
        }
        else if(h2 == 2)
        {
            g.drawImage(hardO, 356, 216, null);
        }
        if(i2 == 1)
        {
            g.drawImage(hardX, 493, 216, null);
        }
        else if(i2 == 2)
        {
            g.drawImage(hardO, 493, 216, null);
        }

        //middle board
        if(a3 == 1)
        {
            g.drawImage(hardX, 331, 295, null);
        }
        else if(a3 == 2)
        {
            g.drawImage(hardO, 331, 295, null);
        }
        if(b3 == 1)
        {
            g.drawImage(hardX, 460, 295, null);
        }
        else if(b3 == 2)
        {
            g.drawImage(hardO, 460, 295, null);
        }
        if(c3 == 1)
        {
            g.drawImage(hardX, 590, 295, null);
        }
        else if(c3 == 2)
        {
            g.drawImage(hardO, 590, 295, null);
        }
        if(d3 == 1)
        {
            g.drawImage(hardX, 265, 401, null);
        }
        else if(d3 == 2)
        {
            g.drawImage(hardO, 265, 401, null);
        }
        if(e3 == 1)
        {
            g.drawImage(hardX, 407, 401, null);
        }
        else if(e3 == 2)
        {
            g.drawImage(hardO, 407, 401, null);
        }
        if(f3 == 1)
        {
            g.drawImage(hardX, 548, 401, null);
        }
        else if(f3 == 2)
        {
            g.drawImage(hardO, 548, 401, null);
        }
        if(g3 == 1)
        {
            g.drawImage(hardX, 226, 505, null);
        }
        else if(g3 == 2)
        {
            g.drawImage(hardO, 226, 505, null);
        }
        if(h3 == 1)
        {
            g.drawImage(hardX, 356, 505, null);
        }
        else if(h3 == 2)
        {
            g.drawImage(hardO, 356, 505, null);
        }
        if(i3 == 1)
        {
            g.drawImage(hardX, 493, 505, null);
        }
        else if(i3 == 2)
        {
            g.drawImage(hardO, 493, 505, null);
        }

        //bottom board
        if(a4 == 1)
        {
            g.drawImage(hardX, 331, 585, null);
        }
        else if(a4 == 2)
        {
            g.drawImage(hardO, 331, 585, null);
        }
        if(b4 == 1)
        {
            g.drawImage(hardX, 460, 585, null);
        }
        else if(b4 == 2)
        {
            g.drawImage(hardO, 460, 585, null);
        }
        if(c4 == 1)
        {
            g.drawImage(hardX, 590, 585, null);
        }
        else if(c4 == 2)
        {
            g.drawImage(hardO, 590, 585, null);
        }
        if(d4 == 1)
        {
            g.drawImage(hardX, 265, 690, null);
        }
        else if(d4 == 2)
        {
            g.drawImage(hardO, 265, 690, null);
        }
        if(e4 == 1)
        {
            g.drawImage(hardX, 407, 690, null);
        }
        else if(e4 == 2)
        {
            g.drawImage(hardO, 407, 690, null);
        }
        if(f4 == 1)
        {
            g.drawImage(hardX, 548, 690, null);
        }
        else if(f4 == 2)
        {
            g.drawImage(hardO, 548, 690, null);
        }
        if(g4 == 1)
        {
            g.drawImage(hardX, 226, 794, null);
        }
        else if(g4 == 2)
        {
            g.drawImage(hardO, 226, 794, null);
        }
        if(h4 == 1)
        {
            g.drawImage(hardX, 356, 794, null);
        }
        else if(h4 == 2)
        {
            g.drawImage(hardO, 356, 794, null);
        }
        if(i4 == 1)
        {
            g.drawImage(hardX, 493, 794, null);
        }
        else if(i4 == 2)
        {
            g.drawImage(hardO, 493, 794, null);
        }

        checkWinner3d();//check for a winner
    }

    public void selectScreen(Graphics g)//select screen for 3d or normal mode
    {
        g.drawImage(selectScreen, 0, 0, null);
    }

    public void player1Win(Graphics g) //if player 1 wins draw win screen
    {
        g.drawImage(background, 0, 0, null);
        g.drawImage(xWinScreen, 0, 0, null);
        g.drawImage(xImage, 310, 310, null);
    }

    public void player2Win(Graphics g) //if player 2 wins draw win screen
    {
        g.drawImage(background, 0, 0, null);
        g.drawImage(oWinScreen, 0, 0, null);
        g.drawImage(oImage, 310, 310, null);
    }

    public void tieScreen(Graphics g)//if both players tie draw tie screen
    {
        g.drawImage(background, 0, 0, null);
        g.drawImage(tieScreen, 0, 0, null);
        g.drawImage(xImage, 142, 227, null);
        g.drawImage(oImage, 516, 227, null);
    }

    public void resetBoard() //reset the board after playing
    {
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        e1 = 0;
        f = 0;
        g1 = 0;
        h = 0;
        i = 0;
        a2 = 0;
        b2 = 0;
        c2 = 0;
        d2 = 0;
        e2 = 0;
        f2 = 0;
        g2 = 0;
        h2 = 0;
        i2 = 0;
        a3 = 0;
        b3 = 0;
        c3 = 0;
        d3 = 0;
        e3 = 0;
        f3 = 0;
        g3 = 0;
        h3 = 0;
        i3 = 0;
        a4 = 0;
        b4 = 0;
        c4 = 0;
        d4 = 0;
        e4 = 0;
        f4 = 0;
        g4 = 0;
        h4 = 0;
        i4 = 0;
        turn = 1;
        playerSelectNum = 1;
        counter = 0;
    }

    public void mouseClicked(MouseEvent e)
    {

    }

    public void mousePressed(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();

        if(screen == 1)//if on the title screen
        {
            if(x >= 292 && x <= 607 && y >= 84 && y <= 274) //if vs bot is clicked
            {
                counter = 1;
                screen = 8;
                players = 1;
            }
            if(x >= 292 && x <= 607 && y >= 631 && y <= 821)//if vs player is clicked
            {
                screen = 7;
            }
        }

        else if(screen == 2 && players == 2)//if vs player easy is picked
        {
            if(x <= 297 && y<= 297 && a == 0)
            {
                if(turn == 1)
                {
                    a = 1;
                    turn = 2;
                }
                else
                {
                    a = 2;
                    turn = 1;
                }
            }
            if(x <= 597 && x >=303 && y <= 297 && b == 0)
            {
                if(turn == 1)
                {
                    b = 1;
                    turn = 2;
                }
                else
                {
                    b = 2;
                    turn = 1;
                }
            }
            if(x <= 900 && x >= 603 && y <= 297 && c == 0)
            {
                if(turn == 1)
                {
                    c = 1;
                    turn = 2;
                }
                else
                {
                    c = 2;
                    turn = 1;
                }
            }
            if(x <= 297 && y <= 597 && y >= 303 && d == 0)
            {
                if(turn == 1)
                {
                    d = 1;
                    turn = 2;
                }
                else
                {
                    d = 2;
                    turn = 1;
                }
            }
            if(x <= 597 && x >= 303 && y <= 597 && y >= 303 && e1 == 0)
            {
                if(turn == 1)
                {
                    e1 = 1;
                    turn = 2;
                }
                else
                {
                    e1 = 2;
                    turn = 1;
                }
            }
            if(x <= 900 && x >= 603 && y <= 597 && y >= 303 && f == 0)
            {
                if(turn == 1)
                {
                    f = 1;
                    turn = 2;
                }
                else
                {
                    f = 2;
                    turn = 1;
                }
            }
            if(x <= 297 && y >= 603 && g1 == 0)
            {
                if(turn == 1)
                {
                    g1 = 1;
                    turn = 2;
                }
                else
                {
                    g1 = 2;
                    turn = 1;
                }
            }
            if(x <= 597 && x >= 303 && y >= 603 && h == 0)
            {
                if(turn == 1)
                {
                    h = 1;
                    turn = 2;
                }
                else
                {
                    h = 2;
                    turn = 1;
                }
            }
            if(x <= 900 && x >= 603 && y >= 603 && i == 0)
            {
                if(turn == 1)
                {
                    i = 1;
                    turn = 2;
                }
                else
                {
                    i = 2;
                    turn = 1;
                }
            }
        }

        else if(screen == 2 && players == 1)//if vs bot is picked
        {
            if(x <= 297 && y <= 297 && a == 0)
            {
                if(turn == 1)
                {
                    a = 1;
                    turn = 2;
                }
            }
            if(x <= 597 && x >= 303 && y <= 297 && b == 0)
            {
                if(turn == 1)
                {
                    b = 1;
                    turn = 2;
                }
            }
            if(x <= 900 && x >= 603 && y <= 297 && c == 0)
            {
                if(turn == 1)
                {
                    c = 1;
                    turn = 2;
                }
            }
            if(x <= 297 && y <= 597 && y >= 303 && d == 0)
            {
                if(turn == 1)
                {
                    d = 1;
                    turn = 2;
                }
            }
            if(x <= 597 && x >= 303 && y <= 597 && y >= 303 && e1 == 0)
            {
                if(turn == 1)
                {
                    e1 = 1;
                    turn = 2;
                }
            }
            if(x <= 900 && x >= 603 && y <= 597 && y >= 303 && f == 0)
            {
                if(turn == 1)
                {
                    f = 1;
                    turn = 2;
                }
            }
            if(x <= 297 && y >= 603 && g1 == 0)
            {
                if(turn == 1)
                {
                    g1 = 1;
                    turn = 2;
                }
            }
            if(x <= 597 && x >= 303 && y >= 603 && h == 0)
            {
                if(turn == 1)
                {
                    h = 1;
                    turn = 2;
                }
            }
            if(x <= 900 && x >= 603 && y >= 603 && i == 0)
            {
                if(turn == 1)
                {
                    i = 1;
                    turn = 2;
                }
            }
            computerMove();
        }

        else if(screen == 3) //if 3d game is picked
        {
            //top board
            if(x >= 297 && x <= 410 && y <= 81 && y >= 16 && a2 == 0)
            {
                if(turn == 1)
                {
                    a2 = 1;
                    turn = 2;
                }
                else
                {
                    a2 = 2;
                    turn = 1;
                }
            }
            if(x >= 456 && x <= 540 && y <= 81 && y >= 16 && b2 == 0)
            {
                if(turn == 1)
                {
                    b2 = 1;
                    turn = 2;
                }
                else
                {
                    b2 = 2;
                    turn = 1;
                }
            }
            if(x >= 587 && x <= 675 && y <= 81 && y >= 16 && c2 == 0)
            {
                if(turn == 1)
                {
                    c2 = 1;
                    turn = 2;
                }
                else
                {
                    c2 = 2;
                    turn = 1;
                }
            }
            if(x >= 232 && x <= 346 && y >= 93 && y <= 192 && d2 == 0)
            {
                if(turn == 1)
                {
                    d2 = 1;
                    turn = 2;
                }
                else
                {
                    d2 = 2;
                    turn = 1;
                }
            }
            if(x >= 415 && x <= 473 && y >= 93 && y <= 192 && e2 == 0)
            {
                if(turn == 1)
                {
                    e2 = 1;
                    turn = 2;
                }
                else
                {
                    e2 = 2;
                    turn = 1;
                }
            }
            if(x >= 547 && x <= 606 && y >= 93 && y <= 192 && f2 == 0)
            {
                if(turn == 1)
                {
                    f2 = 1;
                    turn = 2;
                }
                else
                {
                    f2 = 2;
                    turn = 1;
                }
            }
            if(x >= 232 && x <= 298 && y >= 205 && y <= 287 && g2 == 0)
            {
                if(turn == 1)
                {
                    g2 = 1;
                    turn = 2;
                }
                else
                {
                    g2 = 2;
                    turn = 1;
                }
            }
            if(x >= 353 && x <= 428 && y >= 205 && y <= 287 && h2 == 0)
            {
                if(turn == 1)
                {
                    h2 = 1;
                    turn = 2;
                }
                else
                {
                    h2 = 2;
                    turn = 1;
                }
            }
            if(x >= 485 && x <= 580 && y >= 205 && y <= 287 && i2 == 0)
            {
                if(turn == 1)
                {
                    i2 = 1;
                    turn = 2;
                }
                else
                {
                    i2 = 2;
                    turn = 1;
                }
            }

            //middle board
            if(x >= 297 && x <= 410 && y <= 372 && y >= 305 && a3 == 0)
            {
                if(turn == 1)
                {
                    a3 = 1;
                    turn = 2;
                }
                else
                {
                    a3 = 2;
                    turn = 1;
                }
            }
            if(x >= 456 && x <= 540 && y <= 372 && y >= 305 && b3 == 0)
            {
                if(turn == 1)
                {
                    b3 = 1;
                    turn = 2;
                }
                else
                {
                    b3 = 2;
                    turn = 1;
                }
            }
            if(x >= 587 && x <= 675 && y <= 372 && y >= 305 && c3 == 0)
            {
                if(turn == 1)
                {
                    c3 = 1;
                    turn = 2;
                }
                else
                {
                    c3 = 2;
                    turn = 1;
                }
            }
            if(x >= 232 && x <= 346 && y >= 384 && y <= 484 && d3 == 0)
            {
                if(turn == 1)
                {
                    d3 = 1;
                    turn = 2;
                }
                else
                {
                    d3 = 2;
                    turn = 1;
                }
            }
            if(x >= 415 && x <= 473 && y >= 384 && y <= 484 && e3 == 0)
            {
                if(turn == 1)
                {
                    e3 = 1;
                    turn = 2;
                }
                else
                {
                    e3 = 2;
                    turn = 1;
                }
            }
            if(x >= 547 && x <= 606 && y >= 384 && y <= 484 && f3 == 0)
            {
                if(turn == 1)
                {
                    f3 = 1;
                    turn = 2;
                }
                else
                {
                    f3 = 2;
                    turn = 1;
                }
            }
            if(x >= 232 && x <= 298 && y >= 495 && y <= 574 && g3 == 0)
            {
                if(turn == 1)
                {
                    g3 = 1;
                    turn = 2;
                }
                else
                {
                    g3 = 2;
                    turn = 1;
                }
            }
            if(x >= 353 && x <= 428 && y >= 495 && y <= 574 && h3 == 0)
            {
                if(turn == 1)
                {
                    h3 = 1;
                    turn = 2;
                }
                else
                {
                    h3 = 2;
                    turn = 1;
                }
            }
            if(x >= 485 && x <= 580 && y >= 495 && y <= 574 && i3 == 0)
            {
                if(turn == 1)
                {
                    i3 = 1;
                    turn = 2;
                }
                else
                {
                    i3 = 2;
                    turn = 1;
                }
            }

            //bottom board
            if(x >= 297 && x <= 410 && y <= 662 && y >= 596 && a4 == 0)
            {
                if(turn == 1)
                {
                    a4 = 1;
                    turn = 2;
                }
                else
                {
                    a4 = 2;
                    turn = 1;
                }
            }
            if(x >= 456 && x <= 540 && y <= 662 && y >= 596 && b4 == 0)
            {
                if(turn == 1)
                {
                    b4 = 1;
                    turn = 2;
                }
                else
                {
                    b4 = 2;
                    turn = 1;
                }
            }
            if(x >= 587 && x <= 675 && y <= 662 && y >= 596 && c4 == 0)
            {
                if(turn == 1)
                {
                    c4 = 1;
                    turn = 2;
                }
                else
                {
                    c4 = 2;
                    turn = 1;
                }
            }
            if(x >= 232 && x <= 346 && y >= 675 && y <= 774 && d4 == 0)
            {
                if(turn == 1)
                {
                    d4 = 1;
                    turn = 2;
                }
                else
                {
                    d4 = 2;
                    turn = 1;
                }
            }
            if(x >= 415 && x <= 473 && y >= 675 && y <= 774 && e4 == 0)
            {
                if(turn == 1)
                {
                    e4 = 1;
                    turn = 2;
                }
                else
                {
                    e4 = 2;
                    turn = 1;
                }
            }
            if(x >= 547 && x <= 606 && y >= 675 && y <= 774 && f4 == 0)
            {
                if(turn == 1)
                {
                    f4 = 1;
                    turn = 2;
                }
                else
                {
                    f4 = 2;
                    turn = 1;
                }
            }
            if(x >= 232 && x <= 298 && y >= 786 && y <= 874 && g4 == 0)
            {
                if(turn == 1)
                {
                    g4 = 1;
                    turn = 2;
                }
                else
                {
                    g4 = 2;
                    turn = 1;
                }
            }
            if(x >= 353 && x <= 428 && y >= 786 && y <= 874 && h4 == 0)
            {
                if(turn == 1)
                {
                    h4 = 1;
                    turn = 2;
                }
                else
                {
                    h4 = 2;
                    turn = 1;
                }
            }
            if(x >= 485 && x <= 580 && y >= 786 && y <= 874 && i4 == 0)
            {
                if(turn == 1)
                {
                    i4 = 1;
                    turn = 2;
                }
                else
                {
                    i4 = 2;
                    turn = 1;
                }
            }
        }

        else if(screen == 4)//if you click on the x win screen
        {
            if(x >= 0 && y >= 0)
            {
                screen = 1;
                resetBoard();
            }
        }

        else if(screen == 5)//if you click on the o win screen
        {
            if(x >= 0 && y >= 0)
            {
                screen = 1;
                resetBoard();
            }
        }

        else if(screen == 6)//if you click on the tie screen
        {
            if(x >= 0 && y >= 0)
            {
                screen = 1;
                resetBoard();
            }
        }

        else if(screen == 7)//player/player mode select
        {
            if(x >= 292 && x <= 607 && y >= 84 && y <= 274) //if 3d is clicked
            {
                screen = 8;
                players = 2;
                counter = 3;
            }
            else if(x >= 292 && x <= 607 && y >= 631 && y <= 821)//if easy is clicked
            {
                screen = 8;
                players = 2;
                counter = 2;
            }
        }
        else if(screen == 8)//icon select
        {
            if(x >= 88 && x <= 378 && y >= 235 && y <= 380)//if ufo is clicked
            {
                if(!(counter2 == 1))//ensures that the ufo can only be selected once
                {
                    if(playerSelectNum == 1)//if its player 1s turn to choose
                    {
                        xImage = ufo;
                        hardX = ufo3d;
                        playerSelectNum++;
                        counter2 = 1;
                    }
                    else if(playerSelectNum == 2)//if its player 2s turn to choose
                    {
                        oImage = ufo;
                        hardO = ufo3d;
                        playerSelectNum++;
                        counter2 = 1;
                    }
                }
            }
            if(x >= 528 && x <= 805 && y >= 169 && y <= 446)//if earth is clicked
            {
                if(!(counter2 == 2))//ensures that the earth can only be selected once
                {
                    if(playerSelectNum == 1)//if its player 1s turn to choose
                    {
                        xImage = earth;
                        hardX = earth3d;
                        playerSelectNum++;
                        counter2 = 2;
                    }
                    else if(playerSelectNum == 2)//if its player 2s turn to choose
                    {
                        oImage = earth;
                        hardO = earth3d;
                        playerSelectNum++;
                        counter2 = 2;
                    }
                }
            }
            if(x >= 63 && x <= 401 && y >= 505 && y <= 843)//if galaxy is clicked
            {
                if(!(counter2 == 3))//ensures that the galaxy can only be selected once
                {
                    if(playerSelectNum == 1)//if its player 1s turn to choose
                    {
                        xImage = galaxy;
                        hardX = galaxy3d;
                        playerSelectNum++;
                        counter2 = 3;
                    }
                    else if(playerSelectNum == 2)//if its player 2s turn to choose
                    {
                        oImage = galaxy;
                        hardO = galaxy3d;
                        playerSelectNum++;
                        counter2 = 3;
                    }
                }
            }
            if(x >= 494 && x <= 840 && y >= 506 && y <= 843)//if sun is clicked
            {
                if(!(counter2 == 4))//ensures that the sun can only be selected once
                {
                    if(playerSelectNum == 1)//if its player 1s turn to choose
                    {
                        xImage = sun;
                        hardX = sun3d;
                        playerSelectNum++;
                        counter2 = 4;
                    }
                    else if(playerSelectNum == 2)//if its player 2s turn to choose
                    {
                        oImage = sun;
                        hardO = sun3d;
                        playerSelectNum++;
                        counter2 = 4;
                    }
                }
            }
        }
        repaint();
    }

    public void mouseReleased(MouseEvent e)
    {

    }

    public void mouseEntered(MouseEvent e)
    {

    }

    public void mouseExited(MouseEvent e)
    {

    }
}

