# Inheritance Notes

## Key Concepts
- Child class inherits attributes and methods from parent class.
- Promotes code reuse (DRY principle).
- "is-a" relationship (e.g., ManualCar *is a* Car).

## Access Modifiers
- public, protected, private
- protected allows access in child classes.

## Inheritance Types in Java
- Public inheritance (default in Java with extends keyword)
- Private and protected are not explicitly declared like C++, but access control affects visibility.

## Example
- `ManualCar` adds `currentGear` and `shiftGear()`.
- `ElectricCar` adds `batteryLevel` and `chargeBattery()`.
