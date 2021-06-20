package sample.System;

public class Room {
    private int roomID;
    private int roomCapacity;
    public boolean inUse = false;

    public Room(){

    }

    Room(Room room){
        roomID = room.roomID;
        roomCapacity = room.roomCapacity;
        inUse = room.inUse;
    }

    public Room(int ID, int capacity){
        roomID = ID;
        roomCapacity = capacity;
    }

    public int getRoomID(){
        return roomID;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

}
