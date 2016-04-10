package doubled.greenrivertech.net.learningnumbers;

import java.util.Random;

/**
 * Created by Scott E on 4/10/2016.
 */
public class NumberModal
{
    private int leftnum;
    private int rightnum;
    private int score;
    private int plays;

    public NumberModal()
    {
        generate();
        score = 0;
        plays = 0;
    }

    public int getLeftnum()
    {
        return leftnum;
    }

    public int getRightnum()
    {
        return rightnum;
    }

    public int getScore()
    {
        return score;
    }

    public int getPlays()
    {
        return plays;
    }

    public void generate()
    {
        Random rand = new Random();
        leftnum = rand.nextInt(10) + 1;
        rightnum = 0;
        while (rightnum == leftnum || rightnum == 0)
        {
            rightnum = rand.nextInt(10) + 1;
        }
    }

    public boolean play(int choice)
    {
        plays++;

        if (choice == 0)
        {
            if (leftnum > rightnum)
            {
                score++;
                return true;
            }
        }
        else
        {
            if (rightnum > leftnum)
            {
                score++;
                return true;
            }
        }
        return false;
    }

    public String toString()
    {
        return leftnum + " " + rightnum + " " + score;
    }
}
