import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class BallAnimation4
{
    private static void createAndShowUI()
    {
        BallPanel panel = new BallPanel(1000);

        JFrame frame = new JFrame("BallAnimation4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add( panel );
        frame.pack();
        frame.setVisible( true );

        panel.startAnimation();
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }

    static class BallPanel extends JPanel implements ActionListener
    {
        private ArrayList<Ball> balls = new ArrayList<Ball>();

        public BallPanel(int ballCount)
        {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            setLayout( null );
            setBackground( Color.BLACK );

            Random random = new Random();

            for (int i = 0; i < ballCount; i++)
            {
                Ball ball = new Ball();
                ball.setRandomColor(true);
                ball.setLocation(random.nextInt(screenSize.width), random.nextInt(screenSize.height));
                ball.setMoveRate(32, 32, 1, 1, true);
                ball.setSize(32, 32);
                balls.add( ball );
            }
        }

        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            for (Ball ball: balls)
            {
                ball.draw(g);
            }
        }

        public void startAnimation()
        {
            Timer timer = new Timer(75, this);
            timer.start();
        }

        public void actionPerformed(ActionEvent e)
        {
            move();
            repaint();
        }

        private void move()
        {
            for (Ball ball : balls)
            {
                ball.move(this);
            }
        }
    }

    static class Ball
    {
        public Color color = Color.BLACK;

        public int x = 0;
        public int y = 0;
        public int width  = 1;
        public int height = 1;

        private int moveX = 1;
        private int moveY = 1;
        private int directionX = 1;
        private int directionY = 1;
        private int xScale = moveX;
        private int yScale = moveY;

        private boolean randomMove = false;
        private boolean randomColor = false;
        private Random myRand = null;

        public Ball()
        {
            myRand = new Random();
            setRandomColor(randomColor);
        }

        public void move(JPanel parent)
        {
            int iRight = parent.getSize().width;
            int iBottom = parent.getSize().height;

            x += 5 + (xScale * directionX);
            y += 5 + (yScale * directionY);

            if (x <= 0)
            {
                x = 0;
                directionX *= (-1);
                xScale = randomMove ? myRand.nextInt(moveX) : moveX;
                if (randomColor) setRandomColor(randomColor);
            }

            if (x >= iRight - width)
            {
                x = iRight - width;
                directionX *= (-1);
                xScale = randomMove ? myRand.nextInt(moveX) : moveX;
                if (randomColor) setRandomColor(randomColor);
            }

            if (y <= 0)
            {
                y = 0;
                directionY *= (-1);
                yScale = randomMove ? myRand.nextInt(moveY) : moveY;
                if (randomColor) setRandomColor(randomColor);
            }

            if (y >= iBottom - height)
            {
                y = iBottom - height;
                directionY *= (-1);
                yScale = randomMove ? myRand.nextInt(moveY) : moveY;
                if (randomColor) setRandomColor(randomColor);
            }
        }

        public void draw(Graphics g)
        {
            g.setColor(color);
            g.fillOval(x, y, width, height);
        }

        public void setColor(Color c)
        {
            color = c;
        }

        public void setLocation(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public void setMoveRate(int xMove, int yMove, int xDir, int yDir, boolean randMove)
        {
            this.moveX = xMove;
            this.moveY = yMove;
            directionX  = xDir;
            directionY  = yDir;
            randomMove  = randMove;
        }

        public void setRandomColor(boolean randomColor)
        {
            this.randomColor = randomColor;

            switch (myRand.nextInt(3))
            {
                case 0:  color = Color.BLUE;
                         break;
                case 1:  color = Color.GREEN;
                         break;
                case 2:  color = Color.RED;
                         break;
                default: color = Color.BLACK;
                         break;
            }
        }

        public void setSize(int width, int height)
        {
            this.width  = width;
            this.height = height;
        }
    }

}