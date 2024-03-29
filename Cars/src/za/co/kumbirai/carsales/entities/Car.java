package za.co.kumbirai.carsales.entities;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

/**
 * Entity implementation class for Entity: Car
 * 
 */
@Entity
@NamedQuery(name = "findCars", query = "SELECT c FROM Car c ORDER BY c.model")
public class Car implements Serializable {
	private static final long serialVersionUID = 5593591892072759586L;

	@Id
	@GeneratedValue(strategy = AUTO, generator = "CarSeq")
	@SequenceGenerator(name = "CarSeq", allocationSize = 3, initialValue = 1)
	private Long id;
	private String model;
	@ManyToOne
	@JoinColumn(name = "MANUFACTURER", referencedColumnName = "manufacturer")
	private Manufacturer manufacturer;
	private String information;
	private Integer carYear;
	private BigDecimal price;
	private Double kilometers;

	public Car() {
		super();
	}

	public Car(String man, String mod, String info) {
		this();
		model = mod;
		manufacturer = new Manufacturer(man.toUpperCase());
		information = info;
	}

	public int getAge() {
		GregorianCalendar calendar = new GregorianCalendar();
		return (calendar.get(Calendar.YEAR) - carYear);
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Manufacturer getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getInformation() {
		return this.information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public Integer getCarYear() {
		return this.carYear;
	}

	public void setCarYear(Integer carYear) {
		this.carYear = carYear;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Double getKilometers() {
		return this.kilometers;
	}

	public void setKilometers(Double kilometers) {
		this.kilometers = kilometers;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Car [id=" + this.id + ", model=" + this.model + ", manufacturer=" + this.manufacturer.getManufacturer() + ", information=" + this.information
				+ ", carYear=" + this.carYear + ", price=" + this.price + ", kilometers=" + this.kilometers + "]";
	}
}