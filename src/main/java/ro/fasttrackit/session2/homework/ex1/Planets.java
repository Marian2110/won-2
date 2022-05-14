package ro.fasttrackit.session2.homework.ex1;

public enum Planets {
    MERCURY(0.3)
    , VENUS(0.9)
    , EARTH(1.0)
    , MARS(0.5)
    , JUPITER(2.0)
    , SATURN(1.2)
    , URANUS(0.8)
    , NEPTUNE(1.5)
    , PLUTO(0.1)
    , MOON(0.1)
    ,IO(0.18)
    ,EUROPA(0.18)
    ,GANYMEDE(0.18)
    ,CALLISTO(0.18)
    ,SUN(27)
    ,WHITE_DWARF(0.1);

    private final double gravity;

    Planets(double gravity) {
        this.gravity = gravity;
    }

    public double getGravity() {
        return gravity;
    }

    public double calculateWeight(double weight) {
        return weight * gravity;
    }
}


