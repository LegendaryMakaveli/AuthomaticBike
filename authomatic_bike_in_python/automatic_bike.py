import time

current_gear = 0
speed = 0

def turn_the_bike_on():
    time.sleep(1)
    return True


def put_bike_in_gear(gear):
    global current_gear
    if not turn_the_bike_on:
        return False
    else:
        if isinstance(gear, float) or isinstance(gear, str):
            raise ValueError('Gear must be in int')

        if gear in range(1, 5):
            current_gear = gear
            return current_gear
        else:
            raise ValueError('Gear must be in range 1 to 4')


def accelerate(press_acceleration):
    global speed, current_gear
    if isinstance(press_acceleration, float) or isinstance(press_acceleration, str):
        raise ValueError('Pree acceleration must be in int')
    if turn_the_bike_on() and current_gear == 1 and press_acceleration == 1:
        time.sleep(3)
        speed = 20

    elif turn_the_bike_on() and current_gear == 2 and press_acceleration == 1:
        time.sleep(5)
        speed = 30

    elif turn_the_bike_on() and current_gear == 3 and press_acceleration == 1:
        time.sleep(5)
        speed = 40

    elif turn_the_bike_on() and current_gear == 4 and press_acceleration == 1:
        time.sleep(6)
        speed = 50

    if speed >= 20 :
        current_gear = 2
    if speed >= 30 :
        current_gear = 3
    if speed >= 40 :
        current_gear = 4
    if speed >= 50 :
        current_gear = 4

    return speed,current_gear


def decelerate(press_break):
    global speed, current_gear
    if isinstance(press_break, float) or isinstance(press_break, str):
        raise ValueError('Press break must be in int')

    if turn_the_bike_on() and current_gear == 4 and press_break == 1:
        time.sleep(3)
        speed = 30

    elif turn_the_bike_on() and current_gear == 3 and press_break == 1:
        time.sleep(3)
        speed = 20

    elif turn_the_bike_on() and current_gear == 2 and press_break == 1:
        time.sleep(3)
        speed = 10

    elif turn_the_bike_on() and current_gear == 1 and press_break == 1:
        time.sleep(3)
        speed = 0

    if speed <= 30:
        current_gear = 3
    if speed <= 20:
        current_gear = 2
    if speed <= 10:
        current_gear = 1
    if speed <= 0:
        current_gear = 0

    return speed, current_gear

def turn_bike_off() :
    global speed, current_gear

    if turn_the_bike_on() and current_gear == 0 and speed == 0:
        time.sleep(1)
        return True
    else:
        return False
