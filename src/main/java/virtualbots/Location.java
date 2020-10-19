package virtualbots;

public class Location {
    private final double x;
    private final double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDistance(Location other) {
        // The Pythagorean Theorem!
        double dx = x - other.x;
        double dy = y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Get the absolute direction from this location to the target
    // Uses standard coordinate system, with 0 radians being in the positive X direction,
    // positive being rotation counter-clockwise and negative being clockwise
    // Result is between -Pi and +Pi
    public double getDirection(Location target) {
        return Math.atan2(target.y -this.y, target.x - this.x);
    }

    @Override
    public int hashCode() {
        return (int) (3.0 * x + 7.0 * y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass()) {
            Location loc = (Location)obj;
            if (loc.x == this.x && loc.y == this.y) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "{x:"+x+",y:"+y+"}";
    }
}
