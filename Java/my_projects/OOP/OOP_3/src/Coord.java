package OOP.OOP_3.src;

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
