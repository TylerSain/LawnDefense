import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mouse here.
 * 
 * @author Tyler Sain
 * @version 0.1
 */
public class Mouse extends Actor
{
    /**
     * @author Tyler Sain
    **/
    public void act() {
        if (getWorld() == null) return;
        setRotation(180);
        move(1);
        if (worldInteractions()) {
            return;
        }
    }
    /**
     * This method controls the World Interactions
     * Ex. Controls if the Mouse object intersects the Lawn or and removes the object if it shot
     * @author Tyler Sain
     */

    public boolean worldInteractions(){
        World w = getWorld();
        MyWorld mw = (MyWorld) w;
        if (w == null) {return true;} // means already been removed
        
        if(getX() <= 189){
            if (mw != null) {
            mw.loseLife();
            }
            w.removeObject(this);
            return true;
        }
        Actor bullet = getOneIntersectingObject(Bullet.class);

        if (bullet != null) {
            mw.addScore(1);
            w.removeObject(bullet);
            w.removeObject(this);
            return true; 
        }
    return false;
    
    }
}
