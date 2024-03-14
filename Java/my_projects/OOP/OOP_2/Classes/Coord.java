package OOP.OOP_2.Classes;

public class Coord {
    private int x=0;
    private int y=0;
    public int width = 10, height=10;
    public Coord(int _x, int _y) {
        x = _x;
        y = _y;

    }

    public boolean can_move(int curX, int curY) {
        return curX>=0  && curX<width && curY>=0 && curY<height;
    }

    public void move_to(int dX, int dY){
        if (can_move(dX, dY)){
            x = dX;
            y = dY;
        }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
