package com.foxinmy.weixin4j.pay.payment.coupon;

import com.alibaba.fastjson.annotation.JSONField;
import com.foxinmy.weixin4j.pay.type.mch.CouponType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 订单代金券信息
 * 
 * @className OrderCouponInfo
 * @author jinyu(foxinmy@gmail.com)
 * @date 2015年3月24日
 * @since JDK 1.6
 * @see
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderCouponInfo implements Serializable {

	private static final long serialVersionUID = -8744999305258786901L;

	/**
	 * 代金券或立减优惠批次ID
	 */
	@XmlElement(name = "coupon_batch_id")
	@JSONField(name = "coupon_batch_id")
	private String couponBatchId;
	/**
	 * 代金券类型
	 * 
	 * @see CouponType
	 */
	@XmlElement(name = "coupon_type")
	@JSONField(name = "coupon_type")
	private String couponType;
	/**
	 * 代金券或立减优惠ID
	 */
	@XmlElement(name = "coupon_id")
	@JSONField(name = "coupon_id")
	private String couponId;
	/**
	 * 单个代金券或立减优惠支付金额
	 */
	@XmlElement(name = "coupon_fee")
	@JSONField(name = "coupon_fee")
	private Integer couponFee;

	protected OrderCouponInfo() {
		// jaxb requried
	}

	public String getCouponBatchId() {
		return couponBatchId;
	}

	public void setCouponBatchId(String couponBatchId) {
		this.couponBatchId = couponBatchId;
	}

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	@JSONField(serialize = false)
	public CouponType getFormatCouponType() {
		return couponType != null ? CouponType
				.valueOf(couponType.toUpperCase()) : null;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public Integer getCouponFee() {
		return couponFee;
	}

	public void setCouponFee(Integer couponFee) {
		this.couponFee = couponFee;
	}

	/**
	 * <font color="red">调用接口获取单位为分,get方法转换为元方便使用</font>
	 * 
	 * @return 元单位
	 */
	@JSONField(serialize = false)
	public double getFormatCouponFee() {
		return couponFee != null ? couponFee.doubleValue() / 100d : 0d;
	}

	@Override
	public String toString() {
		return "couponBatchId=" + couponBatchId + ", couponType=" + couponType
				+ ", couponId=" + couponId + ", couponFee=" + couponFee;
	}
}
