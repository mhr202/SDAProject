package sample.System;

public class Allocation {
    private int time;
    private Section section;
    private int Room;

    public Allocation(int ti, Section se, int room) {
        time = ti;
        section = se;
        Room = room;
    }

    public int getTime(){
        return time;
    }
}
