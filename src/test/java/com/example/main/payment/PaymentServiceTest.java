package com.example.main.payment;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.example.main.order.Order;
import com.example.main.product.DiscountPolicy;
import com.example.main.product.Product;

import jakarta.security.auth.message.MessagePolicy;

public class PaymentServiceTest {

	private PaymentService paymentService;
	private PaymentPort paymentPort;

	@BeforeEach
	void setUp() {
		PaymentGateway paymentGateway = new ConsolePaymentGateway();
		PaymentRepository paymentRepository = new PaymentRepository();
		paymentPort = new PaymentAdapter(paymentGateway, paymentRepository);
		paymentService = new PaymentService(paymentPort);
	}

	@Test
	void paymentOrder() {
		final Long orderId = 1L;
		final String cardNumber = "1234-1234-1234-1234";
		final PaymentRequest request = new PaymentRequest(orderId, cardNumber);

		paymentService.payment(request);
	}

	private record PaymentRequest(Long orderId, String cardNumber) {
		private PaymentRequest(Long orderId, String cardNumber) {
			this.orderId = orderId;
			this.cardNumber = cardNumber;
			Assert.notNull(orderId, "orderId must be required");
			Assert.hasText(cardNumber, "cardNumber must have text");
		}
	}

	private static class PaymentService {

		private final PaymentPort paymentPort;

		public PaymentService(PaymentPort paymentPort) {
			this.paymentPort = paymentPort;
		}

		public void payment(PaymentRequest request) {
			Order order = paymentPort.getOrder(request.orderId());

			final Payment payment = new Payment(order, request.cardNumber());

			paymentPort.pay(payment);
			paymentPort.save(payment);
		}
	}

	private interface PaymentPort {
		Order getOrder(Long orderId);

		void pay(Payment payment);

		void save(Payment payment);
	}

	private static class Payment {
		private Long id;
		private final Order order;
		private final String cardNumber;

		public Payment(Order order, String cardNumber) {
			Assert.notNull(order, "order must be required");
			Assert.hasText(cardNumber, "cardNumber must have text");
			this.order = order;
			this.cardNumber = cardNumber;
		}

		public void assignId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}
	}

	private static class PaymentAdapter implements PaymentPort {
		private final PaymentGateway paymentGateway;
		private final PaymentRepository paymentRepository;

		public PaymentAdapter(PaymentGateway paymentGateway, PaymentRepository paymentRepository) {
			this.paymentGateway = paymentGateway;
			this.paymentRepository = paymentRepository;
		}

		@Override
		public Order getOrder(Long orderId) {
			return new Order(new Product("product", 1000, DiscountPolicy.NONE), 2);

		}

		@Override
		public void pay(Payment payment) {
			paymentGateway.execute(payment);
		}

		@Override
		public void save(Payment payment) {
			paymentRepository.save(payment);
		}
	}

	private interface PaymentGateway {
		void execute(Payment payment);
	}

	private static class PaymentRepository {

		private Long sequence = 0L;
		private Map<Long, Payment> persistence = new HashMap<>();

		public void save(Payment payment) {
			payment.assignId(++sequence);
			persistence.put(payment.getId(), payment);
		}
	}

	public class ConsolePaymentGateway implements PaymentGateway {
		@Override
		public void execute(Payment payment) {
			System.out.println("paid");
		}
	}
}
