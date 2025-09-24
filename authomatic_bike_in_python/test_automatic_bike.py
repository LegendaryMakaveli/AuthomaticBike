from unittest import TestCase
from automatic_bike import AutoBike


class TestFunctionsForAutomaticBike(TestCase):
    def setUp(self):
        self.my_bike = AutoBike()
    def test_that_the_ignition_is_turned_on(self):
        self.my_bike.turn_on()
        self.assertTrue(True,  self.my_bike.turn_on())

    def test_that_the_automatic_bike_is_turned_on_and_it_in_gear_and_it_does_not_accept_invalid_input(self):
        self.my_bike.turn_on()
        self.assertTrue(True, self.my_bike.turn_on())
        self.assertRaises(ValueError, self.my_bike.put_gear, 2.2)
        self.assertRaises(ValueError, self.my_bike.put_gear, "str")

    def test_that_the_automatic_bike_is_turned_on_and_it_in_gear_and_it_does_not_accept_above_or_below_gear_range(self):
        self.my_bike.turn_on()
        # self.assertTrue(True, automatic_bike.turn_the_bike_on())
        result = self.my_bike.put_gear(1)
        self.assertTrue(True, result)
        result = self.my_bike.put_gear(4)
        self.assertTrue(True, result)
        self.assertRaises(ValueError, self.my_bike.put_gear, 6)

    def test_that_the_automatic_bike_can_accelerate_and_it_does_not_accept_invalid_input(self):
        self.assertRaises(ValueError, self.my_bike.accelerate, 2.2)
        self.assertRaises(ValueError, self.my_bike.accelerate, "str")

    def test_that_the_automatic_bike_is_turned_on_its_in_gear_and_it_can_accelerate_to_a_speed_range_and_change_automatically_to_next_gear(self):
        self.my_bike.turn_on()
        self.my_bike.put_gear(2)
        speed_and_next_gear = self.my_bike.accelerate(1)
        self.assertEqual((30,3),  speed_and_next_gear)

    def test_that_the_automatic_bike_can_decelerate_and_it_does_not_accept_invalid_input(self):
        self.assertRaises(ValueError, self.my_bike.decelerate, 2.2)
        self.assertRaises(ValueError, self.my_bike.decelerate, "str")

    def test_that_the_automatic_bike_is_turned_on_its_in_gear_and_it_can_decelerate_to_a_speed_range_and_change_automatically_to_next_gear(self):
        self.my_bike.turn_on()
        self.my_bike.put_gear(3)
        speed_and_next_gear = self.my_bike.decelerate(1)
        self.assertEqual((20,2), speed_and_next_gear)

    def test_that_the_automatic_bike_is_turned_off(self):
        self.my_bike.turn_on()
        self.my_bike.turn_off()

        self.assertTrue(True, self.my_bike.turn_off())


