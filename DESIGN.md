# Design

Simulator allows one or more bots to be run at the same time

Bots use an interface that is compatible with FRC robots

Simulator provides fake implementations of a few selected wpilib and 3rd party classes. These
classes deliver fake sensor data, and use commands to actuators to move simulated robot

## Physics

- Drive wheels provide force forward or backwards, proportional to the output setting from -1 to 1
- Odometry is not supported.
