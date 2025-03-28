package builder_pattern;

public class BuilderPattern {
    public static void main(String[] args) {
        Car car1 = new Car.CarBuilder("V8", 4).setSunroof(true).setGPS(false).build();
        Car car2 = new Car.CarBuilder("Electic", 4).setGPS(true).build();

        car1.showCarDetails();
        car2.showCarDetails();
    }

}

class Car {
    private String engine;
    private int wheels;
    private boolean sunroof;
    private boolean gps;

    private Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.sunroof = builder.sunroof;
        this.gps = builder.gps;
    }

    public static class CarBuilder {
        private String engine;
        private int wheels;
        private boolean sunroof;
        private boolean gps;

        public CarBuilder(String engine, int wheels) {
            this.engine = engine;
            this.wheels = wheels;
        }

        public CarBuilder setSunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        public CarBuilder setGPS(boolean gps) {
            this.gps = gps;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    public void showCarDetails() {
        System.out.println(
                "Car with engine: " + engine + ", wheels: " + wheels + ", sunroof: " + sunroof + " and GPS: " + gps);
    }
}
