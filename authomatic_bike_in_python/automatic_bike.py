import time


def turn_the_bike_on():
   return True


def put_bike_in_gear(gear):
    if turn_the_bike_on:
        if isinstance(gear, float) or isinstance(gear, str):
         raise ValueError('Gear must be in int')

        if gear in range(1, 5):
            gear = 1
        elif gear in range(2, 5):
            gear = 2
        elif gear in range(3, 5):
            gear = 3
        elif gear in range(4, 5):
            gear = 4
        else:
            raise ValueError('Gear must be in range 1 to 4')



def accelerate(pree_acceleration):
    if isinstance(pree_acceleration, float) or isinstance(pree_acceleration, str):
        raise ValueError('Pree acceleration must be in int')
    if turn_the_bike_on and put_bike_in_gear == 1 and pree_acceleration == 1:
        time.sleep(3)
    return 20
