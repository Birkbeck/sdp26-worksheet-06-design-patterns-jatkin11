package builder;

public class SportsCarBuilder implements CarBuilder{

    private final Car car = new Car("Sports");
    //Body: External dimensions: overall length (inches): 192.3, overall width (inches): 75.5, overall height (inches): 54.2, wheelbase (inches): 112.3, front track (inches): 63.7, rear track (inches): 64.1 and curb to curb turning circle (feet): 37.7
    //Power: 323 hp @ 6,800 rpm; 278 ft lb of torque @ 4,800 rpm
    //Engine: 3.6L V 6 DOHC and variable valve timing
    //Breaks: Four-wheel disc brakes: two ventilated. Electronic brake distribution. StabiliTrak stability control
    //Seats: Driver sports front seat with one power adjustments manual height, front passenger seat sports front seat with one power adjustments
    //Windows: Front windows with one-touch on two windows
    //Fuel Type: Gasoline 17 MPG city, 28 MPG highway, 20 MPG combined and 380 mi. range


    @Override
    public void buildBodyStyle() {
        this.car.setBodyStyle("External dimensions: overall length (inches): 192.3, overall width (inches): 75.5, overall height (inches): 54.2, wheelbase (inches): 112.3, front track (inches): 63.7, rear track (inches): 64.1 and curb to curb turning circle (feet): 37.7");
    }

    @Override
    public void buildPower(){
        this.car.setPower("323 hp @ 6,800 rpm; 278 ft lb of torque @ 4,800 rpm");
    }

    @Override
    public void buildEngine() {
        this.car.setEngine("3.6L V 6 DOHC and variable valve timing");
    }

    @Override
    public void buildBreaks() {
        this.car.setBreaks("Four-wheel disc brakes: two ventilated. Electronic brake distribution. StabiliTrak stability control");
    }

    @Override
    public void buildSeats() {
        this.car.setSeats("Driver sports front seat with one power adjustments manual height, front passenger seat sports front seat with one power adjustments");
    }

    @Override
    public void buildWindows() {
        this.car.setWindows("Front windows with one-touch on two windows");
    }

    @Override
    public void buildFuelType() {
        this.car.setFuelType("Gasoline 17 MPG city, 28 MPG highway, 20 MPG combined and 380 mi. range");
    }

    @Override
    public Car getCar(){
        return this.car;
    }
}