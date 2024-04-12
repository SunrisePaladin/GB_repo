package OOP.OOP_5.src;

import java.util.ArrayList;

public class Coord {
    private int curX=0;
    private int curY=0;
    public int width = 10, height=10;
    public Coord(int _x, int _y) {
        curX = _x;
        curY = _y;
    }

    public Coord(){
        curX = 0;
        curY = 0;
    }

    @Override 
    public boolean equals(Object obj) {
        // if (!(obj instanceof Coord)) {
        //     return false;
        // }
        Coord other = (Coord)obj;
        return curX==other.getX() && curY==other.getY();
    }


    public int find_distance(Coord c){
        return (int)
        Math.ceil(
            Math.sqrt(Math.pow(c.getX()-curX, 2) 
            + Math.pow(c.getY()-curX, 2))
        ); //надо полностью покрыть клетку для атаки
    }

    
    public boolean can_move(int curX, int curY) {
        return curX>=0  && curX<width && curY>=0 && curY<height;
    }

    //приоритет движения по иксу
    public boolean move_direction_x(Coord c){
        return (Math.abs(c.getX() - curX) > Math.abs(c.getY() - curY));
    }

    //только для ближнего боя?
    public ArrayList<Coord> find_nearest(Coord c){
        ArrayList<Coord> possiblePos = new ArrayList<Coord>();
        for (int i=-1; i <= 1; i++) {
            for (int j=-1; j<=1; j++){
                if (i != 0 && j != 0)
                if (can_move(c.getX()+i, c.getY()+j)) possiblePos.add(new Coord(c.getX()+i, c.getY()+j));
            }
        }
        return possiblePos;
    }

    public void move_to(int dX, int dY){
        if (can_move(dX, dY)){
            curX = dX;
            curY = dY;
        }
    }

    public int getX(){
        return curX;
    }

    public int getY(){
        return curY;
    }
}
