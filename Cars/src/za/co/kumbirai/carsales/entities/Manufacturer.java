package za.co.kumbirai.carsales.entities;

import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Manufacturer
 * 
 */
@Entity
@NamedQuery(name = "findManufacturers", query = "SELECT m FROM Manufacturer m ORDER BY m.manufacturer")
public class Manufacturer implements Serializable {
	private static final long serialVersionUID = -979419254930899478L;

	@Id
	private String manufacturer;
	@OneToMany(cascade = ALL, mappedBy = "manufacturer")
	private List<Car> cars;

	public Manufacturer() {
		super();
	}

	public Manufacturer(String nam) {
		this();
		manufacturer = nam.toUpperCase();
	}

	public Manufacturer(String nam, Car c) {
		this();
		manufacturer = nam.toUpperCase();
		addCar(c);
	}

	public void addCar(Car c) {
		if (cars == null)
			cars = new ArrayList<Car>();
		cars.add(c);
	}

	public int carCount() {
		return cars.size();
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public List<Car> getCars() {
		return this.cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Manufacturer [manufacturer=" + this.manufacturer + ", cars=" + this.cars + "]";
	}
}