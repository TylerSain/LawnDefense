import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rabbit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rabbit extends Actor 
{
    /**
     * Act - do whatever the rabbit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int hp = 5;
    public void act(){
        setRotation(180);
        move(1);
        madeToFinish();
        gotShot();
    }
    public void gotShot(){
        Actor enemy = getOneIntersectingObject(Bullet.class);
        World world = getWorld();
        if (enemy != null) {
            if(hp <= 0){
            world.removeObject(enemy);
            world.removeObject(this);
        }
        else{
            hp = hp - 1;
            world.removeObject(enemy);
        }
            return;
        }
        
    }
    public void madeToFinish(){
        if(getX() == 189){
            //World world = getWorld();
            //getWorld().removeObject(this);
            MyWorld mw = (MyWorld) getWorld();
            mw.loseLife();
            //getWorld().removeObject(this);
        }
    }

}
