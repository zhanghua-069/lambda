package com.xyzq.zh.lambda.chapter5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 自定义收集器实现Collectors.groupingBy方法
 * 
 * @author zhanghua
 *
 * @param <T>
 * @param <K>
 */
public class GroupingBy<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>> {
	
	private final Function<? super T, ? extends K> classifier;

	public GroupingBy(Function<? super T, ? extends K> classifier) {
		this.classifier = classifier;
	}

	@Override
	public Supplier<Map<K, List<T>>> supplier() {
		return HashMap::new;
	}

	@Override
	public BiConsumer<Map<K, List<T>>, T> accumulator() {
		return (map, element) -> {
			K key = classifier.apply(element);
			List<T> elements = map.computeIfAbsent(key, k -> new ArrayList<>());
			elements.add(element);
		};
	}

	@Override
	public BinaryOperator<Map<K, List<T>>> combiner() {
		return (left, right) -> {
			right.forEach((key, value) -> {
				left.merge(key, value, (leftValue, rightValue) -> {
					leftValue.addAll(rightValue);
					return leftValue;
				});
			});
			
			return left;
		};
	}
	
	/**
	 * finisher对累加器中的结果不做处理，此时需要声明characteristics方法
	 */
	@Override
	public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
		return map -> map;
	}

	@Override
	public Set<java.util.stream.Collector.Characteristics> characteristics() {
		Set<Characteristics> characteristics = new HashSet<>();
		// finisher方法其实是identity函数，特征方法声明时需要定义为IDENTITY_FINISH特征
		characteristics.add(Characteristics.IDENTITY_FINISH);
		return characteristics;
	}

}
