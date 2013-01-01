/**
 * za.co.kumbirai.carsales.service.interfaces<br>
 * 
 * <p><b>Title:</b> CarSalesService<br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2012<br>
 * <b>Company:</b> SSP</p>
 * @author Kumbirai 'Coach' Mundangepfupfu
 * @date 19 Dec 2012 1:59:30 PM
 */
package za.co.kumbirai.carsales.service.interfaces;

import java.util.List;
import java.util.Map;

import za.co.kumbirai.carsales.StatisticType;
import za.co.kumbirai.carsales.entities.Car;

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
 * <p><b>Title:</b> CarSalesService<br>
 * <b>Description:</b> </p>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @date 19 Dec 2012 1:59:30 PM<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 *					
 */
public interface CarSalesService {
	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 19 Dec 2012
	 * 
	 * getStatistic
	 * 
	 * @param type
	 * @return
	 */
	public double getStatistic(StatisticType type);

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 19 Dec 2012
	 * 
	 * saveCars
	 * 
	 */
	public void saveCars();

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 20 Dec 2012
	 * 
	 * getStatisticMap
	 * 
	 * @return
	 */
	public Map<StatisticType, Double> getStatisticMap();

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 20 Dec 2012
	 * 
	 * getCarList
	 * 
	 * @return
	 */
	public List<Car> getCarList();

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 27 Dec 2012
	 * 
	 * getCar
	 * 
	 * @param carId
	 * @return
	 */
	public Car getCar(Long carId);

	/**
	 * @author Kumbirai 'Coach' Mundangepfupfu - 28 Dec 2012
	 * 
	 * saveCar
	 * 
	 * @param car
	 * @return
	 */
	public Car saveCar(Car car);
}
