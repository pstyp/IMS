package com.qa.ims.persistence.domain;

import java.util.List;

public class Order {

	private Long orderId;
	private Long customerId;
	private String address;
	private List<Item> items;
	

	public Order(Long orderId, Long customerId, String address, List<Item> items) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.address = address;
		this.items = items;

	}

	public Order(Long customerId, String address) {
		super();
		this.orderId = 0L;
		this.customerId = customerId;
		this.address = address;
	}

	public Order(Long orderId, Long customerId, String address) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.address = address;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;

	}


	@Override
	public String toString() {
		String spaces = "\n ";
		double orderPrice = 0.0;
		for (Item item : items) {
			orderPrice += item.getPrice();
			spaces += item.toString() + " \n";
		}
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", address=" + address + ", items: "
				+  spaces + ", order price: £" + orderPrice +"]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}
}
