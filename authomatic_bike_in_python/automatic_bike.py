import time

class AutoBike:
    def __init__(self):
        self.current_gear = 0
        self.speed = 0
        self.is_on = False

    def turn_on(self):
        time.sleep(1)
        self.is_on = True


    def put_gear(self, gear):
        if not self.is_on:
            return False

        if isinstance(gear, float):
            raise ValueError("Gear must be in whole number")
        if isinstance(gear, str):
            raise ValueError('Gear must be in int')

        if gear in range(1, 5):
            self.current_gear = gear
            return self.current_gear
        raise ValueError("Gear must be in range 1 to 4")


    def accelerate(self, acceleration):
        if isinstance(acceleration, float) or isinstance(acceleration, str):
            raise ValueError('Pree acceleration must be in int')

        if self.is_on and self.current_gear == 1 and acceleration == 1:
            time.sleep(3)
            self.speed = 20

        elif self.is_on and self.current_gear == 2 and acceleration == 1:
            time.sleep(5)
            self.speed = 30

        elif self.is_on and self.current_gear == 3 and acceleration == 1:
            time.sleep(5)
            self.speed = 40

        elif self.is_on and self.current_gear == 4 and acceleration == 1:
            time.sleep(6)
            self.speed = 50

        if self.speed >= 20 :
            self.current_gear = 2
        if self.speed >= 30 :
            self.current_gear = 3
        if self.speed >= 40 :
            self.current_gear = 4
        if self.speed >= 50 :
            self.current_gear = 4

        return self.speed,self.current_gear


    def decelerate(self, press_break):
        if isinstance(press_break, float) or isinstance(press_break, str):
            raise ValueError('Press break must be in int')

        if self.is_on and self.current_gear == 4 and press_break == 1:
            time.sleep(3)
            self.speed = 30

        elif self.is_on and self.current_gear == 3 and press_break == 1:
            time.sleep(3)
            self.speed = 20

        elif self.is_on and self.current_gear == 2 and press_break == 1:
            time.sleep(3)
            self.speed = 10

        elif self.is_on and self.current_gear == 1 and press_break == 1:
            time.sleep(3)
            self.speed = 0

        if self.speed <= 30:
            self.current_gear = 3
        if self.speed <= 20:
            self.current_gear = 2
        if self.speed <= 10:
            self.current_gear = 1
        if self.speed <= 0:
            self.current_gear = 0

        return self.speed, self.current_gear

    def turn_off(self) :
        if self.is_on and self.current_gear == 0 and self.speed == 0:
            time.sleep(1)
            return True
        else:
            return False