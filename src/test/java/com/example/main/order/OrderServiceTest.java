package com.example.main.order;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.example.main.product.DiscountPolicy;
import com.example.main.product.Product;
import com.example.main.product.ProductRepository;

class OrderServiceTest {

	private OrderService orderService;
	private OrderPort orderPort;
	private OrderRepository orderRepository;

	@BeforeEach
	void setUp() {
		orderRepository = new OrderRepository();
		orderPort = new OrderPort() {
			@Override
			public Product getProductById(Long productId) {
				return new Product("product", 1000, DiscountPolicy.NONE);
			}

			@Override
			public void save(Order order) {
				orderRepository.save(order);
			}
		};
		orderService = new OrderService(orderPort);
	}

	@Test
	void orderProduct() {
		final Long productId = 1L;
		final int quantity = 2;

		final CreateOrderRequest request = new CreateOrderRequest(productId, quantity);

		orderService.createOrder(request);
	}

	private record CreateOrderRequest(Long productId, int quantity) {
		private CreateOrderRequest {
			Assert.notNull(productId, "productId must be required");
			Assert.isTrue(quantity > 0, "quantity must be over 0");
		}
	}

	private static class OrderService {

		private OrderPort orderPort;

		public OrderService(final OrderPort orderPort) {
			this.orderPort = orderPort;
		}

		public void createOrder(CreateOrderRequest request) {
			final Product product = orderPort.getProductById(request.productId());

			final Order order = new Order(product, request.quantity());
			orderPort.save(order);
		}
	}

	private static class OrderAdapter implements OrderPort {
		private final ProductRepository productRepository;
		private OrderRepository orderRepository;

		public OrderAdapter(final ProductRepository productRepository, final OrderRepository orderRepository) {
			this.productRepository = productRepository;
			this.orderRepository = orderRepository;
		}

		@Override
		public Product getProductById(Long productId) {
			return productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("No product"));
		}

		@Override
		public void save(Order order) {
			orderRepository.save(order);
		}
	}

	private static class Order {
		private Long id;
		private final Product product;
		private final int quantity;

		public Order(Product product, int quantity) {
			this.product = product;
			this.quantity = quantity;
			Assert.notNull(product, "product must be required");
			Assert.isTrue(quantity > 0, "quantity must be over 0");
		}

		public void assignId(Long aLong) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}
	}

	private static class OrderRepository {
		private Map<Long, Order> persistence = new HashMap<>();
		private Long sequence = 0L;

		public void save(Order order) {
			order.assignId(++sequence);
			persistence.put(order.getId(), order);
		}
	}

	private interface OrderPort {
		Product getProductById(Long productId);

		void save(Order order);
	}
}
