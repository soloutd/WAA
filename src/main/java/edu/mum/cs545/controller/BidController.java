package edu.mum.cs545.controller;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.cs545.model.Bids;
import edu.mum.cs545.model.Car;
import edu.mum.cs545.model.MyBid;
import edu.mum.cs545.model.NewBid;
import edu.mum.cs545.repository.BidRepository;
import edu.mum.cs545.repository.CarRepository;

@Controller
public class BidController {

	@Autowired
	BidRepository br;
	@Autowired
	CarRepository cr;

	@MessageMapping("/bid")
	@SendTo("/topic/bid")
	public NewBid bid(MyBid bid) throws Exception {
		System.out.println("........ greeting CarId: " + bid.getId() + " Price:" + bid.getPrice());
		NewBid nb = new NewBid();

		Car car = cr.findOne(bid.getId());
		Date now = new Date();
		if (car.getExpireDate() != null && now.getTime() > car.getExpireDate().getTime()) {
			nb.setNewbid("Already sold.");
		} else {
			nb.setNewbid(bid.getPrice().toString());

			Bids bs = new Bids();
			bs.setBidDate(new Date());
			bs.setCarId(bid.getId());
			bs.setPrice(Double.valueOf(bid.getPrice()));
			bs.setUserId(3L);
			br.save(bs);
		}

		List<Bids> bids = br.getBidsByCarId(bid.getId());
		double max = 0;
		if (null != bids && bids.size() > 0)
			max = bids.stream().map(b -> b.getPrice()).max(Comparator.comparing(Double::valueOf)).get();

		nb.setHighbid(String.valueOf(max));
		nb.setCarid(bid.getId());
		return nb;
	}

	@RequestMapping("cars/bid/{carid}")
	public String bid(@PathVariable("carid") Long carId, Model model) {

		Car c = cr.findOne(carId);

		if (null == c) {
			c = new Car();
			c.setCarNumber(23);
			c.setName("Lexus");
			cr.save(c);
			return "redirect:cars/bid/" + c.getId();
		}

		model.addAttribute("car", c);

		List<Bids> bids = br.getBidsByCarId(carId);
		double max = 0;
		if (null != bids && bids.size() > 0)
			max = bids.stream().map(b -> b.getPrice()).max(Comparator.comparing(Double::valueOf)).get();
		model.addAttribute("highprice", max);

		return "bid";
	}

	@RequestMapping(value = "cars/finish/{carid}", method = RequestMethod.GET)
	public String finish(@PathVariable("carid") Long carId, Model model) {

		Car c = cr.findOne(carId);

		if (null == c) {
			c = new Car();
			c.setCarNumber(23);
			c.setName("Lexus");
			cr.save(c);
			return "redirect:cars/bid/" + c.getId();
		}

		model.addAttribute("car", c);

		List<Bids> bids = br.getBidsByCarId(carId);
		double max = 0;
		if (null != bids && bids.size() > 0)
			max = bids.stream().map(b -> b.getPrice()).max(Comparator.comparing(Double::valueOf)).get();
		model.addAttribute("highprice", max);

		return "finish";
	}

	@ResponseBody
	@RequestMapping(value = "cars/finish/{id}", method = RequestMethod.POST)
	public NewBid finish(@PathVariable("id") Long id) {
		System.out.println("Finish............ " + id);
		NewBid nb = new NewBid();
		Car car = cr.findOne(id);
		if (null != car) {

			List<Bids> bids = br.getBidsByCarId(id);
			double max = 0;
			if (null != bids && bids.size() > 0)
				max = bids.stream().map(b -> b.getPrice()).max(Comparator.comparing(Double::valueOf)).get();

			car.setExpireDate(new Date());
			cr.save(car);
			System.out.println("Expire.....................");
			nb.setHighbid("High:" + max);
		}
		return nb;
	}
}
