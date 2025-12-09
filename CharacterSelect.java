import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CharacterSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharacterSelect extends World
{

    /**
     * Constructor for objects of class CharacterSelect.
     * @author Tyler Sain
     */
    public CharacterSelect()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("./images/CharacterSelect.png");
    }
    public void act(){
        if (Greenfoot.isKeyDown("2")){
            Greenfoot.setWorld(new MyWorld("./images/Prof.png"));
        }
        if (Greenfoot.isKeyDown("1")){
            Greenfoot.setWorld(new MyWorld("./images/mainCharacter.png"));
        }
        if (Greenfoot.isKeyDown("3")){
            Greenfoot.setWorld(new MyWorld("./images/JohnPork.png"));
        }
    }
}
