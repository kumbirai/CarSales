/**
 * za.co.kumbirai.carsales.service<br>
 * 
 * <p><b>Title:</b> SimpleCarSalesService<br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2012<br>
 * <b>Company:</b> SSP</p>
 * @author Kumbirai 'Coach' Mundangepfupfu
 * @date 19 Dec 2012 2:00:16 PM
 */
package za.co.kumbirai.carsales.service;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import za.co.kumbirai.carsales.StatisticType;
import za.co.kumbirai.carsales.entities.Car;
import za.co.kumbirai.carsales.entities.Manufacturer;
import za.co.kumbirai.carsales.service.interfaces.CarSalesService;

/**
 * <p><b>Purpose:</b><br>
 * <br>
 *
 * Copyright Notice<br>
 * ================<br>
 * This file contains proprietary information.
 * Copying or reproduction without prior written approval is prohibited.<br>
 * Copyright (c) 2012<br>
 * 
 * <p><b>Title:</b> SimpleCarSalesService<br>
 * <b>Description:</b> </p>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @date 19 Dec 2012 2:00:16 PM<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 *					
 */
public class SimpleCarSalesService implements CarSalesService {
	private static SimpleCarSalesService instance;
	private List<Manufacturer> manufacturers;
	private EntityManagerFactory emf;
	private EntityManager em;
	private String PERSISTENCE_UNIT_NAME = "Cars";

	/**
	 * 
	 */
	private SimpleCarSalesService() {
		loadCars();
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 19 Dec 2012
	 * 
	 * initEntityManager
	 * 
	 */
	protected void initEntityManager() {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 19 Dec 2012
	 * 
	 * closeEntityManager
	 * 
	 */
	protected void closeEntityManager() {
		em.close();
		emf.close();
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 19 Dec 2012
	 * 
	 * loadCars
	 * 
	 */
	@SuppressWarnings("unchecked")
	protected void loadCars() {
		initEntityManager();
		Query query = em.createNamedQuery("findManufacturers");
		manufacturers = query.getResultList();
		closeEntityManager();
	}

	/* (non-Javadoc)
	 * @see za.co.kumbirai.carsales.service.interfaces.CarSalesService#saveCars()
	 */
	@Override
	public void saveCars() {
		initEntityManager();
		em.getTransaction().begin();
		for (Manufacturer man : manufacturers) {
			Manufacturer entity;
			entity = em.find(Manufacturer.class, man.getManufacturer());
			if (entity != null) {
				entity.setCars(man.getCars());
				em.merge(entity);
			} else {
				em.persist(man);
			}
		}
		em.getTransaction().commit();
		closeEntityManager();
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 19 Dec 2012
	 * 
	 * getInstance
	 * 
	 * @return
	 */
	public static SimpleCarSalesService getInstance() {
		if (instance == null)
			instance = new SimpleCarSalesService();
		return instance;
	}

	/* (non-Javadoc)
	 * @see za.co.kumbirai.carsales.service.CarSalesService#getStatistics(za.co.kumbirai.carsales.StatisticType)
	 */
	@Override
	public double getStatistic(StatisticType type) {
		double result = 0;

		switch (type) {
		case CARS_COUNT:
			result = carsCount();
			break;
		case MANUFACTURERS_COUNT:
			result = manufacturerCount();
			break;
		case AVERAGE_PRICE:
			result = getAveragePrice();
			break;
		case AVERAGE_DISTANCE:
			result = getAverageDistance();
			break;
		case AVERAGE_AGE:
			result = getAverageAge();
			break;
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see za.co.kumbirai.carsales.service.interfaces.CarSalesService#getStatisticMap()
	 */
	@Override
	public Map<StatisticType, Double> getStatisticMap() {
		Map<StatisticType, Double> stats = new HashMap<StatisticType, Double>();

		for (StatisticType type : EnumSet.allOf(StatisticType.class)) {
			stats.put(type, getStatistic(type));
		}

		return stats;
	}

	/* (non-Javadoc)
	 * @see za.co.kumbirai.carsales.service.interfaces.CarSalesService#getCarList()
	 */
	@Override
	public List<Car> getCarList() {
		List<Car> cars = new ArrayList<Car>();
		for (Manufacturer man : manufacturers) {
			cars.addAll(man.getCars());
		}
		return cars;
	}

	/* (non-Javadoc)
	 * @see za.co.kumbirai.carsales.service.interfaces.CarSalesService#getCar(java.lang.Long)
	 */
	@Override
	public Car getCar(Long carId) {
		for (Car car : getCarList()) {
			if (car.getId().equals(carId))
				return car;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see za.co.kumbirai.carsales.service.interfaces.CarSalesService#saveCar(za.co.kumbirai.carsales.entities.Car)
	 */
	@Override
	public Car saveCar(Car car) {
		String name = car.getManufacturer().getManufacturer();
		for (Manufacturer man : manufacturers) {
			if (man.getManufacturer().equalsIgnoreCase(name)) {
				if (car.getId() == null) {
					man.addCar(car);
					saveManufacturer(man);
					return car;
				} else {
					for (Car c : man.getCars()) {
						if (c.getId().equals(car.getId())) {
							man.getCars().remove(c);
							man.getCars().add(car);
							saveManufacturer(man);
							return car;
						}
					}
				}
			}
		}
		Manufacturer man = new Manufacturer(name, car);
		saveManufacturer(man);
		return car;
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 03 Jan 2013
	 * 
	 * saveManufacturer
	 * 
	 * @param man
	 */
	protected void saveManufacturer(Manufacturer man) {
		initEntityManager();
		em.getTransaction().begin();
		Manufacturer entity;
		entity = em.find(Manufacturer.class, man.getManufacturer());
		if (entity != null) {
			entity.setCars(man.getCars());
			em.merge(entity);
		} else {
			em.persist(man);
		}
		em.getTransaction().commit();
		closeEntityManager();
		loadCars();
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 19 Dec 2012
	 * 
	 * getAverageAge
	 * 
	 * @return
	 */
	protected double getAverageAge() {
		double result = 0;
		int count = 0;

		for (Manufacturer man : manufacturers) {
			for (Car car : man.getCars()) {
				result += car.getAge();
				count++;
			}
		}
		if (count == 0)
			return 0;
		else
			return (result / count);
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 19 Dec 2012
	 * 
	 * getAverageDistance
	 * 
	 * @return
	 */
	protected double getAverageDistance() {
		double result = 0;
		int count = 0;

		for (Manufacturer man : manufacturers) {
			for (Car car : man.getCars()) {
				result += car.getKilometers();
				count++;
			}
		}
		if (count == 0)
			return 0;
		else
			return (result / count);
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 19 Dec 2012
	 * 
	 * getAveragePrice
	 * 
	 * @return
	 */
	protected double getAveragePrice() {
		double result = 0;
		int count = 0;

		for (Manufacturer man : manufacturers) {
			for (Car car : man.getCars()) {
				result += car.getPrice().doubleValue();
				count++;
			}
		}
		if (count == 0)
			return 0;
		else
			return (result / count);
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 19 Dec 2012
	 * 
	 * manufacturerCount
	 * 
	 * @return
	 */
	protected double manufacturerCount() {
		return manufacturers.size();
	}

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 19 Dec 2012
	 * 
	 * carsCount
	 * 
	 * @return
	 */
	protected double carsCount() {
		int count = 0;

		for (Manufacturer man : manufacturers)
			count += man.carCount();

		return count;
	}
}