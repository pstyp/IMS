package com.qa.ims.persistence.domain;

public class OrderItems {

	// middle man

	private Long orderItemsId;
	private Long orderId;
	private Long productId;

	public OrderItems(Long orderItemsId, Long orderId, Long productId) {
		this.orderItemsId = orderItemsId;
		this.orderId = orderId;
		this.productId = productId;

	}

	public OrderItems(Long customerId, Long productId) {
		this.orderId = customerId;
		this.productId = productId;

	}

	public Long getOrderItemsId() {
		return orderItemsId;
	}

	public void setOrderItemsId(Long orderItemsId) {
		this.orderItemsId = orderItemsId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "OrderItems [orderItemsId=" + orderItemsId + ", orderId=" + orderId + ", productId=" + productId + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItems other = (OrderItems) obj;
		if (orderItemsId == null) {
			if (other.orderItemsId != null)
				return false;
		} else if (!orderItemsId.equals(other.orderItemsId))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!orderItemsId.equals(other.productId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}
}