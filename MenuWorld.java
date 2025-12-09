import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the Menu World that appears at the start of the game
 * 
 * @author Ben Kaufman
 */
public class MenuWorld extends World
{
    /**
     * Constructor for objects of class MenuWorld.
     */
    public MenuWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("./images/MainMenu.png");
    }
    /**
     * This method switches to the Character Select screen when the spacebar is pressed
     * @author Ben Kaufman
     */
    public void act(){
        if (Greenfoot.isKeyDown("space")){
            Greenfoot.setWorld(new CharacterSelect());
        }
    }
}
