
import java.util.Scanner;


public class Score 
{
    public String name;
    public int points;
    
    public Score()
    {
        name = "ABC";
        points = 100;
    }
    
    public void addPoints(int newPoints)
    {
        points = points + newPoints;
    }
    
    public void takePoints(int pointsAway)
    {
        points = points - pointsAway;
    }
    
    public void setPoints(int pointValue)
    {
        points = pointValue;
    }
    
    public int getPoints()
    {
        return points;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String newName)
    {
      name = newName;  
    }
    
}
