const { getSpeed } = require("../SourceCode/AutomaticBike");
const {power,switchPower,currentGears,currentSpeed} = require("../SourceCode/AutomaticBike");

describe("Test that the automatic bike can be powered on and off", () => {
    test("test to get the current stage of bike ignition", () => {
        expect(power()).toBe(false);
    });

    test("test to power on the bike", () => {
        expect(power()).toBe(false);
        switchPower();
        expect(power()).toBe(true);
        switchPower(); 
    });

    test("test to power off the bike", () => {
        switchPower();
        expect(power()).toBe(true);
        switchPower();
        expect(power()).toBe(false);
    }); 
});

describe("Test that the automatic bike can be put into gear", () => {
    test("test that the bike is on and it can be put into gear one", () => {
        switchPower();
        expect(currentGears(1)).toBe(1);
        switchPower();
    });
    test("test that the bike is off and it cannot be put into gear", () => {
        expect(()=> {
            throw new Error("Cannot increase gear when bike is off");
        }).toThrow(currentGears(1));
    });

    test("test that the bike gear is in range 1-4", () => {
        expect(()=> {
            throw new Error("Gear must be between 1 and 4");
        }).toThrow(currentGears(5));
    });

    test("test that the bike is on and it can be put into gear two", () => {
        switchPower();
        expect(currentGears(2)).toBe(2);
        switchPower();
    });

    test("test that the bike is on and it can be put into gear three", () => {
        switchPower();
        expect(currentGears(3)).toBe(3);
        switchPower();
    });

    test("test that the bike is on and it can be put into gear four", () => {
        switchPower();
        expect(currentGears(4)).toBe(4);
        switchPower();
    });
});

describe("Test that the automatic bike can change gear authomatically when it get to custom speed", () => {
    test("test that the bike dont increase speed if bike is not on or not in gear", () => {
       expect(() => currentSpeed(1)).toThrow("Cannot increase speed");
    });

    test("test that the bike dont accept negative speed", () => {
         expect(() => currentSpeed(-1)).toThrow("Cannot increase speed");
    });

    test("test that the bike dont accept gear out of range", () => {
         expect(() => currentSpeed(5)).toThrow("Cannot increase speed");
    });

    test("test that the bike is on and it's in gear one and it can automatically change to gear two at 20klm/hr", () => {
        switchPower();
        expect(currentGears(1)).toBe(1);
        expect(currentSpeed(20)).toBe(20);
        expect(currentGears(2)).toBe(2);
        switchPower();
    });

    test("test that the bike is on and it's in gear two and it can automatically change to gear three at 30klm/hr", () => {
        switchPower();
        expect(currentGears(2)).toBe(2);
        expect(currentSpeed(31)).toBe(31);
        expect(currentGears(3)).toBe(3);
        switchPower(); 
    });
});