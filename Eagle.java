public class Eagle extends Bird implements Fly {

    private boolean flying;
    private int altitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    @Override
    public String sing() {
        return "Screech!";
    }    
    public int getAltitude(){
        return altitude;
    }    

    public boolean isFlying() {
        return flying;
    }

    //Flying starts on the ground!
    @Override
    public void takeOff() {
        if (!this.flying && this.altitude == 0) {
            this.flying = true;
            System.out.printf("%s takes off in the sky.%n", this.getName());
        }
    }

    //Flying upwards: altitude increases       
    @Override
    public int ascend (int meters) {
        if (this.flying) {
            this.altitude = Math.min(this.altitude + meters, 325);
            System.out.printf("%s flies upwards, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }
      
          
    //Flying downwards: altitude decreases
    @Override
    public int descend(int meters) {
        if (this.flying) {
            this.altitude = Math.max(this.altitude - meters, 0);
            System.out.printf("%s flies downwards, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }
    //Landing: needs to be on the ground
    @Override
    public void land() {
        if (this.flying && this.altitude == 1){
            this.flying = true;
            System.out.printf("%s lands on the ground.%n", this.getName());
        } 
    }
}
