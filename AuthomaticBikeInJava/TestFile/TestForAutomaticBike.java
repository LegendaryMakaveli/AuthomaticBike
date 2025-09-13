import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestForAutomaticBike {

    @Test
    public void TestThatCreateAutomaticBike() {
        // ARRANGE
        String name = "MAKAVELI AUTO";
        int model = 2901;
        String color = "DEEP BLACK";

        AutomaticBike myAutomaticBike = new AutomaticBike();
        myAutomaticBike.setName(name);
        myAutomaticBike.setModel(model);
        myAutomaticBike.setColor(color);

        assertEquals(name, myAutomaticBike.getName());
        assertEquals(model, myAutomaticBike.getModel());
        assertEquals(color, myAutomaticBike.getColor());
    }

    @Test
    public void TestThatTheAutomaticBikeWeCreateIsOn() {
        AutomaticBike myAutomaticBike = new AutomaticBike();
        myAutomaticBike.setBikeIsOn("ON");

        assertTrue(myAutomaticBike.getBikeIsOn(), "ON");
    }

    @Test
    public void TestThatTheAutomaticBikeWeCreateIsOnWithValidInput() {
        AutomaticBike myAutomaticBike = new AutomaticBike();
        myAutomaticBike.setBikeIsOn("ON");

        assertTrue(myAutomaticBike.getBikeIsOn(), "YES");
    }

    @Test
    public void TestThatTheAutomaticBikeWeCreateIsInGear() {
        AutomaticBike myAutomaticBike = new AutomaticBike();
        myAutomaticBike.setBikeIsOn("ON");
        myAutomaticBike.setGear(2);

        assertEquals(2, myAutomaticBike.getGear());
    }

    @Test
    public void TestThatTheAutomaticBikeWeCreateIsInGearAndItNotBelowGearRange() {
        AutomaticBike myAutomaticBike = new AutomaticBike();
        myAutomaticBike.setBikeIsOn("ON");

        assertThrows(IllegalArgumentException.class, () -> myAutomaticBike.setGear(0));

    }

    @Test
    public void TestThatTheAutomaticBikeWeCreateIsInGearAndItNotAboveGearRange() {
        AutomaticBike myAutomaticBike = new AutomaticBike();
        myAutomaticBike.setBikeIsOn("ON");

        assertThrows(IllegalArgumentException.class, () -> myAutomaticBike.setGear(5));
    }

    @Test
    public void TestThatTheAutomaticBikeWeCreateIsOnAndItInFirstGearAndItCanAccelerateToGivenSpeedAndAutomaticallyChangeToSecondGear() {
        AutomaticBike myAutomaticBike = new AutomaticBike();
        myAutomaticBike.setBikeIsOn("ON");
        myAutomaticBike.setGear(1);
        myAutomaticBike.setAcceleration(1);
        myAutomaticBike.setAutomatic();

        assertEquals(20, myAutomaticBike.getAutomatic());
        assertEquals(1, myAutomaticBike.getAcceleration());
        assertEquals(2, myAutomaticBike.getGear());
    }

    @Test
    public void TestThatTheAutomaticBikeWeCreateIsOnAndItInSecondGearAndItCanAccelerateToGivenSpeedAndAutomaticallyChangeToThirdGear() {
        AutomaticBike myAutomaticBike = new AutomaticBike();
        myAutomaticBike.setBikeIsOn("ON");
        myAutomaticBike.setGear(2);
        myAutomaticBike.setAcceleration(1);
        myAutomaticBike.setAutomatic();

        assertEquals(30, myAutomaticBike.getAutomatic());
        assertEquals(1, myAutomaticBike.getAcceleration());
        assertEquals(3, myAutomaticBike.getGear());
    }

    @Test
    public void TestThatTheAutomaticBikeWeCreateIsOnAndItInThirdGearAndItCanAccelerateToGivenSpeedAndAutomaticallyChangeToFourthGear() {
        AutomaticBike myAutomaticBike = new AutomaticBike();
        myAutomaticBike.setBikeIsOn("ON");
        myAutomaticBike.setGear(3);
        myAutomaticBike.setAcceleration(1);
        myAutomaticBike.setAutomatic();

        assertEquals(40, myAutomaticBike.getAutomatic());
        assertEquals(1, myAutomaticBike.getAcceleration());
        assertEquals(4, myAutomaticBike.getGear());
    }

    @Test
    public void TestThatTheAutomaticBikeWeCreateIsOnAndItInFourthGearAndItCanAccelerateToGivenSpeedAndStillRemainInTheFourthGear() {
        AutomaticBike myAutomaticBike = new AutomaticBike();
        myAutomaticBike.setBikeIsOn("ON");
        myAutomaticBike.setGear(4);
        myAutomaticBike.setAcceleration(1);
        myAutomaticBike.setAutomatic();

        assertEquals(50, myAutomaticBike.getAutomatic());
        assertEquals(1, myAutomaticBike.getAcceleration());
        assertEquals(4, myAutomaticBike.getGear());
    }

    @Test
    public void TestThatTheAutomaticBikeWeCreateIsOnFourthGearAndItCanDecelerateToGivenSpeedAndAutomaticallyChangeToThirdGear() {
        AutomaticBike myAutomaticBike = new AutomaticBike();
        myAutomaticBike.setBikeIsOn("ON");
        myAutomaticBike.setGear(4);
        myAutomaticBike.setDeceleration(1);
        myAutomaticBike.setAutomatic();

        assertEquals(30, myAutomaticBike.getAutomatic());
        assertEquals(1, myAutomaticBike.getDeceleration());
        assertEquals(3, myAutomaticBike.getGear());
    }

    @Test
    public void TestThatTheAutomaticBikeWeCreateIsOnThirdGearAndItCanDecelerateToGivenSpeedAndAutomaticallyChangeToSecondGear() {
        AutomaticBike myAutomaticBike = new AutomaticBike();
        myAutomaticBike.setBikeIsOn("ON");
        myAutomaticBike.setGear(3);
        myAutomaticBike.setDeceleration(1);
        myAutomaticBike.setAutomatic();

        assertEquals(20, myAutomaticBike.getAutomatic());
        assertEquals(1, myAutomaticBike.getDeceleration());
        assertEquals(2, myAutomaticBike.getGear());
    }
    @Test
    public void TestThatTheAutomaticBikeWeCreateIsOnSecondGearAndItCanDecelerateToGivenSpeedAndAutomaticallyChangeToFirstGear() {
        AutomaticBike myAutomaticBike = new AutomaticBike();
        myAutomaticBike.setBikeIsOn("ON");
        myAutomaticBike.setGear(2);
        myAutomaticBike.setDeceleration(1);
        myAutomaticBike.setAutomatic();

        assertEquals(10, myAutomaticBike.getAutomatic());
        assertEquals(1, myAutomaticBike.getDeceleration());
        assertEquals(1, myAutomaticBike.getGear());
    }

    @Test
    public void TestThatTheAutomaticBikeWeCreateIsOnFirstGearAndItCanDecelerateToGivenSpeedAndStopTheBike() {
        AutomaticBike myAutomaticBike = new AutomaticBike();
        myAutomaticBike.setBikeIsOn("ON");
        myAutomaticBike.setGear(1);
        myAutomaticBike.setDeceleration(1);
        myAutomaticBike.setAutomatic();

        assertEquals(0, myAutomaticBike.getAutomatic());
        assertEquals(1, myAutomaticBike.getDeceleration());
        assertEquals(1, myAutomaticBike.getGear());
    }

    @Test
    public void TestThatTheAutomaticBikeWeCreateIsONThenTurnedOff() {
        AutomaticBike myAutomaticBike = new AutomaticBike();
        myAutomaticBike.setBikeIsOn("ON");
        myAutomaticBike.setBikeIsOff("OFF");

        assertTrue(myAutomaticBike.getBikeIsOff(), "Off");
        assertThrows(IllegalArgumentException.class, () -> myAutomaticBike.setBikeIsOff("20"));
    }
}
