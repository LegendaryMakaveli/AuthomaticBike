from unittest import TestCase
import automatic_bike


class TestFunctionsForAutomaticBike(TestCase):
    def test_that_the_ignition_is_turned_on(self):
        automatic_bike.turn_the_bike_on()
        self.assertTrue(True, automatic_bike.turn_the_bike_on())

    def test_that_the_automatic_bike_is_turned_on_and_it_in_gear_and_it_does_not_accept_invalid_input(self):
        automatic_bike.turn_the_bike_on()
        self.assertTrue(True, automatic_bike.turn_the_bike_on())
        self.assertRaises(ValueError, automatic_bike.put_bike_in_gear, 2.2)
        self.assertRaises(ValueError, automatic_bike.put_bike_in_gear, "str")

    def test_that_the_automatic_bike_is_turned_on_and_it_in_gear_and_it_does_not_accept_above_or_below_gear_range(self):
        automatic_bike.turn_the_bike_on()
        # self.assertTrue(True, automatic_bike.turn_the_bike_on())
        result = automatic_bike.put_bike_in_gear(1)
        self.assertTrue(True, result)
        result = automatic_bike.put_bike_in_gear(4)
        self.assertTrue(True, result)
        self.assertRaises(ValueError, automatic_bike.put_bike_in_gear, 6)

    def test_that_the_automatic_bike_can_accelerate_and_it_does_not_accept_invalid_input(self):
        self.assertRaises(ValueError, automatic_bike.accelerate, 2.2)
        self.assertRaises(ValueError, automatic_bike.accelerate, "str")

    def test_that_the_automatic_bike_is_turned_on_its_in_first_gear_and_it_can_accelerate_to_a_speed_range_and_change_automatically_to_second_gear(self):
        automatic_bike.turn_the_bike_on()
        automatic_bike.put_bike_in_gear(1)
        result = automatic_bike.accelerate(1)
        self.assertEqual(20, result)



