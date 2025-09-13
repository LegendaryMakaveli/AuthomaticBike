public class AutomaticBike {
    private String name;
    private int model;
    private String color;
    private boolean bikeIsOn = false;
    private boolean bikeIsOff = true;
    private int gear = 0;
    private int acceleration;
    private int deceleration;
    private int speed;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setModel(int newModel) {
        model = newModel;
    }

    public int getModel() {
        return model;
    }

    public void setColor(String newColor) {
        this.color = newColor;
    }

    public String getColor() {
        return color;
    }

    public void setBikeIsOn(String newBikeIsOn) {
        if(newBikeIsOn.equalsIgnoreCase("ON")) {
            bikeIsOn = true;
        }else {
            throw new IllegalArgumentException("Bike is not on");
        }
    }
    public boolean getBikeIsOn() {
        return bikeIsOn;
    }

    public void setBikeIsOff(String offBike) {
        if(bikeIsOn && offBike.equalsIgnoreCase("OFF") && acceleration == 0) {
            bikeIsOff = true;
        } else {
            throw new IllegalArgumentException("Bike is not off or in gear");
        }
    }

    public boolean getBikeIsOff() {
        return bikeIsOff;
    }

    public void setGear(int newGear) {
        if(bikeIsOn && newGear >= 1 && newGear <= 4) {
            gear = newGear;
        } else {
            throw new IllegalArgumentException("Gear is out of range");
        }
    }

    public int getGear() {
        return gear;
    }

    public void setAcceleration(int  newAcceleration) {
        if(bikeIsOn && gear >= 1 && gear <= 4) {
            if(gear == 1 && newAcceleration == 1) {
                acceleration++;
                try  {
                    Thread.sleep(3000);
                }catch(InterruptedException error){
                    error.getLocalizedMessage();
                }
                 speed = 20;

            } else if(newAcceleration > 1) {
                throw new IllegalArgumentException("Acceleration is out of range");
            }

            if(gear == 2 && newAcceleration == 1) {
                acceleration++;
                try  {
                    Thread.sleep(5000);
                }catch(InterruptedException error){
                    error.getLocalizedMessage();
                }
                speed = 30;
            }

            if(gear == 3 && newAcceleration == 1) {
                acceleration++;
                try  {
                    Thread.sleep(7000);
                }catch(InterruptedException error){
                    error.getLocalizedMessage();
                }
                speed = 40;
            }
            if(gear == 4 && newAcceleration == 1) {
                acceleration++;
                try  {
                    Thread.sleep(9000);
                }catch(InterruptedException error){
                    error.getLocalizedMessage();
                }
                speed = 50;
            }
        }
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setDeceleration(int brake) {
        if(bikeIsOn && gear <= 4 && gear >= 1) {
            if(gear == 4 && brake == 1) {
                deceleration++;
                try  {
                    Thread.sleep(3000);
                }catch(InterruptedException error){
                    error.getLocalizedMessage();
                }
                speed = 30;
            }
            if(gear == 3 && brake == 1) {
                deceleration++;
                try  {
                    Thread.sleep(3000);
                }catch(InterruptedException error){
                    error.getLocalizedMessage();
                }
                speed = 20;
            }
            if(gear == 2 && brake == 1) {
                deceleration++;
                try  {
                    Thread.sleep(3000);
                }catch(InterruptedException error){
                    error.getLocalizedMessage();
                }
                speed = 10;
            }
            if(gear == 1 && brake == 1) {
                deceleration++;
                try  {
                    Thread.sleep(5000);
                }catch(InterruptedException error){
                    error.getLocalizedMessage();
                }
                speed = 0;
            }
        }
    }

    public int getDeceleration() {
       return deceleration;
    }

    public void setAutomatic() {
        if(bikeIsOn && gear >= 1 && gear <= 4) {
            if(gear == 1 && speed == 20) {
                gear = 2;
            }else if(gear == 1 && speed == 10) {
                gear = 1;
            }

            if(gear == 2 && speed == 30) {
                gear = 3;
            }else if(gear == 2 && speed == 10) {
                gear = 1;
            }

            if(gear == 3 && speed == 40) {
                gear = 4;
            }else if(gear == 3 && speed == 20) {
                gear = 2;
            }

            if(gear == 4 && speed >= 40) {
                gear = 4;
            }else if(gear == 4 && speed == 30) {
                gear = 3;
            }
        }
    }

    public int getAutomatic() {
        return speed;
    }


}
