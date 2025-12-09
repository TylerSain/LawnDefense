import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is the controller of the Character that interacts with the world
 * 
 * @author Tyler Sain and Ben Kaufman
 * @version 0.1
 */
public class mainCharacter extends Actor
{
    private boolean buttonWasDown = false;
    private boolean oneButtonWasDown = false;
    private boolean twoButtonWasDown = false;
    /**
     * Actions like shoot and control movement
     * @author Tyler Sain
     */
    public void act()
    {
        control();
        shoot();
        
    }
    /**
     * Constructor for the mainCharacter class
     * @author Tyler Sain
     */
    public mainCharacter()
    {
        setImage("./images/mainCharacter.png"); // default image
    }
    /**
     * Constructor for the mainCharacter class
     * @author Tyler Sain
     * @param imagePath The file path for the character image
     */
    public mainCharacter(String imagePath)
    {
        setImage(imagePath);
    }
    /**
     * @author Tyler Sain
    * This is the controls for the character, W and UP to move, S and Down to move South   
    * */
    private void control(){
        if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")){
            setRotation(270);
            move(4);
            setRotation(0);
            
        }
        if(Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")){
            setRotation(90);
            move(4);
            setRotation(0);
        }
    }
    /**
     * The shooting function for the character, also prevents overfiring
    * @author Tyler Sain
    * */
    private void shoot(){
        boolean buttonDown = Greenfoot.isKeyDown("space");
    
        if (buttonDown && !buttonWasDown) {
            getWorld().addObject(new Bullet(), getX() + 50, getY());
            setRotation(0);
        }
    
        buttonWasDown = buttonDown;
        
    }

}

