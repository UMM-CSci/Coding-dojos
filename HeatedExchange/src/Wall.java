public class Wall {
    private double insulation;
    private Room room1;
    private Room room2;
    private double diff;
    
    public Wall(double initialInsulation, Room room1, Room room2) {
        insulation = initialInsulation;
        this.room1 = room1;
        this.room2 = room2;
    }

    public double getInsulation() {
        return insulation;
    }
    
    public Room getRoom1() {
        return room1;
    }
    
    public Room getRoom2() {
        return room2;
    }

    public void takeTemps() {
        diff = ((room1.getTemp() - room2.getTemp()) / 2) * insulation;
    }

    public void updateRoomTemps() {
        room1.updateTemp(-diff);
        room2.updateTemp(diff);
    }
    
    public void printDiffs() {
        System.out.println(diff);
    }
}
