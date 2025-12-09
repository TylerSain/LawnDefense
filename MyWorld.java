import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Tyler Sain and Ben Kaufman
 * @version 0.1
 */

 

public class MyWorld extends World
{
    private int currentWave = 1; 
    private long startTime = 0;
    public int lives = 3;
    private int score = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    String imagePath;
    public MyWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        startTime = System.currentTimeMillis();
        imagePath = "./images/mainCharacter.png";
        setBackground("./images/worldOne.png");
        prepare();
        Wave1();
        updateHearts();
    }
    public MyWorld(String CharacterImage)
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        imagePath = CharacterImage;
        setBackground("./images/worldOne.png");
        prepare();
        Wave1();
        startTime = System.currentTimeMillis();
        updateHearts();
    }
    
    public void act(){
        if(currentWave == 1 && timer(5000)) {
            Wave2();
            currentWave = 2;
            resetTimer();
        }
        else if(currentWave == 2 && timer(5000)) {
            Wave3();
            currentWave = 3;
            resetTimer();
        }
        if(currentWave == 3 && (getObjects(Mouse.class).size() + getObjects(Rabbit.class).size() == 0)){
            gameWon();
            showText("Play again? Press R", getWidth()/2, getHeight()/2 + 50);
        }
        if(Greenfoot.isKeyDown("r")){
                Greenfoot.setWorld(new MenuWorld());
        }
            
        showScore();
    }
    private void prepare(){
        addObject(new mainCharacter(imagePath),213,200);
        showScore();
    }
    
    /* This is our total scoring system
    */    
    /**
     * Adds points to the player's score
     * @author Tyler Sain
     * @param points The number of points to add
     */
    public void addScore(int points){
        score += points;
    }
    /**
     * @author Tyler Sain
     * @return The player's current score
     */
    public int getScore(){
        return score;
    }
    /**
     * @author Tyler Sain
     * Displays the player's current score on the screen
     */
    private void showScore(){
        showText("Score: " + score, 70, 30);
    }
    
    
    /** This is the timer to set a time between waves
    @author Tyler Sain
    @param waitTime The time to wait in milliseconds
    @return whether the wait time has been reached 
    */
    private boolean timer(int waitTime){
        long currentTime = System.currentTimeMillis();
        if(currentTime - startTime >= waitTime){
            return true;
        }
        else{
            return false;
        }
    }
    
     private void resetTimer(){
        startTime = System.currentTimeMillis();
    }
    

    /**
     * @author Tyler Sain and Ben Kaufman
     * Wave 1 function that spawns a set number of enemies
     */
    private void Wave1(){
        for(int i = 0; i <= Greenfoot.getRandomNumber(10); i++){
            addObject(new Mouse(), 500, Greenfoot.getRandomNumber(300));
        }
        for(int i = 0; i <= Greenfoot.getRandomNumber(5); i++){
            addObject(new Rabbit(), 600, Greenfoot.getRandomNumber(300));
        }
        
    }
    /**
     * @author Tyler Sain and Ben Kaufman
     * Wave 2 function that spawns a set number of enemies
     */
    private void Wave2(){
        for(int i = 0; i <= Greenfoot.getRandomNumber(5); i++){
            addObject(new Mouse(), 600, Greenfoot.getRandomNumber(300));
        }
        for(int i = 0; i <= Greenfoot.getRandomNumber(10); i++){
            addObject(new Rabbit(), 600, Greenfoot.getRandomNumber(300));
        }
    }
    /**
     * @author Tyler Sain and Ben Kaufman
     * Wave \3 function that spawns a set number of enemies
     */
    private void Wave3(){
        for(int i = 0; i <= Greenfoot.getRandomNumber(15); i++){
            addObject(new Rabbit(), 600, Greenfoot.getRandomNumber(300));
        }
        
    }

    /** This method reduces the player's lives by 1 and updates the heart display
     *   @author Ben Kaufman
    */
    public void loseLife(){
        lives--;
        updateHearts();            
        if (lives <= 0) {
            gameOver();
        }
    }
    public int getLives() {
        return lives;
    }
    private void updateHearts() {
        //clear board
        removeObjects(getObjects(Hearts.class));
                
        int startX = 600 - 50; //First Heart X location
        int Y = 36; 
        int spacing = 75;
        
        for(int i = 0; i < lives; i++){
            addObject(new Hearts(), startX - (spacing * i), Y);
        }
    } 
        
    private void gameOver() {
        showText("GAME OVER", getWidth()/2, getHeight()/2);
        showText("Play again? Press R", getWidth()/2, getHeight()/2 + 50);
    }
    private void gameWon(){
        showText("GAME WON!", getWidth()/2, getHeight()/2);
    }
}
